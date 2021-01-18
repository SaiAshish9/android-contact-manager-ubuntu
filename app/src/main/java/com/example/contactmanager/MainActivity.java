package com.example.contactmanager;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert :", "Inserting...");
        db.addContact(new Contact(
                "Sai",
                "123456789"
        ));
        db.addContact(new Contact(
                "Ashish",
                "123456789"
        ));
        db.addContact(new Contact(
                "Sai9",
                "345678902"
        ));
        Log.d("Reading ", "Reading all contacts ...");
        List<Contact> contactsList = db.getAllContacts();

        Contact oneContact = db.getContact(1);

        oneContact.setName("Sai7");

        Log.d("One Contact:", oneContact.getName() + " Phone " + oneContact.getName());

        int newContact = db.updateContact(oneContact);


        Log.d("New Contact", String.valueOf(newContact));

        db.deleteContact(oneContact);

        Log.d("DB Count:", String.valueOf(db.getContactsCount()));

        for (Contact c : contactsList) {
            String log = "ID: " + c.getId() + ", Name " + c.getName() + ", Phone: " + c.getPhoneNumber();
            Log.d("Name :", log);
        }

    }


}