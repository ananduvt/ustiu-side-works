/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.ArrayList;

/**
 *
 * @author U55369
 */
public class Claim {
    
    String number;
    String type;
    String pos;
    String addDate;
    String disDate;
    String primDiag;
    String disStatus;
    String facTin;
    String refProNPI;
    String billType;
    
    ArrayList<Line> lineList;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getDisDate() {
        return disDate;
    }

    public void setDisDate(String disDate) {
        this.disDate = disDate;
    }

    public String getPrimDiag() {
        return primDiag;
    }

    public void setPrimDiag(String primDiag) {
        this.primDiag = primDiag;
    }

    public String getDisStatus() {
        return disStatus;
    }

    public void setDisStatus(String disStatus) {
        this.disStatus = disStatus;
    }

    public String getFacTin() {
        return facTin;
    }

    public void setFacTin(String facTin) {
        this.facTin = facTin;
    }

    public String getRefProNPI() {
        return refProNPI;
    }

    public void setRefProNPI(String refProNPI) {
        this.refProNPI = refProNPI;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public ArrayList<Line> getLineList() {
        return lineList;
    }

    public void setLineList(ArrayList<Line> lineList) {
        this.lineList = lineList;
    }

    @Override
    public String toString() {
        return "Claim{" + "number=" + number + ", type=" + type + ", pos=" + pos + ", addDate=" + addDate + ", disDate=" + disDate + ", primDiag=" + primDiag + ", disStatus=" + disStatus + ", facTin=" + facTin + ", refProNPI=" + refProNPI + ", billType=" + billType + '}';
    }

    
    
    
}
