package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PastPerfectContinuous extends AppCompatActivity {
    private ListView lvPastPerfectContinuous;
    private List<String> listPastPerfectContinuous;
    private ArrayAdapter<String> adapterPastPerfectContinuous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_perfect_continuous);

        lvPastPerfectContinuous = findViewById(R.id.lv_PastPerfectContinuous);
        listPastPerfectContinuous = new ArrayList<>();

        listPastPerfectContinuous.add("VIII. THÌ QUÁ KHỨ HOÀN THÀNH TIẾP DIỄN - PAST PERFECT CONTINUOUS\n" +
                "1. Công thức:\n" +
                "\"\uF0B7  Khẳng định:She+ had + been + V_ing + O (Ex: I had been buying)\n" +
                "\uF0B7  Phủ định: S+ hadn’t+ been+ V-ing + O ( Ex: I hadn't been buying)\n" +
                "\uF0B7  Nghi vấn: Had+S+been+V-ing + O? ( Ex: Had I been buying)\"\n" +
                "2. Cách dùng thì quá khứ hoàn thành tiếp diễn\n" +
                "\uF0B7       Diễn đạt một hành động xảy ra kéo dài trước một hành động khác trong Quá khứ (nhấn mạnh tính tiếp diễn)\n" +
                "Ví dụ: I had been thinking about that before you mentioned it\n" +
                "\uF0B7     Diễn đạt một hành động kéo dài liên tục trước một thời điểm xác định trong quá khứ.\n" +
                "\"Ví dụ: We had been making chicken soup 2 hours before 10:00 last night, so when I\n" +
                "came, the room was still hot and steamy.\"\n" +
                "3. Dấu hiệu nhận biết\n" +
                "\"Dấu hiệu nhận biết: until then, by the time, prior to that time, before, after.\"\n" +
                "Ex: Had you been waiting long before the taxi arrived?");

        adapterPastPerfectContinuous = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPastPerfectContinuous);
        lvPastPerfectContinuous.setAdapter(adapterPastPerfectContinuous);
    }
}