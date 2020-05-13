package com.geektech.a2_homework4_database.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.geektech.a2_homework4_database.App;
import com.geektech.a2_homework4_database.R;
import com.geektech.a2_homework4_database.models.Task;
import java.util.ArrayList;
import java.util.List;

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
        list.addAll(App.getInstance().getDatabase().taskDao().getAll());
        adapter = new TaskAdapter(list);
        recyclerView.setAdapter(adapter);
        loadData();
    }

    private  void loadData(){
        App.getInstance()
                .getDatabase()
                .taskDao()
                .getAllLive()
                .observe(this, new Observer<List<Task>>(){
            @Override
            public void onChanged(List<Task> tasks) {
                list.clear();
                list.addAll(tasks);
                adapter.notifyDataSetChanged();

            }
        });
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == MainActivity.RESULT_OK && requestCode == 100) {
//            String title = data.getStringExtra("title");
//            String desc = data.getStringExtra("description");
//            list.add(0, new Task(title, desc));
//            adapter.notifyDataSetChanged();
//        }
//    }
}


