package com.example.restaurantapp;

import android.content.Context;
import android.telecom.Call;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuRequest  implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;
    private Callback activity;


    public MenuRequest(Context context) {
        this.context = context;
    }

    public interface Callback {
        void gotItems(ArrayList<MenuItem> items);

        void gotItemsError(String message);

    }

    public void getMenu(Callback activity, String category){
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(this.context);
        String url = "https://resto.mprog.nl/menu?category=" + category;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }

    public void onErrorResponse(VolleyError error) {
        activity.gotItemsError(error.getMessage());

    }

    public void onResponse(JSONObject response) {
        ArrayList<MenuItem> items=new ArrayList<MenuItem>();
        try {
            JSONArray JsonArray = response.getJSONArray("items");

            for (int i = 0; i < JsonArray.length(); i++){

                JSONObject item = JsonArray.getJSONObject(i);

                MenuItem menuItem = new MenuItem( item.getString("name"),
                        item.getString("description"),
                        item.getString("image_url"),
                        item.getInt("price"),
                        item.getString("category"));
                items.add(menuItem);


            }
            activity.gotItems(items);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
