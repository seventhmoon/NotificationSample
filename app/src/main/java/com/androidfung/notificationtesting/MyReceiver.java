package com.androidfung.notificationtesting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Date;
import java.util.Random;

public class MyReceiver extends BroadcastReceiver {

    private static String TAG = MyReceiver.class.getSimpleName();
    private final String CHANNEL_ID = "DEFAULT";

    @Override
    public void onReceive(Context context, Intent intent) {

//        throw new UnsupportedOperationException("Not yet implemented");

        Log.d(TAG, "MyReceiver.onReceive() has started");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_noti_default)
                .setContentTitle("Testing ContentTitle")
                .setContentText("Testing ContentText: " + new Date().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(new Random().nextInt(), builder.build());
        // Indicate whether the task finished successfully with the Result
        Log.d(TAG, "MyReceiver.onReceive() is finished");
    }
}
