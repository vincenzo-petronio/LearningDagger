package it.localhost.app.mobile.learningdagger.data.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import it.localhost.app.mobile.learningdagger.exception.NetworkException;
import it.localhost.app.mobile.learningdagger.utils.Constants;
import it.localhost.app.mobile.learningdagger.utils.NetworkApi;

public class ContactsManager {
    private NetworkApi networkApi;

    public ContactsManager(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    public List<Contact> getContacts() {
        String resultJson = "[]";
        try {
            resultJson = networkApi.getUrl(Constants.API_CONTACTS);
        } catch (NetworkException ne) {
            Log.e(this.getClass().getSimpleName(), "NetworkException", ne);
        }

        return new Gson().fromJson(resultJson, new TypeToken<ArrayList<Contact>>() {
        }.getType());
    }
}
