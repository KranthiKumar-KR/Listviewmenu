package com.example.kranthi.listviewmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    HashMap<String, List<String>> Domain_category;
    List<String> Domain_list;
    ExpandableListView Exp_list;
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mactv;
    ListView listview;
    String[] suggestions = {"google", "facebook", "twitter", "Linkedin", "offerup", "wallapop", "gmail", "outlook", "yahoo", "hotmail", "uber", "lyft"};
    DomainsAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = (AutoCompleteTextView) findViewById(R.id.actv);
        mactv = (MultiAutoCompleteTextView) findViewById(R.id.mactv);
        listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, suggestions);
        actv.setAdapter(adapter);
        actv.setThreshold(3);
        mactv.setAdapter(adapter);
        listview.setAdapter(adapter);

        //not working

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = "https://www."+suggestions[position]+".com";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                //if you didnt pass the ACTION_VIEW in the intent declaration we can declare action as shown below in the comments89
                /*intent.setAction(Intent.ACTION_VIEW);*/
                startActivity(intent);

                Toast.makeText(getApplicationContext(),url, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),suggestions[position], Toast.LENGTH_LONG).show();
            }
        });
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        Exp_list = (ExpandableListView) findViewById(R.id.elv);
        Domain_category = DataProvider.getInfo();
        Domain_list = new ArrayList<String>(Domain_category.keySet());

        adapter1 = new DomainsAdapter(this, Domain_category, Domain_list);
        Exp_list.setAdapter(adapter1);
        Exp_list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(),Domain_list.get(groupPosition)+ " is expanded",Toast.LENGTH_LONG).show();
            }
        });
        Exp_list.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(),Domain_list.get(groupPosition) + " is collapsed ",Toast.LENGTH_LONG).show();
            }
        });
        Exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getBaseContext(),Domain_category.get(Domain_list.get(groupPosition)).get(childPosition) + " from category " +Domain_list.get(groupPosition) + " is selected",Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
