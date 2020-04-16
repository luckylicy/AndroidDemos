package app.licy.open.androiddemos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.licy.open.androiddemos.R;

/**
 * IntentTestSecondActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/16
 * email ：licy3051@qq.com
 */
public class IntentTestSecondActivity extends AppCompatActivity {


    private Button mBtnBack;

    public static final int RESULT_CODE = 1002;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test_second);

        mBtnBack = findViewById(R.id.btn_back);

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("11", "1111111");
                setResult(RESULT_CODE, intent);
                finish();
            }
        });
    }
}
