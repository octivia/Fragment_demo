package com.technohack.contextualactionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String []empName={
      "harsh","shubham","balendra","mohit","abinash","ij","shivam","satyam"
    };
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> empList;
    ArrayList<String> selection;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_viewId);
        selection=new ArrayList<>();

        empList=new ArrayList<>();
        empList.addAll(Arrays.asList(empName));

        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,empList);
        listView.setAdapter(arrayAdapter);

        //to enable the multiple selection of list item
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        //to set the listener in listView
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int position, long id, boolean checked) {
                       if(checked){
                           //adding the list item into the another list
                           selection.add(empList.get(position));
                           //count the selected item
                           count++;
                           //set the action mode title
                           actionMode.setTitle(count+"item selected");
                       }else{
                           selection.remove(empList.get(position));
                           //
                           count--;
                           //
                           actionMode.setTitle(count+"item selected");
                       }
            }

            //inflating the menu
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.contextual_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            //context menu options
            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
                if(item.getItemId()==R.id.delete_menuId) {
                    //to remove the item from the list
                    for(Object items:selection){
                        String empN=items.toString();
                        empList.remove(empN);
                    }
                }
                arrayAdapter.notifyDataSetChanged();
                actionMode.finish();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

                count = 0;
                selection.clear();

            }
        });

    }


}
