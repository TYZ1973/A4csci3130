package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText business_numberField, nameField, primarybusinessField, addressField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        business_numberField = (EditText) findViewById(R.id.Text1);
        nameField = (EditText) findViewById(R.id.Text2);
        primarybusinessField = (EditText) findViewById(R.id.Text3);
        addressField = (EditText) findViewById(R.id.Text4);
        provinceField = (EditText) findViewById(R.id.Text5);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String business_number = business_numberField.getText().toString();
        String name = nameField.getText().toString();
        String primary = primarybusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(personID, business_number, name, primary, address, province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}