package com.example.dienthoai;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
PhoneView phoneView;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bạn muốn lưu hình ảnh?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        phoneView.setDrawingCacheEnabled(true);
                        String imageSave = MediaStore.Images.Media.insertImage(getContentResolver(), phoneView.getDrawingCache(), UUID.randomUUID().toString() + ".png", "drawing");
                        if(imageSave !=null)
                            Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(), "Lưu thất bại",  Toast.LENGTH_LONG).show();
                        phoneView.destroyDrawingCache();
                    }
                });
                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int i) {
                         dialog.cancel();
                     }
                 }) ;
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void setControl() {
        btnSave = findViewById(R.id.btnSave);
        phoneView = findViewById(R.id.phone);

    }
}