package tw.com.pcschool.db101902;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm;
        nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builer = new Notification.Builder(context);
        builer.setContentTitle("Test1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("倒數五秒完成");
        Notification notification = builer.build();
        nm.notify(456, notification);

    }
}
