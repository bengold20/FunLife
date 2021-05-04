package com.make.Function.listYourWord;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.make.main.R;
import com.make.database.NewYourWordDatabase;
import com.make.model.NewYourWordModel;

public class UpdateNewYourWordFragment extends Fragment {

    private EditText edtNewYourWord, edtTranslater, edtMeanning;
    private Button btnUpdateNewYourWord;
    NewYourWordModel mListNewYourWord;
    View mView;

    public UpdateNewYourWordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_update_new_your_word, container, false);
        addControls();
        addEvents();

        return mView;
    }

    private void addEvents() {
       btnUpdateNewYourWord.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               xuLyUpdateNewYourWord();
           }
       });
    }

    private void xuLyUpdateNewYourWord() {
        String newWord = edtNewYourWord.getText().toString().trim();
        String trans = edtTranslater.getText().toString().trim();
        String mean = edtMeanning.getText().toString().trim();

        mListNewYourWord.setNewWord(newWord);
        mListNewYourWord.setTranslater(trans);
        mListNewYourWord.setMeanning(mean);

        NewYourWordDatabase.getInstance(getContext()).newYourWordDAO().updateNewYourWord(mListNewYourWord);
        Toast.makeText(getActivity(),"update successfully!!!",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext(), AddNewYourWord.class);
        getContext().startActivity(intent);
    }

    private void addControls() {
        edtNewYourWord = mView.findViewById(R.id.edt_newYourWord);
        edtTranslater = mView.findViewById(R.id.edt_translater);
        edtMeanning = mView.findViewById(R.id.edt_meanning);
        btnUpdateNewYourWord = mView.findViewById(R.id.btn_UpdateNewYourWord);

        mListNewYourWord = (NewYourWordModel) getArguments().getSerializable("object_newYourWord");

        if(mListNewYourWord != null){
            edtNewYourWord.setText(mListNewYourWord.getNewWord());
            edtTranslater.setText(mListNewYourWord.getTranslater());
            edtMeanning.setText(mListNewYourWord.getMeanning());
        }
    }

}