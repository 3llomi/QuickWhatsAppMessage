package com.devlomi.quickwhatsappmessage.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devlomi.quickwhatsappmessage.Util;
import com.devlomi.quickwhatsappmessage.data.WhatsappItem;
import com.devlomi.quickwhatsappmessage.R;

import java.util.List;



/**
 * Created by Devlomi on 31/07/2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<WhatsappItem> whatsappItemList;
    Context context;


    public Adapter(List<WhatsappItem> whatsappItemList, Context context) {
        this.whatsappItemList = whatsappItemList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final WhatsappItem item = whatsappItemList.get(position);
        ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.appNameTv.setText(item.getAppName());
        itemHolder.appPackageTv.setText(item.getAppPackage());
        itemHolder.iconImg.setImageResource(item.getImg());
        itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number;
                if (context instanceof DialogActivity) {
                    DialogActivity activity = (DialogActivity) context;
                    number = activity.getNumberFromEditText();
                } else {
                    MainActivity activity = (MainActivity) context;
                    number = activity.getNumberFromEditText();
                }
                openChat(number, item.getAppPackage());
            }
        });

    }


    private void openChat(String text, String packageName) {
        if (text.trim().isEmpty())
            Toast.makeText(context, "Please Enter Number", Toast.LENGTH_SHORT).show();
        else {
            try {
                String smsNumber = Util.getNumber(text) + "@s.whatsapp.net";
                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.putExtra("jid", smsNumber);
                i.putExtra("sms_body", "Devlomi");
                i.setPackage(packageName);
                context.startActivity(i);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(context, "Make Sure you have WhatsApp App Installed on Your Device", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public int getItemCount() {
        return whatsappItemList.size();
    }


    class ItemHolder extends RecyclerView.ViewHolder {
        private RelativeLayout relative;
        private ImageView iconImg;
        private TextView appNameTv;
        private TextView appPackageTv;

        private CardView cardView;


        public ItemHolder(View itemView) {
            super(itemView);
            relative = (RelativeLayout) itemView.findViewById(R.id.relative);
            iconImg = (ImageView) itemView.findViewById(R.id.icon_img);
            appNameTv = (TextView) itemView.findViewById(R.id.app_name_tv);
            appPackageTv = (TextView) itemView.findViewById(R.id.app_package_tv);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
