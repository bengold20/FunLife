package com.make.sixFunction.grammar.intent12GrammarStructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.make.main.R;

import java.util.ArrayList;
import java.util.List;

public class PresentPerfect extends AppCompatActivity {
    private ListView lvPresentPerfect;
    private List<String> listPresentPerfect;
    private ArrayAdapter<String> adapterPresentPerfect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_perfect);

        lvPresentPerfect= findViewById(R.id.lv_PresentPerfect);
        listPresentPerfect = new ArrayList<>();

        listPresentPerfect.add("III. THÌ HIỆN TẠI HOÀN THÀNH - PRESENT PERFECT\n" +
                "\n" +
                "1. Công thức\n" +
                "\"\uF0B7     Khẳng định: S + have/ has + Past participle (V3) + O. (E.g: She has studied English for 2 years.)\n" +
                "\uF0B7     Phủ định: S + have/ has + NOT+ Past participle (V3) + O. (E.g: I haven’t seen my close friend for a month.)\n" +
                "\uF0B7     Nghi vấn: Have/ has +S+ Past participle (V3) + O? (E.g: Have you eaten dinner yet?)\"\n" +
                "2. Cách sử dụng thì hiện tại hoàn thành trong tiếng Anh:\n" +
                "\"\uF0B7     Diễn tả hành động xảy ra trong quá khứ nhƣng không nói rõ thời điểm, có kết quả liên quan đến hiện tại:\"\n" +
                "Ví dụ: : My car has been stolen./ Chiếc xe của tôi đã bị lấy cắp.\n" +
                "\uF0B7     Diễn tả hành động bắt đầu ở quá khứ và đang tiếp tục ở hiện tại :\n" +
                "Ví dụ: They’ve been married for nearly fifty years / Họ đã kết hôn được 50 năm rồi.\n" +
                "3. Dấu hiệu nhận biết thì hiện tại hoàn thành:\n" +
                "\"Trong thì hiện tại hoàn thành thường có những từ sau: Already, yet, just, ever, never,\n" +
                "since, for, recently, ...\"\n" +
                "\"\uF0B7     just, recently, lately: gần đây, vừa mới\n" +
                "\uF0B7     ever: đã từng\n" +
                "\uF0B7     already: rồi\n" +
                "\uF0B7     for + khoảng thời gian (for a year, for a long time, …)\n" +
                "\uF0B7     since + mốc/điểm thời gian(since 1992, since June, …)\n" +
                "\uF0B7     yet: chưa (dùng trong câu phủ định và câu hỏi)\n" +
                "\uF0B7     so far = until now = up to now = up to the present: cho đến bây giờ\"");

        adapterPresentPerfect = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPresentPerfect);
        lvPresentPerfect.setAdapter(adapterPresentPerfect);
    }
}