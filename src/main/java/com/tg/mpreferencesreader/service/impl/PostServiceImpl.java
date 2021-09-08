package com.tg.mpreferencesreader.service.impl;

import com.tg.mpreferencesreader.dto.PostDto;
import com.tg.mpreferencesreader.entity.Post;
import com.tg.mpreferencesreader.exception.ResourceNotFoundException;
import com.tg.mpreferencesreader.repository.PostRepository;
import com.tg.mpreferencesreader.repository.UserRepository;
import com.tg.mpreferencesreader.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<PostDto> retrievePost(Long userId) throws ResourceNotFoundException {


        if(userRepository.existsById(userId)){
            List<Post> posts = postRepository.findByUserId(userId);
            if(posts.isEmpty()){
                throw new ResourceNotFoundException("No Post present for the user with Id"+userId);
            }
            return mapToDto(posts);
        }
        throw new ResourceNotFoundException("User with Id +"+userId+"not Present");
    }

    private List<PostDto> mapToDto(List<Post> posts){
        return posts.stream().map(post->mapper.map(post, PostDto.class)).collect(Collectors.toList());
    }


}
