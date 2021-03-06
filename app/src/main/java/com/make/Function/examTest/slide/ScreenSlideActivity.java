package com.make.Function.examTest.slide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.make.adapter.ShowDialogAnsAdapter;
import com.make.main.R;
import com.make.model.QuestionModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScreenSlideActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    private Button btnCheckAnswer,btnCheckScore;
    private TextView txtTimeExamTest;
    private Button btnCloseDialog,btnFinishExam;

    int num_exam;
    public int checkAns = 0;

    //CSDL
    QuestionController questionController;
    ArrayList<QuestionModel> arr_Question;

    //time down
    CounterClass timeDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pagerExamText);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        //scroll type zoomoutpage
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //get num_exam from ExamTest Activity

        Intent intent = getIntent();
        num_exam = intent.getIntExtra("num_exam", 0);

        //timedown
        timeDown = new CounterClass(5*60*1000, 1000);
        //set num_xam to fragment slide
        questionController = new QuestionController(this);
        arr_Question = new ArrayList<QuestionModel>();
        arr_Question = questionController.getQuestion(num_exam);


        txtTimeExamTest = findViewById(R.id.txt_timeExamTest);
        txtTimeExamTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnCheckAnswer = findViewById(R.id.btn_checkAnswer);
        btnCheckAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        btnCheckScore = findViewById(R.id.btn_checkScore);
        btnCheckScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(), TestDoneActivity.class);
                intent1.putExtra("arr_Ques", arr_Question);
                startActivity(intent1);
            }
        });

        timeDown.start();
    }

    public ArrayList<QuestionModel> getData(){
       return  arr_Question;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return ScreenSlidePageFragment.create(position,checkAns); //send this page's position to ScreenSlidePageFragment .. truy???n qua fragment gi?? tr??? 0 th?? ch????ng tr??nh ch??a k???t th??c. n???u kh??c 0 th?? k???t th??c v?? hi???n backround c???a ????p ??n l??n
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    private void checkAnswer() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_check_answer);
        dialog.setTitle("Danh S??ch c??u tr??? l???i");

        ShowDialogAnsAdapter showDialogAnsAdapter = new ShowDialogAnsAdapter(arr_Question,this);
        GridView gvListAnswer = dialog.findViewById(R.id.gv_listAnswer);
        gvListAnswer.setAdapter(showDialogAnsAdapter);

        gvListAnswer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);//click t??? dialog s??? t???i c??i c??u h???i ????
                dialog.dismiss(); // close dialog
            }
        });


        btnCloseDialog = dialog.findViewById(R.id.btn_closeDialog);
        btnFinishExam = dialog.findViewById(R.id.btn_finishExam);

        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnFinishExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeDown.cancel();
                result();
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    public void result(){
        checkAns = 1;

        if(mPager.getCurrentItem() >= 3 ) mPager.setCurrentItem(mPager.getCurrentItem()-2);
        else if(mPager.getCurrentItem() < 3) mPager.setCurrentItem(mPager.getCurrentItem()+3);

        btnCheckScore.setVisibility(View.VISIBLE);
        btnCheckAnswer.setVisibility(View.GONE);
    }

    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        //millisInFuture:t???ng th???i gian : 60*1000
        //countDownInterval: t???c ????? ?????m ng?????c: 1000
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            txtTimeExamTest.setText(countTime); //SetText cho textview hi???n th??? th???i gian.
        }

        @Override
        public void onFinish() {
            txtTimeExamTest.setText("00:00");  //SetText cho textview hi???n th??? th???i gian.
            checkAnswer();
        }
    }

//     Ph????ng th???c xoa database. n???u thay ?????i d??? li???u ??? trong db brower r???i x??a sql t??? app c???a m??nh. r???i th??m file sql m???i v??o ????? c???p
//    nh???t d??? li???u m???i..th?? ta x??a c??i database c?? ??i v?? copy c??i m???i v??o
//    c???n x??a c??i file ??? trong ngu???n ??i m???i c???p nh???t ???????c c??i m???i
//            try {
//            db.deleteDataBase();
//            Toast.makeText(this, "X??a th??nh c??ng", Toast.LENGTH_SHORT).show();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "bi loi rui", Toast.LENGTH_SHORT).show();
//        }

}
