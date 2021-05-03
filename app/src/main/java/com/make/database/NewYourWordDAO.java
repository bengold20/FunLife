package com.make.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.make.model.NewYourWordModel;

import java.util.List;

@Dao
public interface NewYourWordDAO {

    @Insert
    void insertNewYourWord(NewYourWordModel newYourWordModel);

    @Query("SELECT * FROM newWordTb")
    List<NewYourWordModel> getListNewWord();

    @Query("SELECT * FROM newWordTb WHERE newWord = :new_word")
    List<NewYourWordModel> checkNewWord(String new_word);

    @Update
    void updateNewYourWord(NewYourWordModel newYourWordModel);

    @Delete
    void deleteNewYourWord(NewYourWordModel newYourWordModel);

    @Query("DELETE FROM newWordTb")
    void deleteAllNewYourWord();

    @Query("SELECT * FROM newWordTb WHERE newWord LIKE '%' || :word || '%'")
    List<NewYourWordModel> searchNewWord(String word);
}
