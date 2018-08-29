package test.db.sql.financecredits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.finance.creditcard.R;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        setTitle(R.string.description);
    }
    public void onClickRequest (View view) {
        Intent intent = new Intent(DescriptionActivity.this, RequestActivity.class);
        startActivity(intent);
    }
}
