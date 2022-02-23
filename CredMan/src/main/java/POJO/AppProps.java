/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author u55369
 */
public class AppProps implements Serializable{
    
    private List<Credential> credList;
    private Properties properties;

    public List<Credential> getCredList() {
        return credList;
    }

    public void setCredList(List<Credential> credList) {
        this.credList = credList;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }  
    
}
