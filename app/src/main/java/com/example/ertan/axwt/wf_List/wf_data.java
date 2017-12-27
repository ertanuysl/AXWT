package com.example.ertan.axwt.wf_List;




import java.util.ArrayList;

public class wf_data {

    private int imageID;
    private String baslik;
    private String tanim;
    private String wf_title;
    private String wf_name;
    private String wf_price;
    private String wf_date;


    public int getImageID() {
        return imageID;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getTanim() {
        return tanim;
    }

    public String getWf_title() {
        return wf_title;
    }

    public String getWf_name() {
        return wf_name;
    }

    public String getWf_price() {
        return wf_price;
    }

    public String getWf_date() {
        return wf_date;
    }


    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public void setWf_title(String wf_title) {
        this.wf_title = wf_title;
    }

    public void setWf_name(String wf_name) {
        this.wf_name = wf_name;
    }

    public void setWf_price(String wf_price) {
        this.wf_price = wf_price;
    }

    public void setWf_date(String wf_date) {
        this.wf_date = wf_date;
    }






    public static ArrayList<wf_data> getData(){

        ArrayList<wf_data> dataList=new ArrayList<wf_data>();

        for(int i=0; i<20; i++){

            wf_data gecici=new wf_data();

            gecici.setWf_title("Kırktasiye "+i);
            gecici.setWf_name("Ertan "+i);
            gecici.setWf_price("9."+i);
            gecici.setWf_date("17.11.2017");
            dataList.add(gecici);

        }

        return dataList;


    }

}
