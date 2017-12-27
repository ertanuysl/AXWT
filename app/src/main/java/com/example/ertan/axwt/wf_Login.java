package com.example.ertan.axwt;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.ertan.axwt.wf_List.wf_List;

public class wf_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wf__login);

        Button button = (Button) findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //On click function
            public void onClick(View view) {
                AlertDialog.Builder alertMessage = new AlertDialog.Builder(wf_Login.this);
                EditText name = (EditText) findViewById(R.id.editText);
                name.setPaintFlags(name.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                EditText pass = (EditText) findViewById(R.id.editText2);

                if (name.getText().toString().equals("ertan")&&pass.getText().toString().equals("123")) {
                    Intent intent = new Intent(wf_Login.this,wf_List.class);
                    intent.putExtra("isim",name.getText().toString());
                    startActivity(intent);
                }
                else{
                    alertMessage.setTitle("Mesaj Başlığı");
                    alertMessage.setMessage("başarısız2435345");
                    alertMessage.show();
                }
            }
            //Create the intent to start another activity
            //  Intent intent = new Intent(view.getContext(), AnotherActivity.class);
            // startActivity(intent);

        });



    }
}
