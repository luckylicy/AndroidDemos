package app.licy.open.androiddemos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.licy.open.androiddemos.R;

/**
 * IntentTestActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/16
 * email ：licy3051@qq.com
 */
public class IntentTestActivity extends AppCompatActivity {

    private Button mBtnGoForward;

    public static final int REQUEST_CODE = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);

        mBtnGoForward = findViewById(R.id.btn_go_forward);

        mBtnGoForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(IntentTestActivity.this, IntentTestSecondActivity.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            String ss = data.getStringExtra("11");
            if (ss == null) {
                return;
            }
            Log.d("TAG", ss);
        }
    }
}
