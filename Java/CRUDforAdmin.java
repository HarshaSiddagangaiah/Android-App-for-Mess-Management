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

public class CRUDforAdmin extends AppCompatActivity {

    String MethodCheck="";
    String JSON_STRING;
    String JSON_PARSESTRING;
    BackgroundJSON3 backgroundJSON3 = new BackgroundJSON3(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crudfor_admin_layout);
    }


    class BackgroundJSON3 extends AsyncTask<String, Void, String>
    {
        Context ctx;

        BackgroundJSON3(Context ctx)
        {
            this.ctx=ctx;
        }

        String json_url;
        @Override
        protected void onPreExecute() {
        }


        @Override
        protected String doInBackground(String... voids) {


            String method = voids[0];

            if(method.equals("wholemenu")) {
                json_url = "http://10.0.2.2/packagesmess/androidmenudisplaywhole.php";
            }

          else if(method.equals("premenu")) {
                json_url = "http://10.0.2.2/packagesmess/androidmenudisplaypremenu.php";
            }

                try {



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


            if(MethodCheck.equals("wholemenu")) {

                JSON_PARSESTRING = result;
                Intent intent = new Intent(ctx, DisplayListView.class);
                intent.putExtra("json_data", JSON_PARSESTRING);
                ctx.startActivity(intent);
            }

           else if(MethodCheck.equals("premenu")) {

                JSON_PARSESTRING = result;
                Intent intent = new Intent(ctx, DisplayPreMenuAll.class);
                intent.putExtra("json_data", JSON_PARSESTRING);
                ctx.startActivity(intent);
            }

        }
    }





    public void AddBtnInCrudPressed(View view)
    {
        startActivity(new Intent(this,AddMenuViaSpinnerLoading.class));
    }
    public void DeleteBtnInCrudPressed(View view)
    {
        startActivity(new Intent(this,DeleteViaDatePicker.class));
    }
    public void UpdateBtnInCrudPressed(View view)
    {
        startActivity(new Intent(this,UpdateRecipesInDatabse.class));
    }
    public void MenuBtnInCrudPressed(View view)
    {

        String method ="wholemenu";
        MethodCheck = "wholemenu";

        backgroundJSON3.execute(method);
        if(JSON_PARSESTRING==null)
        {
            Toast.makeText(getApplicationContext(),"Processing..",Toast.LENGTH_SHORT).show();
        }

        else
        { // NEW FILE HERE TOO
            Intent intent = new Intent(this,DisplayListView.class);
            intent.putExtra("json_data",JSON_PARSESTRING);
            startActivity(intent);

        }
        finish();
        Toast.makeText(CRUDforAdmin.this,"Whole Menu",Toast.LENGTH_SHORT).show();

    }

    public void DisplayPreMenuInCrudPressed(View view)
    {
        String method ="premenu";
        MethodCheck = "premenu";
        backgroundJSON3.execute(method);
        if(JSON_PARSESTRING==null)
        {
            Toast.makeText(getApplicationContext(),"Processing..",Toast.LENGTH_SHORT).show();
        }

        else
        { // NEW FILE HERE TOO
            Intent intent = new Intent(this,DisplayPreMenuAll.class);
            intent.putExtra("json_data",JSON_PARSESTRING);
            startActivity(intent);

        }
        finish();
        Toast.makeText(CRUDforAdmin.this,"Pre Menu",Toast.LENGTH_SHORT).show();
    }

    public void MenuByDayBtnInCrudPressed(View view)
    {
        startActivity(new Intent(this,CustomRectangularButtonsMenu.class));

    }

    public void RegisterBtnInCrudPressed(View view)
    {
        startActivity(new Intent(this,Register.class));
    }

    public void PasswordChangeBtnInCrudPressed(View view)
    {
        startActivity(new Intent(this,ChangeCurrentPassword.class));
    }

    public void DetailOfPreMenuBtn(View view)
    {
        startActivity(new Intent(this,CrudOfPreMenu.class));
    }



}
