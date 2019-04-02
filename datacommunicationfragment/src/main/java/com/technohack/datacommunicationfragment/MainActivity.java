package com.technohack.datacommunicationfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.FragmentAListener, Fragment2.FragmentBListener {

    Fragment1 fragment1;
    Fragment2 fragment2;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1=new Fragment1();
        fragment2=new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame1_Id,fragment1)
                .replace(R.id.main_frame2_Id,fragment2)
                .commit();


    }


    @Override
    public void onInputASent(CharSequence input) {
        fragment2.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
         fragment1.updateEditText(input);
    }
}
