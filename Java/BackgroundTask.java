package Java;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by user on 6/8/2017.
 */
public class BackgroundTask extends AsyncTask<String, Void, String> {

    AlertDialog alertDialog;
    Context ctx;

    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }
    public String checking="";
    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");
    }

    @Override
    protected String doInBackground(String... voids) {

        String reg_url = "http://10.0.2.2/packagesmess/androidregister.php";
        String login_url = "http://10.0.2.2/packagesmess/androidlogin.php";
        String AddNewRecipe_url = "http://10.0.2.2/packagesmess/androidaddrecipe.php";
        String DeleteRecipe_url = "http://10.0.2.2/packagesmess/androiddeleterecipe.php";
        String UpdateRecipe_url = "http://10.0.2.2/packagesmess/androidUpdaterecipe.php";
        String Changepassword_url = "http://10.0.2.2/packagesmess/androidChangepassword.php";
        String DeleteRecipeDate_url = "http://10.0.2.2/packagesmess/androiddeleterecipedate.php";
        String AddNewRecipeDate_url = "http://10.0.2.2/packagesmess/androidaddrecipedate.php";
        String UpdateRecipeDate_url = "http://10.0.2.2/packagesmess/androidUpdaterecipedate.php";
        String AddInPreMenuHere_url = "http://10.0.2.2/packagesmess/androidAddInPreMenuHere.php";
        String DeletefromPreMenuHere_url = "http://10.0.2.2/packagesmess/androidDeleteFromPreMenuHere.php";
        String UpdateInPreMenuHere_url = "http://10.0.2.2/packagesmess/androidUpdateInPreMenuHere.php";

        String method = voids [0];

        if(method.equals("register"))
        {
            String employeeno = voids[1];
            String employeepassword = voids[2];
            Log.d("myTag", employeepassword);
            String confirmpassword = voids[3];

            try
            {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("employeeno","UTF-8")+"="+URLEncoder.encode(employeeno,"UTF-8")+"&"+
                        URLEncoder.encode("employeepassword","UTF-8")+"="+URLEncoder.encode(employeepassword,"UTF-8")+"&"+
                        URLEncoder.encode("confirmpassword","UTF-8")+"="+URLEncoder.encode(confirmpassword,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                Log.d("myTag", employeepassword);
                return "Registration Successful";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if (method.equals("login"))
        {
            String employeeno = voids[1];
            String employeepassword = voids[2];
            Log.d("myTag", employeepassword);

            try
            {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("employeeno","UTF-8")+"="+URLEncoder.encode(employeeno,"UTF-8")+"&"+
                        URLEncoder.encode("employeepassword","UTF-8")+"="+URLEncoder.encode(employeepassword,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));

                String response="";
                String line = "";

                while((line = bufferedReader.readLine())!=null)
                {
                    response+=line;
                }

                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                Log.d("myTag", response);
                return response;




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (method.equals("changethepassword"))
        {
            String currentpassword = voids[1];
            String newpassword = voids[2];
            String employeeno = voids[3];
            Log.d("myTag", currentpassword);
            Log.d("myTag", newpassword);
            Log.d("myTag", employeeno);

            try
            {
                URL url = new URL(Changepassword_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("currentpassword","UTF-8")+"="+URLEncoder.encode(currentpassword,"UTF-8")+"&"+
                        URLEncoder.encode("newpassword","UTF-8")+"="+URLEncoder.encode(newpassword,"UTF-8")
                        +"&"+ URLEncoder.encode("employeeno","UTF-8")+"="+URLEncoder.encode(employeeno,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));

                String response="";
                String line = "";

                while((line = bufferedReader.readLine())!=null)
                {
                    response+=line;
                }

                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                Log.d("myTag", response);
                return response;




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("addinpremenu"))
        {
            String recipe1 = voids[1];

            try
            {
                URL url = new URL(AddInPreMenuHere_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("Recipe1","UTF-8")+"="+URLEncoder.encode(recipe1,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipe Saved in PreMenu";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("delinpremenu"))
        {
            String recipe1 = voids[1];

            try
            {
                URL url = new URL(DeletefromPreMenuHere_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("Recipe1","UTF-8")+"="+URLEncoder.encode(recipe1,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipe Deleted from PreMenu";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(method.equals("updateinpremenu"))
        {
            String Recipe1 = voids[1];
            String Recipe2 = voids[2];

            try
            {
                URL url = new URL(UpdateInPreMenuHere_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("Recipe1","UTF-8")+"="+URLEncoder.encode(Recipe1,"UTF-8")+"&"+
                        URLEncoder.encode("Recipe2","UTF-8")+"="+URLEncoder.encode(Recipe2,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipe Updated";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }



        else if(method.equals("addRecipe"))
        {
            String day = voids[1];
            String recipe1 = voids[2];
            String recipe2 = voids[3];
            String recipe3 = voids[4];

            try
            {
                URL url = new URL(AddNewRecipe_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8")+"&"+
                        URLEncoder.encode("recipe1","UTF-8")+"="+URLEncoder.encode(recipe1,"UTF-8")+"&"+
                        URLEncoder.encode("recipe2","UTF-8")+"="+URLEncoder.encode(recipe2,"UTF-8")+"&"+
                        URLEncoder.encode("recipe3","UTF-8")+"="+URLEncoder.encode(recipe3,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipes Saved";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("addRecipeDate"))
        {
            String day = voids[1];
            String date = voids[2];
            String recipe1 = voids[3];
            String recipe2 = voids[4];
            String recipe3 = voids[5];

            try
            {
                URL url = new URL(AddNewRecipeDate_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8")+"&"+
                        URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8")+"&"+
                        URLEncoder.encode("recipe1","UTF-8")+"="+URLEncoder.encode(recipe1,"UTF-8")+"&"+
                        URLEncoder.encode("recipe2","UTF-8")+"="+URLEncoder.encode(recipe2,"UTF-8")+"&"+
                        URLEncoder.encode("recipe3","UTF-8")+"="+URLEncoder.encode(recipe3,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipes Saved";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("deleteRecipes"))
        {
            String day = voids[1];

            try
            {
                URL url = new URL(DeleteRecipe_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipes Deleted";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("deleteRecipesDate"))
        {
            String day = voids[1];
            String date = voids[2];

            try
            {
                URL url = new URL(DeleteRecipeDate_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8")+"&"+
                        URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipes Deleted";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("updateRecipe"))
        {
            String day = voids[1];
            String recipe1 = voids[2];
            String recipe2 = voids[3];
            String recipe3 = voids[4];

            Log.d("myTag", recipe1);
            Log.d("myTag", recipe2);
            Log.d("myTag", recipe3);
            Log.d("myTag", day);

            try
            {
                URL url = new URL(UpdateRecipe_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8")+"&"+
                        URLEncoder.encode("recipe1","UTF-8")+"="+URLEncoder.encode(recipe1,"UTF-8")+"&"+
                        URLEncoder.encode("recipe2","UTF-8")+"="+URLEncoder.encode(recipe2,"UTF-8")+"&"+
                        URLEncoder.encode("recipe3","UTF-8")+"="+URLEncoder.encode(recipe3,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipes Updated";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("updateRecipeDate"))
        {
            String day = voids[1];
            String date = voids[2];
            String recipe1 = voids[3];
            String recipe2 = voids[4];
            String recipe3 = voids[5];

            Log.d("myTag", recipe1);
            Log.d("myTag", recipe2);
            Log.d("myTag", recipe3);
            Log.d("myTag", day);

            try
            {
                URL url = new URL(UpdateRecipeDate_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data = URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8")+"&"+
                        URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8")+"&"+
                        URLEncoder.encode("recipe1","UTF-8")+"="+URLEncoder.encode(recipe1,"UTF-8")+"&"+
                        URLEncoder.encode("recipe2","UTF-8")+"="+URLEncoder.encode(recipe2,"UTF-8")+"&"+
                        URLEncoder.encode("recipe3","UTF-8")+"="+URLEncoder.encode(recipe3,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Recipes Updated";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

         if (result.equals("Registration Successful"))
         {
             Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
         }

       else if (result.equals("Recipes Saved"))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }

         else if (result.equals("Recipes Deleted"))
         {
             Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
         }
         else if (result.equals("Recipes Updated"))
         {
             Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
         }

         else if (result.equals("Login Successful"))
         {
             Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
             ctx.startActivity(new Intent(ctx, CRUDforAdmin.class));


         }

       else
        {
            this.checking=result.toString();
            Log.d("myTag", checking);
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();


        }


    }
}
