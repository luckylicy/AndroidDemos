package app.licy.open.androiddemos.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * MusicService
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/18
 * email ：licy3051@qq.com
 */
public class MusicService extends IntentService {

    private static final String TAG = "MusicService";

    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_TIME = "KEY_TIME";
    public static final String KEY_MISSION_TYPE = "KEY_MISSION_TYPE";

    public MusicService( ) {
        super("");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){

            String name = intent.getStringExtra(KEY_NAME);
            int time = intent.getIntExtra(KEY_TIME, 0);
            int type = intent.getIntExtra(KEY_MISSION_TYPE, 0);

            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else {
            Log.d(TAG, "intent is null!!!");
        }
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);

        Log.d(TAG, "onStart");
        Log.d(TAG, "intent is " + intent + " \n startId is " + startId);

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        Log.d(TAG, "intent is " + intent + " \n startId is " + startId + " \n flags is  " + flags);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        Log.d(TAG, "intent is " + intent);
        return super.onBind(intent);
    }


}
