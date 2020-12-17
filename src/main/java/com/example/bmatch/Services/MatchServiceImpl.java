package com.example.bmatch.Services;

import com.example.bmatch.Interafaces.MatchService;
import com.example.bmatch.Models.Match;
import com.example.bmatch.Models.UserDetail;
import com.example.bmatch.Repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    private int userId = 0;
    private Match actualMatch;

    public void like(){

    }

    public void dislike(){

    }

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public void saveRecord() {
        matchRepository.save(actualMatch);
    }

    @Override
    public void createRecord(int likerId, int likedId) {
        buildMatchRecord(likerId,likedId);
        if (ensureRecordDontExist(likerId,likedId)){
            saveRecord();
            createChatRoom();
        }
    }

    @Override
    public Match buildMatchRecord(int likerId, int likedId) {
        Match match = new Match();
        match.likedId = likedId;
        match.likerId = likerId;
        match.status = "wait";
        this.userId = likedId;
        this.actualMatch = match;
        return match;
    }

    @Override
    public boolean ensureRecordDontExist(int likerId, int likedId) {
        Optional<Match> match = matchRepository.findByLikedIdAndLikerId(likedId, likerId);
        if (match.isPresent() && match.get().status == "wait"){
            actualMatch.status = "ok";
            match.get().status = "ok";
            matchRepository.save(match.get());
            return true;
        }else if (match.isPresent() && match.get().status == "no"){
            actualMatch.status = "no";
            return false;
        }else {
            return false;
        }
    }

    @Override
    public void createChatRoom() {

    }

    @Override
    public UserDetail showPendingLikes(int userId) {
        return null;
    }
}
