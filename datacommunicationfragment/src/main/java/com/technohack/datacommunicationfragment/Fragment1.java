package com.technohack.datacommunicationfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    FragmentAListener listener;

    private Button sendTextBtn;
    private EditText sendText;

    public interface  FragmentAListener{
        public void onInputASent(CharSequence input);
    }

    public Fragment1() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_fragment1,container,false);

            sendTextBtn=view.findViewById(R.id.frag1_btnId);
            sendText=view.findViewById(R.id.frag1_editId);

            sendTextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      //sending the text
                      CharSequence input=sendText.getText().toString().trim();
                      listener.onInputASent(input);

                }
            });

            return view;
    }

    //to update the edit Text
    public void updateEditText(CharSequence input){
        sendText.setText(input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        /*
        if(context instanceof  FragmentAListener){
            listener=(FragmentAListener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement FragmentAListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
       listener=null;
    }
}
