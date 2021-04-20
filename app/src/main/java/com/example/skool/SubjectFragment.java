package com.example.skool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class SubjectFragment extends Fragment {
    TextView textView;
    private Context mcontext;

    public SubjectFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        textView=(TextView)view.findViewById(R.id.englishtext);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(mcontext,R.anim.bounce);
                textView.startAnimation(animation);
                Intent intent=new Intent(mcontext,MathScreen.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
