package com.devlomi.quickwhatsappmessage.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.devlomi.quickwhatsappmessage.R;

/**
 * Created by Devlomi on 10/03/2017.
 */

public class AboutActivity extends AppCompatActivity {
    LinearLayout DeveloperLO, WebsiteLO, MoreAppsLO, RateAppLO, PrayFSLO;
    String developerName = "Devlomi";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        init();
        DeveloperLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/3llomi"));
                startActivity(i);
            }
        });

        WebsiteLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.devlomi.com"));
                startActivity(i);
            }
        });

        MoreAppsLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=" + developerName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=" + developerName)));
                }
            }
        });

        RateAppLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });

        PrayFSLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://donate.unhcr.org/international/syria"));
                startActivity(i);
            }
        });
    }

    private void init() {
        DeveloperLO = (LinearLayout) findViewById(R.id.developer_lo);
        WebsiteLO = (LinearLayout) findViewById(R.id.website_lo);
        MoreAppsLO = (LinearLayout) findViewById(R.id.more_apps_lo);
        RateAppLO = (LinearLayout) findViewById(R.id.rate_app_lo);
        PrayFSLO = (LinearLayout) findViewById(R.id.prayfs_lo);
    }
}
