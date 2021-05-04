package com.make.Function.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class FuturePerfectContinuous extends AppCompatActivity {
    private ListView lvFuturePerfectContinuous;
    private List<String> listFuturePerfectContinuous;
    private ArrayAdapter<String> adapterFuturePerfectContinuous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_perfect_continuous);
        lvFuturePerfectContinuous = findViewById(R.id.lv_FuturePerfectContinuous);
        listFuturePerfectContinuous = new ArrayList<>();

        listFuturePerfectContinuous.add("XII. TƢƠNG LAI HOÀN THÀNH TIẾP DIỄN (FUTURE PERFECT CONTINUOUS)\n" +
                "1. Công thức\n" +
                "\"\uF0B7     Khẳng định: S + shall/will + have been + V-ing + O\n" +
                "\uF0B7     Phủ định: S + shall/will + not + have + been + V-ing\n" +
                "\uF0B7     Nghi vấn: Shall/Will + S+ have been + V-ing + O ?\"\n" +
                "2. Cách dùng\n" +
                "\"Các dùng thì tương lai hoàn thành tiếp diễn:  để diễn tả một hành động xảy ra trong quá\n" +
                "khứ tiếp diễn liên tục đến một thời điểm cho trước trong tương lai:\"\n" +
                "Ví dụ:\n" +
                "\"\uF0B7     I will have been studying English for 10 years by the end of next month.\n" +
                "\uF0B7     By 2001, I will have been living in London for sixteen years.\"\n" +
                "3. Dấu hiệu:\n" +
                "For + khoảng thời gian + by/ before + mốc thời gian trong tương lai\n" +
                "Ví dụ:\n" +
                "\"\uF0B7     for 10 years by the end of this year (được 10 năm cho tới cuối năm nay)\n" +
                "\uF0B7     for 2 days before the time my parents come back tomorrow. (được 2 ngày trước lúc bố mẹ tôi quay về vào ngày mai).\"\n" +
                "\n");

        adapterFuturePerfectContinuous = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listFuturePerfectContinuous);
        lvFuturePerfectContinuous.setAdapter(adapterFuturePerfectContinuous);
    }
}