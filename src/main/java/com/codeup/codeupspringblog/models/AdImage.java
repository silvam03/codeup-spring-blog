package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ad_images")
public class AdImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public AdImage(long id, String imageURL) {
        this.id = id;
        this.imageURL = imageURL;
    }

    public AdImage() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(columnDefinition = "TEXT")
    private String imageURL;

    @ManyToOne
//    @JoinColumn(name = "ad_id")
    private Ad ad;
}
