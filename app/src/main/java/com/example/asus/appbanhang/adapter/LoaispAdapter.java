package com.example.asus.appbanhang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.appbanhang.R;
import com.example.asus.appbanhang.modal.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arraylistloaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arraylistloaisp, Context context) {
        this.arraylistloaisp = arraylistloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylistloaisp.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylistloaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHoder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder = null;
        if (view == null) {
            viewHoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHoder.txttenloaisp = view.findViewById(R.id.textviewloaisp);
            viewHoder.imgloaisp = view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHoder);

        }else {
            viewHoder = (ViewHoder) view.getTag();
            Loaisp loaisp = (Loaisp) getItem(position);
            viewHoder.txttenloaisp.setText(loaisp.getTenloaisp());
            Picasso.with(context).load(loaisp.getHinhanhloaisp())
                    .placeholder(R.drawable.ic_wait_64px)
                    .error(R.drawable.ic_error_60px)
                    .into(viewHoder.imgloaisp);
        }
        return view;
    }
}
