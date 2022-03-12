package Java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ChangeCurrentPassword extends AppCompatActivity {

    EditText ET_CURRENTPASSWORD, ET_NEWPASSWORD, ET_EMPLOYEENO;
    String currentpassword,newpassword,employeeno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_current_password_layout);

        ET_CURRENTPASSWORD = (EditText) findViewById(R.id.editCurrentPassword);
        ET_NEWPASSWORD = (EditText) findViewById(R.id.editNewPassword);
        ET_EMPLOYEENO = (EditText) findViewById(R.id.editEmployeeno3);
    }

    public void ChangeThePasswordInside(View view)
    {
        currentpassword = ET_CURRENTPASSWORD.getText().toString();
        newpassword = ET_NEWPASSWORD.getText().toString();
        employeeno = ET_EMPLOYEENO.getText().toString();

        String method ="changethepassword";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        Log.d("myTag", newpassword);
        backgroundTask.execute(method, currentpassword,newpassword,employeeno);
        finish();
    }
}
