package test.db.sql.financecredits;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.finance.creditcard.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestActivity extends AppCompatActivity {
    String name;
    String surname;
    String phone;
    EditText etName, etSurname, etPhone;
    CheckBox mCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        setTitle(R.string.makeRequest);

        etName = (EditText) findViewById(R.id.editTextName);
        etSurname = (EditText) findViewById(R.id.editTextSurname);
        etPhone = (EditText) findViewById(R.id.editTextPhone);

        mCheckBox = (CheckBox)findViewById(R.id.checkBox);
    }
    class SendLoginData extends AsyncTask<Void, Void, Void> {

        String resultString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                name = etName.getText().toString();
                surname = etSurname.getText().toString();
                phone = etPhone.getText().toString();
                String myURL = "http://kesh.online/lead.php?name="+name+"&surname="+surname+"&phone="+phone;
                String parammetrs = "param1=1&param2=XXX";
                byte[] data = null;
                InputStream is = null;

                try {
                    URL url = new URL(myURL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    conn.setRequestProperty("Content-Length", "" + Integer.toString(parammetrs.getBytes().length));
                    OutputStream os = conn.getOutputStream();
                    data = parammetrs.getBytes("UTF-8");
                    os.write(data);
                    data = null;

                    conn.connect();
                    int responseCode= conn.getResponseCode();

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    if (responseCode == 200) {
                        is = conn.getInputStream();

                        byte[] buffer = new byte[8192]; // Такого вот размера буфер
                        // Далее, например, вот так читаем ответ
                        int bytesRead;
                        while ((bytesRead = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, bytesRead);
                        }
                        data = baos.toByteArray();
                        resultString = new String(data, "UTF-8");
                    } else {
                    }



                } catch (MalformedURLException e) {

                    //resultString = "MalformedURLException:" + e.getMessage();
                } catch (IOException e) {

                    //resultString = "IOException:" + e.getMessage();
                } catch (Exception e) {

                    //resultString = "Exception:" + e.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(resultString != null) {
                Intent intent = new Intent(RequestActivity.this, ThanksActivity.class);
                startActivity(intent);
            }

        }
    }

    public void onClickRequest (View view) {
        etName.getText().length();
        etSurname.getText().length();
        etPhone.getText().length();
        if ((etName.getText().length()!=0) && (etSurname.getText().length()!=0) && (etPhone.getText().length()!=0)){
            if (mCheckBox.isChecked()) {
                new SendLoginData().execute();
//                Toast.makeText(RequestActivity.this, "ok", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(RequestActivity.this, "Необходимо согласие на обработку персональных данных", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(RequestActivity.this, "Заполните поля!", Toast.LENGTH_LONG).show();
        }




    }

}
