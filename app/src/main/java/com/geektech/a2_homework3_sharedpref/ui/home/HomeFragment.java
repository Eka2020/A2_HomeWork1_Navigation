package com.geektech.a2_homework3_sharedpref.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.geektech.a2_homework3_sharedpref.MainActivity;
import com.geektech.a2_homework3_sharedpref.R;
import com.geektech.a2_homework3_sharedpref.models.Task;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private TaskAdapter adapter;
    private ArrayList<Task> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TaskAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == MainActivity.RESULT_OK && requestCode == 100) {
            String title = data.getStringExtra("title");
            String desc = data.getStringExtra("description");
            list.add(0, new Task(title, desc));
            adapter.notifyDataSetChanged();
        }
    }
}


