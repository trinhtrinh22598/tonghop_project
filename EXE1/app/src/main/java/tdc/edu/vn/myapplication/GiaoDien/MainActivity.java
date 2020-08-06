package tdc.edu.vn.myapplication.GiaoDien;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Adapter.CustomApdapter;
import tdc.edu.vn.myapplication.DataBase.DBThietBi;
import tdc.edu.vn.myapplication.Model.ThietBi;
import tdc.edu.vn.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnXoa, btnSua, btnThoat;
    EditText txtMaLoai, txtTenLoai;
    ListView lvDanhSach;

    int index = -1;

    CustomApdapter apdapter;

    ArrayList<ThietBi> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();


    }

    private void setEvent() {
        HienThiDL();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
                HienThiDL();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuaDL();
                HienThiDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
                HienThiDL();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ThietBi thietBi = data.get(position);
                txtMaLoai.setText(thietBi.getMaLoai());
                txtTenLoai.setText(thietBi.getTenLoai());
                index = position;

            }
        });

    }




    private void HienThiDL() {
        DBThietBi dbSinhVien = new DBThietBi(this);
        data = dbSinhVien.LayDL();
        apdapter = new CustomApdapter(MainActivity.this, R.layout.listview_item, data);
        lvDanhSach.setAdapter(apdapter);
    }

    private void ThemDL() {
        ThietBi thietBi = new ThietBi();
        thietBi.setMaLoai(txtMaLoai.getText().toString());
        thietBi.setTenLoai(txtTenLoai.getText().toString());

        DBThietBi dbSinhVien = new DBThietBi(this);
        dbSinhVien.Them(thietBi);
    }
    private void SuaDL() {
        ThietBi thietBi = new ThietBi();
        thietBi.setMaLoai(txtMaLoai.getText().toString());
        thietBi.setTenLoai(txtTenLoai.getText().toString());

        DBThietBi dbSinhVien = new DBThietBi(this);
        dbSinhVien.Sua(thietBi);
    }
    private void XoaDL() {
        ThietBi thietBi = new ThietBi();
        thietBi.setMaLoai(txtMaLoai.getText().toString());
        thietBi.setTenLoai(txtTenLoai.getText().toString());

        DBThietBi dbSinhVien = new DBThietBi(this);
        dbSinhVien.Xoa(thietBi);
    }


    private void setControl() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        txtMaLoai = findViewById(R.id.txtMa);
        txtTenLoai = findViewById(R.id.txtTen);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }


}
