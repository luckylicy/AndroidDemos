package app.licy.open.androiddemos.app;

import android.app.Application;
import android.os.Build;

import com.alibaba.android.arouter.launcher.ARouter;

import app.licy.open.androiddemos.BuildConfig;

/**
 * MyApp
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/18
 * email ：licy3051@qq.com
 */
public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        init(this);
    }

    private void init(Application application) {

        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }

        ARouter.init(application);
    }
}
