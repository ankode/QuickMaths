package com.example.mahe.quickmaths;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button signUp;
    TextView login;
    EditText un,pwd,name;
    SQLiteDatabase sqLiteDatabaseObj;
    Cursor cursor;
    SQLiteOpenHelper sqLiteHelper;
    String SQLiteDataBaseQueryHolder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login=(TextView)findViewById(R.id.login);
        signUp=(Button)findViewById(R.id.signUp);
        un=(EditText)findViewById(R.id.un);
        pwd=(EditText)findViewById(R.id.pwd);
        name=(EditText)findViewById(R.id.name);
        sqLiteHelper = new SQLiteHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
                sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "(" + SQLiteHelper.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper.Table_Column_1_Name + " VARCHAR, " + SQLiteHelper.Table_Column_2_UN + " VARCHAR, " + SQLiteHelper.Table_Column_3_Password + " VARCHAR);");
                if(name.getText().toString().isEmpty()||un.getText().toString().isEmpty()||pwd.getText().toString().isEmpty())
                {
                    Toast.makeText(SignUpActivity.this, "Please fill all the details.", Toast.LENGTH_LONG).show();
                }
                else if(ifUserNameExists())
                {
                    Toast.makeText(SignUpActivity.this, "Username already exists.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME+" (name,user_name,password) VALUES('"+name.getText().toString()+"', '"+un.getText().toString()+"', '"+pwd.getText().toString()+"');";
                    sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
                    sqLiteDatabaseObj.close();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean ifUserNameExists(){

        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_UN + "=?", new String[]{un.getText().toString()}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                cursor.close();
                return true;
            }
        }
        return false;
    }
}
