package Java.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.mDataObject.Spacecraft;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    Spinner sp;
    Spinner sp2;
    Spinner sp3;
    String jsonData;

    ProgressDialog pd;
    ArrayList<String> spacecrafts=new ArrayList<>();
    ArrayList<String> spacecrafts2=new ArrayList<>();
    ArrayList<String> spacecrafts3=new ArrayList<>();

    public DataParser(Context c, Spinner sp,Spinner sp2,Spinner sp3, String jsonData) {
        this.c = c;
        this.sp = sp;
        this.sp2 = sp2;
        this.sp3 = sp3;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if(result==0)
        {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(c,"Parsed Successsfully",Toast.LENGTH_SHORT).show();

            //BIND
            ArrayAdapter adapter=new ArrayAdapter(c,android.R.layout.simple_list_item_1,spacecrafts);
            ArrayAdapter adapter2=new ArrayAdapter(c,android.R.layout.simple_list_item_1,spacecrafts2);
            ArrayAdapter adapter3=new ArrayAdapter(c,android.R.layout.simple_list_item_1,spacecrafts3);
            sp.setAdapter(adapter);
            sp2.setAdapter(adapter2);
            sp3.setAdapter(adapter3);



        }
    }

    private int parseData()
    {
        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            spacecrafts.clear();
            Spacecraft s=null;
            spacecrafts2.clear();
            Spacecraft s2=null;
            spacecrafts3.clear();
            Spacecraft s3=null;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                //   int id=jo.getInt("id");
                String name=jo.getString("Recipe1");

                s=new Spacecraft();
                //   s.setId(id);
                s.setName(name);

                spacecrafts.add(name);

                s2=new Spacecraft();
                //   s.setId(id);
                s2.setName(name);

                spacecrafts2.add(name);

                s3=new Spacecraft();
                //   s.setId(id);
                s3.setName(name);

                spacecrafts3.add(name);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;

    }

}
