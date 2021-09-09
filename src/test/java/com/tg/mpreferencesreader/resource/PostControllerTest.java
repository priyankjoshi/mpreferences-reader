package com.tg.mpreferencesreader.resource;

import com.tg.mpreferencesreader.dto.PostDto;
import com.tg.mpreferencesreader.exception.ResourceNotFoundException;
import com.tg.mpreferencesreader.service.PostService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService postService;

    @Test
    public void retrieveUserPostSuccess() throws ResourceNotFoundException {
        Long userId = 1L;
        Mockito.when(postService.retrievePost(userId)).thenReturn(createUserPost());
        List<PostDto> posts = postController.retrieveUserPosts(userId);
        Assert.assertNotNull(posts);
        Assert.assertTrue(posts.get(0).getId() == 1L);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void retrieveUserPostFailedForResource() throws ResourceNotFoundException {
        Long userId = 1L;
        Mockito.when(postService.retrievePost(userId)).thenThrow(new ResourceNotFoundException("User with Id not present"));
        postController.retrieveUserPosts(userId);
    }

    private List<PostDto> createUserPost() {
        PostDto postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle("First Description");
        postDto.setDescription("The First Description");
        return Arrays.asList(postDto);
    }
}
