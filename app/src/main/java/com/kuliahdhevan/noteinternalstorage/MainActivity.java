package com.kuliahdhevan.noteinternalstorage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtContent;
    Button btnSave, btnRead;
    private final String CONTENT = "content";

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.kuliahdhevan.noteinternalstorage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtContent = findViewById(R.id.edtContent);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
    }

    public void save(View view) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(CONTENT, edtContent.getText().toString());
        preferencesEditor.apply();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Konfirmasi");
        alert.setMessage("Data Tersimpan");
        alert.setIcon(R.drawable.ic_launcher_foreground);
        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Sukses Simpan", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
        edtContent.setText("");
    }

    public void read(View view) {
        String mContent = mPreferences.getString(CONTENT, "");
        edtContent.setText(mContent);
    }
}