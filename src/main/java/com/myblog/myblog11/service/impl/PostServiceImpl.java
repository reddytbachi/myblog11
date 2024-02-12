package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.Entity.Post;
import com.myblog.myblog11.exception.ResourseNotFoundException;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepository.save(post);


        postDto.setId(savedPost.getId());
        postDto.setTitle(savedPost.getTitle());
        postDto.setDescription(savedPost.getDescription());
        postDto.setContent(savedPost.getContent());

        return postDto;
    }


    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourseNotFoundException("Post not Found with id" + id)
        );

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription ());
        dto.setContent(post.getContent());

        return dto;
    }


}
