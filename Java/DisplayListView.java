package Java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    MenuByDayAdapter menuByDayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);

        listView = (ListView) findViewById(R.id.listView1);


        menuByDayAdapter = new MenuByDayAdapter(this,R.layout.row_layout);
        listView.setAdapter(menuByDayAdapter);

        json_string = getIntent().getExtras().getString("json_data");

        try
        {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count= 0;

            String date,day, recipe1, recipe2, recipe3;

            while(count<jsonArray.length())
            {

                JSONObject JO = jsonArray.getJSONObject(count);
                date = JO.getString("date");
                day = JO.getString("day");
                recipe1 = JO.getString("recipe1");
                recipe2 = JO.getString("recipe2");
                recipe3 = JO.getString("recipe3");
                MenuByDay menuByDay = new MenuByDay(date,day,recipe1,recipe2,recipe3);
                menuByDayAdapter.add(menuByDay);
                count++;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void FullBackButtonPressed(View view)
    {
        finish();
        startActivity(new Intent(this,CRUDforAdmin.class));
    }
}
