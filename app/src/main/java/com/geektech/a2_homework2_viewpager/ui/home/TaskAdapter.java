package com.geektech.a2_homework2_viewpager.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.a2_homework2_viewpager.R;
import com.geektech.a2_homework2_viewpager.models.Task;
import com.geektech.a2_homework2_viewpager.ui.OnItemClickListener;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> list;
    private OnItemClickListener onItemClickListener;


    public TaskAdapter(ArrayList<Task> list) {
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  void setOnItemClickListener (OnItemClickListener onItemClickListener){
        this.onItemClickListener= onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title=itemView.findViewById(R.id.text_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        public void bind(Task task) {
            text_title.setText(task.getTitle());
        }
    }
}