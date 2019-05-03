package com.androidfung.notificationtesting;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Date;
import java.util.Random;

public class MyService extends JobService {
    private static final String TAG = MyService.class.getSimpleName();
    private static final String CHANNEL_ID = "DEFAULT";


    @Override
    public boolean onStartJob(JobParameters params) {

        Log.d(TAG, "MyService.onReceive() has started");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_noti_default)
                .setContentTitle("Testing ContentTitle")
                .setContentText("Testing ContentText: " + new Date().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(new Random().nextInt(), builder.build());
        // Indicate whether the task finished successfully with the Result
        Log.d(TAG, "MyService.onReceive() is finished");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
