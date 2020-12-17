package com.example.bmatch.Controllers;

import com.example.bmatch.Interafaces.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/like")
    public void matchLike(){

    }

    @PostMapping("/dislike")
    public void matchDislike(){

    }

    @PostMapping("/likers/queue")
    public void showLikesQueue(){

    }



}
