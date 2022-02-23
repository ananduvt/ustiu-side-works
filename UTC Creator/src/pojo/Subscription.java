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
public class Subscription {
    
    String id;
    ArrayList<Member> memberList;

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + id + '}';
    }

   
}
