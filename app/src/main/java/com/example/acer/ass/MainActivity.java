package com.example.acer.ass;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    ViewPager viewPager;
    private Button button;
    /* private String[] images={
             "https://www.zigwheels.com/newcars/Hyundai/Xcent",
             "http://www.team-bhp.com/forum/test-drives-initial-ownership-reports/165540-preview-hyundai-creta.html"

     };
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       setContentView(R.layout.activity_main);

       /*
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        */


        button = (Button) findViewById(R.id.Blogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


        final EditText etusername=(EditText) findViewById(R.id.TFusername);
        String str=etusername.getText().toString();
        final EditText etpassword=(EditText) findViewById(R.id.TFpassword);
        String pass=etpassword.getText().toString();

        String password=helper.searchPass(str);
        if(pass.equals(password))
        {
            Intent i=new Intent(MainActivity.this,frontpageactivity.class);
            i.putExtra("Username",str);
            startActivity(i);
        }
        else
        {
            Toast temp=Toast.makeText(MainActivity.this,"USERNAME AND PASSWORD DON'T MATCH",Toast.LENGTH_SHORT);
            temp.show();

        }

        final Button blogin=(Button) findViewById(R.id.Blogin);
        final TextView RegisterLink=(TextView) findViewById(R.id.tvregister);

        RegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(MainActivity.this,SignupActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }
    public void openActivity2(){
        Intent intent=new Intent(this,frontpageactivity.class);
        startActivity(intent);
    }
}
