package tw.com.pcschool.db101902;

import android.app.Notification;
import android.app.NotificationManager;
import android.bluetooth.BluetoothClass;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    TextView tv2;
    MyRec rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        tv2 = (TextView) findViewById(R.id.textView2);
        rec = new MyRec();
    }

    class MyRec extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            tv2.setText("倒數完成!!!");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(rec, new IntentFilter("CC5"));
    }

    @Override
    protected void onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(rec);
        super.onStop();
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
