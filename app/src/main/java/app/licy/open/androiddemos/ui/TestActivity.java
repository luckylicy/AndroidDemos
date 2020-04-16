package app.licy.open.androiddemos.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.licy.open.androiddemos.R;

/**
 * TestActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/16
 * email ：licy3051@qq.com
 */
public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    StringBuilder stringBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        stringBuilder = new StringBuilder();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "dddddd" + stringBuilder.toString() + "fffff");
    }
}
