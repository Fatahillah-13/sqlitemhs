package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Input_Mhs extends AppCompatActivity {

    Button tblsave, tblview;
    EditText xnim, xnama;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_mhs);

        xnim=findViewById(R.id.nimmhs);
        xnama=findViewById(R.id.namamhs);

        dbh=new DatabaseHelper(this);

        tblsave=findViewById(R.id.tombol_simpan);
        tblview=findViewById(R.id.tombol_view);

        tblsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xnim.getText().length()<14 || xnim.getText().length()>14){
                    xnim.setError("Wajib 14 karakter");
                    Toast.makeText(getApplicationContext(), "Maaf NIM harus 14 karakter", Toast.LENGTH_SHORT).show();
                    xnim.requestFocus();
                } else {
                    dbh.tambah_data(xnim.getText().toString(),xnama.getText().toString());
                }
            }
        });
        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Input_Mhs.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}