package com.example.a15017498.demo_schedulednotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScheduledNotificationReceiver extends BroadcastReceiver {

    int reqCode = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent (context,MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context,reqCode,i, PendingIntent.FLAG_CANCEL_CURRENT);


        //Build Notification
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Amazing Offer!");
        builder.setContentText("Subject");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
       // This 1 is, when the user clicks on the notification
        builder.setContentIntent(pIntent);
        //To cancel
        builder.setAutoCancel(true);

        Notification n = builder.build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(123,n);




    }
}
