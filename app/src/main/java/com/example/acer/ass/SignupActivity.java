package com.example.acer.ass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends Activity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signup);
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.bregister) {
            EditText name = (EditText) findViewById(R.id.etname);
            EditText username = (EditText) findViewById(R.id.etusername);
            EditText email = (EditText) findViewById(R.id.etpassword);
            EditText password = (EditText) findViewById(R.id.etpassword);
            EditText contact_number = (EditText) findViewById(R.id.etage);

            String namestr = name.getText().toString();
            String usernamestr = username.getText().toString();
            String emailstr = email.getText().toString();
            String passswordstr = password.getText().toString();
            String contact_numberstr = contact_number.getText().toString();


                Contact c= new Contact();
                c.setName(namestr);
                c.setUsername(usernamestr);
                c.setEmail(emailstr);
                c.setPassword(passswordstr);
                c.setContact_number(contact_numberstr);

                helper.insertContact(c);


        }}}
