package com.example.ist_mac_01.week_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {

    Button bt1,bt2;
    EditText tx1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);

        tx1 = (EditText)findViewById(R.id.editText);

        final Context context = getApplicationContext();

        final SharedPreferences sh = getSharedPreferences("Champ",context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sh.edit();
        editor.putInt("highSocre",0);
        editor.commit();

        bt1.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               int inputScore = Integer.parseInt(tx1.getText().toString());
               int currentScore = sh.getInt("highScore",-1);

               if(inputScore > currentScore){
                   Toast t = Toast.makeText(context, "High score = " +inputScore, Toast.LENGTH_LONG);
                   t.show();
                   editor.putInt("HighScore",inputScore);
                   editor.commit();
               } else{
                   Toast t = Toast.makeText(context, "No new score",Toast.LENGTH_LONG);
                   t.show();
               }
           }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                starActivity(intent);
            }
        });
    }
}
