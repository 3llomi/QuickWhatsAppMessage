package com.devlomi.quickwhatsappmessage.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.devlomi.quickwhatsappmessage.R;
import com.devlomi.quickwhatsappmessage.data.ListOfItems;

/**
 * Created by Devlomi on 31/07/2017.
 */

public class DialogActivity extends AppCompatActivity {
    EditText editTextDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        editTextDialog = (EditText) findViewById(R.id.edit_text_dialog);

        findViewById(R.id.title_tv_dialog).setVisibility(View.GONE);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        Adapter adapter = new Adapter(ListOfItems.getList(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    public String getNumberFromEditText() {
        return editTextDialog.getText().toString();
    }

}
