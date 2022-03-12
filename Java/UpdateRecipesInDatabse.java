package Java;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateRecipesInDatabse extends AppCompatActivity {

    EditText ET_UpdateRECIPE1, ET_UpdateRECIPE2, ET_UpdateRECIPE3,ET_UpdateDay,ET_UpdateDate;
    String day,recipe1,recipe2,recipe3;

    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;
    String wholedateset, daytoset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_recipes_layout);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);



        ET_UpdateRECIPE1 = (EditText) findViewById(R.id.UpdateRecipe1);
        ET_UpdateRECIPE2 = (EditText) findViewById(R.id.UpdateRecipe2);
        ET_UpdateRECIPE3 = (EditText) findViewById(R.id.UpdateRecipe3);
        ET_UpdateDay = (EditText) findViewById(R.id.editDayInupdate);
        ET_UpdateDate = (EditText) findViewById(R.id.editDateInUpdate);

        ShowDialogOnBtnClick();

    }



    public void ShowDialogOnBtnClick(){

        btn = (Button) findViewById(R.id.PickDateDayInUpdateBtn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V)
            {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID)
            return new DatePickerDialog(this,dPickerListener, year_x,month_x,day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dPickerListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x=year;
            month_x=monthOfYear + 1;
            day_x= dayOfMonth;

            String ye = Integer.toString(year_x);
            String mo = Integer.toString(month_x);
            String da = Integer.toString(day_x);
            String dayName="";

            if(day_x>=1 && day_x<=9)
            {
                da="0"+da;
            }
            if(month_x>=1 && month_x<=9)
            {
                mo="0"+mo;
            }

            String AllInOne = da + "-" + mo + "-" +ye ;
            Date date = null;

            String dtStart = ye + "-" + mo + "-" +da ;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(dtStart);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            Calendar c = Calendar.getInstance();
            c.setTime(date); // yourdate is an object of type Date

            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String DOW = Integer.toString(dayOfWeek);
            switch (dayOfWeek) {
                case 1:
                    dayName = "Sunday";
                    break;
                case 2:
                    dayName = "Monday";
                    break;
                case 3:
                    dayName = "Tuesday";
                    break;
                case 4:
                    dayName = "Wednesday";
                    break;
                case 5:
                    dayName = "Thursday";
                    break;
                case 6:
                    dayName = "Friday";
                    break;
                case 7:
                    dayName = "Saturday";
                    break;
            }

            // Toast.makeText(ctx,dayName,Toast.LENGTH_LONG).show();
            Log.d("myTag", dayName);

            wholedateset = AllInOne;
            daytoset = dayName;

            ET_UpdateDay.setText(AllInOne, TextView.BufferType.EDITABLE);
            ET_UpdateDate.setText(dayName, TextView.BufferType.EDITABLE);

            Toast.makeText(UpdateRecipesInDatabse.this,day_x+"/"+month_x+"/"+year_x,Toast.LENGTH_SHORT).show();
            Log.d("myTag", dayName);


        }
    };




    public void UpdateRecipesInDB(View view)
    {
        recipe1 = ET_UpdateRECIPE1.getText().toString();
        recipe2 = ET_UpdateRECIPE2.getText().toString();
        recipe3 = ET_UpdateRECIPE3.getText().toString();

        String method ="updateRecipeDate";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,daytoset,wholedateset,recipe1,recipe2,recipe3);
        //finish();
    }

}
