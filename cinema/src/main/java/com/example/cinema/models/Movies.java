package com.example.cinema.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int     id;
    @Column(name = "title")
    private String  title;
    @Column(name = "rating")
    private String  rating;
    @Column(name = "duration")
    private int     duration;

    public Movies(String title, String rating, int duration) {
        this.title      = title;
        this.rating     = rating;
        this.duration   = duration;
    }

    public Movies() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
