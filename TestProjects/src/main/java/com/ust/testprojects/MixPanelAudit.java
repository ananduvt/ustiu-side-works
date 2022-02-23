/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ust.testprojects;

import com.mixpanel.mixpanelapi.ClientDelivery;
import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author u55369
 */
public class MixPanelAudit {

    private String httpHost;
    private String httpPort;

    private String eventName = " Tool Execution Details";

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    private MessageBuilder messageBuilder;
    private ClientDelivery delivery;
    private MixpanelAPI mixpanel;

    enum MessageType {
        TOOL_START, TOOL_STOP, TOOL_INVOKE;
    }

    public MixPanelAudit(String projectToken) {

        this(projectToken, "", "");
    }

    public MixPanelAudit(String projectToken, String httpHost, String httpPort) {

        this.httpHost = httpHost;
        this.httpPort = httpPort;

        messageBuilder = new MessageBuilder(projectToken);
        delivery = new ClientDelivery();
        mixpanel = new MixpanelAPI();

        init();
    }

    private void init() {

        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }};
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            System.err.println("Error in SSL validation");
        }
        if (!httpHost.equals("") && !httpPort.equals("")) {
            System.setProperty("http.proxyHost", httpHost);
            System.setProperty("http.proxyPort", httpPort);

            System.setProperty("https.proxyHost", httpHost);
            System.setProperty("https.proxyPort", httpPort);
        } else {
            System.out.println("Proxy not Set");
        }

    }

    private void addInfo(JSONObject jsonObject, String toolName, MessageType messageType) {
        try {
            jsonObject.put("User Name", System.getProperty("user.name"));
            jsonObject.put("Machine", java.net.InetAddress.getLocalHost());
            jsonObject.put("DateTime", new Date().toString());
            jsonObject.put("Tool Name", toolName);

            setEventType(jsonObject, messageType);
        } catch (JSONException ex) {
            Logger.getLogger(MixPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MixPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setEventType(JSONObject jObject, MessageType messageType) {

        try {
            jObject.put("Event Type", messageType);
        } catch (JSONException ex) {
            Logger.getLogger(MixPanelAudit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getDistintId() {
        String userName = System.getProperty("user.name");
        String ip;
        try {
            ip = java.net.InetAddress.getLocalHost().toString();
        } catch (Exception e) {
            ip = "NA";
        }
        String dateTime = new Date().toString();

        return userName + "-" + ip + "-" + dateTime;
    }

    public boolean sendEvent(String toolName, MessageType messageType) {

        JSONObject props = new JSONObject();
        addInfo(props, toolName, messageType);

        JSONObject event
                = messageBuilder.event(getDistintId(), eventName, props);
        System.out.println(event);
        delivery.addMessage(event);

        try {
            mixpanel.deliver(delivery);
            delivery = new ClientDelivery();
            return true;
        } catch (IOException ex) {
            System.err.println("Error in sending message\n" + ex);
        }
        return false;
    }

}
