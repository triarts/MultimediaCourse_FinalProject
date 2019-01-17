package com.example.arta.mulmedtest1;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private SurfaceHolder vidHolder;
    private SurfaceView vidSurface;
    String vidAddress = "http://140.113.208.143:8080/stream";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        VideoView vidView = (VideoView)findViewById(R.id.myVideo);
//        //String vidAddress = "https://192.168.0.3:8080/stream";
//        String vidAddress = "http://140.113.208.143:8080/stream";
//        //String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
//        Uri vidUri = Uri.parse(vidAddress);
//
//        //vidView.setVideoURI(vidUri);
//        vidView.setVideoPath(vidAddress);
//
//        MediaController vidControl = new MediaController(this);
//        vidControl.setAnchorView(vidView);
//        vidView.setMediaController(vidControl);
//
//
//        vidView.start();


        vidSurface = (SurfaceView) findViewById(R.id.surfView);
        vidHolder = vidSurface.getHolder();
        vidHolder.addCallback(this);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

        mediaPlayer.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(vidHolder);
            mediaPlayer.setDataSource(vidAddress);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
