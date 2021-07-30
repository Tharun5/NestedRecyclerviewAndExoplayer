package com.tharun.nestedRecyclerviewApp.model;

public class BannerVideos {

    Integer id;
    String videoName;
    String imageUrl;
    String fileUrl;

    public BannerVideos(Integer id, String videoName, String imageUrl, String fileUrl) {
        this.id = id;
        this.videoName = videoName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
