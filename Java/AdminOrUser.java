package Java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AdminOrUser extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_or_user_layout);




    }

    public void UserPanelPressed(View view)
    {
        Toast.makeText(AdminOrUser.this,"User",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,CustomRectangularButtonsMenu.class));
    }

    public void AdminPanelPressed(View view)
    {
        Toast.makeText(AdminOrUser.this,"Admin",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

}
