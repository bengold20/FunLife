package com.make.Function.listYourWord;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.make.main.R;
import com.make.database.NewYourWordDatabase;
import com.make.model.NewYourWordModel;

import java.util.List;

public class AddNewYourWordFragment extends Fragment {


    private EditText edtNewYourWord, edtTranslater, edtMeanning;
    private Button btnAddNewYourWord;
    View mView;

    public AddNewYourWordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_add_new_your_word, container, false);
        addControls();
        addEvents();

        return mView;
    }

    private void addEvents() {
        btnAddNewYourWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyAddNewWord();
            }
        });
    }

    private void xuLyAddNewWord() {
        String newWord = edtNewYourWord.getText().toString();
        String translater = edtTranslater.getText().toString();
        String meanning = edtMeanning.getText().toString();

        if (TextUtils.isEmpty(newWord) || TextUtils.isEmpty(translater) || TextUtils.isEmpty(meanning)) {
            return;
        }

        NewYourWordModel newYourWordModel = new NewYourWordModel();
        newYourWordModel.setNewWord(newWord);
        newYourWordModel.setTranslater(translater);
        newYourWordModel.setMeanning(meanning);


        if (isExistNewWord(newYourWordModel)) {
            Toast.makeText(getContext(), "user Exist!!!", Toast.LENGTH_SHORT).show();
            return; //co return de neu true thi khong chay ben duoi nua
        }
        NewYourWordDatabase.getInstance(getContext()).newYourWordDAO().insertNewYourWord(newYourWordModel);
        Toast.makeText(getContext(), "Add New Word Successfully", Toast.LENGTH_LONG).show();

        edtNewYourWord.setText(" ");
        edtTranslater.setText(" ");
        edtMeanning.setText(" ");


        Intent intent = new Intent(getContext(), AddNewYourWord.class);
        getContext().startActivity(intent);


    }

    private void addControls() {
        edtNewYourWord = mView.findViewById(R.id.edt_newYourWord);
        edtTranslater = mView.findViewById(R.id.edt_translater);
        edtMeanning = mView.findViewById(R.id.edt_meanning);
        btnAddNewYourWord = mView.findViewById(R.id.btn_addNewYourWord);
    }

    private boolean isExistNewWord(NewYourWordModel newYourWordModel) {
        List<NewYourWordModel> list = NewYourWordDatabase.getInstance(getActivity()).newYourWordDAO().checkNewWord(newYourWordModel.getNewWord());
        return list != null && !list.isEmpty();
    }

}