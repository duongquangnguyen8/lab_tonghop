package com.example.lab_tonghop_ph50030;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_tonghop_ph50030.adapter.SinhVienAdapter;
import com.example.lab_tonghop_ph50030.models.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SinhVienAdapter sinhVienAdapter;
    private ListView listSv;
    private ArrayList<SinhVien> dsSinhVien;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar=findViewById(R.id.toolbar);
        listSv=findViewById(R.id.listSinhVien);
        btnUpdate=findViewById(R.id.btnUpdate);
        setSupportActionBar(toolbar);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("Danh sách sinh viên");
        bar.setDisplayShowTitleEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);

        dsSinhVien=new ArrayList<>();
        dsSinhVien.add(new SinhVien("PH50030","Nguyễn Quang Dương","MD19301"));
        dsSinhVien.add(new SinhVien("PH49915","Nguyễn Trung Duy","MD19301"));
        sinhVienAdapter=new SinhVienAdapter(MainActivity.this,dsSinhVien);
        listSv.setAdapter(sinhVienAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_sinhvien,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.gioiThieu){
            Intent intent=new Intent(MainActivity.this, GioiThieuActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}