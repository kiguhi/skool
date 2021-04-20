package com.example.skool;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class FragmentSliderTwo extends Fragment {
    // make sure you import android.support.v4.app.Fragment

    VideoView videoView;
    View view_vid;
    private Context mcontext;

    public FragmentSliderTwo(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slider_two_layout, container, false);


        videoView=(VideoView)view.findViewById(R.id.video2);
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
