package com.devlomi.quickwhatsappmessage;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.devlomi.quickwhatsappmessage.ui.DialogActivity;


/**
 * Created by Devlomi on 31/07/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class TileService extends android.service.quicksettings.TileService {


    @Override
    public void onClick() {

        if (!isSecure()) {
            showDialog();
        } else {
            unlockAndRun(new Runnable() {
                @Override
                public void run() {
                    showDialog();
                }
            });
        }
    }


    private void showDialog() {
        startActivityAndCollapse(new Intent(this, DialogActivity.class));
    }
}
