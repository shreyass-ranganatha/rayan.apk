package com.shreyassranganatha.rayan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView psych;
    Random random = new Random();
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context activity = this;


        ImageView img = findViewById(R.id.imageView);
        img.startAnimation(AnimationUtils.loadAnimation(this, R.anim.vibrate_a));

        final int[] anims = {R.anim.vibrate_a, R.anim.vibrate_b, R.anim.vibrate_c, R.anim.vibrate_d};

        final Integer[] flags = {1, 1};
        final Integer[] paths = {R.drawable.rayan_a, R.drawable.rayan_b};

        psych = (ImageView)findViewById(R.id.psychView);
        Glide.with(this).load(Uri.parse("android.resource://com.shreyassranganatha.rayan/" + R.drawable.ic_launcher_foreground)).into(psych);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    img.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.zoom));

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            img.clearAnimation();
                            img.startAnimation(AnimationUtils.loadAnimation(activity, anims[random.nextInt(anims.length)]));

                            flags[1] += 1;
                            img.setImageResource(paths[flags[1] % 2]);

                            flags[0] = 1;
                        }
                    }, 400);


            }
        });
    }

}