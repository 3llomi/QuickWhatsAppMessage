package com.devlomi.quickwhatsappmessage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devlomi.quickwhatsappmessage.R;
import com.devlomi.quickwhatsappmessage.data.ListOfItems;



public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String number = editText.getText().toString();
                if (number.isEmpty())
                    Toast.makeText(MainActivity.this, "please enter the number", Toast.LENGTH_SHORT).show();

                else
                    showDialogChooseWhatsapp();


            }
        });
    }

    public String getNumberFromEditText() {
        return editText.getText().toString();
    }

    private void showDialogChooseWhatsapp() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);


        view.findViewById(R.id.edit_text_dialog).setVisibility(View.GONE);
        view.findViewById(R.id.space_view).setVisibility(View.GONE);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        Adapter adapter = new Adapter(ListOfItems.getList(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        dialog.setView(view);
        dialog.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.about);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

