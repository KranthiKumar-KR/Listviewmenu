package com.example.kranthi.listviewmenu;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kranthi on 7/17/2016.
 */
public class DomainsAdapter extends BaseExpandableListAdapter {
    private Context ctx;
    private HashMap<String,List<String>> Domains_category;
    private List<String> Domains_List;
    public DomainsAdapter(Context ctx,HashMap<String,List<String>> Domains_category, List<String> Domains_List){
       this.ctx = ctx;
        this.Domains_category = Domains_category;
        this.Domains_List = Domains_List;
    }
    @Override
    public int getGroupCount() {
        return Domains_List.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Domains_category.get(Domains_List.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Domains_List.get(groupPosition);
    }

    @Override
    public Object getChild(int parent, int child) {
        return Domains_category.get(Domains_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentview) {
        String group_title = (String) getGroup(parent);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, parentview,false);

        }
        TextView parent_textview = (TextView) convertView.findViewById(R.id.parentlayout);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView, ViewGroup parentview) {
        String child_title = (String) getChild(parent, child);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout,parentview,false);

        }
        TextView child_textview = (TextView) convertView.findViewById(R.id.childlayout);
        child_textview.setText(child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
