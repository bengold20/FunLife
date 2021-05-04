package com.make.Function.tableDTBQT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.make.adapter.TableDTBQTAdapter;
import com.make.main.R;
import com.make.model.TableDTBQTModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TableDTBQTActivity extends AppCompatActivity {

    RecyclerView rcvTableDTBQT;
    List<TableDTBQTModel> listTableDTBQTModel;
    TableDTBQTAdapter adapterTableDTBQT;

    //tên csdl
    String DB_NAME = "bangDTBQT.sqlite";
    //tên thư muc database, lưu trữ ứng dụng trong thư mục cài đặt gốc
    private String DB_PATH = "/databases/";
    //để truy vấn và tương tác với csdl
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_d_t_b_q_t);

        copyCSDLFromAsset();

        addControls();
        showAllContacts();
    }

    private void showAllContacts() {
        //mở CSDL nếu có thì mở nếu không có thì tạo mới null
        database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        //dùng rawquery để lấy bảng, cursor này trả về null chưa lấy dữ liệu
        Cursor cursor = database.query("tableDTBQT", null, null, null, null, null, null);
        //xóa dữ liệu trong danh sách trước
        listTableDTBQTModel.clear();
        //duyệt dữ liệu
        while (cursor.moveToNext()) {

            String dongTuNguyenMau = cursor.getString(0);
            String theQuaKhu = cursor.getString(1);
            String quaKhuPhanTu = cursor.getString(2);
            String nghiaDongTu = cursor.getString(3);

            TableDTBQTModel tableDTBQTModel = new TableDTBQTModel();
            tableDTBQTModel.setDongTuNguyenMau(dongTuNguyenMau);
            tableDTBQTModel.setTheQuaKhu(theQuaKhu);
            tableDTBQTModel.setQuaKhuPhanTu(quaKhuPhanTu);
            tableDTBQTModel.setNghiaDongTu(nghiaDongTu);


            listTableDTBQTModel.add(tableDTBQTModel);
        }
        cursor.close();

        adapterTableDTBQT.setData(listTableDTBQTModel);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvTableDTBQT.setLayoutManager(linearLayoutManager);
        rcvTableDTBQT.setAdapter(adapterTableDTBQT);

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
        rcvTableDTBQT = findViewById(R.id.rcv_tableDTBQT);
        listTableDTBQTModel = new ArrayList<>();
        adapterTableDTBQT = new TableDTBQTAdapter();

    }
}