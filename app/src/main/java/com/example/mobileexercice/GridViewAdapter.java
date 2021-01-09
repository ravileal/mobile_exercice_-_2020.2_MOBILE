package com.example.mobileexercice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    int numDrawable[];

    public GridViewAdapter(Context context, int[] numDrawable) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.numDrawable = numDrawable;
    }

    @Override
    public int getCount() {
        return numDrawable.length;
    }

    @Override
    public Object getItem(int position) {
        return numDrawable[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(layoutInflater == null)
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null)
            convertView = layoutInflater.inflate(R.layout.grid_item, null);

        ImageView imageView = convertView.findViewById(R.id.grid_item_image);
        imageView.setImageResource(numDrawable[position]);

        return convertView;
    }
}
