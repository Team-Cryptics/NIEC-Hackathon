package com.samarthgupta.niec_hackathon.POJO;

/**
 * Created by samarthgupta on 22/03/17.
 */

public class PlaceOrder {


        String userID;
        String uniqueID;
        public String name;
        public String descrip;
        public String photo;
        public String condition;
        public int years;
        float costsp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceOrder() {

            descrip= null; photo=null; condition=null;
            years=0; costsp = 0; userID = null; uniqueID = null; name = null;
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


