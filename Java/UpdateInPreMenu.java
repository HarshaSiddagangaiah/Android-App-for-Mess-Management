package Java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class UpdateInPreMenu extends AppCompatActivity {


    EditText ET_PREVIOUSRECIPE, ET_NEWRECIPE;
    String PreviousRecipe, NewRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_in_pre_menu_layout);

        ET_PREVIOUSRECIPE = (EditText) findViewById(R.id.PreviousInPreMenuET);
        ET_NEWRECIPE = (EditText) findViewById(R.id.NewInPreMenuET);

    }

    public void PreviousNewButtonPreMenu(View view)
    {
        PreviousRecipe = ET_PREVIOUSRECIPE.getText().toString();
        NewRecipe = ET_NEWRECIPE.getText().toString();

        String method ="updateinpremenu";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,PreviousRecipe,NewRecipe);
        //finish();

    }

}
