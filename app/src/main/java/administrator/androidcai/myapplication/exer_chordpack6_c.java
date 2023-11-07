package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.UnicodeSet;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.VibrationEffect;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.library.NavigationBar;

import java.lang.reflect.Type;

import cn.pedant.SweetAlert.SweetAlertDialog;
import me.itangqi.waveloadingview.WaveLoadingView;

public class exer_chordpack6_c extends AppCompatActivity {

    private TextView text1,text2,text3,howto,name_chord,try_again;
    public MediaPlayer correct;
    public ImageView dot_1,dot_2,dot_3;
    private ConstraintLayout constraintLayout;
    private Button next;
    String udata ="จับคอร์ด C อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String one ="1";
    String two ="2";
    String three ="3";
    Animation uptodown,downtoup,lefttoright;
    TextView textView;
    Animation left_slide;
    private Animation  mShakeAnimation;

    int z=0;


    StateProgressBar stateProgressBar;

    Button button2;

    String[] des = {" "," "," ","FINISH"};

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    String chord_c = "C";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_chordpack6_c);




        waveLoadingView = findViewById(R.id.wave123);
        waveLoadingView.setProgressValue(5);
        waveLoadingView.setCenterTitle(chord_c);
        waveLoadingView.setCenterTitleSize(45);
        waveLoadingView.setCenterTitleStrokeColor(10);



        Typeface tf = Typeface.createFromAsset(getAssets(),"Cloud.otf");
        stateProgressBar = findViewById(R.id.bar);
        stateProgressBar.setStateDescriptionData(des);
        stateProgressBar.setStateNumberTypeface("Cloud.otf");
        stateProgressBar.setStateDescriptionTypeface("Cloud.otf");

        left_slide = AnimationUtils.loadAnimation(this,R.anim.left_fade);






        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();





        howto = findViewById(R.id.textView9);
        name_chord = findViewById(R.id.textView8);
        try_again = findViewById(R.id.try_again);

        text1 = (TextView)findViewById(R.id.textView5);
        text2 = (TextView)findViewById(R.id.textView6);
        text3 = (TextView)findViewById(R.id.textView7);




        SpannableString content2 = new SpannableString(string_try_again);
        content2.setSpan(new UnderlineSpan(),0,string_try_again.length(), 0);
        try_again.setText(content2);

        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(),0,udata.length(),0);
        howto.setText(content);



        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);



        text1.setTypeface(tf);
        text2.setTypeface(tf);
        text3.setTypeface(tf);
        try_again.setTypeface(tf);
        try_again.setVisibility(View.INVISIBLE);
        try_again.setEnabled(false);
        howto.setTypeface(tf);
        name_chord.setTypeface(tf);
        dot_1 = findViewById(R.id.dot_1);
        dot_2 = findViewById(R.id.dot_2);
        dot_3 = findViewById(R.id.dot_3);

        mShakeAnimation = AnimationUtils.loadAnimation(exer_chordpack6_c.this,R.anim.shake_area);


        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
        dot_3.startAnimation(mShakeAnimation);

        correct = MediaPlayer.create(exer_chordpack6_c.this,R.raw.chord_c);


        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        constraintLayout = (ConstraintLayout)findViewById(R.id.layoutxml1);



        constraintLayout.setOnTouchListener(new RelativeLayout.OnTouchListener(){
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



        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SweetAlertDialog dialog = new SweetAlertDialog(exer_chordpack6_c.this,SweetAlertDialog.WARNING_TYPE);
                dialog.getWindow(). setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                dialog.setTitleText("มือซ้าย");
                dialog.setContentText("1.ใช้นิ้วชี้แตะที่ช่องหมายเลข 1<BR>2.ใช้นิ้วกลางแตะที่ช่องหมายเลข 2<BR>3.ใช้นิ้วนางแตะที่ช่องหมายเลข 3");
                dialog.setContentTextSize(12);
                dialog.setConfirmText("OK");
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        dialog.dismiss();
                    }
                }).show();
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


        ImageView back =  (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2();
            }
        });


    }



    public void openMain2(){
        Intent intent = new Intent(this,boardcast_learn.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    public void openTable_CActivity(){
        Intent intent = new Intent(this, exer_chordpack6_em.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
        finish();
    }

    public void shownumber(){
        text1.setText(one);
        text2.setText(two);
        text3.setText(three);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
        z=0;
        waveLoadingView.setProgressValue(5);
        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
        dot_3.startAnimation(mShakeAnimation);
    }




    void handleTouch(MotionEvent  m) {

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        final long[] pattern = {2000, 1000};
        text1 = (TextView) findViewById(R.id.textView5);
        text2 = (TextView) findViewById(R.id.textView6);
        text3 = (TextView) findViewById(R.id.textView7);

        int k = 0;
        int vi = 0;
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
            String BAR1 = "1";
            String BAR2 = "2";
            String BAR3 = "3";


            if(z==10)
                id = 10;

            if (id == 0) {
                int id0 = m.getPointerId(i);
                int id1 = m.getPointerId(i);
                int id2 = m.getPointerId(i);

                if (id0 == 0) {
                    if (y >= 210 && y <= 283) {
                        if (x <= 716) {

                            dot_1.clearAnimation();
                            text1.setText(touchStatus);
                            dot_1.clearColorFilter();
                            k = 1;
                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                            waveLoadingView.setProgressValue(33);
                            waveLoadingView.setAnimDuration(500);

                        } else
                            k = 0;
                    }
                    else {
                        k = 0;
                        dot_1.startAnimation(mShakeAnimation);
                        dot_2.startAnimation(mShakeAnimation);
                        dot_3.startAnimation(mShakeAnimation);
                        text1.setText(BAR1);
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setAnimDuration(200);
                        text2.setText(BAR2);
                        text3.setText(BAR3);
                    }
                }
            }


            if (k == 1) {
                if (id == 1) {
                    if (y >= 420 && y <= 518) {
                        if (x > 750) {
                            if (x <= 1290) {
                                k = 2;
                                dot_2.clearAnimation();
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                text2.setText(touchStatus);
                                waveLoadingView.setProgressValue(60);
                                waveLoadingView.setAnimDuration(500);
                                if (m.getAction() == MotionEvent.ACTION_UP) {
                                    text2.setText(BAR2);
                                    dot_2.startAnimation(mShakeAnimation);
                                    stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                    waveLoadingView.setProgressValue(30);
                                    waveLoadingView.setAnimDuration(200);
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
                    if (y >= 524 && y <= 622) {
                        if (x > 1326) {
                            if (x <= 1854) {
                                dot_3.clearAnimation();
                                text3.setText(touchStatus);
                                k++;
                                stateProgressBar.setAllStatesCompleted(true);
                                z=10;
                                waveLoadingView.setProgressValue(101);
                                waveLoadingView.setAnimDuration(500);
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

