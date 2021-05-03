package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class SimpleFuture extends AppCompatActivity {
    private ListView lvSimpleFuture;
    private List<String> listSimpleFuture;
    private ArrayAdapter<String> adapterSimpleFuture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_future);
        lvSimpleFuture = findViewById(R.id.lv_SimpleFuture);
        listSimpleFuture = new ArrayList<>();

        listSimpleFuture.add("IX. TƢƠNG LAI ĐƠN (SIMPLE FUTURE)\n" +
                "1. Công thức:\n" +
                "\"\uF0B7     Khẳng định:S + shall/will + V(infinitive) + O (Ex: We’ ll enjoy it)\n" +
                "\uF0B7     Phủ định: S + shall/will + not + V(infinitive) + O (He won’t go to school.)\"\n" +
                "\n" +
                "\n" +
                "\uF0B7     Nghi vấn: Shall/will+S + V(infinitive) + O ? (Will they have dinner together?)\n" +
                "Ví dụ: The prime minister will open the debate in parliament tomorrow.\n" +
                "2. Cách dùng:\n" +
                "\"\uF0B7     Diễn tả dự định nhất thời xảy ra ngay tại lúc nói. (EX: Are you going to the beach? I will go with you – Bạn muốn đi biển không? Mình sẽ đi cùng bạn.)\n" +
                "\uF0B7     Nói về một dự đoán dựa trên kinh nghiệm có được trong quá khứ. (EX: I think it’ll be extremely hot there – Tôi nghĩ rằng nó sẽ rất nóng đó)\n" +
                "\uF0B7     Khi đưa ra ý kiến, đề nghị. (EX: Don’t worry, I’ll let everyone know - Đừng lo lắng, tôi sẽ cho tất cả mọi người biết\"\n" +
                "Lƣu ý:\n" +
                "\"Thì tương lai đơn có thể sử dụng để diễn tả cả hành động có dự định và không có dự định từ trước. Tuy nhiên để phân biệt với thì tương lai gần có dự định, thì tương lai đơn thường được dùng cho các hành động mang tính bộc phát ngay tại thời điểm nói chứ\n" +
                "không có dự định như thì tương lai gần. Ví dụ:\"\n" +
                "Mother: There is no sugar left. (Hết đường mất rồi.)\n" +
                "\"Son: Ok, I will go to market and buy it for you. (Con sẽ ra chợ mua cho mẹ.)\"\n" +
                "3. Dấu hiệu nhận biết\n" +
                "\"Trong câu thường có: tomorrow, Next day/ Next week/ next month/ next year,  in + thời\n" +
                "gian, probably, perhaps, ...\"");

        adapterSimpleFuture = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listSimpleFuture);
        lvSimpleFuture.setAdapter(adapterSimpleFuture);
    }
}