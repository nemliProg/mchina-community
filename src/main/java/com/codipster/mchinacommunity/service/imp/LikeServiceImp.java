package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.mongodocs.Like;
import com.codipster.mchinacommunity.mongodocs.Post;
import com.codipster.mchinacommunity.repository.LikeRepository;
import com.codipster.mchinacommunity.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImp implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Like getLike(String likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        return like.orElse(null);
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @Override
    public Like updateLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteLike(String LikeId) {
        Optional<Like> like = likeRepository.findById(LikeId);
        like.ifPresent(likeRepository::delete);
    }
}
