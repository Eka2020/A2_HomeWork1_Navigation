package com.geektech.a2_homework3_sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import com.geektech.a2_homework3_sharedpref.ui.header.ProfileActivity;
import com.geektech.a2_homework3_sharedpref.ui.onboard.OnBoardActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isShow()) {
            startActivity(new Intent(this, OnBoardActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,
                        FormActivity.class), 100);
            }
        });

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        ImageView imageView = header.findViewById(R.id.imageView1);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isShow();
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                finish();
                return;
            }
        });
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private boolean isShow() {
        SharedPreferences preferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        return preferences.getBoolean("isShow", false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100 && data != null) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            fragment.getChildFragmentManager().getFragments().get(0).
                    onActivityResult(requestCode, resultCode, data);
      }
        else if (resultCode == RESULT_OK && requestCode == 102 && data != null) {
            TextView name = findViewById(R.id.header_name);
            TextView email = findViewById(R.id.header_email);
            ImageView image = findViewById(R.id.imageView1);
            data.getStringExtra("header_name");
            name.setText("n");
            data.getStringExtra("header_email");
            email.setText("e");
//            data.getStringExtra("header_image");
//            image.setImageMatrix("image");
            onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_close) {
            SharedPreferences preferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
            preferences.edit().putBoolean("isShow", false).apply();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
