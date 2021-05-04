package com.make.Function.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PresentSimple extends AppCompatActivity {
    private ListView lvPresentSimple;
    private List<String> listpPresentSimple;
    private ArrayAdapter<String> adapterPresentSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_simple);

        lvPresentSimple = findViewById(R.id.lv_presentSimple);
        listpPresentSimple = new ArrayList<>();

        listpPresentSimple.add("I. THÌ HIỆN TẠI ĐƠN (SIMPLE PRESENT):                                                                                                                           1. Công thức thì hiện tại đơn Công thức thì hiện tại đơn đối với động từ thường                                                    \uF0B7  Khẳng định:S + V_S/ES + O\n" +
                "\uF0B7  Phủ định: S+ DO/DOES + NOT + V(Infinitive) +O\n" +
                "\uF0B7  Nghi vấn: DO/DOES + S + V (Infinitive)+ O ?\n" +
                "Công thức thì hiện tại đơn đối với động từ Tobe                                                                                                              \uF0B7  Khẳng định: S+ AM/IS/ARE + (an/a/the) N(s)/ Adj\n" +
                "\uF0B7  Phủ định: S + AM/IS/ARE + NOT + (an/a/the) N (s)/ Adj\n" +
                "\uF0B7  Nghi vấn: AM/IS/ARE + S + (an/a/the) N (s)/ Adj?                                                                                                             Ví dụ:                                                                                                                                                                                           \uF0B7  I am a student.\n" +
                "\uF0B7  She is not beautiful.\n" +
                "\uF0B7  Are you a student?                                                                                                                                                              2. Cách sử dụng:                                                                                                                                                                        - Diễn tả một sự thật hiển nhiên, một chân lý. (E.g: The sun rises in the East and sets in the West.)                                                                                                                                                                                     - Diễn tả 1 thói quen, một hành động thường xảy ra ở hiện tại. (E.g:I get up early every morning.)                                                   - Nói lên khả năng của một người (E.g : He plays tennis very well.)                                                                              3. Dấu hiệu nhận biết thì hiện tại đơn:                                                                                                                                                    -Trong câu có xuất hiện từ sau: every (every day, every week, every month, ...)                                                           -Các trạng từ tần suất xuất hiện trong thì hiện tại đơn:  Always , usually,\n" +
                "often, sometimes, seldom, rarely, hardly, never.                                                                                                                        Ví dụ:                                                                                                                                                                                            \uF0B7     I use the Internet just about every day.\n" +
                "\uF0B7     I always miss you.");

        adapterPresentSimple = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listpPresentSimple);
        lvPresentSimple.setAdapter(adapterPresentSimple);
    }
}