package tw.com.pcschool.db101902;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;


public class MyService extends Service {
    int i = 5;
    private Handler handler = new Handler();
    private Runnable showTime = new Runnable() {
        public void run() {
// 顯示目前時間
            Log.i("mylog", new Date().toString());
            i--;
            if (i < 0)
            {
                stopSelf();
            }
            handler.postDelayed(this, 1000);

        }
    };
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("SEC", "Start!!");
        handler.post(showTime);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("SEC", "Destroy");
        handler.removeCallbacks(showTime);

        Intent it = new Intent();
        it.setAction("COUNT5");
        sendBroadcast(it);
        super.onDestroy();
    }
}
