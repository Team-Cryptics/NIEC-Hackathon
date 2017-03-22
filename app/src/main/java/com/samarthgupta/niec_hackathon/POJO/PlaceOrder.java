package com.samarthgupta.niec_hackathon.POJO;

/**
 * Created by samarthgupta on 22/03/17.
 */

public class PlaceOrder {


        String userID;
        String uniqueID;
        public String descrip;
        public String photo;
        public String condition;
        public String warranty;
        public int years;
        float costsp;

        public PlaceOrder() {

            descrip= null; photo=null; condition=null; warranty = null;
            years=0; costsp = 0; userID = null; uniqueID = null;
        }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public float getCostsp() {
        return costsp;
    }

    public void setCostsp(float costsp) {
        this.costsp = costsp;
    }
}


