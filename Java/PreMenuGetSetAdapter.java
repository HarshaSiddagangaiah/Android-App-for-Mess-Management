package Java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PreMenuGetSetAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public PreMenuGetSetAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(PreMenuGetSet object) {
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

        PreMenuDayHolder preMenuDayHolder;

        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.premenu_layouts,parent,false);

            preMenuDayHolder = new PreMenuDayHolder();

            preMenuDayHolder.tx_recipe1 = (TextView) row.findViewById(R.id.tx_premenurecipe);


            row.setTag(preMenuDayHolder);

        }
        else
        {
            preMenuDayHolder = (PreMenuDayHolder) row.getTag();
        }

        PreMenuGetSet preMenuGetSet = (PreMenuGetSet) this.getItem(position);


        preMenuDayHolder.tx_recipe1.setText(preMenuGetSet.getRecipe1());


        return row;
    }


    static class PreMenuDayHolder
    {
        TextView tx_recipe1;

    }



}
