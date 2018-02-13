package com.devlomi.quickwhatsappmessage.data;

/**
 * Created by Devlomi on 31/07/2017.
 */

public class WhatsappItem {
    private int img;
    private String appName;
    private String appPackage;


    public WhatsappItem(int img, String appName, String appPackage) {
        this.img = img;
        this.appName = appName;
        this.appPackage = appPackage;

    }

    public int getImg() {
        return img;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppPackage() {
        return appPackage;
    }


}
