package com.geektech.a2_homework4_database.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.a2_homework4_database.R;
import com.geektech.a2_homework4_database.models.Task;
import com.geektech.a2_homework4_database.ui.OnItemClickListener;
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

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_title, text_desc;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            text_desc = itemView.findViewById(R.id.text_desc);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }

            public void bind (Task task){
                text_title.setText(task.getTitle());
                text_desc.setText(task.getDesc());
            }
        }

//
//    private void showDialog(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder();
//        builder.setTitle("Android Database")
//                .setMessage("Вы хотите удалить?")
//                .setCancelable(false)
//                .setNegativeButton("ДА", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                        Toast.makeText(MainActivity.class , "Вы удалили строку", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setPositiveButton("НЕТ", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
}
