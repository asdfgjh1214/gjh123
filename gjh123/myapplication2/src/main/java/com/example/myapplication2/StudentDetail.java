package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StudentDetail extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave,btnDelete;
    private Button btnClose;
    private EditText etName;
    private EditText etNo;
    private EditText etAge;
    private int _student_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        etName = (EditText) findViewById(R.id.etName);
        etNo = (EditText) findViewById(R.id.etno);
        etAge = (EditText) findViewById(R.id.etAge);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        _student_id =0;
        Intent intent = getIntent();
        _student_id =intent.getIntExtra("student_Id", 0);
        StudentRepo repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_student_id);

        etAge.setText(String.valueOf(student.age));
        etName.setText(student.name);
        etNo.setText(student.no);
    }






    @Override
    public void onClick(View v) {
        if(v==findViewById(R.id.btnSave)){
            StudentRepo repo=new StudentRepo(this);
            Student student=new Student();
            student.age=Integer.parseInt(etAge.getText().toString());
            student.no=etNo.getText().toString();
            student.name=etName.getText().toString();
            student.student_ID=_student_id;

            if(_student_id==0){
                _student_id=repo.insert(student);
                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
            }else{
                repo.update(student);
                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (v== findViewById(R.id.btnDelete)){
            StudentRepo repo = new StudentRepo(this);
            repo.delete(_student_id);
            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (v== findViewById(R.id.btnClose)){
            finish();
        }
    }
}