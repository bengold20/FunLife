package com.make.sixFunction.wordPopular;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.make.main.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class WordActivity extends AppCompatActivity {
    FloatingActionButton fabAddWordPopular;

    ListView lvWordPopular;
    ArrayList<String> listWordPopular;
    ArrayAdapter<String> adapterWordPopular;

    //tên csdl
    String DB_NAME = "word.sqlite";
    //tên thư muc database, lưu trữ ứng dụng trong thư mục cài đặt gốc
    private String DB_PATH = "/databases/";
    //để truy vấn và tương tác với csdl
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        copyCSDLFromAsset();
        addControls();
        addEvents();
        showAllContacts();
    }

    private void addEvents() {

    }

    private void showAllContacts() {
        //mở CSDL nếu có thì mở nếu không có thì tạo mới null
        database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        //dùng rawquery để lấy bảng, cursor này trả về null chưa lấy dữ liệu
        Cursor cursor = database.query("wordEnglish", null, null, null, null, null, null);
        //xóa dữ liệu trong danh sách trước
        listWordPopular.clear();
        //duyệt dữ liệu
        while (cursor.moveToNext()) {
            String word = cursor.getString(0);

            listWordPopular.add(word);
//            Toast.makeText(this,word+ " ok " , Toast.LENGTH_LONG).show();
//            Log.e("showAllContacts: ",word+ " ok " );
        }
        cursor.close();
        adapterWordPopular.notifyDataSetChanged();
    }

    private void copyCSDLFromAsset() {
        File dbFile = getDatabasePath(DB_NAME);
        //nếu dbFile mà chưa tồn tại thì chép vào
        //ngược lại thì xóa đi và chép lại
        if (!dbFile.exists()) {
            //sao chép dữ liệu
            copyDatabase();
        } else {
            dbFile.delete();
            copyDatabase();
        }
    }

    private void copyDatabase() {
        //tương tác với file thì cần phải có try catch
        try {
            //lấy data và đưa vào myInput
            InputStream myInput = getAssets().open(DB_NAME);
            //lấy đường dẫn lưu trữ để đưa myInput vào
            String outFileName = getApplicationInfo().dataDir + DB_PATH + DB_NAME;
            File f = new File(getApplicationInfo().dataDir + DB_PATH);
            //nếu f chưa tồn tại thì tạo một file rỗng
            if (!f.exists()) {
                f.mkdir();
            }
            //Mở một csdl rông là InputStream
            //myInput -> myOutput là nơi mà ta tương tác với CDSL
            OutputStream myOutput = new FileOutputStream(outFileName);
            //chép dữ liệu từ myInput vào myOutput
            byte[] buffer = new byte[1024];
            int lan;
            //lần đọc từng buffer
            while ((lan = myInput.read(buffer)) > 0) {
                //ghi vào nơi lưu trữ là myOutput
                myOutput.write(buffer, 0, lan);
            }
            //làm rỗng file myOutput;
            myOutput.flush();
            //lần lượt đóng các file lại
            myInput.close();
            myOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("lỗi sao chép ", toString());
        }
    }

    private void addControls() {
        lvWordPopular = findViewById(R.id.lv_wordPopular);

        listWordPopular = new ArrayList<>();
//        Toast.makeText(this,listWordPopular+ " ok " , Toast.LENGTH_LONG).show();

        adapterWordPopular = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listWordPopular);
        lvWordPopular.setAdapter(adapterWordPopular);

    }

}