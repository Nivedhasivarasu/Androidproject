package com.example.a17bit022;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class stream1 extends AppCompatActivity {
   ListView mylist;

   ArrayList<String> myArrayList=new ArrayList<>();

   DatabaseReference mref;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream1);

        final String newloc=getIntent().getExtras().getString("location");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth=FirebaseAuth.getInstance();


       final ArrayAdapter<String> myArrayAdater=new ArrayAdapter<String>(stream1.this,android.R.layout.simple_list_item_1,myArrayList);
        mylist=(ListView)findViewById(R.id.listview1);

        mylist.setAdapter(myArrayAdater);



        mref= FirebaseDatabase.getInstance().getReference().child(newloc);


        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                final  String value;
                value = dataSnapshot.getValue(String.class);

                myArrayAdater.add(value);


                mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference myRef=firebaseDatabase.getReference().child(firebaseAuth.getUid()).child("company");
                        if (newloc.equals("coimbatore") && position==0){


                            myRef.setValue(value);

                           display("https://www.infognana.com/");
                        }
                        if(newloc.equals("coimbatore") && position==1){
                            myRef.setValue(value);
                            display("https://www.solitontech.com/");
                        }
                        if(newloc.equals("coimbatore") && position==2){
                            myRef.setValue(value);
                            display("http://knila.com/");
                        }
                        if(newloc.equals("coimbatore") && position==3){
                            myRef.setValue(value);
                            display("https://www.ndot.in/");
                        }
                        if(newloc.equals("coimbatore") && position==4){
                            myRef.setValue(value);
                            display("http://www.loftyitsolutions.com/");
                        }
                        if(newloc.equals("coimbatore") && position==5)
                            myRef.setValue(value);{
                            display("");
                        }
                        if(newloc.equals("coimbatore") && position==6){
                            myRef.setValue(value);
                            display("https://www.owler.com/");
                        }
                        if(newloc.equals("coimbatore") && position==7){
                            myRef.setValue(value);
                            display("https://www.cloudassert.com/");
                        }
                        if(newloc.equals("coimbatore") && position==8){
                            myRef.setValue(value);
                            display("http://www.i2softwaretechsolutions.com/");
                        }
                        if(newloc.equals("coimbatore") && position==9){
                            myRef.setValue(value);
                            display("https://www.nexusglobalsolutions.com/");
                        }
                        if(newloc.equals("coimbatore") && position==10){
                            myRef.setValue(value);
                            display("https://www.informationevolution.com/");
                        }


                    }
                });




                myArrayAdater.notifyDataSetChanged();
            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myArrayAdater.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });









    }


    private void LogOut(){
        AlertDialog.Builder builder = new AlertDialog.Builder(stream1.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(stream1.this, MainActivity.class));
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


    private void display(final String  url ){
        AlertDialog.Builder builder = new AlertDialog.Builder(stream1.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("continue ur process with...")
                .setCancelable(false)
                .setPositiveButton("viewdetails", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        startActivity(new  Intent(Intent.ACTION_VIEW, Uri.parse(url)));
finish();

                    }
                })
                .setNeutralButton("register", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent=new Intent(stream1.this,Registerdetail.class);
                        startActivity(intent);

finish();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
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
           case R.id.TrackMenu:{
                startActivity(new Intent(stream1.this,Track.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
