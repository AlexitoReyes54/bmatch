package com.example.bmatch.Interafaces;


import com.example.bmatch.Models.Match;
import com.example.bmatch.Models.UserDetail;

public interface MatchService {

    public void saveRecord();

    public void createRecord(int likerId,int likedId);

    public Match buildMatchRecord(int likerId,int likedId);

    public boolean ensureRecordDontExist(int likerId,int likedId);

    public void createChatRoom();

    public UserDetail showPendingLikes(int userId);
}
