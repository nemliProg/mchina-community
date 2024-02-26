package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.mongodocs.Like;

import java.util.List;

public interface LikeService {
    Like saveLike(Like like);
    Like getLike(String likeId);
    List<Like> getAllLikes();
    Like updateLike(Like like);
    void deleteLike(String LikeId);

}
