package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.mongodocs.Post;
import com.codipster.mchinacommunity.repository.PostRepository;
import com.codipster.mchinacommunity.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPost(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        post.ifPresent(postRepository::delete);
    }
}
