package com.example.edeleon8425.midterm_prog3210;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button commentsButton;
    Button sendSMS;

    CommentsAdapter commentAdapter=null;
    ListView listView=null;
    SQLiteDB db=null;
    ArrayList<User> use=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new SQLiteDB(this);

        use=db.getData();
        commentAdapter= new CommentsAdapter(this,R.layout.layout_comments,use);

        listView = (ListView) findViewById(R.id.commentsList);
        listView.setAdapter(commentAdapter);


        commentsButton = (Button) findViewById(R.id.Button1);
        commentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Emily De Leon", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
        sendSMS = (Button) findViewById(R.id.Button2);
        sendSMS.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
            sendIntent.setData(Uri.parse("sms:5195555555"));
            startActivity(sendIntent);
        }
    });

    }
}
