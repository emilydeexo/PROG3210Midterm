package com.example.edeleon8425.midterm_prog3210;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    Button submitComment;
    SQLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final EditText username = (EditText) findViewById(R.id.nameEditText);
        final EditText comment = (EditText) findViewById(R.id.commentEditText);
        submitComment = (Button) findViewById(R.id.Button3);
        submitComment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String ucomment = comment.getText().toString();
                if (username.getText().toString().equals("") ||
                        comment.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Something is missing"
                            , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Intent code for open new activity through intent.
                    Intent intent = new Intent(Activity2.this, MainActivity.class);
                    startActivity(intent);
                    db = new SQLiteDB(Activity2.this);
                    db.addUser(new User(user_name, ucomment));
                    Toast.makeText(Activity2.this,user_name+" - "+ucomment,Toast.LENGTH_SHORT).show();
                }
            }
        });
        db=new SQLiteDB(Activity2.this);
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}