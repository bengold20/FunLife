package com.make.model;

import java.io.Serializable;

//implement seri... để có thể truyền dữ liệu mảng sang activity khác
public class QuestionModel implements Serializable {
    private int _id;
    private String question;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private int num_exam;
    private String my_ans = "";
    public int choiceID = -1; //-1 bởi khi chạy vào radgroup nó sẽ ko check radbutton nào cả

    public QuestionModel() {
    }

    public QuestionModel(int _id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, int num_exam, String my_ans) {
        this._id = _id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.num_exam = num_exam;
        this.my_ans = my_ans;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }

    public String getMy_ans() {
        return my_ans;
    }

    public void setMy_ans(String my_ans) {
        this.my_ans = my_ans;
    }

}
