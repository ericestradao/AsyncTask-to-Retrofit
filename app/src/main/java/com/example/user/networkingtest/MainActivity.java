package com.example.user.networkingtest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.networkingtest.presenter.Controller;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;

//    static final String BASE_URL = "http://www.googleapis.com/books/v1/volumes?";
//    final String QUERY_PARAMS = "q";
//    final String maxResults = "maxResults";
//    final String printType = "printType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.texView);
        editText = (EditText)findViewById(R.id.editText);

        Controller controller = new Controller();
        controller.start();
        //checkConnection(textView);

    }

    public void checkConnection(View view) {
//        String queryString = editText.getText().toString();
//
//        NetworkInfo networkInfo = null;
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        networkInfo = connectivityManager.getActiveNetworkInfo();
//
//        if (networkInfo != null && networkInfo.isConnected()) {
//
//            new MyAsyncTask(textView).execute(queryString);
//
//        } else {
//            textView.setText("No network connection available");
//        }
//
//        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        boolean isWifiConn = networkInfo.isConnected();
//
//        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        boolean isMobileConn = networkInfo.isConnected();
//        return queryString;
        String queryString = "pride prejudice";

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        textView.setText("loading");

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            new GetData(textView).execute(queryString);
            textView.setText("loading");
        }
        else {
            if (queryString.length() == 0) {
                textView.setText("not found");
            } else {
                textView.setText("internet disconnected");
            }
        }
    }


//    public Uri createURI() {
//        Uri builtURI = Uri.parse(BASE_URL).buildUpon()
//                .appendQueryParameter(QUERY_PARAMS, "pride+prejudice")
//                .appendQueryParameter(maxResults, "10")
//                .appendQueryParameter(printType, "books")
//                .build();
//        return builtURI;
//    }

//    public String getDataasString(Uri builtURI)
//            throws MalformedURLException, IOException {
//
//        URL requestURL = new URL(builtURI.toString());
//
//        HttpURLConnection conn =
//                (HttpURLConnection) requestURL.openConnection();
//
//        conn.setReadTimeout(10000 /* milliseconds */);
//        conn.setConnectTimeout(15000 /* milliseconds */);
//        conn.setRequestMethod("GET");
//        conn.setDoInput(true);
//
//        conn.connect();
//        int response = conn.getResponseCode();
//
//        InputStream is = conn.getInputStream();
//
//        int len = is.read();
//        String contentAsString = convertIsToString(is, len);
//        return contentAsString;
//
//
//    }
//
//    public String convertIsToString(InputStream stream, int len)
//            throws IOException, UnsupportedEncodingException {
//
//        StringBuilder builder = new StringBuilder();
//        BufferedReader reader =
//                new BufferedReader(new InputStreamReader(stream));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            builder.append(line + "\n");
//        }
//        if (builder.length() == 0) {
//            return null;
//        }
//        return builder.toString();
//    }
    //method to pass info to simple text view
//    public class populateStrintoView(String queryString){
//         WeakReference<TextView> textView;
//        HttpURLConnection urlConnection = null;
//        BufferedReader reader = null;
//        String bookJSONString = null;
//    }
    //wroker trhead





}