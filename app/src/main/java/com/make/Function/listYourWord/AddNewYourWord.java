package com.make.Function.listYourWord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.make.adapter.NewYourWordAdapter;
import com.make.main.MainActivity;
import com.make.main.R;
import com.make.database.NewYourWordDatabase;
import com.make.model.NewYourWordModel;

import java.util.ArrayList;
import java.util.List;

public class AddNewYourWord extends AppCompatActivity {
    FloatingActionButton fabAddNewYourWord,fabDeleteAllNewYourWord;

    private static final int BEN_REQUEST_CODE_NEWWORD = 3;
    RecyclerView rcvNewYourWord;
    List<NewYourWordModel> listNewYourWord;
    NewYourWordAdapter adapterNewYourWord;
    private ImageButton imgbtnSearchNewWord;
    private EditText edtSearchNewWord;

    Toolbar tbAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_your_word);

        addControls();
        addEvents();
    }

    private void addEvents() {
        fabAddNewYourWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_newYourWord, new AddNewYourWordFragment()).commit();
            }
        });

        fabDeleteAllNewYourWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    deleteAllYourWord();
            }
        });

        imgbtnSearchNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchNewWord();
            }
        });

    }

    private void addControls() {

        fabAddNewYourWord = findViewById(R.id.fab_addNewYourWord);
        fabDeleteAllNewYourWord = findViewById(R.id.fab_deleteAllNewYourWord);
        rcvNewYourWord = findViewById(R.id.rcv_newYourWord);
        imgbtnSearchNewWord = findViewById(R.id.imgbtn_searchNewWord);
        edtSearchNewWord = findViewById(R.id.edt_searchNewWord);

        adapterNewYourWord = new NewYourWordAdapter(new NewYourWordAdapter.IfClickItemNewWord() {
            @Override
            public void updateNewYourWord(NewYourWordModel newYourWordModel) {
                clickUpdateNewYourWord(newYourWordModel);
            }

            @Override
            public void deleteNewYourWord(NewYourWordModel newYourWordModel) {
                clickDeleteNewYourWord(newYourWordModel);
            }
        });

        loadDataNewWord();
        rcvNewYourWord.setLayoutManager(new LinearLayoutManager(this));
        rcvNewYourWord.setAdapter(adapterNewYourWord);

        //toolbar
        //toolbar
        tbAddWord = findViewById(R.id.tb_AddWord);
        setSupportActionBar(tbAddWord);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tbAddWord.setNavigationIcon(R.drawable.ic_back);
        tbAddWord.setLogo(R.drawable.ic_rabbit);
    }

    private void clickDeleteNewYourWord(NewYourWordModel newYourWordModel) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm delete this word!")
                .setMessage("Are you sure?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NewYourWordDatabase.getInstance(AddNewYourWord.this).newYourWordDAO().deleteNewYourWord(newYourWordModel);

                loadDataNewWord();
            }
        }).setNegativeButton("NO",null).show();
    }

    private void clickUpdateNewYourWord(NewYourWordModel newYourWordModel) {
        UpdateNewYourWordFragment updateNewYourWordFragment = new UpdateNewYourWordFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_newYourWord",newYourWordModel);
        updateNewYourWordFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_newYourWord, updateNewYourWordFragment);
        fragmentTransaction.commit();
    }

    private void deleteAllYourWord() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm delete all this word!")
                .setMessage("Are you sure?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NewYourWordDatabase.getInstance(AddNewYourWord.this).newYourWordDAO().deleteAllNewYourWord();

                        loadDataNewWord();
                    }
                }).setNegativeButton("NO",null).show();
    }

    private void searchNewWord() {
            String strKeySearchWord = edtSearchNewWord.getText().toString().trim();
            listNewYourWord = new ArrayList<>();
            listNewYourWord = NewYourWordDatabase.getInstance(this).newYourWordDAO().searchNewWord(strKeySearchWord);
            adapterNewYourWord.setDaTa(listNewYourWord);

            hideKeyboard();
    }

    public void loadDataNewWord(){
        listNewYourWord = new ArrayList<>(NewYourWordDatabase.getInstance(this).newYourWordDAO().getListNewWord());
        adapterNewYourWord.setDaTa(listNewYourWord);
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent = new Intent(AddNewYourWord.this, MainActivity.class);
                startActivity(intent);
                return true;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

}