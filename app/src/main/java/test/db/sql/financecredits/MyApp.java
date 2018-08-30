package test.db.sql.financecredits;

import android.app.Application;

import com.financeapp.mfo.R;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public class MyApp extends Application {
    String metrika;
    @Override
    public void onCreate() {
        super.onCreate();
        metrika = getString(R.string.metrika);
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder(metrika);
        YandexMetrica.activate(getApplicationContext(), configBuilder.build());
        YandexMetrica.enableActivityAutoTracking(this);
    }
}
