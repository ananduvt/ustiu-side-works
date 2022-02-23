/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.List;

/**
 *
 * @author U55369
 */
public class Subscription {

    private String id;
    private List<Member> memberList;

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + id + ", memberList=" + memberList + '}';
    }

}
