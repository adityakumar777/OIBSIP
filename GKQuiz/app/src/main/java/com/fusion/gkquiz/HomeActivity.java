package com.fusion.gkquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.fusion.gkquiz.databinding.ActivityHomeBinding;
import com.moos.library.HorizontalProgressView;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //inAnimation();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Dialog");
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeActivity.super.onBackPressed();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });

        dialog = builder.create();

                AlertDialog.Builder builder1 = new AlertDialog.Builder(HomeActivity.this);

                // Inflate the dialog view from your XML layout
                View dialogView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.time_up, null);

                builder1.setView(dialogView);

                AlertDialog alertDialog = builder1.create();

                // Make sure the dialog is cancelable (so the user can dismiss it by tapping outside)
                alertDialog.setCancelable(true);
                dialogView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Show the dialog


                // Set a click listener to perform an action when the dialog is clicked
                YoYo.with(Techniques.FadeOut)
                        .duration(700)
                        .playOn(binding.javaProg);

                YoYo.with(Techniques.FadeOut)
                        .duration(700)
                        .playOn(binding.startBtn);
                nevigateToTestActivity();
            }
        });
    }

    public void nevigateToTestActivity(){
        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    private void inAnimation() {
        YoYo.with(Techniques.Wobble)
                .duration(700)
                .playOn(binding.javaProg);
        AnimationDrawable animationDrawable = (AnimationDrawable) binding.homeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dialog.show();
    }
}
