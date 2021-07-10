package com.example.listview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.R;
import com.example.listview.TestBean;

import java.util.List;

public class TestAdapter extends BaseAdapter {

    private List<TestBean> list;
    private Context context;

    public TestAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();

    }

    public void setData(List<TestBean> list) {
        this.list = list;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        ViewHolder3 viewHolder3 = null;
        ViewHolderEmpty viewHolderEmpty = null;
        TestBean testBean = list.get(position);
        int type = testBean.type;
        if (convertView == null) {
            switch (type) {
                case 1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_one, null);
                    viewHolder1 = new ViewHolder1();
                    convertView.setTag(viewHolder1);
                    break;
                case 2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_two, null);
                    viewHolder2 = new ViewHolder2();
                    convertView.setTag(viewHolder2);
                    break;
                case 3:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_three, null);
                    viewHolder3 = new ViewHolder3();
                    convertView.setTag(viewHolder3);
                    break;
                default:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_empty, null);
                    viewHolderEmpty = new ViewHolderEmpty();
                    convertView.setTag(viewHolderEmpty);
                    break;

            }
        } else {
            switch (type) {
                case 1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case 2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
                case 3:
                    viewHolder3 = (ViewHolder3) convertView.getTag();
                    break;
                default:
                    viewHolderEmpty = (ViewHolderEmpty) convertView.getTag();
                    break;
            }
        }
/*        switch (type) {
            case 1:
                if (convertView == null || !(convertView.getTag() instanceof ViewHolder1)) {
                    viewHolder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_one, null);
                    convertView.setTag(viewHolder1);
                } else {
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    Log.e("11111", "getView: " + "viewHolder1=" + position);
                }
                break;
            case 2:
                if (convertView == null || !(convertView.getTag() instanceof ViewHolder2)) {
                    viewHolder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_two, null);
                    convertView.setTag(viewHolder2);
                } else {
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    Log.e("11111", "getView: " + "viewHolder2=" + position);
                }
                break;
            case 3:
                if (convertView == null || !(convertView.getTag() instanceof ViewHolderEmpty)) {
                    viewHolderEmpty = new ViewHolderEmpty();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_empty, null);
                    convertView.setTag(viewHolderEmpty);
                } else {
                    viewHolderEmpty = (ViewHolderEmpty) convertView.getTag();
                    Log.e("11111", "getView: " + "viewHolderEmpty=" + position);
                }
                break;
            default:
                if (convertView == null || !(convertView.getTag() instanceof ViewHolder3)) {
                    viewHolder3 = new ViewHolder3();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_three, null);
                    convertView.setTag(viewHolder3);
                } else {
                    viewHolder3 = (ViewHolder3) convertView.getTag();
                    Log.e("11111", "getView: " + "viewHolder3=" + position);
                }
                break;

        }*/
        return convertView;
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position).type;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    public static class ViewHolder1 {
        ImageView imageView;
    }

    public static class ViewHolder2 {
        TextView textView;
    }

    public static class ViewHolder3 {
        Button button;
    }

    public static class ViewHolderEmpty {
    }
}
