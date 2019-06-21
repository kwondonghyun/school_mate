package com.example.com.mocon;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFragment extends Fragment {
    OnImageClickedListener mListener;
    public MainFragment newInstance(String nickname, Boolean gender) {
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("nickname", nickname);
        args.putBoolean("gender", gender);
        mainFragment.setArguments(args);
        return mainFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        String nickname = args.getString("nickname");
        final TextView appTitle = (TextView) view.findViewById(R.id.app_title);
        appTitle.setText(nickname);

        Boolean isMale = args.getBoolean("gender");
        final ImageView profile = (ImageView) view.findViewById(R.id.profile);
        if (!isMale) {
            profile.setImageResource(R.drawable.woman);
        }


        final ImageView calendarImage = (ImageView) view.findViewById(R.id.calendarImage);
        final ImageView foodImage = (ImageView) view.findViewById(R.id.foodImage);
        final ImageView groupImage = (ImageView) view.findViewById(R.id.groupImage);
        final ImageView alarmImage = (ImageView) view.findViewById(R.id.alarmImage);

        calendarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnImageClicked(2);
            }
        });

        foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnImageClicked(1);
            }
        });

        groupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnImageClicked(3);
            }
        });

        alarmImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnImageClicked(4);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnImageClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }

    public interface OnImageClickedListener {
        void OnImageClicked(int position);
    }
}
