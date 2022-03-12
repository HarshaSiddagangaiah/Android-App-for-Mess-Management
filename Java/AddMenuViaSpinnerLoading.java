package Java;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Java.mMySQL.Downloader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddMenuViaSpinnerLoading extends AppCompatActivity {

    final static String urlAddress="http://10.0.2.2/packagesmess/spinnerload.php";
    EditText ET_ADDRECIPE1, ET_ADDRECIPE2, ET_ADDRECIPE3,ET_AddDay,ET_AddDate;
    String day,recipe1,recipe2,recipe3;

    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;
    String wholedateset, daytoset;
    Spinner sp;
    Spinner sp2;

    Spinner sp3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu_via_spinner_loading_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


       sp= (Spinner) findViewById(R.id.sp);
        sp2= (Spinner) findViewById(R.id.sp2);
        sp3= (Spinner) findViewById(R.id.sp3);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Downloader(AddMenuViaSpinnerLoading.this,urlAddress,sp,sp2,sp3).execute();

            }
        });

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);



        ET_AddDay = (EditText) findViewById(R.id.editDayfromAdd);
        ET_AddDate = (EditText) findViewById(R.id.editDatefromAdd);

        ShowDialogOnBtnClick();
    }


    public void ShowDialogOnBtnClick(){

        btn = (Button) findViewById(R.id.PickThingsFromAddbtn);

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

            ET_AddDate.setText(AllInOne, TextView.BufferType.EDITABLE);
            ET_AddDay.setText(dayName, TextView.BufferType.EDITABLE);

            Toast.makeText(AddMenuViaSpinnerLoading.this,day_x+"/"+month_x+"/"+year_x,Toast.LENGTH_SHORT).show();
            Log.d("myTag", dayName);


        }
    };


    public void saveNewRecipeinDatabase(View view)
    {


        recipe1 = sp.getSelectedItem().toString();
        recipe2 = sp2.getSelectedItem().toString();
        recipe3 = sp3.getSelectedItem().toString();

        String method ="addRecipeDate";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,daytoset,wholedateset,recipe1,recipe2,recipe3);
    }

    public void DeleteFromAddScreen(View view)
    {
        startActivity(new Intent(this,DeleteViaDatePicker.class));
    }

    public void UpdateFromAddScreen(View view)
    {
        startActivity(new Intent(this,UpdateRecipesInDatabse.class));
    }





}
