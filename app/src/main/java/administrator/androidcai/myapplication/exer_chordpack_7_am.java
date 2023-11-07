package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.kofigyan.stateprogressbar.StateProgressBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class exer_chordpack_7_am extends AppCompatActivity {

    private TextView text1, text2, text3, howto, name_chord, try_again;
    public MediaPlayer correct;
    public ImageView dot_1, dot_2, dot_3;
    private ConstraintLayout constraintLayout;
    private Button next;
    private ImageView back;
    String udata = "จับคอร์ด Am อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String one = "1";
    String two = "2";
    String three = "3";
    Animation uptodown, downtoup, lefttoright;

    Animation left_slide;

    int z = 0;
    StateProgressBar stateProgressBar;


    String[] des = {" ", " ", " ", "FINISH"};

    WaveLoadingView waveLoadingView2;
    String chord_c = "Am";

    private Animation  mShakeAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_chordpack_7_am);


        waveLoadingView2 = findViewById(R.id.wave123);
        waveLoadingView2.setProgressValue(5);
        waveLoadingView2.setCenterTitle(chord_c);
        waveLoadingView2.setCenterTitleSize(30);
        waveLoadingView2.setCenterTitleStrokeColor(10);


        text1 = (TextView) findViewById(R.id.textView5);
        text2 = (TextView) findViewById(R.id.textView6);
        text3 = (TextView) findViewById(R.id.textView7);


        howto = findViewById(R.id.textView10);
        name_chord = findViewById(R.id.textView11);
        try_again = findViewById(R.id.try_again2);

        SpannableString content2 = new SpannableString(string_try_again);
        content2.setSpan(new UnderlineSpan(), 0, string_try_again.length(), 0);
        try_again.setText(content2);

        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        howto.setText(content);


        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this, R.anim.lefttoright);


        Typeface tf = Typeface.createFromAsset(getAssets(), "Cloud.otf");


        stateProgressBar = findViewById(R.id.bar);
        stateProgressBar.setStateDescriptionData(des);
        stateProgressBar.setStateNumberTypeface("Cloud.otf");
        stateProgressBar.setStateDescriptionTypeface("Cloud.otf");

        left_slide = AnimationUtils.loadAnimation(this, R.anim.left_fade);


        text1.setTypeface(tf);
        text2.setTypeface(tf);
        text3.setTypeface(tf);
        try_again.setTypeface(tf);
        try_again.setVisibility(View.INVISIBLE);
        howto.setTypeface(tf);
        name_chord.setTypeface(tf);


        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();


        dot_1 = findViewById(R.id.dot_1);
        dot_2 = findViewById(R.id.dot_2);
        dot_3 = findViewById(R.id.dot_3);


        mShakeAnimation = AnimationUtils.loadAnimation(exer_chordpack_7_am.this,R.anim.shake_area);


        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
        dot_3.startAnimation(mShakeAnimation);

        correct = MediaPlayer.create(exer_chordpack_7_am.this, R.raw.chord_am);


        View overlay = findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        constraintLayout = (ConstraintLayout) findViewById(R.id.layoutxml1);


        constraintLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
                                                public boolean onTouch(View v, MotionEvent m) {
                                                    handleTouch(m);
                                                    return true;
                                                }
                                            }


        );


        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shownumber();
            }
        });


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2();
            }
        });

        next = findViewById(R.id.button_note);
        next.setTypeface(tf);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTable_CActivity();
            }
        });
    }


    public void openMain2() {
        Intent intent = new Intent(this, boardcast_learn.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    public void openTable_CActivity() {
        Intent intent = new Intent(this, exer_chordpack7_dm.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
        finish();
    }

    public void shownumber() {
        text1.setText(one);
        text2.setText(two);
        text3.setText(three);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);

        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
        z = 0;
        waveLoadingView2.setProgressValue(5);
        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
        dot_3.startAnimation(mShakeAnimation);
    }


    void handleTouch(MotionEvent m) {
        text1 = (TextView) findViewById(R.id.textView5);
        text2 = (TextView) findViewById(R.id.textView6);
        text3 = (TextView) findViewById(R.id.textView7);


        int k = 0;
        int pointerCount = m.getPointerCount();
        int idd = m.getPointerId(k);
        int xx = (int) m.getX();
        int yy = (int) m.getY();


        breakLoop:
        for (int i = 0; i < pointerCount; i++) {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);

            String touchStatus = "✔";
            String BAR1 = "ใช้นิ้วชี้กด";
            String BAR2 = "ใช้นิ้วกลางกด";
            String BAR3 = "ใช้นิ้วนางกด";

            if (z == 10)
                id = 10;

            if (id == 0) {
                int id0 = m.getPointerId(i);
                int id1 = m.getPointerId(i);
                int id2 = m.getPointerId(i);

                if (id0 == 0) {

                    if (y >= 196 && y <= 293) {
                        if (x <= 670) {
                            dot_1.clearAnimation();
                            text1.setText(touchStatus);
                            dot_1.clearColorFilter();
                            k = 1;
                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                            waveLoadingView2.setProgressValue(33);
                            waveLoadingView2.setAnimDuration(500);
                        } else
                            k = 0;
                    } else {
                        k = 0;
                        dot_1.startAnimation(mShakeAnimation);
                        dot_2.startAnimation(mShakeAnimation);
                        dot_3.startAnimation(mShakeAnimation);
                        text1.setText(BAR1);
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        waveLoadingView2.setProgressValue(0);
                        waveLoadingView2.setAnimDuration(200);
                        text2.setText(BAR2);
                        text3.setText(BAR3);
                    }
                }
            }


            if (k == 1) {
                if (id == 1) {
                    if (y >= 420 && y <= 520) {
                        if (x > 750) {
                            if (x <= 1289) {
                                dot_2.clearAnimation();
                                text2.setText(touchStatus);
                                k = 2;
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                text2.setText(touchStatus);
                                waveLoadingView2.setProgressValue(60);
                                waveLoadingView2.setAnimDuration(500);
                                if (m.getAction() == MotionEvent.ACTION_UP) {
                                    text2.setText(BAR2);
                                    dot_2.startAnimation(mShakeAnimation);
                                    stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                    waveLoadingView2.setProgressValue(30);
                                    waveLoadingView2.setAnimDuration(200);
                                }
                            } else
                                k = 0;
                        }
                    } else {
                        k = 0;
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        text2.setText(BAR2);
                        dot_2.startAnimation(mShakeAnimation);
                    }
                }
            }


            if (k == 2) {
                if (id == 2) {
                    if (y >= 327 && y <= 412) {
                        if (x > 750) {
                            if (x <= 1289) {
                                dot_3.clearAnimation();
                                text3.setText(touchStatus);
                                k++;
                                stateProgressBar.setAllStatesCompleted(true);
                                z = 10;
                                waveLoadingView2.setProgressValue(101);
                                waveLoadingView2.setAnimDuration(500);
                            }
                        }
                    }
                }
            }


            if (k == 3) {
                text1.setText(touchStatus);
                text2.setText(touchStatus);
                text3.setText(touchStatus);
                correct.start();
                next.setVisibility(View.VISIBLE);
                try_again.setVisibility(View.VISIBLE);
                try_again.setEnabled(true);
                next.startAnimation(left_slide);
                break breakLoop;
            }
        }
    }
}

