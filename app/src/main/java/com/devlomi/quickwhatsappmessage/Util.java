package com.devlomi.quickwhatsappmessage;

import android.telephony.PhoneNumberUtils;

/**
 * Created by Devlomi on 02/05/2017.
 */

public class Util {

    public static String getNumber(String number) {
        return PhoneNumberUtils.stripSeparators(number);
    }


}
