package com.make.Function.examTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.make.adapter.ExamTestAdapter;
import com.make.main.MainActivity;
import com.make.main.R;
import com.make.database.DBHelper;
import com.make.model.ExamTestModel;
import com.make.Function.examTest.slide.ScreenSlideActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExamTest extends AppCompatActivity {
    RecyclerView rcvExamTest;
    List<ExamTestModel> listExamTest;
    ExamTestAdapter adapterExamTest;
    Toolbar tbExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_test);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {

        rcvExamTest = findViewById(R.id.rcv_ExamTest);
        declareAdapter();

        listExamTest = new ArrayList<>();
        listExamTest.add(new ExamTestModel("Đề kiểm tra số 1","PDF","5 Phút"));
        listExamTest.add(new ExamTestModel("Đề kiểm tra số 2","PDF","5 Phút"));
        listExamTest.add(new ExamTestModel("Đề kiểm tra số 3","PDF","5 Phút"));
        listExamTest.add(new ExamTestModel("Đề kiểm tra số 4","PDF","5 Phút"));

        adapterExamTest.setData(listExamTest);
        rcvExamTest.setLayoutManager(new LinearLayoutManager(this));
        rcvExamTest.setAdapter(adapterExamTest);



        DBHelper db = new DBHelper(this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //toolbar
        tbExam = findViewById(R.id.tb_Examtest);
        setSupportActionBar(tbExam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tbExam.setNavigationIcon(R.drawable.ic_back);
        tbExam.setLogo(R.drawable.ic_rabbit);

    }

    public void declareAdapter(){
        adapterExamTest = new ExamTestAdapter(new ExamTestAdapter.IfClickItemExamTest() {
            @Override
            public void goToItent0() {
                clickGoToIntent0();
            }

            @Override
            public void goToItent1() {
                clickGoToIntent1();
            }

            @Override
            public void goToItent2() {
                clickGoToIntent2();
            }

            @Override
            public void goToItent3() {
                clickGoToIntent3();
            }
        });
    }

    private void clickGoToIntent0() {
        Intent intent = new Intent(this, ScreenSlideActivity.class);
        intent.putExtra("num_exam",1);
        startActivity(intent);
    }
    private void clickGoToIntent1() {
        Intent intent = new Intent(this, ScreenSlideActivity.class);
        intent.putExtra("num_exam",2);
        startActivity(intent);
    }
    private void clickGoToIntent2() {
        Intent intent = new Intent(this, ScreenSlideActivity.class);
        intent.putExtra("num_exam",3);
        startActivity(intent);
    }
    private void clickGoToIntent3() {
        Intent intent = new Intent(this, ScreenSlideActivity.class);
        intent.putExtra("num_exam",4);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent = new Intent(ExamTest.this, MainActivity.class);
                startActivity(intent);
                return true;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}