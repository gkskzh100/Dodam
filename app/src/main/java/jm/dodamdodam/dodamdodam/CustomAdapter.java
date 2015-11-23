package jm.dodamdodam.dodamdodam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by kim on 2015-11-14.
 */
public class CustomAdapter extends BaseAdapter {

    private String[] values;
    private Context context;

    public CustomAdapter(Context context, String[] values) {
        this.values = values;
        this.context = context;
    }
    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = vi.inflate(R.layout.activity_item, null);

        String value = values[position];

        if(value != null) {
            TextView textView = (TextView) v.findViewById(R.id.gridview_item);
            textView.setText(value);
        }


        return v;
    }
}
