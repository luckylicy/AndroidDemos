package app.licy.open.androiddemos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import app.licy.open.androiddemos.R;
import app.licy.open.androiddemos.service.MusicService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ServiceTestActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/18
 * email ：licy3051@qq.com
 */
public class ServiceTestActivity extends AppCompatActivity {


    @BindView(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        Intent intent = new Intent(ServiceTestActivity.this, MusicService.class);
        intent.putExtra(MusicService.KEY_NAME, "licy");
        intent.putExtra(MusicService.KEY_TIME, 30);
        intent.putExtra(MusicService.KEY_MISSION_TYPE, 1);

        ContextCompat.startForegroundService(ServiceTestActivity.this, intent);
    }


}
