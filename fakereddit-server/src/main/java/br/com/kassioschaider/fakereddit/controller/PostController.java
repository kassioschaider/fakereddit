package br.com.kassioschaider.fakereddit.controller;

import br.com.kassioschaider.fakereddit.service.PostService;
import br.com.kassioschaider.fakereddit.service.dto.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PostController {

    @Autowired
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @PostMapping("/posts")
    @Transactional
    public ResponseEntity<PostDTO> add(@RequestBody PostDTO postDTO, UriComponentsBuilder uriBuilder) {
        var result = postService.add(postDTO);
        return ResponseEntity.created(uriBuilder.path("/posts/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @PutMapping("/posts/{id}/upvote")
    @Transactional
    public ResponseEntity<Integer> addVote(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
        var result = postService.addVote(id);
        return ResponseEntity.created(uriBuilder.path("/posts")
                .buildAndExpand(result).toUri())
                .body(result);
    }
}
