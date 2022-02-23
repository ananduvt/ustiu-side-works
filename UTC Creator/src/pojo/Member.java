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
public class Member {
    
    String id;
    String dob;
    String gender;
    String rCode;
    
    ArrayList<Claim>  claimList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public ArrayList<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(ArrayList<Claim> claimList) {
        this.claimList = claimList;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", dob=" + dob + ", gender=" + gender + ", rCode=" + rCode + '}';
    }

 
}
