package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.dto.PostSearchDto;
import com.hyunsdb.hambook.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostSearchRepository {
    Page<Post> postSearchPage(PostSearchDto postSearchDto, Pageable pageable);
}
