package com.example.ertan.axwt;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ertan.axwt.wf_List.wf_List;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class wf_Login extends AppCompatActivity {
    TextView tv1;
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
                name.setPaintFlags(name.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                EditText pass = (EditText) findViewById(R.id.editText2);
                tv1 = (TextView) findViewById(R.id.tv1);
                new HttpRequestTask().execute("http://kotlinturkiye.com/ertan/wf_login_con.php");


                if (name.getText().toString().equals("ertan") && pass.getText().toString().equals("123")) {
                    Intent intent = new Intent(wf_Login.this, wf_List.class);
                    intent.putExtra("isim", name.getText().toString());
                    startActivity(intent);
                } else {
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

    class HttpRequestTask extends AsyncTask<String, String, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader br = null;
            String stringUrl = params[0];
            String result="";
            String inputLine;
            try {
                URL url = new URL(stringUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                connection.connect();

                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
                Log.d("sonuc", result);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("postExceuretangle", s);
            tv1.setText(s);
        }


    }

}

