package it.localhost.app.mobile.learningdagger.ui.adapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.localhost.app.mobile.learningdagger.R;
import it.localhost.app.mobile.learningdagger.data.model.Contact;
import it.localhost.app.mobile.learningdagger.ui.activity.ContactsListActivity;

public class ContactsListAdapter extends BaseAdapter {

    private static final String TAG = "ContactsListAdapter";
    private ContactsListActivity contactsListActivity;
    private final List<Contact> collection = new ArrayList<>();

    /**
     * @param contactsListActivity
     */
    public ContactsListAdapter(ContactsListActivity contactsListActivity) {
        Log.v(TAG, "ContactsListAdapter");
        this.contactsListActivity = contactsListActivity;
    }

    @Override
    public int getCount() {
        return collection.size();
    }

    @Override
    public Object getItem(int i) {
        return collection.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_contactslist_row, viewGroup, false);
        }

        Contact item = (Contact) getItem(i);

        TextView tvNome = (TextView) view.findViewById(R.id.tvNome);
        tvNome.setText(item.getName());

        Log.v(TAG, "tvName: " + tvNome.getText().toString());

        return view;
    }

    /**
     * Aggiorna il contenuto della collezione
     *
     * @param contacts List<Contact>
     */
    public void updateContactsList(List<Contact> contacts) {
        if (contacts != null && contacts.size() > 0) {
            this.collection.clear();
            this.collection.addAll(contacts);
            notifyDataSetChanged();
        }
    }
}
