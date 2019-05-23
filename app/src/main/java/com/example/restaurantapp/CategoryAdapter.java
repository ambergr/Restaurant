package com.example.restaurantapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<String> {

    ArrayList<String> categories;

    public CategoryAdapter(Context context, int resource, ArrayList<String> allObjects) {
        super(context, resource, allObjects);
        this.categories = allObjects;
    }
}
