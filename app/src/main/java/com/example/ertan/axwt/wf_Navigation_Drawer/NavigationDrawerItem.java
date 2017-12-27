package com.example.ertan.axwt.wf_Navigation_Drawer;

import java.util.ArrayList;
import com.example.ertan.axwt.R;

public class NavigationDrawerItem  {
    String baslik;
    int resimID;

    public String getBaslik() {
        return baslik;
    }

    public int getResimID() {
        return resimID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setResimID(int resimID) {
        this.resimID = resimID;
    }

    public static ArrayList<NavigationDrawerItem> getData(){

        ArrayList<NavigationDrawerItem> dataList=new ArrayList<NavigationDrawerItem>();
        int[] resimIDs=getImages();
        String[] basliklar=getBasliklar();

        for(int i=0; i<basliklar.length; i++)
        {
            NavigationDrawerItem navItem=new NavigationDrawerItem();
            navItem.setBaslik(basliklar[i]);
            navItem.setResimID(resimIDs[i]);

            dataList.add(navItem);
        }

        return dataList;


    }

    private static int[] getImages() {
        return new int[]{
                R.drawable.ic_birds, R.drawable.ic_animal,
                R.drawable.ic_forest, R.drawable.ic_ocean,
                };

    }

    private static String[] getBasliklar() {

        return new String[] {
                "Ana Sayfa", "Pozisyon", "Raporlama", "Çıkış"
        };
    }
}
