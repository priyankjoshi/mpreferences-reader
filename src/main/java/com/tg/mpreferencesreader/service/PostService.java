package com.tg.mpreferencesreader.service;

import com.tg.mpreferencesreader.dto.PostDto;
import com.tg.mpreferencesreader.exception.ResourceNotFoundException;

import java.util.List;

public interface PostService {

    List<PostDto> retrievePost(Long userId) throws  ResourceNotFoundException;
}
