package com.tharun.nestedRecyclerviewApp.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.tharun.nestedRecyclerviewApp.R;

import java.util.Objects;


public class AwardsFragment extends Fragment {

    TextView points, level, empty;
    ProgressBar levelProgress;
    ImageView imgBronze, imgSilver, imgGold, imgEmpty;
    TextView txtBronze, txtSilver, txtGold;
    String userId;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_awards, container, false);

        points = view.findViewById(R.id.txt_points);
        level = view.findViewById(R.id.txt_level);
        empty = view.findViewById(R.id.txt_empty);
        levelProgress = view.findViewById(R.id.level_progressBar);
        imgBronze = view.findViewById(R.id.img_bronze);
        imgSilver = view.findViewById(R.id.img_silver);
        imgGold = view.findViewById(R.id.img_gold);
        txtBronze = view.findViewById(R.id.txt_bronze);
        txtSilver = view.findViewById(R.id.txt_silver);
        txtGold = view.findViewById(R.id.txt_gold);
        imgEmpty = view.findViewById(R.id.img_empty);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId).collection("userpoints").document(userId);

        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable @org.jetbrains.annotations.Nullable DocumentSnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                String point, levelStr;
                int levelNo,progress;
                assert value != null;
                point = "Points  :  "+value.getString("points")+" pts";
                points.setText(point);
                levelNo =  Integer.parseInt(Objects.requireNonNull(value.getString("points")));
                if(levelNo % 15 == 0){
                    levelStr = "Level  "+levelNo/15;
                }else{
                    levelStr = "Level  "+(levelNo/15 + 1);
                }
                level.setText(levelStr);


                progress = (levelNo/5 -1)%3;
                levelProgress.setProgress(progress+1);

                if(levelNo < 20){
                    empty.setVisibility(View.VISIBLE);
                    imgEmpty.setVisibility(View.VISIBLE);
                }else if(levelNo < 35){
                    empty.setVisibility(View.GONE);
                    imgEmpty.setVisibility(View.GONE);
                    imgBronze.setVisibility(View.VISIBLE);
                    txtBronze.setVisibility(View.VISIBLE);
                }else if(levelNo < 50){
                    imgEmpty.setVisibility(View.GONE);
                    empty.setVisibility(View.GONE);
                    imgBronze.setVisibility(View.VISIBLE);
                    txtBronze.setVisibility(View.VISIBLE);
                    imgSilver.setVisibility(View.VISIBLE);
                    txtSilver.setVisibility(View.VISIBLE);
                }else{
                    empty.setVisibility(View.GONE);
                    imgEmpty.setVisibility(View.GONE);
                    imgBronze.setVisibility(View.VISIBLE);
                    txtBronze.setVisibility(View.VISIBLE);
                    imgSilver.setVisibility(View.VISIBLE);
                    txtSilver.setVisibility(View.VISIBLE);
                    imgGold.setVisibility(View.VISIBLE);
                    txtGold.setVisibility(View.VISIBLE);
                }

            }
        });



        return view;
    }
}