package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        MenuItem menu = (MenuItem) intent.getSerializableExtra("menu");

        ImageView plaatje = findViewById(R.id.plaatje);
        TextView titel = findViewById(R.id.titel);
        TextView price = findViewById(R.id.price);
        TextView description = findViewById(R.id.description);

        String name = menu.getName();
        titel.setText(name);

        float prijs =  menu.getPrice();
        String prices2 = Float.toString(prijs);
        price.setText(prices2);

        String descriptions = menu.getDescription();
        description.setText(descriptions);

        String url = menu.getImageUrl();
        Picasso.get().load(url).into(plaatje);
    }

}
