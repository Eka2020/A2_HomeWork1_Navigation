package com.geektech.a2_homework2_viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.geektech.a2_homework2_viewpager.models.Task;

public class FormActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Новая задача");
        }
        editTitle = findViewById(R.id.edit_title);
        editDesc = findViewById(R.id.edit_desc);
    }

    public void onClick(View view) {
        String title = editTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();
        Task task = new Task(title, desc);
        Intent intent = new Intent();
        intent.putExtra("task", task);
        setResult(RESULT_OK, intent);
        finish();


//        Intent intent = new Intent();
//        someClass.text = editName.getText().toString();
//        Log.d("ololo", someClass.text);
//        intent.putExtra(MainActivity.RESULT_KEY, someClass);
//        setResult(RESULT_OK, intent);
//        finish();


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
       if (id == R.id.action_HomeSecondFragment_to_HomeFragment) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
