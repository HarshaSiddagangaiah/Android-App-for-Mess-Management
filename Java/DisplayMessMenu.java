package Java;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DisplayMessMenu extends Activity {

    String JSON_STRING;
    String JSON_PARSESTRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaymenu);
        GetJSON();
    }


    public void GetJSON()
    {
        new BackgroundJSON().execute();
    }




    class BackgroundJSON extends AsyncTask<Void, Void, String>
    {
        String json_url;
            // HAVE TO MAKE A WHOLE NEW ACTIVITY FOR THIS LATER
        @Override
        protected void onPreExecute() {
            json_url = "http://10.0.2.2/packagesmess/androidmenudisplaywhole.php";
        }


        @Override
        protected String doInBackground(Void... voids) {
            try
            {
                json_url = "http://10.0.2.2/packagesmess/androidmenudisplaywhole.php";
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }



        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView  = (TextView)findViewById(R.id.txtdisplaymenu);
            textView.setText(result);
            JSON_PARSESTRING=result;
        }
    }

    public void parseJSON(View view)
    {
            if(JSON_PARSESTRING==null)
            {
                Toast.makeText(getApplicationContext(),"Processing..",Toast.LENGTH_SHORT).show();
            }

            else
            { // NEW FILE HERE TOO
                Intent intent = new Intent(this,DisplaySingleListView.class);
                intent.putExtra("json_data",JSON_PARSESTRING);
                startActivity(intent);


            }

        finish();

    }




}
