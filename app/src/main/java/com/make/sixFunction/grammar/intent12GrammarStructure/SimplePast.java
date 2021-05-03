package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class SimplePast extends AppCompatActivity {

    private ListView lvSimplePast;
    private List<String> listSimplePast;
    private ArrayAdapter<String> adapterSimplePaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_past);

        lvSimplePast = findViewById(R.id.lv_SimplePast);
        listSimplePast = new ArrayList<>();

        listSimplePast.add("V. QUÁ KHỨ ĐƠN (PAST SIMPLE)\n" +
                "1. Công thức\n" +
                "Với động từ thường:\n" +
                "\"\uF0B7     (Khẳng định): S + V(past)+ O ( E.g: He worked as a policeman.)\n" +
                "\uF0B7     (Phủ định): S + DID+ NOT + V (infinitive) + O ( She didn’t eat bread for the breakfast.)\n" +
                "\uF0B7     (Nghi vấn): DID + S+ V (infinitive)+ O ? ( Did you call Zoey yesterday?)\"\n" +
                "Với động từ Tobe:\n" +
                "\"\uF0B7     (Khẳng định): S + WAS/WERE + (an/a/the) + N(s)/ Adj\n" +
                "\uF0B7     (Phủ định): S+ WAS/ WERE + NOT + (an/a/the) + N(s)/ Adj\n" +
                "\uF0B7     (Nghi vấn): WAS/WERE + S+ (an/a/the) + N(s)/ Adj?\"\n" +
                "\n" +
                "3. Cách dùng thì quá khứ đơn:\n" +
                "Diễn tả một hành động đã xảy ra và kết thúc trong quá khứ.\n" +
                "Ví dụ:\n" +
                "\"\uF0B7     I went to the concert last week.\n" +
                "\uF0B7     A few weeks ago, a woman called to report a robbery.\"\n" +
                "3. Dấu hiệu nhận biết:\n" +
                "\"Các từ thường xuất hiện trong thì quá khứ đơn: Yesterday ( hôm qua), last (night/\n" +
                "week/ month/ year), ago (cách đây), ...\"");

        adapterSimplePaste = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listSimplePast);
        lvSimplePast.setAdapter(adapterSimplePaste);
    }
}