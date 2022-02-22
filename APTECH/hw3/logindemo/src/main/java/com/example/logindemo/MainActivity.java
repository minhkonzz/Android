package com.example.logindemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Student> students = new ArrayList<>(0);
    private ListView listStudent;
    private TextView title;

    private final static String USERNAME_EXTRA = "username";
    private final static String PASSWORD_EXTRA = "password";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        Intent intent = getIntent();
        String username = String.format("%s", intent.getStringExtra(USERNAME_EXTRA));
        String password = String.format("%s", intent.getStringExtra(PASSWORD_EXTRA));
        boolean res = username.equals("aptech") && password.equals("12345");
        if(res) {
            students.add(new Student(1048, "Minh Tri", "Ha Noi"));
            students.add(new Student(1049, "Duc Thanh", "Ha Noi"));
            students.add(new Student(1050, "Minh Pham", "Ha Noi"));
        }
        title.setText(res ? "List Aptech student" : "ERROR 404");
        Toast.makeText(MainActivity.this, res ? "Login success" : "Wrong username or password", Toast.LENGTH_SHORT).show();
    }

    private void setupViews() {
        title = findViewById(R.id.title);
        listStudent = findViewById(R.id.listStudent);
        MyListViewAdapter studentsAdapter = new MyListViewAdapter(students);
        listStudent.setAdapter(studentsAdapter);
    }
}