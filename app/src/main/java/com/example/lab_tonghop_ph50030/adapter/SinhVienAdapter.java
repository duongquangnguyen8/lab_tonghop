package com.example.lab_tonghop_ph50030.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab_tonghop_ph50030.MainActivity;
import com.example.lab_tonghop_ph50030.R;
import com.example.lab_tonghop_ph50030.UpdateActivity;
import com.example.lab_tonghop_ph50030.models.SinhVien;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SinhVien> dsSinhVien;

    public SinhVienAdapter(Context context, ArrayList<SinhVien> dsSinhVien) {
        this.context = context;
        this.dsSinhVien = dsSinhVien;
    }

    @Override
    public int getCount() {
        return dsSinhVien.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = null;
        if(view!=null){
            row=view;
        }
        else {
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(R.layout.activity_list1dong,null);
        }
        SinhVien sv=dsSinhVien.get(i);

        TextView tvMsv=row.findViewById(R.id.tvMSV);
        TextView tvTen=row.findViewById(R.id.tvTen);
        TextView tvLop=row.findViewById(R.id.tvLop);

        tvTen.setText("Họ tên: "+sv.getTen());
        tvMsv.setText("MSV: "+sv.getMsv());
        tvLop.setText("Lớp: "+sv.getLop());
        Button btnDelete=row.findViewById(R.id.btnDelete);
        Button btnUpdate=row.findViewById(R.id.btnUpdate);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(i);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                LayoutInflater inflater=((Activity)context).getLayoutInflater();
                View view1=inflater.inflate(R.layout.activity_update,null);
                builder.setView(view1);
                EditText edtUpdateMsv=view1.findViewById(R.id.edtUpdateMSV);
                EditText edtUpdateTen=view1.findViewById(R.id.edtUpdateTen);
                EditText edtUpdatenLop=view1.findViewById(R.id.edtUpdateLop);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String msv=edtUpdateMsv.getText().toString();
                        String ten=edtUpdateTen.getText().toString();
                        String lop=edtUpdatenLop.getText().toString();

                        sv.setMsv(msv);
                        sv.setLop(lop);
                        sv.setTen(ten);
                        notifyDataSetChanged();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
        return row;
    }
    public void delete(int vitri){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có chắc chắn muốn xoá không?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dsSinhVien.remove(vitri);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

}
