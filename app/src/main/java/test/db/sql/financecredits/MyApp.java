package test.db.sql.financecredits;

import android.app.Application;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder("07b2a61b-7de6-4531-886f-31660202b96b");
        YandexMetrica.activate(getApplicationContext(), configBuilder.build());

        YandexMetrica.enableActivityAutoTracking(this);
    }
}
