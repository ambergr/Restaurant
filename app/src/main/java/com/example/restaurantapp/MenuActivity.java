package com.example.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback {
    ArrayList<MenuItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String categoryClicked = (String) intent.getStringExtra("category");

        TextView menu = findViewById(R.id.menu);
        menu.setText(categoryClicked + " menu");

        MenuRequest req = new MenuRequest(getApplicationContext());
        req.getMenu(this, categoryClicked);

        ListView listView = findViewById(R.id.menus);
        listView.setOnItemClickListener(new menuListener());

    }


    @Override
    public void gotItems(ArrayList<MenuItem> items) {
        this.items = items;
        Toast.makeText(this, "got items", Toast.LENGTH_LONG );
        ListView listView = findViewById(R.id.menus);
        ArrayAdapter arrayAdapter = new MenuAdapter(this, R.layout.menuitem, items);
        listView.setAdapter(arrayAdapter);
        System.out.println("halp");

    }

    @Override
    public void gotItemsError(String message) {

    }

    private class menuListener  implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            MenuItem clicked = items.get(position);

            Intent intent = new Intent(MenuActivity.this, DetailsActivity.class);
            intent.putExtra("menu", clicked);
            startActivity(intent);
        }
    }

}
