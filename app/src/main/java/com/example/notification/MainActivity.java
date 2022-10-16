package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private static final String CHANNEL_ID = "Shatarko";
    private static final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.mainlogo, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcone = bitmapDrawable.getBitmap();

        NotificationManager rm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            notification = new Notification.Builder(this,CHANNEL_ID)
                    .setLargeIcon(largeIcone)
                    .setSmallIcon(R.drawable.mainlogo)
                    .setContentText("Hub is online.")
                    .setSubText("New message from Shatarko")
                    .setChannelId(CHANNEL_ID)
                    .build();
            rm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "new", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcone)
                    .setSmallIcon(R.drawable.mainlogo)
                    .setContentText("New message")
                    .setSubText("New message from Asif")
                    .build();

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rm.notify(NOTIFICATION_ID,notification);

            }
        });
    }
}