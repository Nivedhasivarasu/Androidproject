
        package com.example.a17bit022;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.graphics.Color;
        import android.text.Html;
        import android.text.method.LinkMovementMethod;
        import android.app.PendingIntent;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.telephony.SmsManager;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.security.SecureRandom;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.Random;

        public class Retrive extends AppCompatActivity {
  DatabaseReference ref;
    FirebaseDatabase database;
    private FirebaseAuth firebaseAuth;
    ListView mylist;
     ArrayAdapter<String> myArrayAdater;
    ArrayList<String> myArrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("UserIn");
        getSupportActionBar().setTitle("User request list");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        String[] testArray = getResources().getStringArray(R.array.Spinner_items22);

        final List <String> fruits_list = new ArrayList<String>(Arrays.asList(testArray));




myArrayAdater=new ArrayAdapter<String>(Retrive.this,android.R.layout.simple_list_item_1,fruits_list);
        mylist=(ListView)findViewById(R.id.listview);
       mylist.setAdapter(myArrayAdater);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                          @Override

                                          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                              if(position==0){
                                                 display("g-net solution coimbatore private limited",position,"Rajana R");


                                              }
                                              if(position==3) {
                                        display("Soliton Technologies Pvt Ltd",position,"Nivedha S");
                                              }
                                          else{
                                          display("i2 Software Tech",position,"RAJANA R");}


        }
                                      });



    }
    private void LogOut(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Retrive.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        finish();
                        startActivity(new Intent(Retrive.this,MainActivity.class));
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
    private void display(final String cname1, final int position, final String name){

        AlertDialog.Builder builder = new AlertDialog.Builder(Retrive.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("ACCEPT OR REJECT PROCESS....")
                .setCancelable(false)
                .setPositiveButton("ACCEPT", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Random random = new Random();

                        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                        SecureRandom rnd = new SecureRandom();
                      int len=10;
                            StringBuilder sb = new StringBuilder(len);
                            for (int i = 0; i < len; i++)
                                sb.append(AB.charAt(rnd.nextInt(AB.length())));



                       sendemailaccept(name,cname1,sb);

                       sendsmsaccept(cname1,sb);

                       finish();
                    }
                })
                .setNeutralButton("REJECT", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                       sendmail(name,cname1);
                       sendsms(cname1);




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
    private void sendmail(String name,String cname1){
        String to = "nivedha1320@gmail.com";
        String subject= "IV GUIDE APP REQUEST PROCESS..";
        String body="Hi "+name+"..."+"\n"+"\n"+
                "your request for company  "+cname1+"   has been rejected!!!  "+"\n"+
                "for more info contact : ivguide@gmail.com";
        String mailTo = "mailto:" + to +
                "?&subject=" + Uri.encode(subject) +
                "&body=" + Uri.encode(body);
        Intent emailIntent = new Intent(Intent.ACTION_VIEW);
        emailIntent.setData(Uri.parse(mailTo));
        startActivity(emailIntent);

    }
            private void sendemailaccept(String name, String cname1, StringBuilder random){
                String to = "nivedha1320@gmail.com";
                String subject= "IV GUIDE APP REQUEST PROCESS..";
                String body="Hi "+name+"..."+"\n"+"\n"+
                        "your request for company  "+cname1+"   has been accepted!!!  "+"\n"+
                        "Random Acess NO : "+" "+random.toString()+" "+
                        "for more info contact : ivguide@gmail.com"+" "+"DATE AND TIME:";
                String mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject) +
                        "&body=" + Uri.encode(body);
                Intent emailIntent = new Intent(Intent.ACTION_VIEW);
                emailIntent.setData(Uri.parse(mailTo));
                startActivity(emailIntent);

            }
    private void sendsms(String cname1){
        Intent intent=new Intent(getApplicationContext(),adminlogin2.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        String no="9488585385",msg="Message from Ivgude Application" +
                "your register for the company "+" " +cname1+"is failed.....sorry!!";

        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(no, null, msg, pi,null);

    }
            private void sendsmsaccept(String cname1,StringBuilder random){
                Intent intent=new Intent(getApplicationContext(),adminlogin2.class);
                PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                String no="9488585385",msg="Message from Ivgude Application" +
                        "your register for "+" " +cname1+"has been accepted successfully!!!"+"\n"+"RANDOM ACCESS NO : "+random.toString();


                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi,null);

            }
}
