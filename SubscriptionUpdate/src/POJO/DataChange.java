/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author u55369
 */
public class DataChange {

    private String existingSubscriptionId;
    private String newSubscriptionId;
    private String identifiedAccount;
    private String startDate;
    private String enrolledPlan;

    public String getExistingSubscriptionId() {
        return existingSubscriptionId;
    }

    public void setExistingSubscriptionId(String existingSubscriptionId) {
        this.existingSubscriptionId = existingSubscriptionId;
    }

    public String getNewSubscriptionId() {
        return newSubscriptionId;
    }

    public void setNewSubscriptionId(String newSubscriptionId) {
        this.newSubscriptionId = newSubscriptionId;
    }

    public String getIdentifiedAccount() {
        return identifiedAccount;
    }

    public void setIdentifiedAccount(String identifiedAccount) {
        this.identifiedAccount = identifiedAccount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEnrolledPlan() {
        return enrolledPlan;
    }

    public void setEnrolledPlan(String enrolledPlan) {
        this.enrolledPlan = enrolledPlan;
    }

    @Override
    public String toString() {
        return "ChangeData{" + "existingSubscriptionId=" + existingSubscriptionId + ", newSubscriptionId=" + newSubscriptionId + ", identifiedAccount=" + identifiedAccount + ", startDate=" + startDate + ", enrolledPlan=" + enrolledPlan + '}';
    }

    
}
