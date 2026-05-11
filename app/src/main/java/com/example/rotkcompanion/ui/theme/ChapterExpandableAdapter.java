package com.example.rotkcompanion.ui.theme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.rotkcompanion.R;

import java.util.List;
import java.util.Map;

public class ChapterExpandableAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final List<String> groupList;
    private final Map<String, List<String>> childMap;

    public ChapterExpandableAdapter(Context context, List<String> groupList,
                                      Map<String, List<String>> childMap) {
        this.context = context;
        this.groupList = groupList;
        this.childMap = childMap;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.details_group_item, parent, false);
        }
        TextView groupTitle = convertView.findViewById(R.id.detailsGroupView);
        groupTitle.setText(groupList.get(groupPosition));
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childMap.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMap.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.details_child_item, parent, false);
        }

        String detail = (String) getChild(groupPosition, childPosition);
        TextView detailView = convertView.findViewById(R.id.detailsChildView);
        detailView.setText(detail);


       /* if (detail.contains("Story So Far...")) {
            detailView.setTextColor(ContextCompat.getColor(context, R.color.chinese_yellow));
            detailView.setOnClickListener(v -> {
                Intent intent = new Intent(context, CharacterDetails.class);

                //TODO Change this later when implementing sorting
                //Repository.getmCharacterNameByID(groupPosition + 1);
                intent.putExtra("characterID", groupPosition + 1);
                intent.putExtra("characterName", groupList.get(groupPosition));


                context.startActivity(intent);
            });
        } else {
            detailView.setOnClickListener(null);
            detailView.setTextColor(Color.parseColor("#FFFFFF"));
        }
*/

        return convertView;
    }

    @Override
    public boolean hasStableIds() { return false; }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }
}