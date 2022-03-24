package com.kuliah.Exercise1_PAM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HalamanTugas extends AppCompatActivity {
    TextView eNama;
    EditText edTask, edJenis, edTime;
    FloatingActionButton submit;
    String nama, task, jenis, waktu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSubmit){
            Bundle b = new Bundle();
            b.putString("task", edTask.getText().toString().trim());
            b.putString("jenis", edJenis.getText().toString().trim());
            b.putString("time", edTime.getText().toString().trim());

            Intent i = new Intent(getApplicationContext(), HalamanHasil.class);
            i.putExtras(b);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.mnLogout){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);

        eNama = findViewById(R.id.setNama);
        edTask = findViewById(R.id.inTask);
        edJenis = findViewById(R.id.inJenis);
        edTime = findViewById(R.id.inTime);
        submit = findViewById(R.id.fabSubmit);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("name");
        eNama.setText(nama);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edTask.getText().toString();
                jenis = edJenis.getText().toString();
                waktu = edTime.getText().toString();

                if (TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    Toast t = Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    edTask.setError("Masukan Tugas");
                }
                else if (!TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    edJenis.setError("Masukan Jenis Tugas");
                }
                else if (!TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    edTime.setError("Masukan Deadline Tugas");
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(), "Tugas Berhasil Ditambahkan", Toast.LENGTH_SHORT);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("task", task.trim());
                    b.putString("jenis", jenis.trim());
                    b.putString("time", waktu.trim());

                    Intent i = new Intent(getApplicationContext(), HalamanHasil.class );
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }
}