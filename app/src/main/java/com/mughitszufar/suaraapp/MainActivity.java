package com.mughitszufar.suaraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int satu, dua, tiga, empat, lima, enam, tujuh, delapan, sembilan, sepuluh;
    private int sound3StreamId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }
        satu = soundPool.load(this, R.raw.satu, 1);
        dua = soundPool.load(this, R.raw.dua, 1);
        tiga = soundPool.load(this, R.raw.tiga, 1);
        empat = soundPool.load(this, R.raw.empat, 1);
        lima = soundPool.load(this, R.raw.lima, 1);
        enam = soundPool.load(this, R.raw.enam, 1);
        tujuh = soundPool.load(this,R.raw.tujuh,1);
        delapan = soundPool.load(this,R.raw.delapan, 1);
        sembilan = soundPool.load(this,R.raw.sembilan,1);
        sepuluh = soundPool.load(this,R.raw.sepuluh,1);

    }
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_sound1:
                soundPool.play(satu, 1, 1, 0, 0, 1);
                //soundPool.pause(sound3StreamId);
                soundPool.autoPause();
                break;
            case R.id.button_sound2:
                soundPool.play(dua, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound3:
                sound3StreamId = soundPool.play(tiga, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound4:
                soundPool.play(empat, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound5:
                soundPool.play(lima, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound6:
                soundPool.play(enam, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound7:
                soundPool.play(tujuh, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound8:
                soundPool.play(delapan, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound9:
                soundPool.play(sembilan, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound10:
                soundPool.play(sepuluh, 1, 1, 0, 0, 1);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
