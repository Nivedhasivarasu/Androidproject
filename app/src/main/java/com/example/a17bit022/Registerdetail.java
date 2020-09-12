/********************************************************************************************
 Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 Vestibulum commodo. Ut rhoncus gravida arcu.
 *******************************************************************************************/

package com.example.a17bit022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.telephony.SmsManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registerdetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Button bt;
Spinner dept,compses;
private  EditText nostu,date;


    String deptar;
    String stucount;
    String aldate;
    String sess,register;

    private FirebaseAuth firebaseAuth;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerdetail);

         dept=findViewById(R.id.spinner4);
        dept.setOnItemSelectedListener(this);

        compses=findViewById(R.id.spinner5);
        compses.setOnItemSelectedListener(this);

        nostu=(EditText)findViewById(R.id.editText6);
        date=(EditText)findViewById(R.id.editText7);


        bt=(Button)findViewById(R.id.button2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        firebaseAuth=FirebaseAuth.getInstance();



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                deptar=dept.getSelectedItem().toString().trim();
                stucount=nostu.getText().toString().trim();
                aldate=date.getText().toString().trim();
                sess=compses.getSelectedItem().toString().trim();

                if(deptar.isEmpty()){
                    Toast.makeText(Registerdetail.this,"fill dept",Toast.LENGTH_SHORT).toString().trim();
                }
                if(stucount.isEmpty()){
                    nostu.setError("enter count");
                }
                if(aldate.isEmpty()){
                    date.setError("enter date");
                }
                if(sess.isEmpty()){
                    Toast.makeText(Registerdetail.this,"check session",Toast.LENGTH_SHORT).toString().trim();
                }
                if(deptar.equals("select dept")){
                    Toast.makeText(Registerdetail.this,"fill dept",Toast.LENGTH_SHORT).toString().trim();
                }
                else {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("department");
                    myRef.setValue(deptar);
                    DatabaseReference myRef1 = firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("noofstu");
                    myRef1.setValue(stucount);
                    DatabaseReference myRef3 = firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("date");
                    myRef3.setValue(aldate);
                    DatabaseReference myRef5 = firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("session");
                    myRef5.setValue(sess);
                    DatabaseReference myRef4 = firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("register");
                    myRef4.setValue(1);

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String email = user.getEmail();



                    final DatabaseReference myRef22=firebaseDatabase.getReference().child("register");
                    myRef22.child(stucount).setValue(email);
                    final DatabaseReference myRef221=firebaseDatabase.getReference().child("hello");
                    //DatabaseReference colldata=firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("databaseactivityusercollege");
                    //String coll=colldata.toString().trim();
                    myRef221.child(stucount).setValue(user.getUid());


                    Toast.makeText(Registerdetail.this, "successfully registered can view details in track button", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(),Studentlogin1.class);
                    PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                      String no="9488585385",msg="Message from Ivgude Application" +
                       "your register has been recorded successfully!!!";
                    //Get the SmsManager instance and call the sendTextMessage method to send message
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(no, null, msg, pi,null);




                }

            }
        });
    }




   /* private void sendUserData(){


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef=firebaseDatabase.getReference(firebaseAuth.getUid());

        DataBaseactivity databaseactivity=new DataBaseactivity(deptar,stucount,aldate,sess);
        myRef.setValue(databaseactivity);
    }*/


    private void LogOut(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Registerdetail.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(Registerdetail.this, MainActivity.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutMenu:{
                LogOut();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
