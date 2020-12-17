package com.example.bmatch.Models;

import javax.persistence.*;

@Entity
@Table(name="match")
public class Match {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int match_id;

    @Column(name="liker_id")
    public int likerId;

    @Column(name="liked_id")
    public int likedId;

    @Column(name="status")
    public String status;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLikedId() {
        return likedId;
    }

    public void setLikedId(int likedId) {
        this.likedId = likedId;
    }

    public int getLikerId() {
        return likerId;
    }

    public void setLikerId(int likerId) {
        this.likerId = likerId;
    }


}
