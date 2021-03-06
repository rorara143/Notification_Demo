package com.example.vitin.notification_demo;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    //build the object is going to be notification itself
    NotificationCompat.Builder notification;
    private static final int uniqueID = 45123; //notification has to be assigned unique

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// build the new notification
        notification = new NotificationCompat.Builder(this);
        //remove notification once it has been visited
        notification.setAutoCancel(true);

    }
    //customize the notification
    public void onClick(View view) {
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title");
        notification.setContentText("I am the body text of your notification");

        // send the notification to the home screen
        Intent i = new Intent(this, MainActivity.class);
        // give the device access to perform this intent by calling the PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        // send out the notification
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());
    
    }
}
