package tw.com.pcschool.db101902;

import android.app.Notification;
import android.app.NotificationManager;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void click1(View v)
    {
        Notification.Builder builer = new Notification.Builder(MainActivity.this);
        builer.setContentTitle("Test1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("這是 Notification 測試");
        Notification notification = builer.build();
        nm.notify(123, notification);
    }
    public void click2(View v)
    {
        Intent it = new Intent(MainActivity.this, MyService.class);
        startService(it);
    }
    public void click3(View v)
    {
        Intent it = new Intent(MainActivity.this, MyService.class);
        stopService(it);
    }
}
