package com.geektech.a2_homework3_sharedpref.ui.header;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.geektech.a2_homework3_sharedpref.MainActivity;
import com.geektech.a2_homework3_sharedpref.R;

public class ProfileActivity extends AppCompatActivity {

    private EditText edit_name, edit_age, edit_phone, edit_email, edit_address;
    private TextView name, email, phone, age, address;
    ImageView imageView;
    private ImageView imgCurrent;
    private int current = 1;
    private int[] imgIDs = {0, R.drawable.avatar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imgCurrent = findViewById(R.id.profile_image);
        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        edit_phone = findViewById(R.id.edit_phone);
        edit_email = findViewById(R.id.edit_email);
        edit_address = findViewById(R.id.edit_address);
        final Button close = findViewById(R.id.btn_profile_close);
        Button save = findViewById(R.id.btn_profile_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = edit_name.getText().toString();
                name = findViewById(R.id.tv_prof_name);
                name.setText(n);
                String a = edit_age.getText().toString();
                age = findViewById(R.id.tv_prof_age);
                age.setText(a);
                String ph = edit_phone.getText().toString();
                phone = findViewById(R.id.tv_prof_phone);
                phone.setText(ph);
                String add = edit_address.getText().toString();
                address = findViewById(R.id.tv_prof_address);
                address.setText(add);
                edit_age.setText("");
                edit_name.setText("");
                edit_phone.setText("");
                edit_email.setText("");
                edit_address.setText("");

                close.setVisibility(View.VISIBLE);
                Button save = findViewById(R.id.btn_profile_save);
                save.setVisibility(View.GONE);

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

         Button change = findViewById(R.id.btn_profile_change);
         change.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 name = findViewById(R.id.tv_prof_name);
                 name.setText("");
                 age = findViewById(R.id.tv_prof_age);
                 age.setText("");
                 phone = findViewById(R.id.tv_prof_phone);
                 phone.setText("");
                 email = findViewById(R.id.tv_prof_email);
                 email.setText("");
                 address = findViewById(R.id.tv_prof_address);
                 address.setText("");
                 imageView = findViewById(R.id.profile_image);
                 imageView.setImageResource(R.drawable.avatar);

                 Button save = findViewById(R.id.btn_profile_save);
                 save.setVisibility(View.VISIBLE);
                 Button close = findViewById(R.id.btn_profile_close);
                 close.setVisibility(View.GONE);

             }
         });
    }
//    public void image_preview(View view) {
//        current--;
//        if (current==0) current=7;
//        imgCurrent.setImageResource(imgIDs[current]);
//    }
//
//    public void image_next(View view) {
//        current++;
//        if (current==7) current=1;
//        imgCurrent.setImageResource(imgIDs[current]);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 102 && data != null) {
            Intent intent = new Intent(this, MainActivity.class);
            String n;
            n = name.getText().toString();
            intent.putExtra("header_name", n);
            String e;
            e = email.getText().toString();
            intent.putExtra("header_email", e);
//            String image = new String();
//            intent.putExtra("header_image", image);
            startActivityForResult(intent, 102);
        }
    }
}


