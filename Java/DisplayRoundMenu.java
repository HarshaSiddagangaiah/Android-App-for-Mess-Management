package Java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class DisplayRoundMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_round_menu_layout);
    }

    public void CircleButton1Pressed(View view)
    {
        Toast.makeText(DisplayRoundMenu.this,"Circle Button 1",Toast.LENGTH_SHORT).show();
    }

}
