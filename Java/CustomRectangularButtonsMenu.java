package Java;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomRectangularButtonsMenu extends AppCompatActivity {

    String JSON_STRING;
    String JSON_PARSESTRING;
    BackgroundJSON2 backgroundJSON2 = new BackgroundJSON2(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_rectangular_buttons_menu_layout);


    }

    class BackgroundJSON2 extends AsyncTask<String, Void, String>
    {
        Context ctx;

        BackgroundJSON2(Context ctx)
        {
            this.ctx=ctx;
        }

        String json_url;
        // HAVE TO MAKE A WHOLE NEW ACTIVITY FOR THIS LATER
        @Override
        protected void onPreExecute() {
            json_url = "http://10.0.2.2/packagesmess/androidMondayMenu.php";
        }


        @Override
        protected String doInBackground(String... voids) {
            try {
                String method = voids[0];
                if (method.equals("monday")) {

                json_url = "http://10.0.2.2/packagesmess/androidMondayMenu.php";
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();


            }

                if (method.equals("tuesday")) {

                    json_url = "http://10.0.2.2/packagesmess/androidTuesdayMenu.php";
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();


                }

                if (method.equals("wednesday")) {

                    json_url = "http://10.0.2.2/packagesmess/androidWednesdayMenu.php";
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();


                }

                if (method.equals("thursday")) {

                    json_url = "http://10.0.2.2/packagesmess/androidThursdayMenu.php";
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();


                }

                if (method.equals("friday")) {

                    json_url = "http://10.0.2.2/packagesmess/androidFridayMenu.php";
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();


                }

                if (method.equals("saturday")) {

                    json_url = "http://10.0.2.2/packagesmess/androidSaturdayMenu.php";
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();


                }

                if (method.equals("sunday")) {

                    json_url = "http://10.0.2.2/packagesmess/androidSundayMenu.php";
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();


                }



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

            JSON_PARSESTRING=result;
            Intent intent = new Intent(ctx, DisplaySingleListView.class);
            intent.putExtra("json_data",JSON_PARSESTRING);
            ctx.startActivity(intent);

        }
    }




    public void MondayButtonPressed(View view)
    {
        String method ="monday";
        backgroundJSON2.execute(method);
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
        Toast.makeText(CustomRectangularButtonsMenu.this,"Monday Menu",Toast.LENGTH_SHORT).show();
    }
    public void TuesdayButtonPressed(View view)
    {
        String method ="tuesday";

        backgroundJSON2.execute(method);
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
        Toast.makeText(CustomRectangularButtonsMenu.this,"Tuesday Menu",Toast.LENGTH_SHORT).show();
    }
    public void WednesdayButtonPressed(View view)
    {
        String method ="wednesday";
        backgroundJSON2.execute(method);
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
        Toast.makeText(CustomRectangularButtonsMenu.this,"Wednesday Menu",Toast.LENGTH_SHORT).show();
    }
    public void ThursdayButtonPressed(View view)
    {
        String method ="thursday";
        backgroundJSON2.execute(method);
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

        Toast.makeText(CustomRectangularButtonsMenu.this,"Thursday Menu",Toast.LENGTH_SHORT).show();
    }
    public void FridayButtonPressed(View view)
    {
        String method ="friday";
        backgroundJSON2.execute(method);
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

        Toast.makeText(CustomRectangularButtonsMenu.this,"Friday Menu",Toast.LENGTH_SHORT).show();
    }
    public void SaturdayButtonPressed(View view)
    {
        String method ="saturday";
        backgroundJSON2.execute(method);
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

        Toast.makeText(CustomRectangularButtonsMenu.this,"Saturday Menu",Toast.LENGTH_SHORT).show();
    }
    public void SundayButtonPressed(View view)
    {
        String method ="sunday";
        backgroundJSON2.execute(method);
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

        Toast.makeText(CustomRectangularButtonsMenu.this,"Sunday Menu",Toast.LENGTH_SHORT).show();
    }

}
