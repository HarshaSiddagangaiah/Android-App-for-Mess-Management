package Java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DeleteRecipeByDay extends AppCompatActivity {


    String day;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_recipe_by_day_layout);

        dropdown = (Spinner)findViewById(R.id.spinner2);
        String[] items = new String[]{"Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday", "Sunday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


    }


    public void DeleteRecipeinDatabase(View view)
    {
        day = dropdown.getSelectedItem().toString();

        String method ="deleteRecipes";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,day);
        //finish();
    }


}
