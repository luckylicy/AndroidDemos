package app.licy.open.androiddemos.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static final String TAG = "TimeDealActivity";

    @BindView(R.id.tv_get_time)
    TextView tvGetTime;
    @BindView(R.id.tv_result)
    TextView tvResult;

    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z", Locale.getDefault());
    SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    String time = "2020-04-28T01:53:39.000Z";

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

                try {
                    time = time.replace("Z", " UTC");
                    Log.d(TAG, time);
                    Date date = dateFormat2.parse(time);
                    if (date != null) {
                        result = dateFormat3.format(date);
                        Log.d(TAG, result);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.tv_result:
                tvResult.setText(result);
                break;
            default:
                break;
        }
    }
}
