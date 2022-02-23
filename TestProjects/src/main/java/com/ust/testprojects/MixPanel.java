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
public class MixPanel {

    private static String PROJECT_TOKEN = "5c386fb30a8e25d770cf24d8bb558cd5";
    private static String distinctId = "12345";

    private static String host = "165.225.104.32";
    private static String port = "10223";

    public static void main(String[] args) {

        MixPanelAudit mpa = new MixPanelAudit(PROJECT_TOKEN, host, port);
        mpa.sendEvent("Test tool", MixPanelAudit.MessageType.TOOL_START);
    }

  
    private static void test1() {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

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

        // System.setProperty("http.proxyHost", "165.225.104.32");
        //System.setProperty("http.proxyPort", "10223");
        //System.setProperty("https.proxyHost", "165.225.104.32");
        //  System.setProperty("https.proxyPort", "10223");
// You can find your project token in the
// project settings dialog
// of the Mixpanel web application
        MessageBuilder messageBuilder
                = new MessageBuilder(PROJECT_TOKEN);

// Create an event
        //JSONObject sentEvent
        //  = messageBuilder.event(distinctId, "Sent Message", null);
// You can send properties along with events
        JSONObject props = new JSONObject();
        try {
            props.put("Name", "Test");
            props.put("Date", new Date().toString());
        } catch (JSONException ex) {
            Logger.getLogger(MixPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        JSONObject planEvent
                = messageBuilder.event(distinctId, "Test Event", props);
        System.out.println(planEvent);
// Gather together a bunch of messages into a single
// ClientDelivery. This can happen in a separate thread
// or process from the call to MessageBuilder.event()
        ClientDelivery delivery = new ClientDelivery();
        // delivery.addMessage(sentEvent);
        delivery.addMessage(planEvent);

// Use an instance of MixpanelAPI to send the messages
// to Mixpanel's servers.
        MixpanelAPI mixpanel = new MixpanelAPI();
        try {
            mixpanel.deliver(delivery);
        } catch (IOException ex) {
            Logger.getLogger(MixPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
