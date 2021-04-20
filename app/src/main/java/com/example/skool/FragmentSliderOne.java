package com.example.skool;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentSliderOne extends Fragment {
    // make sure you import android.support.v4.app.Fragment

    VideoView videoView;
    TextView textView;
    private Context mcontext;

    public FragmentSliderOne(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slider_one_layout, container, false);

        textView=(TextView)view.findViewById(R.id.funcontent);

       videoView=(VideoView)view.findViewById(R.id.video1);
       MediaController vidControl=new MediaController(mcontext);
       vidControl.setAnchorView(videoView);
       videoView.setMediaController(vidControl);
        String uriPath = "android.resource://com.example.skool/"+R.raw.end_game_taylor_swift;

        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        return view;
    }
}
