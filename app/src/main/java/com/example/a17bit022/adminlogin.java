/********************************************************************************************
 Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 Vestibulum commodo. Ut rhoncus gravida arcu.
 *******************************************************************************************/

package com.example.a17bit022;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {
EditText t1,t2;
Button btn;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        t1=(EditText)findViewById(R.id.editText8);
        t2=(EditText)findViewById(R.id.editText9);
        progressDialog=new ProgressDialog(adminlogin.this);

        btn=(Button)findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               progressDialog.setMessage("Processing");
               progressDialog.show();

                String id=t1.getText().toString();
                String pass=t2.getText().toString();

                if((id.equals("admin__&&op"))&&(pass.equals("admin@ivguideapp"))){
                    progressDialog.dismiss();
                    Toast.makeText(adminlogin.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(adminlogin.this,adminlogin2.class));
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(adminlogin.this,"LOGIN FAILED ID and PASSWORD INCORRECT",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
