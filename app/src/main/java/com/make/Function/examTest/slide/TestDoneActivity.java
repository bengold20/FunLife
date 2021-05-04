package com.make.Function.examTest.slide;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.make.main.R;
import com.make.model.QuestionModel;
import com.make.Function.examTest.ExamTest;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<QuestionModel> arr_Question = new ArrayList<>();

    int num_notAnswer;
    int num_true;
    int num_false;

    TextView txtAnsTrue,txtAnsFalse,txtNotAns,txtSumScores;
    Button btnExitExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        Intent intent = getIntent();
        arr_Question = (ArrayList<QuestionModel>) intent.getExtras().getSerializable("arr_Ques");
        addControls();
        checkResult();

        txtNotAns.setText("" +num_notAnswer);
        txtAnsFalse.setText("" +num_false);
        txtAnsTrue.setText("" +num_true);
        txtSumScores.setText("" + (num_true * 2));

    }

    private void addControls() {
        txtAnsTrue = findViewById(R.id.txt_ansTrue);
        txtAnsFalse = findViewById(R.id.txt_ansFalse);
        txtNotAns = findViewById(R.id.txt_notAns);
        txtSumScores = findViewById(R.id.txt_sumScores);

        btnExitExam = findViewById(R.id.btn_exitExam);
        btnExitExam.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(TestDoneActivity.this)
                        .setIcon(R.drawable.ic_rabbit)
                        .setTitle("Bạn có muốn thoát không???")
                        .setMessage("Are you sure?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(TestDoneActivity.this, ExamTest.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("NO",null).show();
            }
        });

    }


    //check kết quả
    public void checkResult(){
        for (int i=0;i < arr_Question.size();i++){
            if(arr_Question.get(i).getMy_ans().equals("") == true){
                num_notAnswer++;
            }else if(arr_Question.get(i).getResult().equals(arr_Question.get(i).getMy_ans()) == true){
                num_true++;
            }else num_false++;
        }
    }


}