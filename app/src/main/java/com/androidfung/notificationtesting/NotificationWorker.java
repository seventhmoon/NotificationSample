package com.androidfung.notificationtesting;

import android.content.Context;
import android.util.Log;

import java.util.Date;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {

    private final String TAG = NotificationWorker.class.getSimpleName();
    private final String CHANNEL_ID = "DEFAULT";

    public NotificationWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {

        Log.d(TAG, "NotificationWorker.dowork() has started");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_noti_default)
                .setContentTitle("Testing ContentTitle")
                .setContentText("Testing ContentText: " + new Date().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(new Random().nextInt(), builder.build());
        // Indicate whether the task finished successfully with the Result
        Log.d(TAG, "NotificationWorker.dowork() is finished");

        return Result.success();
    }


}
