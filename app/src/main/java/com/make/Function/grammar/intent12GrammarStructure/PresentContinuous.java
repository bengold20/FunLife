package com.make.Function.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PresentContinuous extends AppCompatActivity {

    private ListView lvPresentContinuous;
    private List<String> listPresentContinuous;
    private ArrayAdapter<String> adapterPresentContinuous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_continuous);

        lvPresentContinuous = findViewById(R.id.lv_PresentContinuous);
        listPresentContinuous = new ArrayList<>();
        listPresentContinuous.add("II. THÌ HIỆN TẠI TIẾP DIỄN (PRESENT CONTINUOUS)\n" +
                "1. Công thức\n" +
                "\"\uF0B7     Khẳng định: S + is/ am/ are + V_ing + O ( E.g: They are studying English.)\n" +
                "\uF0B7     Phủ định: S+ is/ am/ are + NOT + V_ing + O (E.g: I’m not cooking now.)\n" +
                "\uF0B7     Nghi vấn: Is/ am/ are + S+ V_ing + O ( Is she watching T.V at the moment?)\"\n" +
                "2. Cách sử dụng\n" +
                "\"\uF0B7     Diễn tả hành động đang diễn ra tại thời điểm nói (E.g: The children are playing football now.)\n" +
                "\uF0B7     Diễn tả hành động đang diễn ra nhưng không nhất thiết xảy ra tại thời điểm nói. (E.g: I am looking for a job)\n" +
                "\uF0B7     Diễn tả 1 sự than phiền với hành động lặp đi lặp lại nhiều gây khó chịu, bực mình. Trong trường hợp này, câu thường có trạng từ tần suất \"\"always\"\". (E.g : He is always borrowing our books and then he doesn’t remember.)\n" +
                "\uF0B7     Dùng để diễn tả một hành động sắp xảy ra trong tương lai theo kế hoạch đã định trước (E.g: I am flying to Thailand tomorrow.)\"\n" +
                "Lƣu ý quan trọng cần biết:\n" +
                "\"Không dùng thì hiện tại tiếp diễn với các động từ chỉ tri giác, nhận thức như : be, see,\n" +
                "hear, feel, realize, seem, remember, forget, understand, know, like, want, glance, smell, love, hate, ...\"\n" +
                "Ví dụ:\n" +
                "\"\uF0B7     I am tired now.\n" +
                "\uF0B7     He wants to go for a cinema at the moment.\n" +
                "\uF0B7     Do you remember me?\"\n" +
                "3. Dấu hiệu nhận biết:\n" +
                "\"Trong câu có những từ: Now, right now, at present, at the moment,\"\n" +
                "\"Trong các câu trước đó là một câu chỉ mệnh lệnh: Look!, Watch! Be quite!, ..\"");

        adapterPresentContinuous = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPresentContinuous);
        lvPresentContinuous.setAdapter(adapterPresentContinuous);
    }
}