package com.example.lab_tonghop_ph50030;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUser_Login,edtPassword_Login;
    private CheckBox cbLogin;
    private Button btnDangNhap;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
        edtUser_Login.setText(sharedPreferences.getString("user",""));
        edtPassword_Login.setText(sharedPreferences.getString("password",""));
        cbLogin.setChecked(sharedPreferences.getBoolean("checked",false));
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser_Login.getText().toString().trim();
                String password = edtPassword_Login.getText().toString().trim();
                if (user.equals("ph50030") && password.equals("ph50030")) {
                    if (cbLogin.isChecked()){
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("user",user);
                        editor.putString("password",password);
                        editor.putBoolean("checked",false);
                        editor.commit();
                    }
                    else {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.remove("user");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void init(){
        edtUser_Login=findViewById(R.id.edtUser_Login);
        edtPassword_Login=findViewById(R.id.edtPassword_Login);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        cbLogin=findViewById(R.id.cbLogin);

    }


}
