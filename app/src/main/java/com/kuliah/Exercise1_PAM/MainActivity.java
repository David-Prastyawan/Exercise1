package com.kuliah.Exercise1_PAM;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signin;
    TextView tRegis;
    EditText edNama, edPassword;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tRegis = findViewById(R.id.tRegister);
        signin = findViewById(R.id.btsign);
        edNama = findViewById(R.id.user1);
        edPassword = findViewById(R.id.pass1);

        tRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HalamanRegistrasi.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edNama.getText().toString();
                password = edPassword.getText().toString();

                Bundle b = new Bundle();
                b.putString("name", nama.trim());

                if (nama.isEmpty() || password.isEmpty()) {

                    Toast t = Toast.makeText(getApplicationContext(), "Email & Password wajib Diisi!", Toast.LENGTH_LONG);
                    edNama.setError("Email Harus Diisi");
                    edPassword.setError("Password Harus Diisi");
                    t.show();
                }
                if (nama.equals("david") && password.equals("666")) {

                    Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);
                    t.show();

                    b.putString("a", nama.trim());
                    b.putString("b", password.trim());

                    Intent i = new Intent(getApplicationContext(), HalamanTugas.class);
                    i.putExtras(b);
                    startActivity(i);

                }
                else if (!nama.equals("david") && password.equals("666")) {

                    Toast t = Toast.makeText(getApplicationContext(), "Email salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (nama.equals("david") && !password.equals("666")) {

                    Toast t = Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else {

                    Toast t = Toast.makeText(getApplicationContext(), "Email dan Password Salah", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}