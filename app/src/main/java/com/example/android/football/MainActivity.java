package com.example.android.football;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutRedA;
    private LinearLayout linearLayoutYellowA;
    private LinearLayout linearLayoutCornerA;

    private LinearLayout linearLayoutRedB;
    private LinearLayout linearLayoutYellowB;
    private LinearLayout linearLayoutCornerB;



    int quantityScoreA;
    int quantityScoreB;
    int quantityRedCardA;
    int quantityRedCardB;
    int quantityYellowCardA;
    int quantityYellowCarB;
    int quantityCornerA;
    int quantityCornerB;
    int possession;

    SeekBar sb;
    TextView valueTextprogressB;
    TextView ValueTextprogressA;
    TextView scoreTeamA;
    TextView scoreTeamB;
    EditText nameTeamA;
    EditText nameTeamB;

    String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutRedA = findViewById(R.id.linearLayoutRedA);
        linearLayoutYellowA = findViewById(R.id.linearLayoutYellowA);
        linearLayoutCornerA = findViewById(R.id.linearLayoutCornerA);

        linearLayoutRedB = findViewById(R.id.linearLayoutRedB);
        linearLayoutYellowB = findViewById(R.id.linearLayoutYellowB);
        linearLayoutCornerB = findViewById(R.id.linearLayoutCornerB);

        scoreTeamA = findViewById(R.id.score_Team_A);
        scoreTeamB = findViewById(R.id.score_Team_B);

        nameTeamA = findViewById(R.id.leftTeam);
        nameTeamA.setCursorVisible(false);

        nameTeamB = findViewById(R.id.rightTeam);
        nameTeamB.setCursorVisible(false);



        sb = findViewById(R.id.seek_bar);
        valueTextprogressB = findViewById(R.id.procent_possesion_team_B);
        ValueTextprogressA = findViewById(R.id.procent_possesion_team_A);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                valueTextprogressB.setText(String.valueOf(100 - progress) + "%");
                ValueTextprogressA.setText(String.valueOf(progress + "%"));
                possession=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb) {

            }
        });

    }

    public void onClickRedteamA(View v)
    {
        linearLayoutRedA.addView(createNewImageViewRedA());
        quantityRedCardA+=1;
    }

    public void onClickYellowteamA(View view){
        linearLayoutYellowA.addView(createNewImageViewYellowA());
        quantityYellowCardA+=1;
    }
    private ImageView createNewImageViewYellowA(){
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,4);

        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.yellow_card_rectangle);
        return imageView;
    }

    private ImageView createNewImageViewRedA() {
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,4);

        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.red_card_rectriangle);
        return imageView;
    }

    public void onClickCornerteamA(View v){
        linearLayoutCornerA.addView(createNewImageViewCornerA());
        quantityCornerA+=1;
    }

    private ImageView createNewImageViewCornerA(){
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,4);

        final ImageView imageView = new ImageView (this);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.corner_button);
        return imageView;
    }

    public void onClickRedteamB(View v) {
        quantityRedCardB+=1;
        linearLayoutRedB.addView(createNewImageViewRedB());


    }

    public void onClickYellowteamB(View view){
        quantityYellowCarB+=1;
        linearLayoutYellowB.addView(createNewImageViewYellowB());
    }
    private ImageView createNewImageViewYellowB(){
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,4);

        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.yellow_card_rectangle);
        return imageView;
    }

    private ImageView createNewImageViewRedB() {
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,4);

        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.red_card_rectriangle);
        return imageView;
    }

    public void onClickCornerteamB(View v){
        quantityCornerB+=1;
        linearLayoutCornerB.addView(createNewImageViewCornerB());
    }

    private ImageView createNewImageViewCornerB(){
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,4);

        final ImageView imageView = new ImageView (this);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.corner_button);
        return imageView;
    }


    public void onClickScoreA(View view) {

        quantityScoreA += 1;

        scoreTeamA.setText("" + quantityScoreA);
    }



    public void onClickScoreB(View view) {

        quantityScoreB += 1;

        scoreTeamB.setText("" + quantityScoreB);
    }


    public void onClickRestart(View view) {
        quantityScoreA=0;
        quantityScoreB=0;
        quantityYellowCarB=0;
        quantityYellowCardA=0;
        quantityRedCardA=0;
        quantityRedCardB=0;
        quantityCornerA=0;
        quantityCornerB=0;

        scoreTeamB.setText("" + quantityScoreB);
        scoreTeamA.setText("" + quantityScoreA);

        linearLayoutRedA.removeAllViews();
        linearLayoutRedB.removeAllViews();
        linearLayoutCornerA.removeAllViews();
        linearLayoutCornerB.removeAllViews();
        linearLayoutYellowA.removeAllViews();
        linearLayoutYellowB.removeAllViews();
    }

    public void onClickShare(View view){

        String nameTeamAString = nameTeamA.getText().toString();
        String nameTeamBString = nameTeamB.getText().toString();


        Log.i("OnClickhare","jestem prawie w domu");
        message = "Hi, dude i want to share the result of\n today football match with you";
        message+= "\n\n"+ nameTeamAString + " vs " + nameTeamBString;
        message+= "\n\n" + "Score: " + quantityScoreA + "-" + quantityScoreB;
        message+= "\n" + "Corners:" + quantityCornerA + "-" + quantityCornerB;
        message+= "\n" + "Red Cards:" + quantityRedCardA + "-" + quantityRedCardB;
        message+= "\n" + "Yellow Cards:" + quantityYellowCardA + "-" + quantityYellowCarB;
        message+= "\n" + "Ball possession: "  + possession + "% - " + (100-possession) + "%";


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to = "kozakmajk@gmail.com";
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Match result");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(intent);

    }

}



