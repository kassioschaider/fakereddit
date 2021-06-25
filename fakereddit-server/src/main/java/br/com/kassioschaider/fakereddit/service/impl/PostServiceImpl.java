package br.com.kassioschaider.fakereddit.service.impl;

import br.com.kassioschaider.fakereddit.repository.PostRepository;
import br.com.kassioschaider.fakereddit.service.PostService;
import br.com.kassioschaider.fakereddit.service.dto.PostDTO;
import br.com.kassioschaider.fakereddit.service.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final PostMapper postMapper;

    @Override
    public List<PostDTO> getAll() {
        return postMapper.toDto(postRepository.findAll());
    }

    @Override
    public PostDTO add(PostDTO postDTO) {
        return null;
    }

    @Override
    public int addVote(int postId) {
        return 0;
    }
}