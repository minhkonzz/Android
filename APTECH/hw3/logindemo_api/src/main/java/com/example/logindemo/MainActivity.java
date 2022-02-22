package com.example.logindemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Student> students = new ArrayList<>(0);
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
            APIService.apis.getAllStudents().enqueue(new Callback<Student[]>() {
                @Override
                public void onResponse(Call<Student[]> call, Response<Student[]> response) {
                    Toast.makeText(MainActivity.this, "Call API and got list student success", Toast.LENGTH_SHORT).show();
                    title.setText("List Aptech student");
                    students = Arrays.asList(response.body());
                    MyListViewAdapter studentsAdapter = new MyListViewAdapter(students);
                    listStudent.setAdapter(studentsAdapter);
                }

                @Override
                public void onFailure(Call<Student[]> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Call API and got list student failed", Toast.LENGTH_SHORT).show();
                    title.setText("ERROR 404");
                }
            });
        }
    }

    private void setupViews() {
        title = findViewById(R.id.title);
        listStudent = findViewById(R.id.listStudent);
    }
}