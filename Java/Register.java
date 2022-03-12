package Java;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class Register extends Activity {

    EditText ET_EMPLOYEENO, ET_PASSWORD, ET_CONFIRMPASSWORD;
    String employeeno,password,confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        ET_EMPLOYEENO = (EditText) findViewById(R.id.employeeno2);
        ET_PASSWORD = (EditText) findViewById(R.id.psw2);
        ET_CONFIRMPASSWORD = (EditText) findViewById(R.id.confirmpsw2);

    }

    public void userReg(View view)
    {
        employeeno = ET_EMPLOYEENO.getText().toString();
        password = ET_PASSWORD.getText().toString();
        confirmpassword = ET_CONFIRMPASSWORD.getText().toString();

        String method ="register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        Log.d("myTag", password);
        backgroundTask.execute(method, employeeno,password,confirmpassword);
        finish();
    }

}








