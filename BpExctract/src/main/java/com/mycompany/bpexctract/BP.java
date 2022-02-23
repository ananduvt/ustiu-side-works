/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpexctract;

/**
 *
 * @author u55369
 */
public class BP {
    private String fileName;
    private String bpName;
    private String slotgForPhysicianVisits;

    
    public String getBpName() {
        return bpName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setBpName(String bpName) {
        this.bpName = bpName;
    }

    public String getSlotgForPhysicianVisits() {
        return slotgForPhysicianVisits;
    }

    public void setSlotgForPhysicianVisits(String slotgForPhysicianVisits) {
        this.slotgForPhysicianVisits = slotgForPhysicianVisits;
    }

    @Override
    public String toString() {
        return "BP{" + "fileName=" + fileName + ", bpName=" + bpName + ", slotgForPhysicianVisits=" + slotgForPhysicianVisits + '}';
    }

}
