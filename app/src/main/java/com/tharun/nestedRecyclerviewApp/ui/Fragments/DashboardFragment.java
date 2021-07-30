package com.tharun.nestedRecyclerviewApp.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tharun.nestedRecyclerviewApp.R;
import com.tharun.nestedRecyclerviewApp.adapter.BannerVideosPagerAdapter;
import com.tharun.nestedRecyclerviewApp.adapter.MainRecyclerAdapter;
import com.tharun.nestedRecyclerviewApp.model.AllCategory;
import com.tharun.nestedRecyclerviewApp.model.BannerVideos;
import com.tharun.nestedRecyclerviewApp.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardFragment extends Fragment {

    BannerVideosPagerAdapter bannerVideosPagerAdapter;
    ViewPager bannerVideosViewPager;
    List<BannerVideos> bannerVideosList;
    List<AllCategory> allCategoryList;
    List<CategoryItem> categoryList1, categoryList2, categoryList3, categoryList4;
    TabLayout tabLayout;
    Timer sliderTimer;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        tabLayout = view.findViewById(R.id.tab_indicator);

            bannerVideosList = new ArrayList<>();
            bannerVideosList.add(new BannerVideos(1, "Mountain5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5MountainsImg.png?alt=media&token=02453a25-d98c-43ef-bd15-4afa729c3d20", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5MountainsVideo.mp4?alt=media&token=4708f96f-d448-4707-9e97-924e2222ed6f"));
            bannerVideosList.add(new BannerVideos(2, "Waterfall5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5WaterfallsImg.png?alt=media&token=b0d6a0d3-d83f-455c-b52d-06f388c0689e", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5WaterfallsVideo.mp4?alt=media&token=5d05f600-da87-494f-b51f-b6e427ff16fa"));
            bannerVideosList.add(new BannerVideos(3, "City5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5CityImg.png?alt=media&token=19c44c68-8566-41f3-ae64-cd9d8c5976fc", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5CityVideo.mp4?alt=media&token=f71097d2-c4ee-4cb4-a8bc-1ba093d1e8b4"));
            bannerVideosList.add(new BannerVideos(4, "Flower5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5FlowerImg.png?alt=media&token=f3b3d340-7efe-42b6-a7e2-82fd94c22bf9", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5FlowerVideo.mp4?alt=media&token=1718405e-4753-475a-b601-559666986ea9"));
            bannerVideosList.add(new BannerVideos(5, "Mountain4", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F4MountainsImg.png?alt=media&token=0527b5c4-8d69-4ea3-b71e-f9f51d551ffb", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F4MountainsVideo.mp4?alt=media&token=1562d7a5-e7b0-49fd-92d0-ceeaf3874b85"));

            setBannerVideosPagerAdapter(view, bannerVideosList);


            //Add Category Item data
            categoryList1 = new ArrayList<>();
            categoryList1.add(new CategoryItem(1, "Waterfalls1", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F1WaterfallsImg.png?alt=media&token=13a7e5b5-8554-4b73-8c84-e135bfc4fb78", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F1WaterfallsVideo.mp4?alt=media&token=06207c0d-1689-454c-9477-f5e5de40f213"));
            categoryList1.add(new CategoryItem(2, "Waterfalls2", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F2WaterfallsImg.png?alt=media&token=f1b8353a-bd33-40bd-9daa-f67eebbeb0f2", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F2WaterfallsVideo.mp4?alt=media&token=4386ef9d-1bf3-4a23-995c-0125d96e75cf"));
            categoryList1.add(new CategoryItem(3, "Waterfalls3", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F3WaterfallsImg.png?alt=media&token=756711ac-92dd-47c9-b8a5-a817ddb11f36", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F3WaterfallsVideo.mp4?alt=media&token=ffdcf8eb-900f-40be-8a13-88f733c378c0"));
            categoryList1.add(new CategoryItem(4, "Waterfalls4", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F4WaterfallsImg.png?alt=media&token=ff7f8f70-0ad8-4c8b-9491-dc9fdf8eaff0", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F4WaterfallsVideo.mp4?alt=media&token=0bfbba1d-3327-4789-8f14-cc4807241e2a"));
            categoryList1.add(new CategoryItem(5, "Waterfalls5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5WaterfallsImg.png?alt=media&token=b0d6a0d3-d83f-455c-b52d-06f388c0689e", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5WaterfallsVideo.mp4?alt=media&token=5d05f600-da87-494f-b51f-b6e427ff16fa"));

            categoryList2 = new ArrayList<>();
            categoryList2.add(new CategoryItem(1, "Mountains1", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F1MountainsImg.png?alt=media&token=3b906527-c05c-4c8d-8f95-058f020e0d74", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F1MountainsVideo.mp4?alt=media&token=b30b0999-a9d6-4c1d-8b19-8de9debe2326"));
            categoryList2.add(new CategoryItem(2, "Mountains2", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F2MountainsImg.png?alt=media&token=d8e37786-a203-4e9f-9881-101166b7f935", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F2MountainsVideo.mp4?alt=media&token=779d8b5d-4923-4911-948a-ed1d99e29175"));
            categoryList2.add(new CategoryItem(3, "Mountains3", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F3MountainsImg.png?alt=media&token=1c66400c-c4b0-47a3-8613-65c0633c9aa3", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F3MountainsVideo.mp4?alt=media&token=01a557a6-c49f-4aa1-bcb6-bfaf8a8f6ad3"));
            categoryList2.add(new CategoryItem(4, "Mountains4", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F4MountainsImg.png?alt=media&token=0527b5c4-8d69-4ea3-b71e-f9f51d551ffb", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F4MountainsVideo.mp4?alt=media&token=1562d7a5-e7b0-49fd-92d0-ceeaf3874b85"));
            categoryList2.add(new CategoryItem(5, "Mountains5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5MountainsImg.png?alt=media&token=02453a25-d98c-43ef-bd15-4afa729c3d20", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5MountainsVideo.mp4?alt=media&token=4708f96f-d448-4707-9e97-924e2222ed6f"));

            categoryList3 = new ArrayList<>();
            categoryList3.add(new CategoryItem(1, "Cities1", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F1CityImg.png?alt=media&token=eebbdbd5-0112-4a74-92bb-1f63aa1f13b7", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F1CityVideo.mp4?alt=media&token=c4169aa7-4054-4dee-b0cc-fe9e52879e3c"));
            categoryList3.add(new CategoryItem(2, "Cities2", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F2CityImg.png?alt=media&token=a8d4524c-c8f7-4bf1-b30c-a57716bd2c5e", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F2CityVideo.mp4?alt=media&token=e5c7f557-5b6c-4e2f-8c98-c3743f2861b7"));
            categoryList3.add(new CategoryItem(3, "Cities3", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F3CityImg.png?alt=media&token=e06dd78f-bb47-4940-b785-db8afeafa397", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F3CityVideo.mp4?alt=media&token=85aeca46-0fef-4d3b-9b28-468436dc0014"));
            categoryList3.add(new CategoryItem(4, "Cities4", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F4CityImg.png?alt=media&token=c2da9d87-d8cc-4d18-8fa8-6df16d87b090", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F4CityVideo.mp4?alt=media&token=5a649669-189d-42a8-b4ea-03952ccaaf43"));
            categoryList3.add(new CategoryItem(5, "Cities5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5CityImg.png?alt=media&token=19c44c68-8566-41f3-ae64-cd9d8c5976fc", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5CityVideo.mp4?alt=media&token=f71097d2-c4ee-4cb4-a8bc-1ba093d1e8b4"));

            categoryList4 = new ArrayList<>();
            categoryList4.add(new CategoryItem(1, "Flowers1", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F1FlowerImg.png?alt=media&token=3e0b1ca2-44e6-44c2-933a-51d3ec1f76fd", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F1FlowerVideo.mp4?alt=media&token=d0517d85-339f-4d74-9439-dbcb4bb9d5d9"));
            categoryList4.add(new CategoryItem(2, "Flowers2", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F2FlowerImg.png?alt=media&token=ad1a9a26-48bd-4501-bdda-b1ea6f56a65e", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F2FlowerVideo.mp4?alt=media&token=00df9aaa-e210-4193-a12f-72f703c2304c"));
            categoryList4.add(new CategoryItem(3, "Flowers3", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F3FlowerImg.png?alt=media&token=5079e331-9977-49c9-b42f-cd6905660c1a", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F3FlowerVideo.mp4?alt=media&token=c86d96de-2e7d-4179-be96-64999a32839f"));
            categoryList4.add(new CategoryItem(4, "Flowers4", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F4FlowerImg.png?alt=media&token=4bfb9779-a8d3-4acd-a759-48a31bff1063", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F4FlowerVideo.mp4?alt=media&token=d96ec485-471e-4aac-ad1f-b5d7c8af729c"));
            categoryList4.add(new CategoryItem(5, "Flowers5", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Images%2F5FlowerImg.png?alt=media&token=f3b3d340-7efe-42b6-a7e2-82fd94c22bf9", "https://firebasestorage.googleapis.com/v0/b/saathealthtestapp.appspot.com/o/Videos%2F5FlowerVideo.mp4?alt=media&token=1718405e-4753-475a-b601-559666986ea9"));

            allCategoryList = new ArrayList<>();
            allCategoryList.add(new AllCategory(1, "Waterfalls", categoryList1));
            allCategoryList.add(new AllCategory(2, "Mountains", categoryList2));
            allCategoryList.add(new AllCategory(3, "Cites", categoryList3));
            allCategoryList.add(new AllCategory(4, "Flowers", categoryList4));
            setMainRecycler(view, allCategoryList);

        return view;
    }

    public void setBannerVideosPagerAdapter(View view, List<BannerVideos> bannerVideosList){
        bannerVideosViewPager = view.findViewById(R.id.banner_viewPager);
        bannerVideosPagerAdapter = new BannerVideosPagerAdapter(getContext(),bannerVideosList);
        bannerVideosViewPager.setAdapter(bannerVideosPagerAdapter);
        tabLayout.setupWithViewPager(bannerVideosViewPager);

        sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),3000,3000);
        tabLayout.setupWithViewPager(bannerVideosViewPager,true);
    }

    class AutoSlider extends TimerTask {

        @Override
        public void run() {
            if (isAdded()) {
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (bannerVideosViewPager.getCurrentItem() < bannerVideosList.size() - 1) {
                            bannerVideosViewPager.setCurrentItem(bannerVideosViewPager.getCurrentItem() + 1);
                        } else {
                            bannerVideosViewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }

    public void setMainRecycler(View view, List<AllCategory> allCategoryList){
        mainRecycler = view.findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(getContext(), allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

}
