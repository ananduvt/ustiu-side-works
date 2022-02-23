/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ust.credman;

import POJO.AppProps;
import POJO.Credential;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author u55369
 */
public class Util {

    private static Crypto crypto = new Crypto();

    public static void main(String[] args) {

    }

    public static boolean isFirst() {

        File configFile = new File(Global.CONFIG_FILE);
        if (configFile.exists()) {
            return false;
        } else {

            return true;
        }
    }

    public static void createConfigFile(String configFileName, AppProps appProps) {
        try {
            File configFile = new File(configFileName);
            configFile.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error in creating  Config File : " + configFileName);
        }

        viewAppProps(appProps);
        crypto.encryptObjectToFile(appProps, Global.DEFAULT_CRYPT_KEY, configFileName);
    }

    public static AppProps loadConfigFile(String configFileName) {

        AppProps appProps = (AppProps) crypto.decryptObjectFromFile(Global.DEFAULT_CRYPT_KEY, configFileName);
        viewAppProps(appProps);
        return appProps;
    }

    public static void updateConfigFile(String fileName) {

    }

    private static void viewAppProps(AppProps appProps) {
        System.out.println("Cred List");
        System.out.println(appProps.getCredList());

        System.out.println("Props");
        System.out.println(appProps.getProperties());
    }
}
