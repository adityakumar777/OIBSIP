package com.fusion.gkquiz;


import static com.fusion.gkquiz.Model.setTest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.fusion.gkquiz.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    int position =0;
    ActivityMainBinding binding;
    int rightAns = 0;
    int wrongAns = 0;
    CountDownTimer countDownTimer;
    List<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AnimationDrawable animationDrawable = (AnimationDrawable) binding.mainLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        binding.progressViewHorizontal.setTrackWidth(30);
        binding.progressViewHorizontal.setProgressDuration(10000);
        binding.progressViewHorizontal.setProgressTextVisibility(false);
        binding.progressViewHorizontal.setTrackEnabled(true);
        binding.progressViewHorizontal.setProgressCornerRadius(20);
        binding.progressViewHorizontal.setProgressTextPaddingBottom(12);
        binding.progressViewHorizontal.startProgressAnimation();
        countDownTimer = new CountDownTimer(10000, 1000) { // 15 seconds with 1-second intervals
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                // When the timer finishes, show a time-up alert dialog
                setRightAns();
                showTimeUpDialog();
            }
        };

        makeQNA();
        setNextQuestion();


        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( position<9 ){
                    position++;
                    binding.progressViewHorizontal.setProgress(0.0f);
                    binding.progressViewHorizontal.startProgressAnimation();
                }
                if (position==9){
                    binding.nextBtn.setText("Result");
                    binding.nextBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            countDownTimer.cancel();
                            binding.progressViewHorizontal.stopProgressAnimation();
                            showScorecard();
                        }
                    });
                }
                setNextQuestion();
                resetColor();
            }
        });
    }

    private void showTimeUpDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setDimAmount(0);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, android.R.color.transparent)));


        // Inflate the dialog view from your XML layout
        View dialogView = LayoutInflater.from(this).inflate(R.layout.time_up, null);

        dialog.setContentView(R.layout.time_up);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;

        dialog.getWindow().setAttributes(layoutParams);


        // Make sure the dialog is cancelable (so the user can dismiss it by tapping outside)
        dialog.setCancelable(true);

        // Show the dialog
        dialog.show();

        // Set a click listener to perform an action when the dialog is clicked
        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ImageView imageView = dialog.findViewById(R.id.timeUpImg);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    private void setNextQuestion() {

        binding.card1.setClickable(true);
        binding.card2.setClickable(true);
        binding.card3.setClickable(true);
        binding.card4.setClickable(true);

        if (position<10) {
            startCountDown();
            binding.questionNumber.setText("Q." + (position + 1));
            binding.question.setText(list.get(position).getQuestion());
            binding.option1.setText(list.get(position).getOp1());
            binding.option2.setText(list.get(position).getOp2());
            binding.option3.setText(list.get(position).getOp3());
            binding.option4.setText(list.get(position).getOp4());

        }
    }

    private void startCountDown() {
        countDownTimer.start();
    }

    private void showScorecard() {

        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.scorecard, null);
        TextView noOfRightAns = dialogView.findViewById(R.id.noOfRightAns);
        TextView grade = dialogView.findViewById(R.id.grade);
        ImageView emoji = dialogView.findViewById(R.id.emoji);

        noOfRightAns.setText(Integer.toString(rightAns));

        if (rightAns == 10) {
            emoji.setImageResource(R.drawable.perfect);
            grade.setText("Perfect");
            grade.setBackgroundColor(getResources().getColor(R.color.green,getTheme()));
        }
        else if (rightAns >= 5) {

            emoji.setImageResource(R.drawable.good);
            grade.setText("Good");
            grade.setBackgroundColor(getResources().getColor(R.color.yellow,getTheme()));
        } else {
            emoji.setImageResource(R.drawable.bad);
            grade.setText("Better luck next time!");
            grade.setBackgroundColor(getResources().getColor(R.color.red,getTheme()));
        }

        builder.setView(dialogView);
        AlertDialog alertDialog;
        alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, android.R.color.transparent)));

        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                onBackPressed();
            }

        });
    }

    private void resetColor() {
        binding.card1.setBackgroundResource(R.drawable.corners);
        binding.card2.setBackgroundResource(R.drawable.corners);
        binding.card3.setBackgroundResource(R.drawable.corners);
        binding.card4.setBackgroundResource(R.drawable.corners);
    }

    public void checkRightAns(View view) {

        binding.progressViewHorizontal.stopProgressAnimation();

        if (view.getId() == R.id.card1 && list.get(position).getRightAns().equals('a')) {
            binding.card1.setBackgroundResource(R.drawable.corners_green);
            rightAns++;
        } else if (view.getId() == R.id.card2 && list.get(position).getRightAns().equals("b")) {
            binding.card2.setBackgroundResource(R.drawable.corners_green);
            rightAns++;
        } else if (view.getId() == R.id.card3 && list.get(position).getRightAns().equals("c")) {
            binding.card3.setBackgroundResource(R.drawable.corners_green);
            rightAns++;
        } else if (view.getId() == R.id.card4 && list.get(position).getRightAns().equals("d")) {
            binding.card4.setBackgroundResource(R.drawable.corners_green);
            rightAns++;
        } else {
            wrongAns++;
            view.setBackground(getDrawable(R.drawable.corners_red));
            setRightAns();
        }
        binding.card1.setClickable(false);
        binding.card2.setClickable(false);
        binding.card3.setClickable(false);
        binding.card4.setClickable(false);

        if (position==9){
            showScorecard();
        }
    }

    private void setRightAns() {
        countDownTimer.cancel();

        binding.card1.setClickable(false);
        binding.card2.setClickable(false);
        binding.card3.setClickable(false);
        binding.card4.setClickable(false);


        if (list.get(position).getRightAns().equals("a")) {
            binding.card1.setBackgroundResource(R.drawable.corners_green);
        } else if (list.get(position).getRightAns().equals("b")) {
            binding.card2.setBackgroundResource(R.drawable.corners_green);
        } else if (list.get(position).getRightAns().equals("c")) {
            binding.card3.setBackgroundResource(R.drawable.corners_green);
        } else {
            binding.card4.setBackgroundResource(R.drawable.corners_green);
        }

    }

    private void makeQNA() {
        int testNumber = getIntent().getIntExtra("testNumber",0);
        binding.toolbar.setTitle("Test "+testNumber);
        setTest(list,testNumber);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,TestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onBackPressed();
    }
}