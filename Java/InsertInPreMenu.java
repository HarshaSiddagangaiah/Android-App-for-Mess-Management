package Java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class InsertInPreMenu extends AppCompatActivity {

    EditText ET_ADDRECIPE, ET_DELETERECIPE;
    String AddRecipe, DelRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_in_pre_menu_layout);

        ET_ADDRECIPE = (EditText) findViewById(R.id.PickAddInPreMenuET);
        ET_DELETERECIPE = (EditText) findViewById(R.id.PickDELETEInPreMenuET);


    }

    public void AddInPreMenuPressedHere(View view)
    {

        AddRecipe = ET_ADDRECIPE.getText().toString();

        String method ="addinpremenu";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,AddRecipe);
        //finish();

    }

    public void DeleteInPreMenuPressedHere(View view)
    {
        DelRecipe = ET_DELETERECIPE.getText().toString();

        String method ="delinpremenu";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,DelRecipe);
        //finish();
    }

}
