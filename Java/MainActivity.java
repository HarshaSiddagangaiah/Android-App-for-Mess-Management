package Java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ET_EMPLOYEENO, ET_PASS;
    String employeeno,employeepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_EMPLOYEENO = (EditText) findViewById(R.id.employeeno1);
        ET_PASS = (EditText) findViewById(R.id.psw1);

    }

    public void userReg(View view)
    {
        startActivity(new Intent(this,Register.class));
    }

    public void userLogin(View view)
    {
        employeeno = ET_EMPLOYEENO.getText().toString();
        employeepassword = ET_PASS.getText().toString();

        String method ="login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        Log.d("myTag", employeepassword);
        backgroundTask.execute(method, employeeno,employeepassword);
       // finish();
        Log.d("myTag", backgroundTask.checking);
        String checkingLogin = backgroundTask.checking.toString();
        Log.d("myTag", checkingLogin);


    }

    public void openMenu(View view)
    {
        startActivity(new Intent(this,CustomRectangularButtonsMenu.class));
    }



}
