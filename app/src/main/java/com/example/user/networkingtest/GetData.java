package com.example.user.networkingtest;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class GetData extends AsyncTask<String,Void,String> {
    private WeakReference<TextView> textView;

    public GetData(TextView textView) {
        this.textView = new WeakReference<>(textView);
    }

    @Override
    protected String doInBackground(String... strings) {

        return NetConn.getBookInfo(strings[0]);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            Object totalItems = jsonObject.get("totalItems");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("description");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
            if (title != null && authors != null) {
                textView.get().setText(title);
            }
            else {
                textView.get().setText("no results");
            }

        } catch (Exception e) {
            textView.get().setText("no results");
            e.printStackTrace();
        }
    }
}
