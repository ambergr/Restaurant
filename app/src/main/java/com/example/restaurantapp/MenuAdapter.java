package com.example.restaurantapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class MenuAdapter extends ArrayAdapter<MenuItem> {

    ArrayList<MenuItem> items;

    public MenuAdapter(Context context, int resource, ArrayList<MenuItem> allObjects) {
        super(context, resource, allObjects);
        this.items = allObjects;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menuitem, parent, false);
        }

        MenuItem item =items.get(position);
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView course = convertView.findViewById(R.id.textView);
        TextView price = convertView.findViewById(R.id.textView2);

        float prices = item.getPrice();
        String prices2 = Float.toString(prices);
        price.setText(prices2);

        String courses =  item.getCategory();
        course.setText(courses);

        String url = item.getImageUrl();

        Picasso.get().load(url).into(image);

        return convertView;
    }
}
