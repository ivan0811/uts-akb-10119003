package com.ivan.uts_10119003.view.Catatan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ivan.uts_10119003.MainActivity;
import com.ivan.uts_10119003.R;
import com.ivan.uts_10119003.model.CatatanModel;
import com.ivan.uts_10119003.service.DBService;

//nim : 10119003
//nama : ivan faathirza
//kelas : IF1
public class UpdateCatatanActivity extends AppCompatActivity {
    EditText judul_update, kategori_update, konten_update;
    Button update_button, delete_button;

    String id, judul, kategori, konten, created_at;
    CatatanModel catatanModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_catatan);
        judul_update = findViewById(R.id.judul_update);
        kategori_update = findViewById(R.id.kategori_update);
        konten_update = findViewById(R.id.konten_update);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        getAndSetIntentData();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(judul);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catatanModel = new CatatanModel(id, judul_update.getText().toString(), kategori_update.getText().toString(), konten_update.getText().toString(), created_at);
                DBService db = new DBService(UpdateCatatanActivity.this);
                db.updateData(catatanModel);

                Intent intent = new Intent(UpdateCatatanActivity.this, MainActivity.class);
//            buat clear activity sebelumnya
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("judul") &&
                getIntent().hasExtra("kategori") &&
                getIntent().hasExtra("konten") &&
                getIntent().hasExtra("created_at")){

                id = getIntent().getStringExtra("id");
                judul = getIntent().getStringExtra("judul");
                kategori = getIntent().getStringExtra("kategori");
                konten = getIntent().getStringExtra("konten");
                created_at = getIntent().getStringExtra("created_at");

                judul_update.setText(judul);
                kategori_update.setText(kategori);
                konten_update.setText(konten);
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + judul + " ?");
        builder.setMessage("Are you sure you want to delete " + judul + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBService db = new DBService(UpdateCatatanActivity.this);
                db.deleteOneRow(id);

                Intent intent = new Intent(UpdateCatatanActivity.this, MainActivity.class);
//            buat clear activity sebelumnya
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}