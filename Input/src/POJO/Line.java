/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author U55369
 */
public class Line {
    
    private String lineNumber;
    private String servFromDate;
    private String ServToDate;
    private String revCode;
    private String cpt4Code;
    private String cpt4Modifier;
    private String units;
    private String subAmount;
    private String authNumber;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getServFromDate() {
        return servFromDate;
    }

    public void setServFromDate(String servFromDate) {
        this.servFromDate = servFromDate;
    }

    public String getServToDate() {
        return ServToDate;
    }

    public void setServToDate(String ServToDate) {
        this.ServToDate = ServToDate;
    }

    public String getRevCode() {
        return revCode;
    }

    public void setRevCode(String revCode) {
        this.revCode = revCode;
    }

    public String getCpt4Code() {
        return cpt4Code;
    }

    public void setCpt4Code(String cpt4Code) {
        this.cpt4Code = cpt4Code;
    }

    public String getCpt4Modifier() {
        return cpt4Modifier;
    }

    public void setCpt4Modifier(String cpt4Modifier) {
        this.cpt4Modifier = cpt4Modifier;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSubAmount() {
        return subAmount;
    }

    public void setSubAmount(String subAmount) {
        this.subAmount = subAmount;
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
    }

    @Override
    public String toString() {
        return "Line{" + "lineNumber=" + lineNumber + ", servFromDate=" + servFromDate + ", ServToDate=" + ServToDate + ", revCode=" + revCode + ", cpt4Code=" + cpt4Code + ", cpt4Modifier=" + cpt4Modifier + ", units=" + units + ", subAmount=" + subAmount + ", authNumber=" + authNumber + '}';
    }
   
}
