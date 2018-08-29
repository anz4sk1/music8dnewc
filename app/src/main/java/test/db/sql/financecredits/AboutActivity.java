package test.db.sql.financecredits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.finance.creditcard.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(R.string.aboutApp);
        TextView tvTermsOfUse = (TextView) findViewById(R.id.textLikeGP);
        tvTermsOfUse.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
