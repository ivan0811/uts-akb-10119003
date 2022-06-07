package com.ivan.uts_10119003.view.Catatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ivan.uts_10119003.MainActivity;
import com.ivan.uts_10119003.R;
import com.ivan.uts_10119003.model.CatatanModel;
import com.ivan.uts_10119003.service.DBService;

public class AddCatatanActivity extends AppCompatActivity {
    EditText judul_input, kategori_input, konten_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_catatan);

        judul_input = findViewById(R.id.judul_input);
        kategori_input = findViewById(R.id.kategori_input);
        konten_input = findViewById(R.id.konten_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatatanModel catatanModel = new CatatanModel("",
                        judul_input.getText().toString(),
                        kategori_input.getText().toString(),
                        konten_input.getText().toString(),
                        "tanggal hari ini");
                DBService db = new DBService(AddCatatanActivity.this);
                db.addCatatan(catatanModel);
                Intent intent = new Intent(AddCatatanActivity.this, MainActivity.class);
//            buat clear activity sebelumnya
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}