package com.make.sixFunction.grammar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.make.adapter.GrammarAdapter;
import com.make.main.R;
import com.make.model.GrammarModel;

import java.util.ArrayList;
import java.util.List;

public class GrammarActivity extends AppCompatActivity {
    RecyclerView rcvGrammar;
    List<GrammarModel> listGrammar;
    GrammarAdapter adapterGrammar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        rcvGrammar = findViewById(R.id.rcv_Grammar);
        declareAdapter();

        listGrammar = new ArrayList<>();
        listGrammar.add(new GrammarModel("1. Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn,..."));
        listGrammar.add(new GrammarModel("2. Câu bị động","Cấu trúc ngữ pháp, các trường,..."));

        adapterGrammar.setData(listGrammar);
        rcvGrammar.setLayoutManager(new LinearLayoutManager(this));
        rcvGrammar.setAdapter(adapterGrammar);

    }

    public void declareAdapter(){
        adapterGrammar = new GrammarAdapter(new GrammarAdapter.IfClickItemGrammar() {
            @Override
            public void goToItent0() {
                clickGoToIntent0();
            }

            @Override
            public void goToItent1() {
                clickGoToIntent1();
            }
        });
    }

    private void clickGoToIntent0() {
        Intent intent = new Intent(this,GrammarStructureActivity.class);
        startActivity(intent);
    }
    private void clickGoToIntent1() {
        Toast.makeText(this,"Nội dung sẽ sớm được cập nhật",Toast.LENGTH_SHORT).show();
    }
}