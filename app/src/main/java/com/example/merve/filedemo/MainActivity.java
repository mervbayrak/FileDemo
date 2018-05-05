package com.example.merve.filedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    String fileName="mynote.txt";
    EditText etNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNote= (EditText) findViewById(R.id.etNote);
        readNote();

    }
    public void readNote(){//okuma
        try {
            FileInputStream fileInputStream=openFileInput(fileName);
            byte[] buffer=new byte[(int) fileInputStream.getChannel().size()];
            fileInputStream.read(buffer);
            String note=new String(buffer);
            etNote.setText(note);
            fileInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveNote(View view) {//yazma
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutputStream.write(etNote.getText().toString().getBytes());
            fileOutputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
