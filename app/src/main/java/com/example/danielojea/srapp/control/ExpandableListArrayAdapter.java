package com.example.danielojea.srapp.control;

/**
 * Created by Daniel on 06.07.2017.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.danielojea.srapp.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListArrayAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String[]>> _listDataChild;
    private int lastExpandedPosition = -1;

    public ExpandableListArrayAdapter(Context context, List<String> listDataHeader,
                                      HashMap<String, List<String[]>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String[] childText = (String[]) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_list_array_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        TextView txtListChildValue = (TextView) convertView.findViewById(R.id.lblListItemValue);
        TextView txtListChild2 = (TextView) convertView.findViewById(R.id.lblListItem2);
        TextView txtListChild2Value = (TextView) convertView.findViewById(R.id.lblListItem2Value);
        LinearLayout secondRow = (LinearLayout) convertView.findViewById(R.id.secondRow);


        if(childText.length ==1)
        {
            txtListChild.setText(childText[0]);
            txtListChild2.setVisibility(View.GONE);
            txtListChildValue.setVisibility(View.GONE);
            txtListChild2Value.setVisibility(View.GONE);
            secondRow.setVisibility(View.GONE);

        }
        if(childText.length ==2)
        {
            txtListChild.setText(childText[0]);
            txtListChild2.setText(childText[1]);
            txtListChildValue.setVisibility(View.GONE);
            txtListChild2Value.setVisibility(View.GONE);
        }
        if(childText.length ==3)
        {
            txtListChild.setText(childText[0]);
            txtListChildValue.setText(childText[1]);
            txtListChild2.setText(childText[2]);            //z.b 16 w6
            txtListChild2Value.setVisibility(View.INVISIBLE);
            int stringLength = childText[2].length();
            if(childText[2].substring(stringLength -2).equals("w6")){
                highligthValue(Integer.parseInt(childText[2].substring(0,stringLength -3)),txtListChild2,6,13);
            }
        }
        if(childText.length ==4) {
            txtListChild.setText(childText[0]);
            txtListChildValue.setText(childText[1]);
            txtListChild2.setText(childText[2]);
            txtListChild2Value.setText(childText[3]);
            int stringLength = childText[2].length();
            if(childText[2].substring(stringLength -2).equals("w6")){
                highligthValue(Integer.parseInt(childText[2].substring(0,stringLength -3)),txtListChild2,6,13);
            }
        }


        return convertView;
    }
    public void highligthValue(int attributValue, TextView attributField,int low,int high){
        if (attributValue >= high) {
            attributField.setTextColor(_context.getResources().getColor(R.color.highValue));
        } else {
            if (attributValue <= low) {
                attributField.setTextColor(_context.getResources().getColor(R.color.lowValue));
            }
        }
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public int getLastExpandedPosition() {
        return lastExpandedPosition;
    }

    public void setLastExpandedPosition(int lastExpandedPosition) {
        this.lastExpandedPosition = lastExpandedPosition;
    }

}