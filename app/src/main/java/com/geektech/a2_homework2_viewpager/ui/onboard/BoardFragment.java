package com.geektech.a2_homework2_viewpager.ui.onboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geektech.a2_homework2_viewpager.R;

public class BoardFragment extends Fragment {


    public BoardFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int pos = getArguments().getInt("pos");
        TextView textTitle =view.findViewById(R.id.text_title);
        ImageView imageView = view.findViewById(R.id.imageView);

              switch (pos){
            case 0:
                textTitle.setText("Весна");
                imageView.setImageResource(R.drawable.spring);
                break;
            case 1:
                textTitle.setText("Лето");
                imageView.setImageResource(R.drawable.summer);
                break;
            case 2:
                textTitle.setText("Осень");
                imageView.setImageResource(R.drawable.autumn);
                break;
            case 3:
                textTitle.setText("Зима");
                imageView.setImageResource(R.drawable.winter);
                break;
            case 4:
                textTitle.setText("");
                break;
        }
    }
}
