package com.example.mahe.quickmaths;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView signUp;
    EditText un,pwd;
    String pwdFound="";
    SQLiteDatabase sqLiteDatabaseObj;
    Cursor cursor;
    SQLiteOpenHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.login);
        signUp=(TextView)findViewById(R.id.signup);
        un=(EditText)findViewById(R.id.un);
        pwd=(EditText)findViewById(R.id.pwd);
        sqLiteHelper = new SQLiteHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(un.getText().toString().isEmpty()||pwd.getText().toString().isEmpty())
               {
                   Toast.makeText(LoginActivity.this, "Please enter all details.", Toast.LENGTH_LONG).show();
               }
               else
               {
                   sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
                   cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_UN + "=?", new String[]{un.getText().toString()}, null, null, null);
                   while (cursor.moveToNext()) {

                       if (cursor.isFirst()) {

                           cursor.moveToFirst();

                           // Storing Password associated with entered email.
                           pwdFound = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));

                           // Closing cursor.
                           cursor.close();
                       }
                   }
                   if(pwdFound.equals(pwd.getText().toString()))
                   {
                       Intent intent = new Intent(LoginActivity.this, GameMenuActivity.class);
                       startActivity(intent);

                   }
                   else
                   {
                       Toast.makeText(LoginActivity.this, "UserName or Password is Wrong, Please Try Again.", Toast.LENGTH_LONG).show();
                   }
               }
           }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
