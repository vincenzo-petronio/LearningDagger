package it.localhost.app.mobile.learningdagger.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import it.localhost.app.mobile.learningdagger.exception.NetworkException;

public class NetworkApi {
    private static final String TAG = "NetworkApi";
    private static final int HTTP_TIMEOUT = 15000;

    /**
     * @param user
     * @param psw
     * @return
     */
    public boolean isUserAuth(String user, String psw) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(psw)) {
            return false;
        } else {
            // A random return ;-)
            return Math.random() < 0.2;
        }
    }

    /**
     * @param url String
     * @return String
     * @throws NetworkException
     */
    public String getUrl(String url) throws NetworkException {
        String result = null;
//        StringBuffer sb = new StringBuffer();
//        InputStream is = null;
//        HttpURLConnection httpURLConnection = null;
//
//        try {
//            httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
//            httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.setConnectTimeout(HTTP_TIMEOUT);
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.connect();
//            Log.i(TAG, "Connect with: " + url);
//
//            switch (httpURLConnection.getResponseCode()) {
//                case HttpURLConnection.HTTP_OK:
//                    is = new BufferedInputStream(httpURLConnection.getInputStream());
//                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//                    String inputLine = "";
//                    while ((inputLine = br.readLine()) != null) {
//                        sb.append(inputLine);
//                    }
//                    result = sb.toString();
//                    break;
//                default:
//                    Log.e(TAG, "ResponseCode != 200");
//                    break;
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "Exception", e);
//            throw new NetworkException(e.getMessage());
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException ioe) {
//                    Log.e(TAG, "IOException", ioe);
//                    throw new NetworkException(ioe.getMessage());
//                }
//            }
//        }

        result = "[{\"name\":\"Henry\",\"surname\":\"Oneil\",\"sex\":\"m\",\"birthday\":\"22/08/1956\"},{\"name\":\"Candice\",\"surname\":\"Oneil\",\"sex\":\"f\",\"birthday\":\"15/01/1985\"},{\"name\":\"Rebecca\",\"surname\":\"Powel\",\"sex\":\"f\",\"birthday\":\"05/11/1966\"},{\"name\":\"Frances\",\"surname\":\"Rieker\",\"sex\":\"m\",\"birthday\":\"21/02/1996\"},{\"name\":\"Erin\",\"surname\":\"Trujillo\",\"sex\":\"m\",\"birthday\":\"26/04/1984\"}]";

        return result;
    }
}
