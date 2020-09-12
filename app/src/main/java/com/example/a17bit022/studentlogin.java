package com.example.a17bit022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class studentlogin extends AppCompatActivity {
private TextView t1,forgetpassword;
private EditText name,password;
private Button login;
private FirebaseAuth firebaseAuth;
private ProgressDialog progressDialog;


@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

        TextView t1 = (TextView)findViewById(R.id.textView8);

        final EditText name= (EditText) findViewById(R.id.editText2);

        final EditText password= (EditText) findViewById(R.id.editText3);

        Button login=(Button)findViewById(R.id.button);

         TextView forgetpassword = (TextView)findViewById(R.id.tvForgetPassword);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

       FirebaseUser user=firebaseAuth.getCurrentUser();

      /* if(hello !=null){
           finish();
           startActivity(new Intent(studentlogin.this,Studentlogin1.class));
       }*/



       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openActivity();
           }
       });


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if((name.getText().toString()).equals("")||(password.getText().toString()).equals("")){
                   Toast.makeText(studentlogin.this,"fill the login credentials",Toast.LENGTH_SHORT).show();
               }
               else{
              openActivity1(name.getText().toString(),password.getText().toString());
           }}
       });

       forgetpassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(studentlogin.this, forgetpassword.class));
           }
       });
    }

    public void openActivity() {


        Intent intent = new Intent(this, newuser.class);
        startActivity(intent);
    }

    public  void openActivity1(String username,String userpassword) {

    progressDialog.setMessage("Processing");
    progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username, userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(studentlogin.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(studentlogin.this, Studentlogin1.class));
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(studentlogin.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
