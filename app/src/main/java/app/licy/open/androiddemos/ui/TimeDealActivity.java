package app.licy.open.androiddemos.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import app.licy.open.androiddemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TimeDealActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/17
 * email ：licy3051@qq.com
 */
public class TimeDealActivity extends AppCompatActivity {


    @BindView(R.id.tv_get_time)
    TextView tvGetTime;
    @BindView(R.id.tv_result)
    TextView tvResult;

    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
    SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    String result = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_format);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_get_time, R.id.tv_result})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_time:
                
                break;
            case R.id.tv_result:
                tvResult.setText(result);
                break;
            default:
                break;
        }
    }
}
