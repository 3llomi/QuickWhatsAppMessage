package com.devlomi.quickwhatsappmessage.data;

import com.devlomi.quickwhatsappmessage.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devlomi on 31/07/2017.
 */

public class ListOfItems {
    public static List<WhatsappItem> getList() {

        List<WhatsappItem> whatsappItems = new ArrayList<>();
        whatsappItems.add(new WhatsappItem(R.drawable.whatsapp, "WhatsApp", Constants.WHATSAPP));
        whatsappItems.add(new WhatsappItem(R.drawable.gb_whatsapp, "GBWhatsApp", Constants.GBWHATSAPP));
        whatsappItems.add(new WhatsappItem(R.drawable.gb_icon_two, "GBWhatsApp3", Constants.GBWHATSAPP3));
        whatsappItems.add(new WhatsappItem(R.drawable.whatsapp_two_plus, "WhatsApp2Plus", Constants.WHATSAPP2PLUS));
        whatsappItems.add(new WhatsappItem(R.drawable.whatsapp_three_plus, "WhatsApp3Plus", Constants.WHATSAPP3PLUS));
        whatsappItems.add(new WhatsappItem(R.drawable.whatsapp_four_plus, "WhatsApp4Plus", Constants.WHATSAPP4PLUS));
        return whatsappItems;
    }
}
