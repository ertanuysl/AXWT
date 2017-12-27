package com.example.ertan.axwt.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.ertan.axwt.R;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTextTab, btnIconTab, btnCustomTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tablayout Örnek");

        btnTextTab = (Button) findViewById(R.id.btnTextTab);
        btnIconTab= (Button) findViewById(R.id.btnIconTab);
        btnCustomTab= (Button) findViewById(R.id.btnCustomTab);
        btnTextTab.setOnClickListener(this);
        btnIconTab.setOnClickListener(this);
        btnCustomTab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent=null;
        switch (v.getId()) {


            case R.id.btnTextTab:
                //intent=new Intent(this, TextTab.class);
                startActivity(intent);

                break;

            case R.id.btnIconTab:

            //    intent=new Intent(this, IconTab.class);
                startActivity(intent);

                break;

            case R.id.btnCustomTab:

         //       intent=new Intent(this, CustomTab.class);
                startActivity(intent);

                break;


        }
    }
}
