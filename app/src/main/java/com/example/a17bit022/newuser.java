package com.example.a17bit022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newuser extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private FirebaseAuth firebaseAuth;


private EditText newuserusername,newuseruserpassword,newuseruseremail,newuserRollno,newuserphno,newuserconfirmps;
String name1,coll1,pno1,Roll1,password1,email1,confirmpss1;
Spinner aspinner;

   private Button reg;
   private TextView userlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        Button b2=(Button)findViewById(R.id.button3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        set();


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                  String user_email=newuseruseremail.getText().toString().trim();
                    String user_password=newuseruserpassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) {

                                sendUserData();
                                Toast.makeText(newuser.this, "Registeration successfull and data uploaded", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(newuser.this,studentlogin.class));
                            }


                            else{

                                Toast.makeText(newuser.this, " email should be valid ...Registeration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });


        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(newuser.this,studentlogin.class));
            }
        });








    }
    private void set(){
        newuserusername=(EditText)findViewById(R.id.editText);
        aspinner=findViewById(R.id.spinner);
        aspinner.setOnItemSelectedListener(this);
        newuserRollno=(EditText)findViewById(R.id.editText13);
        newuseruserpassword=(EditText)findViewById(R.id.editText14);
        newuseruseremail=(EditText)findViewById(R.id.editText16);
        reg=(Button)findViewById(R.id.button3);
        userlogin=(TextView) findViewById(R.id.textView24);
        newuserphno=(EditText)findViewById(R.id.editText18);
        newuserconfirmps=(EditText)findViewById(R.id.editText15);
    }


    private Boolean validate(){
        Boolean result=false;
         name1=newuserusername.getText().toString();
        coll1=aspinner.getSelectedItem().toString();
        Roll1=newuserRollno.getText().toString();
        password1=newuseruserpassword.getText().toString();
        email1=newuseruseremail.getText().toString();
        pno1=newuserphno.getText().toString();
        confirmpss1=newuserconfirmps.getText().toString();

        if(name1.isEmpty()) {

            newuserusername.setError("name field empty");
        }
        else if(coll1.isEmpty()||coll1.equals("Select College")){
            Toast.makeText(this,"select college name",Toast.LENGTH_SHORT).show();
        }
        else if(Roll1.isEmpty()){
            newuserRollno.setError("Rollno field empty");
        }
        else if(password1.isEmpty()||password1.length()<=6){
            newuseruserpassword.setError("password field empty must be greater than 6 char");
        }
        else if(email1.isEmpty()|| (!email1.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
            newuseruseremail.setError("email field invalid");
        }
        else if(pno1.isEmpty() || pno1.length()!=10) {
            newuserphno.setError("phno field invalid");
        }
        else  if(!confirmpss1.matches(password1)){
            Toast.makeText(this,"password - confirmps mismatch",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;
    }



    private void sendUserData(){
      FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef=firebaseDatabase.getReference(firebaseAuth.getUid());

      DataBaseactivity databaseactivity=new DataBaseactivity(name1,coll1,Roll1,email1,pno1);
      myRef.setValue(databaseactivity);

        DatabaseReference myRef1=firebaseDatabase.getReference().child(firebaseAuth.getUid());
        myRef1.child("date").setValue("");

        DatabaseReference myRef2=firebaseDatabase.getReference().child(firebaseAuth.getUid());
        myRef2.child("department").setValue(" ");

        DatabaseReference myRef3=firebaseDatabase.getReference().child(firebaseAuth.getUid());
        myRef3.child("noofstu").setValue(" ");

        DatabaseReference myRef4=firebaseDatabase.getReference().child(firebaseAuth.getUid());
        myRef4.child("register").setValue("0");

        DatabaseReference myRef5=firebaseDatabase.getReference().child(firebaseAuth.getUid());
        myRef5.child("session").setValue(" ");

        DatabaseReference myRef6=firebaseDatabase.getReference().child(firebaseAuth.getUid());
        myRef6.child("company name").setValue(" ");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();


    }







    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
