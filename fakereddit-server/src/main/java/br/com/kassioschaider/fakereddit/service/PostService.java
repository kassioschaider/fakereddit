package br.com.kassioschaider.fakereddit.service;

import br.com.kassioschaider.fakereddit.service.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAll();

    PostDTO add(PostDTO postDTO);

    int addVote(Long postId);
}
