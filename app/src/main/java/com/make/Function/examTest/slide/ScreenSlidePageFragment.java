package com.make.Function.examTest.slide;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.make.main.R;
import com.make.model.QuestionModel;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends Fragment {
    ArrayList<QuestionModel> arr_Question;
    public static final String ARG_PAGE = "page_key"; //this is key
    public static final String ARG_CHECKANSWER = "checkans_key"; //this is key
    private int mPageNumber; //position page now
    public int checkAns; // biến kiểm tra

    private RadioGroup radGroupAns;
    private RadioButton radA, radB, radC, radD;


    private TextView txt_question, txt_contentQuestion, txt_answer1, txt_answer2, txt_answer3, txt_answer4;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        txt_question = rootView.findViewById(R.id.txt_question);
        txt_contentQuestion = rootView.findViewById(R.id.txt_contentQuestion);

        radGroupAns = rootView.findViewById(R.id.radGroup);
        radA = rootView.findViewById(R.id.radA);
        radB = rootView.findViewById(R.id.radB);
        radC = rootView.findViewById(R.id.radC);
        radD = rootView.findViewById(R.id.radD);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get Data From ScreenSlideActivity
        arr_Question = new ArrayList<>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_Question = slideActivity.getData(); //get data from activity
        mPageNumber = getArguments().getInt(ARG_PAGE); //get position from activity
        checkAns = getArguments().getInt(ARG_CHECKANSWER);

    }

    //gửi vị trí fragment hiện tại . tự tạo
    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PAGE, pageNumber);
        bundle.putInt(ARG_CHECKANSWER, checkAnswer);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_question.setText("Câu hỏi số " + (mPageNumber + 1));
        txt_contentQuestion.setText(getPositionPager(mPageNumber).getQuestion());
        radA.setText(getPositionPager(mPageNumber).getAns_a());
        radB.setText(getPositionPager(mPageNumber).getAns_b());
        radC.setText(getPositionPager(mPageNumber).getAns_c());
        radD.setText(getPositionPager(mPageNumber).getAns_d());

        //khi kết thúc thì không chọn được đáp án khác
        if(checkAns != 0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(getPositionPager(mPageNumber).getResult().toString());
        }

        radGroupAns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getPositionPager(mPageNumber).choiceID = checkedId; //khi chọn cái nào thì nó sẽ gán cho choiceID
                getPositionPager(mPageNumber).setMy_ans(getChoiceFromID(checkedId));
            }
        });
    }

    //vị trí trang nào ở activity
    public QuestionModel getPositionPager(int position){
      return arr_Question.get(position);
    }

    //lấy giá trị(vị trí) của radgroup từ ***00, ***01... thành đáp án A,B,C,D
    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else {
            return "chưa lựa chọn";
        }
    }

    //hàm kiểm tra câu đúng . nếu đúng thì đổi màu background của radio button tương ứng
    //tham số trả về là cột trong csdl
    private void getCheckAns(String ans){
        if(ans.equals("A") == true){
            radA.setBackgroundResource(R.drawable.bg_green_conner_30);
            radB.setBackgroundResource(R.drawable.bg_red_conner_30);
            radC.setBackgroundResource(R.drawable.bg_red_conner_30);
            radD.setBackgroundResource(R.drawable.bg_red_conner_30);
        }else if(ans.equals("B") == true){
            radA.setBackgroundResource(R.drawable.bg_red_conner_30);
            radB.setBackgroundResource(R.drawable.bg_green_conner_30);
            radC.setBackgroundResource(R.drawable.bg_red_conner_30);
            radD.setBackgroundResource(R.drawable.bg_red_conner_30);
        }else if(ans.equals("C") == true){
            radA.setBackgroundResource(R.drawable.bg_red_conner_30);
            radB.setBackgroundResource(R.drawable.bg_red_conner_30);
            radC.setBackgroundResource(R.drawable.bg_green_conner_30);
            radD.setBackgroundResource(R.drawable.bg_red_conner_30);
        }else if(ans.equals("D") == true){
            radA.setBackgroundResource(R.drawable.bg_red_conner_30);
            radB.setBackgroundResource(R.drawable.bg_red_conner_30);
            radC.setBackgroundResource(R.drawable.bg_red_conner_30);
            radD.setBackgroundResource(R.drawable.bg_green_conner_30);
        }else ;
    }

}