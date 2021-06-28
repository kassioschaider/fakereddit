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
        postDTO.setUpvotes(0);
        var post = postMapper.toEntity(postDTO);
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    public int addVote(Long postId) {
        var post = postRepository.getById(postId);
        post.setUpvotes(post.getUpvotes() + 1);
        var postUpvoted = postRepository.save(post);

        return postUpvoted.getUpvotes();
    }
}
