package com.make.Function.grammar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.make.adapter.GrammarStructureAdapter;
import com.make.main.R;
import com.make.model.GrammarStructureModel;
import com.make.Function.grammar.intent12GrammarStructure.FutureContinuous;
import com.make.Function.grammar.intent12GrammarStructure.FuturePerfect;
import com.make.Function.grammar.intent12GrammarStructure.FuturePerfectContinuous;
import com.make.Function.grammar.intent12GrammarStructure.PastContinuous;
import com.make.Function.grammar.intent12GrammarStructure.PastPerfect;
import com.make.Function.grammar.intent12GrammarStructure.PastPerfectContinuous;
import com.make.Function.grammar.intent12GrammarStructure.PresentContinuous;
import com.make.Function.grammar.intent12GrammarStructure.PresentPerfect;
import com.make.Function.grammar.intent12GrammarStructure.PresentPerfectContinuous;
import com.make.Function.grammar.intent12GrammarStructure.PresentSimple;
import com.make.Function.grammar.intent12GrammarStructure.SimpleFuture;
import com.make.Function.grammar.intent12GrammarStructure.SimplePast;

import java.util.ArrayList;
import java.util.List;

public class GrammarStructureActivity extends AppCompatActivity {

    RecyclerView rcvGrammarStructure;
    List<GrammarStructureModel> listGrammarStructure;
    GrammarStructureAdapter adapterGrammarStructure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_structure);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        rcvGrammarStructure = findViewById(R.id.rcv_GrammarStructure);
        declareAdapter();

        listGrammarStructure = new ArrayList<>();
        listGrammarStructure.add(new GrammarStructureModel("Hi???n t???i ????n","Present simple"));
        listGrammarStructure.add(new GrammarStructureModel("Hi???n t???i ti???p di???n","Present continuous"));
        listGrammarStructure.add(new GrammarStructureModel("Hi???n t???i ho??n th??nh","Present perfect"));
        listGrammarStructure.add(new GrammarStructureModel("Hi???n t???i ho??n th??nh ti???p di???n","Present perfect continuous"));
        listGrammarStructure.add(new GrammarStructureModel("Qu?? kh??? ????n","Simple past"));
        listGrammarStructure.add(new GrammarStructureModel("Qu?? kh??? ti???p di???n","Past continuous"));
        listGrammarStructure.add(new GrammarStructureModel("Qu?? kh??? ho??n th??nh","Past Perfect"));
        listGrammarStructure.add(new GrammarStructureModel("Qu?? kh??? ho??n th??nh ti???p di???n","Past Perfect continuous"));
        listGrammarStructure.add(new GrammarStructureModel("T????ng lai ????n","Simple future"));
        listGrammarStructure.add(new GrammarStructureModel("T????ng lai ti???p di???n","Future continuous"));
        listGrammarStructure.add(new GrammarStructureModel("T????ng lai ho??n th??nh","Future perfect"));
        listGrammarStructure.add(new GrammarStructureModel("T????ng lai ho??n th??nh ti???p di???n","Future perfect continuous"));


        adapterGrammarStructure.setData(listGrammarStructure);
        rcvGrammarStructure.setLayoutManager(new LinearLayoutManager(this));
        rcvGrammarStructure.setAdapter(adapterGrammarStructure);

    }

    public void declareAdapter(){
        adapterGrammarStructure = new GrammarStructureAdapter(new GrammarStructureAdapter.IfClickItemGrammarStructure() {
            @Override
            public void goToItent0() {
                clickGoToIntent();
            }

            @Override
            public void goToItent1() {
                clickGoToIntent1();
            }

            @Override
            public void goToItent2() {
                clickGoToIntent2();
            }

            @Override
            public void goToItent3() {
                clickGoToIntent3();
            }

            @Override
            public void goToItent4() {
                clickGoToIntent4();
            }

            @Override
            public void goToItent5() {
                clickGoToIntent5();
            }

            @Override
            public void goToItent6() {
                clickGoToIntent6();
            }

            @Override
            public void goToItent7() {
                clickGoToIntent7();
            }

            @Override
            public void goToItent8() {
                clickGoToIntent8();
            }

            @Override
            public void goToItent9() {
                clickGoToIntent9();
            }

            @Override
            public void goToItent10() {
                clickGoToIntent10();
            }

            @Override
            public void goToItent11() {
                clickGoToIntent11();
            }
        });
    }

    private void clickGoToIntent11() {
        Intent intent = new Intent(this, FuturePerfectContinuous.class);
        startActivity(intent);
    }

    private void clickGoToIntent10() {
        Intent intent = new Intent(this, FuturePerfect.class);
        startActivity(intent);
    }

    private void clickGoToIntent9() {
        Intent intent = new Intent(this, FutureContinuous.class);
        startActivity(intent);
    }

    private void clickGoToIntent8() {
        Intent intent = new Intent(this, SimpleFuture.class);
        startActivity(intent);
    }

    private void clickGoToIntent7() {
        Intent intent = new Intent(this, PastPerfectContinuous.class);
        startActivity(intent);
    }

    private void clickGoToIntent6() {
        Intent intent = new Intent(this, PastPerfect.class);
        startActivity(intent);
    }

    private void clickGoToIntent5() {
        Intent intent = new Intent(this, PastContinuous.class);
        startActivity(intent);
    }

    private void clickGoToIntent4() {
        Intent intent = new Intent(this, SimplePast.class);
        startActivity(intent);
    }

    private void clickGoToIntent3() {
        Intent intent = new Intent(this, PresentPerfectContinuous.class);
        startActivity(intent);
    }

    private void clickGoToIntent2() {
        Intent intent = new Intent(this, PresentPerfect.class);
        startActivity(intent);
    }

    private void clickGoToIntent1() {
        Intent intent = new Intent(this, PresentContinuous.class);
        startActivity(intent);
    }

    private void clickGoToIntent() {
        Intent intent = new Intent(this, PresentSimple.class);
        startActivity(intent);
    }
}