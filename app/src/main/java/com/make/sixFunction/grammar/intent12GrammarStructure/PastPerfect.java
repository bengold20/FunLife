package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PastPerfect extends AppCompatActivity {
    private ListView lvPastPerfect;
    private List<String> listPastPerfect;
    private ArrayAdapter<String> adapterPastPerfect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_perfect);
        lvPastPerfect = findViewById(R.id.lv_PastPerfect);
        listPastPerfect = new ArrayList<>();

        listPastPerfect.add("VII. QUÁ KHỨ HOÀN THÀNH (PAST PERFECT)\n" +
                "1. Công thức\n" +
                "\"\uF0B7     Khẳng định: S + had + V3/ED + O (Ex: They had gone to school before they went home.)\n" +
                "\uF0B7     Phủ định: S + had+ not + V3/ED + O ( They hadn’t eaten breakfast before they went to school.)\n" +
                "\uF0B7     Nghi vấn: Had +S + V3/ED + O ? (Had they eaten breakfast before they went to school?)\"\n" +
                "2. Cách dùng\n" +
                "\"Diễn tả một hành động đã xảy ra, hoàn thành trước một hành động khác trong quá khứ.\"\n" +
                "\"+ Khi hai hành động cùng xảy ra trong quá khứ, ta dùng thì quá khứ hoàn thành cho\n" +
                "hành động xảy ra trước và quá khứ đơn cho hành động xảy ra sau.\"\n" +
                "\"+ Khi thì quá khứ hoàn thành thường được dùng kết hợp với thì quá khứ đơn, ta\n" +
                "thường dùng kèm với các giới từ và liên từ như: by (có nghĩa như before), before, after, when, till, untill, as soon as, no sooner…than\"\n" +
                "\"Ex: Yesterday, I went out after I had finished my homework. (Hôm qua, tôi đi chơi sau\n" +
                "khi tôi đã làm xong bài tập.)\"\n" +
                "3. Dấu hiệu nhận biết:\n" +
                "Dấu hiện nhận biết thì quá khứ hoàn thành:\n" +
                "\"\uF0B7     Từ nhận biết: until then, by the time, prior to that time, before, after, for, as soon as, by, ...\n" +
                "\uF0B7     Trong câu thường có các từ: before, after, when by, by the time, by the end of + time in the past\"\n" +
                "\n" +
                "Ví dụ:\n" +
                "\"The old tenant had vacated the property by the time we lookd at it. There was no\n" +
                "furniture left inside\"\n" +
                "\"When I got up this morning, my father had already left.\"");

        adapterPastPerfect = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPastPerfect);
        lvPastPerfect.setAdapter(adapterPastPerfect);
    }
}