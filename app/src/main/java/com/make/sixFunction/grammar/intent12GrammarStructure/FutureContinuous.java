package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class FutureContinuous extends AppCompatActivity {
    private ListView lvFutureContinuous;
    private List<String> listFutureContinuous;
    private ArrayAdapter<String> adapterFutureContinuous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_continuous);
        lvFutureContinuous = findViewById(R.id.lv_FutureContinuous);
        listFutureContinuous = new ArrayList<>();

        listFutureContinuous.add("X. THÌ TƢƠNG LAI TIẾP DIỄN (FUTURE CONTINUOUS)\n" +
                "1. Công thức:\n" +
                "\"\uF0B7     Khẳng định: S + shall/will + be + V-ing+ O\n" +
                "\uF0B7     Phủ định: S + shall/will + not + be + V-ing + O\n" +
                "\uF0B7     Nghi vấn: Shall/Will+S + be + V-ing + O?\"\n" +
                "2. Cách dùng:\n" +
                "\"\uF0B7     Dùng để nói về một hành động xảy ra trong tương lai tại thời điểm xác định. (EX: At 10 o’clock tomorrow, my friends and I will be going to the museum.)\"\n" +
                "\n" +
                "\"\uF0B7     Dùng nói về một hành động đang xảy ra trong tương lai thì có hành động khác xen vào. (EX:When you come tomorrow, I will be watching my favorite TV show.)\"\n" +
                "3. Dấu hiệu:\n" +
                "Trong câu có các trạng từ chỉ thời gian trong tương lai kèm theo thời điểm xác định:\n" +
                "- at this time/ at this moment + thời gian trong tương lai: Vào thời điểm này ….\n" +
                "- At + giờ cụ thể + thời gian trong tương lai: vào lúc …..\n" +
                "Ví dụ:\n" +
                "\"- At this time tomorrow I will be watching my favorite TV show. (Vào thời điểm này\n" +
                "ngày mai, tôi đang xem chương trình TV yếu thích của mình.)\"\n" +
                "\"- At 6 a.m tomorrow, I will be running in the park. (Vào 6h sáng mai, tôi đang chạy\n" +
                "bộ trong công viên)\"");

        adapterFutureContinuous = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listFutureContinuous);
        lvFutureContinuous.setAdapter(adapterFutureContinuous);
    }
}