package com.example.exercise1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.exercise1.MainActivity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pendaftaran extends AppCompatActivity {
    String agama = "";
    Button bbatal;
    Button bdaftar;
    private int cekAgama;
    private int cekKelamin;
    EditText ependalamat;
    EditText ependemail;
    EditText ependnama;
    EditText ependpassword;
    EditText ependrepassword;
    private boolean isChecking = true;
    boolean isEmailValid = false;
    boolean isPasswordValid = false;
    boolean isRePasswordValid = false;
    boolean isalamatvalid = false;
    boolean isnamavalid = false;
    String jk = "";
    TextInputLayout pendalamaterror;
    TextInputLayout pendemailerror;
    TextInputLayout pendnamaerror;
    TextInputLayout pendpassworderror;
    TextInputLayout pendrepassworderror;
    RadioButton rbpendbudha;
    RadioButton rbpendhindu;
    RadioButton rbpendislam;
    RadioButton rbpendkatolik;
    RadioButton rbpendkepercayaan;
    RadioButton rbpendkonghucu;
    RadioButton rbpendkristen;
    RadioButton rbpendlaki;
    RadioButton rbpendperempuan;
    RadioGroup rgagama1;
    RadioGroup rgagama2;
    RadioGroup rgagama3;
    RadioGroup rgjeniskelamin;

    public void JenisAgama(View view) {
        int n = this.cekAgama;
        if (n == R.id.rbIslam) {
            this.agama = "Islam";
            return;
        }
        if (n == R.id.rbKatolik) {
            this.agama = "Katolik";
            return;
        }
        if (n == R.id.rbKristen) {
            this.agama = "Kristen";
            return;
        }
        if (n == R.id.rbKonghucu) {
            this.agama = "Konghucu";
            return;
        }
        if (n == R.id.rbHindu) {
            this.agama = "Hindu";
            return;
        }
        if (n == R.id.rbBudha) {
            this.agama = "Budha";
            return;
        }
        if (n == R.id.rbPK) {
            this.agama = "Aliran Kepercayaan";
        }
    }

    public void JenisKelamin(View view) {
        int n = this.cekKelamin;
        if (n == R.id.rbLaki) {
            this.jk = "Laki-Laki";
            return;
        }
        if (n == R.id.rbPerempuan) {
            this.jk = "Perempuan";
        }
    }

    public void MenghubungkanKomponen() {
        ependnama =findViewById(R.id.etNama);
        ependalamat =findViewById(R.id.etAlamat);
        ependemail =findViewById(R.id.edEmaildaftar);
        ependpassword =findViewById(R.id.edPassworddaftar);
        ependrepassword =findViewById(R.id.edPassworddaftarkembali);
        rgjeniskelamin =findViewById(R.id.JKvalid);
        rgagama1 =findViewById(R.id.Agamavalid);
        rgagama2 =findViewById(R.id.Agamavalid2);
        rgagama3 =findViewById(R.id.Agamavalid3);
        rbpendlaki =findViewById(R.id.rbLaki);
        rbpendperempuan =findViewById(R.id.rbPerempuan);
        rbpendislam =findViewById(R.id.rbIslam);
        rbpendkatolik =findViewById(R.id.rbKatolik);
        rbpendkristen =findViewById(R.id.rbKristen);
        rbpendkonghucu =findViewById(R.id.rbKonghucu);
        rbpendhindu =findViewById(R.id.rbHindu);
        rbpendbudha =findViewById(R.id.rbBudha);
        rbpendkepercayaan =findViewById(R.id.rbPK);
        pendnamaerror =findViewById(R.id.namavalid);
        pendalamaterror =findViewById(R.id.alamatvalid);
        pendemailerror =findViewById(R.id.emaildafarvalid);
        pendpassworderror =findViewById(R.id.passworddaftarvalid);
        pendrepassworderror =findViewById(R.id.Passworddaftarkembalivalid);
        bbatal =findViewById(R.id.btbatal);
        bdaftar =findViewById(R.id.btdaftar);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pendaftaran);
        this.MenghubungkanKomponen();
        this.rgagama1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup, int n) {
                if (n != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgagama2.clearCheck();
                    Pendaftaran.this.rgagama3.clearCheck();
                    Pendaftaran.this.cekAgama = n;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rgagama2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup, int n) {
                if (n != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgagama1.clearCheck();
                    Pendaftaran.this.rgagama3.clearCheck();
                    Pendaftaran.this.cekAgama = n;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rgagama3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup, int n) {
                if (n != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgagama1.clearCheck();
                    Pendaftaran.this.rgagama2.clearCheck();
                    Pendaftaran.this.cekAgama = n;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rgjeniskelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup, int n) {
                if (n != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.cekKelamin = n;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.bdaftar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Pendaftaran.this.JenisAgama(view);
                Pendaftaran.this.JenisKelamin(view);
                Pendaftaran.this.validasi(view);
            }
        });
        this.bbatal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(Pendaftaran.this.getApplicationContext(), MainActivity.class);
                Pendaftaran.this.startActivity(intent);
            }
        });
    }

    public void validasi(View view) {
        if (this.ependnama.getText().toString().isEmpty() || this.ependalamat.getText().toString().isEmpty() || this.ependemail.getText().toString().isEmpty() || this.ependpassword.getText().toString().isEmpty() || this.ependrepassword.getText().toString().isEmpty() || this.agama.isEmpty() || this.jk.isEmpty()) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Data Harus Diisi Semua", (int)0).show();
        }
        if (this.ependnama.getText().toString().isEmpty()) {
            this.pendnamaerror.setError((CharSequence)"Nama Tidak Boleh Kosong");
            this.isnamavalid = false;
        } else {
            this.pendnamaerror.setErrorEnabled(false);
            this.isnamavalid = true;
        }
        if (this.ependalamat.getText().toString().isEmpty()) {
            this.pendalamaterror.setError((CharSequence)"Alamat Tidak Boleh Kosong");
            this.isalamatvalid = false;
        } else {
            this.pendalamaterror.setErrorEnabled(false);
            this.isalamatvalid = true;
        }
        if (this.ependemail.getText().toString().isEmpty()) {
            this.pendemailerror.setError((CharSequence)"Email Tidak Boleh Kosong");
            this.isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher((CharSequence)this.ependemail.getText().toString()).matches()) {
            this.pendemailerror.setError((CharSequence)"Harap Masukkan Email Dengan Benar");
            this.isEmailValid = false;
        } else {
            this.isEmailValid = true;
            this.pendemailerror.setErrorEnabled(false);
        }
        if (this.ependpassword.getText().toString().isEmpty()) {
            this.pendpassworderror.setError((CharSequence)"Password Tidak Boleh Kosong");
            this.isPasswordValid = false;
        } else if (this.ependpassword.getText().length() < 6) {
            this.pendpassworderror.setError((CharSequence)"Panjang Password Minimal 6 Karakter");
            this.isPasswordValid = false;
        } else {
            this.isPasswordValid = true;
            this.pendpassworderror.setErrorEnabled(false);
        }
        if (this.ependrepassword.getText().toString().isEmpty()) {
            this.pendrepassworderror.setError((CharSequence)"Re-Password Tidak Boleh Kosong");
            this.isRePasswordValid = false;
        } else if (this.ependrepassword.getText().length() < 6) {
            this.pendrepassworderror.setError((CharSequence)"Panjang Re-Password Minimal 6 Karakter");
            this.isRePasswordValid = false;
        } else if (!this.ependrepassword.getText().toString().equals((Object)this.ependpassword.getText().toString())) {
            this.pendrepassworderror.setError((CharSequence)"Password Tidak Sama");
            this.isRePasswordValid = false;
        } else {
            this.isRePasswordValid = true;
            this.pendrepassworderror.setErrorEnabled(false);
        }
        if (this.isnamavalid && this.isalamatvalid && this.isEmailValid && this.isPasswordValid && this.isRePasswordValid && !this.agama.isEmpty() && !this.jk.isEmpty()) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Pendaftaran Berhasil", (int)1).show();
            this.startActivity(new Intent(this.getApplicationContext(), MainActivity.class));
        }
    }
}