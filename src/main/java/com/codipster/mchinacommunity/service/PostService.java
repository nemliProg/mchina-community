package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.mongodocs.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    Post getPost(String postId);
    List<Post> getAllPosts();
    Post updatePost(Post post);
    void deletePost(String postId);
}
