package Java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CrudOfPreMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_of_pre_menu_layout);
    }


    public void AddDelforPreMenuIsPressed(View view)
    {
        startActivity(new Intent(this,InsertInPreMenu.class));
    }


    public void UpdateforPreMenuIsPressed(View view)
    {
        startActivity(new Intent(this,UpdateInPreMenu.class));
    }

}
