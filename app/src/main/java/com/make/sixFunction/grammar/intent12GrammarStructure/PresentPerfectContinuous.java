package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PresentPerfectContinuous extends AppCompatActivity {

    private ListView lvPresentPerfectContinuous;
    private List<String> listPresentPerfectContinuous;
    private ArrayAdapter<String> adapterPresentPerfectContinuous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_perfect_continuous);

        lvPresentPerfectContinuous = findViewById(R.id.lv_presentSimple);
        listPresentPerfectContinuous = new ArrayList<>();

        listPresentPerfectContinuous.add("IV. THÌ HIỆN TẠI HOÀN THÀNH TIẾP DIỄN - PRESENT PERFECT CONTINUOUS\n" +
                "1. Công thức:\n" +
                "\"\uF0B7     Khẳng định: S has/have + been + V_ing + O (E.g: I have been looking you all day.)\n" +
                "\uF0B7     Phủ định: S+ hasn’t/ haven’t+ been+ V-ing + O (E.g: She has not been studying English for 5 years.)\"\n" +
                "\n" +
                "\n" +
                "\uF0B7     Nghi vấn: Has/have+ S+ been+ V-ing + O? (e.g: Has he been standing in the snow for more than 3 hours?)\n" +
                "2. Cách dùng:\n" +
                "\"Diễn tả một hành động bắt đầu trong quá khứ diễn ra liên tục và kéo dài đến hiện tại.\n" +
                "Nhấn mạnh vào tính chất “liên tục” của hành động.\"\n" +
                "\"Ví dụ: He been standing in the snow for more than 3 hours./ Anh ấy đã đứng dưới trời\n" +
                "tuyết hơn 3 tiếng rồi.\"\n" +
                "Phân biệt với thì hiện tại hoàn thành:\n" +
                "\"Thì hiện tại hoàn thành nhấn mạnh vào kết quả còn thì hiện tại hoàn thành tiếp diễn\n" +
                "nhấn mạnh vào quá trình.\"\n" +
                "3. Cách nhận biết thì hiện tại hoàn thành tiếp diễn:\n" +
                "\"- Từ nhận biết: all day, all week, all month, since, for, for a long time, almost every day\n" +
                "this week, recently, lately, in the past week, in recent years, up until now, and so far.\"\n" +
                "Ví dụ: I am so tired. I have been searching for a new apartment all the morning.");

        adapterPresentPerfectContinuous = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPresentPerfectContinuous);
        lvPresentPerfectContinuous.setAdapter(adapterPresentPerfectContinuous);
    }
}