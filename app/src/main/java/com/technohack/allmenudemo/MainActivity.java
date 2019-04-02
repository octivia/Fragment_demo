package com.technohack.allmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView  contextMenuText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contextMenuText=findViewById(R.id.context_menuId);
        //RegisterForContextMenu
        registerForContextMenu(contextMenuText);


    }

    //For option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.navigation_menu,menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
           case R.id.nav_menu_settingId:
               Toast.makeText(this, "Settings Menu", Toast.LENGTH_SHORT).show();
               return true;
            case R.id.nav_menu_logoutId:
                Toast.makeText(this, "Logout Menu", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return false;

        }
    }


    ///
    ///
    //
    //// for Context menu
    ///
    ///
    ///

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_menu_saveId:
                Toast.makeText(this, "Save Option Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.context_menu_deleteId:
                Toast.makeText(this, "Delete Option Clicked", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return false;
        }
    }


    //Pop up Menu

    public void onPopupMenu(View view){

        PopupMenu popupMenu=new PopupMenu(this,view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();

    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.popup_insertId:
                Toast.makeText(this, "Insert Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popup_updateId:
                Toast.makeText(this, "Update Clicked", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return false;
        }
    }



}
