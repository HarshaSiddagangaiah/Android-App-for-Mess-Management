package Java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayPreMenuAll extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PreMenuGetSetAdapter preMenuGetSetAdapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_pre_menu_all_layout);

        listView = (ListView) findViewById(R.id.listviewPreMenu);

        preMenuGetSetAdapter= new PreMenuGetSetAdapter(this,R.layout.premenu_layouts);
        listView.setAdapter(preMenuGetSetAdapter);

        json_string = getIntent().getExtras().getString("json_data");

        Log.d("myTag", json_string);

        try
        {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count= 0;

            String recipe1;

            while(count<jsonArray.length())
            {

                JSONObject JO = jsonArray.getJSONObject(count);

                recipe1 = JO.getString("Recipe1");

                PreMenuGetSet preMenuGetSet = new PreMenuGetSet(recipe1);
                preMenuGetSetAdapter.add(preMenuGetSet);
                count++;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void PreMenuBackButtonPressed(View view)
    {
        finish();
        startActivity(new Intent(this,CRUDforAdmin.class));
    }

}
