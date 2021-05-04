package com.make.Function.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class FuturePerfect extends AppCompatActivity {
    private ListView lvFuturePerfect;
    private List<String> listFuturePerfect;
    private ArrayAdapter<String> adapterFuturePerfect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_perfect);
        lvFuturePerfect = findViewById(R.id.lv_FuturePerfect);
        listFuturePerfect = new ArrayList<>();

        listFuturePerfect.add("XI. THÌ TƢƠNG LAI HOÀN THÀNH (FUTURE PERFECT)\n" +
                "1. Công thức:\n" +
                "\"\uF0B7     Khẳng định:S + shall/will + have + V3/ED\n" +
                "\uF0B7     Phủ định: S + shall/will + not + have + V3/ED\n" +
                "\uF0B7     Nghi vấn: Shall/Will+ S + have + V3/ED ?\"\n" +
                "2. Cách dùng :\n" +
                "\uF0B7     Dùng để diễn tả một hành động hay sự việc hoàn thành trƣớc một thời điểm trong tƣơng lai.\n" +
                "\"Ví dụ: I will have finished my homework before 10 o’clock this evening. (Cho đến\n" +
                "trước 10h tối nay tôi sẽ hoàn thành xong bài tập về nhà rồi.)\"\n" +
                "\uF0B7     Dùng để diễn tả một hành động hay sự việc hoàn thành trƣớc một hành động hay sự việc khác trong tƣơng lai.\n" +
                "\"Ví dụ: I will have made the meal ready before the time you come tomorrow. (Ngày mai\n" +
                "tôi đã chuẩn bị bữa ăn sẵn sàng trước khi bạn đến ngày mai.)\"\n" +
                "\n" +
                "3. Dấu hiệu:\n" +
                "\"\uF0B7     By + thời gian tương lai,\n" +
                "\uF0B7     By the end of + thời gian trong tương lai,\n" +
                "\uF0B7     Before + thời gian tương lai\n" +
                "\uF0B7     By the time …\"\n" +
                "\"Ví dụ:\n" +
                "- By the end of this month I will have taken an English course. (Cho tới cuối tháng này thì tôi đã tham gia một khóa học Tiếng Anh rồi.)\"\n" +
                "\"- Ngan will have served on the Board of West Coast College for 20 years by the\n" +
                "time she retires.\"");

        adapterFuturePerfect = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listFuturePerfect);
        lvFuturePerfect.setAdapter(adapterFuturePerfect);
    }
}