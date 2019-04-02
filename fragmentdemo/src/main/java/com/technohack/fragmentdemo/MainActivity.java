package com.technohack.fragmentdemo;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.technohack.fragmentdemo.dynamic_fragment.DynamicFragment1;

public class MainActivity extends AppCompatActivity {

    private Button staticFragmentBtn;
    DynamicFragment1 dynamicFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staticFragmentBtn=findViewById(R.id.static_frag_btnId);
        staticFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StaticActivity.class));
            }
        });

        //creating object of fragment
         dynamicFragment1=new DynamicFragment1();

         addFragment();
    }

    //to add the fragment in action dynamically
    private void addFragment() {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.main_frame_layoutId,dynamicFragment1);
        //to remove the fragment
        //fragmentTransaction.remove(dynamicFragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


     }
}
