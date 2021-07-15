package com.tharun.saathealthtestapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.tharun.saathealthtestapp.R;
import com.tharun.saathealthtestapp.VideoPlayerActivity;
import com.tharun.saathealthtestapp.model.BannerVideos;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BannerVideosPagerAdapter extends PagerAdapter {

    Context context;
    List<BannerVideos> bannerVideosList;
    static int points;
    private String userId;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    public BannerVideosPagerAdapter(Context context, List<BannerVideos> bannerVideosList) {
        this.context = context;
        this.bannerVideosList = bannerVideosList;
    }

    @Override
    public int getCount() {
        return bannerVideosList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_video_layout,null);

        ImageView bannerImage = view.findViewById(R.id.banner_image);
        //Fetch images from url using glide library
        Glide.with(context).load(bannerVideosList.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userId = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
                Map<String,Object> user = new HashMap<>();
                DocumentReference documentReference = firebaseFirestore.collection("users").document(userId).collection("userpoints").document(userId);
                documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable @org.jetbrains.annotations.Nullable DocumentSnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                        assert value != null;
                        points = Integer.parseInt(Objects.requireNonNull(value.getString("points")));
                    }
                });
                points=points+5;
                user.put("points",String.valueOf(points));
                documentReference.set(user);
                Intent i = new Intent(context, VideoPlayerActivity.class);
                i.putExtra("url",bannerVideosList.get(position).getFileUrl());
                context.startActivity(i);
            }
        });

        return view;
    }
}
