package com.example.exercise1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.exercise1.KontakMahasiswa;
import com.example.exercise1.Pendaftaran;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button bLogin;
    EditText eEmail;
    EditText ePassword;
    TextInputLayout emailError;
    boolean isEmailValid;
    boolean isPasswordValid;
    TextInputLayout passError;
    TextView tDaftar;

    public void SetValidation() {
        if (eEmail.getText().toString().isEmpty()) {
            emailError.setError((CharSequence)"Email Tidak Boleh Kosong");
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher((CharSequence)eEmail.getText().toString()).matches()) {
            emailError.setError((CharSequence)"Harap Masukkan Email Dengan Benar");
            isEmailValid = false;
        } else {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }
        if (ePassword.getText().toString().isEmpty()) {
            passError.setError((CharSequence)"Password Tidak Boleh Kosong");
            isPasswordValid = false;
        } else if (ePassword.getText().length() < 6) {
            passError.setError((CharSequence)"Panjang Password Minimal 6 Karakter");
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
            passError.setErrorEnabled(false);
        }
        if (isEmailValid && isPasswordValid && eEmail.getText().toString().equals((Object)"anggita@mail.com") && ePassword.getText().toString().equals((Object)"121216")) {
            Toast.makeText((Context)getApplicationContext(), (CharSequence)"Login Sukses", (int)0).show();
            startActivity(new Intent(getApplicationContext(), KontakMahasiswa.class));
            return;
        }
        Toast.makeText((Context)getApplicationContext(), (CharSequence)"Email atau Password Salah", (int)0).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eEmail=findViewById(R.id.edEmail);
        ePassword=findViewById(R.id.edPassword);
        tDaftar=findViewById(R.id.tvDaftar);
        bLogin=findViewById(R.id.btLogin);
        emailError=findViewById(R.id.edEmailvalid);
        passError=findViewById(R.id.edPasswordvalid);
        bLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MainActivity.this.SetValidation();
            }
        });
        tDaftar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), Pendaftaran.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}