package com.tg.mpreferencesreader.resource;

import com.tg.mpreferencesreader.dto.PostDto;
import com.tg.mpreferencesreader.exception.ResourceNotFoundException;
import com.tg.mpreferencesreader.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/user/{userId}/posts")
    public List<PostDto> retrieveUserPosts(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException {
        return postService.retrievePost(userId);


    }

}
