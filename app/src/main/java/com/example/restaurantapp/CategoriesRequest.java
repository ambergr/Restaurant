package com.example.restaurantapp;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;
    private Callback activity;

    public CategoriesRequest(Context context) {
        this.context = context;
    }

    public interface Callback {
        void gotCategories(ArrayList<String> categories);

        void gotCategoriesError(String message);

    }

    public void getCategories(Callback activity){

        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(this.context);
        String url = "https://resto.mprog.nl/categories";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }
    
    public void onErrorResponse(VolleyError error) {
        activity.gotCategoriesError(error.getMessage());

    }

    public void onResponse(JSONObject response) {
        ArrayList<String> categories=new ArrayList<String>();
        try {
            JSONArray JSONArray = response.getJSONArray("categories");

            for (int i = 0; i < JSONArray.length(); i++){

                categories.add(JSONArray.getString(i));

            }

            activity.gotCategories(categories);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
