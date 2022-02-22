package com.example.logindemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {

    private final ArrayList<Student> students;

    public MyListViewAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return students.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Student currentStudent = students.get(i);
        View studentView = view == null ? View.inflate(viewGroup.getContext(), R.layout.student_view, null) : view;
        ((TextView) studentView.findViewById(R.id.studentName)).setText(String.format("%s", currentStudent.getName()));
        return studentView;
    }
}
