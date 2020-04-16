package app.licy.open.androiddemos.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import app.licy.open.androiddemos.R;

/**
 * PermissionTestActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/15
 * email ：licy3051@qq.com
 */
public class PermissionTestActivity extends AppCompatActivity {

    private Button btnApply;
    private static final String TAG = "PermissionTestActivity";
    private Context mContext;

    private boolean isNeedRequest = false;

    private static final int BASIC_PERMISSIONS_REQUEST_CODE = 110;

    private final String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET,
            Manifest.permission.MODIFY_AUDIO_SETTINGS,
            Manifest.permission.WRITE_SETTINGS,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_test);
        mContext = this;
        btnApply = findViewById(R.id.btn_apply);

        btnApply.setOnClickListener(v -> requestPermission());
    }

    private void requestPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            for (int i = 0; i < BASIC_PERMISSIONS.length; i++) {
                if (ActivityCompat.checkSelfPermission(mContext, BASIC_PERMISSIONS[i]) != PackageManager.PERMISSION_GRANTED) {
                    isNeedRequest = true;
                }
            }

            if (isNeedRequest) {
                ActivityCompat.requestPermissions(PermissionTestActivity.this, BASIC_PERMISSIONS, BASIC_PERMISSIONS_REQUEST_CODE);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == BASIC_PERMISSIONS_REQUEST_CODE) {

            if (grantResults.length > 0) {

                for (int i = 0; i < grantResults.length; i++) {
                    if (PackageManager.PERMISSION_GRANTED == grantResults[i]) {
                        Log.d(TAG, permissions[i] + " is granted ~ ");
                    } else {
                        Log.e(TAG, permissions[i] + " is denied ~ ");
                    }
                }


            }

        }


    }
}
