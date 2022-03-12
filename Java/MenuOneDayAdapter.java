package Java;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MenuOneDayAdapter extends ArrayAdapter {


    List list = new ArrayList();

    public MenuOneDayAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(MenuByDay object) {
        super.add(object);

        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;

        MenuByDayHolder menuByDayHolder;

        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.one_dayonly_layout,parent,false);

            menuByDayHolder = new MenuByDayHolder();


            menuByDayHolder.tx_date = (TextView) row.findViewById(R.id.tx_date_one);
            menuByDayHolder.tx_day = (TextView) row.findViewById(R.id.tx_day_one);
            menuByDayHolder.tx_recipe1 = (TextView) row.findViewById(R.id.tx_recipe1_one);
            menuByDayHolder.tx_recipe2 = (TextView) row.findViewById(R.id.tx_recipe2_one);
            menuByDayHolder.tx_recipe3 = (TextView) row.findViewById(R.id.tx_recipe3_one);

            row.setTag(menuByDayHolder);

        }
        else
        {
            menuByDayHolder = (MenuByDayHolder) row.getTag();
        }

        MenuByDay menuByDay = (MenuByDay) this.getItem(position);

        menuByDayHolder.tx_date.setText(menuByDay.getDate());
        menuByDayHolder.tx_day.setText(menuByDay.getDay());
        menuByDayHolder.tx_recipe1.setText(menuByDay.getRecipe1());
        menuByDayHolder.tx_recipe2.setText(menuByDay.getRecipe2());
        menuByDayHolder.tx_recipe3.setText(menuByDay.getRecipe3());

        return row;
    }


    static class MenuByDayHolder
    {
        TextView tx_date,tx_day, tx_recipe1,tx_recipe2,tx_recipe3;

    }








}
