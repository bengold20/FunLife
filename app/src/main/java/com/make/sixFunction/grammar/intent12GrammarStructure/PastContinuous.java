package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PastContinuous extends AppCompatActivity {

    private ListView lvPastContinuous;
    private List<String> listPastContinuous;
    private ArrayAdapter<String> adapterPastContinuous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_continuous);

        lvPastContinuous = findViewById(R.id.lv_PastContinuous);
        listPastContinuous = new ArrayList<>();

        listPastContinuous.add("VI. THÌ QUÁ  KHỨ TIẾP DIỄN - PAST CONTINUOUS\n" +
                "1. Công thức:\n" +
                "\"\uF0B7     Khẳng định: S + was/were + V_ing + O (E.g: She was watching the news at 7 o'clock yesterday.)\n" +
                "\uF0B7     Phủ định: S + wasn’t/weren’t+ V-ing + O (E.g: The weren’t watching the news at 7 o'clock yesterday.)\n" +
                "\uF0B7     Nghi vấn: Was/Were + S+ V-ing + O? ( E.g: Were you watching the news at 7 o'clock yesterday?)\"\n" +
                "2. Cách dùng:\n" +
                "\uF0B7     Dùng để diễn tả một hành động đang xảy ra tại một thời điểm xác định trong quá khứ.\n" +
                "\"Ví dụ:  At 12 o’clock yesterday, we were having lunch. (Vào lúc 12h ngày hôm qua,\n" +
                "chúng tôi đang ăn trưa.)\"\n" +
                "\"\uF0B7     Dùng để diễn tả một hành động đang xảy ra thì một hành động khác xen vào. Hành động đang xảy ra chia thì quá khứ tiếp diễn, hành động xen vào chia thì quá khứ đơn.\"\n" +
                "\"Ex:  He was chatting with his friend when his mother came into the room. (Cậu ta đang tán gẫu với bạn khi mẹ cậu ta vào phòng.)\n" +
                "3. Dấu hiệu nhận biết:\"\n" +
                "\n" +
                "\"Trong câu có những từ: While, when, as, at 10:00 (giờ) last night, ...\n" +
                "Ví dụ:\"\n" +
                "\"\uF0B7  It happened at five the afternoon while she was watching the news on TV.\n" +
                "\uF0B7  He was doing his homework in his bedroom when the burglar came into the house.\"");

        adapterPastContinuous = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPastContinuous);
        lvPastContinuous.setAdapter(adapterPastContinuous);

    }
}