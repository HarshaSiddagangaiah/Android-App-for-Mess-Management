package Java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplaySingleListView extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    MenuOneDayAdapter menuOneDayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_single_list_view_layout);

        listView = (ListView) findViewById(R.id.listViewSingle);

        menuOneDayAdapter = new MenuOneDayAdapter(this,R.layout.one_dayonly_layout);

        listView.setAdapter(menuOneDayAdapter);

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
                menuOneDayAdapter.add(menuByDay);
                count++;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void BackButtonPressed(View view)
    {
        finish();
        startActivity(new Intent(this,CustomRectangularButtonsMenu.class));
    }
}
