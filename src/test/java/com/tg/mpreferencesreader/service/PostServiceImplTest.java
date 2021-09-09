/*
package com.tg.mpreferencesreader.service;

import com.tg.mpreferencesreader.dto.PostDto;
import com.tg.mpreferencesreader.entity.Post;
import com.tg.mpreferencesreader.exception.ResourceNotFoundException;
import com.tg.mpreferencesreader.repository.PostRepository;
import com.tg.mpreferencesreader.repository.UserRepository;
import com.tg.mpreferencesreader.service.impl.PostServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ModelMapper mapper;


    @Test
    public void retrieveUserPostSuccessfully() throws ResourceNotFoundException {

        Long userId =1L;
        Mockito.when(userRepository.existsById(userId)).thenReturn(true);
        Mockito.when(postRepository.findByUserId(userId)).thenReturn(createUserPost());
        Mockito.when(mapper.map(getPost(),PostDto.class)).thenReturn(createPostDtoResponse());
        List<PostDto> postDtos = postService.retrievePost(userId);
        Assert.assertNotNull(postDtos.get(0));
    }

    private List<Post> createUserPost() {
        Post post = getPost();
        return Arrays.asList(post);
    }

    private Post getPost() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("First Description");
        post.setDescription("The First Description");
        return post;
    }

    private PostDto createPostDtoResponse() {
        PostDto postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle("First Description");
        postDto.setDescription("The First Description");
        return postDto;
    }
}
*/
