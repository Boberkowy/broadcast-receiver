package com.example.boberkowy.broadcastreceiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private final String channelId = "channelId";
    private int id = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("RECEIVER", "RECEIEVED INTENT");

        Intent launchIntent = new Intent("android.intent.action.myaction");
        launchIntent.setAction("android.intent.action.myaction");
        launchIntent.addCategory("android.intent.category.DEFAULT");

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notify = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Dodano nowy produkt:")
                .setContentText(intent.getStringExtra("product_id"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat nm = NotificationManagerCompat.from(context);

        nm.notify(id++, notify.build());
    }
}
