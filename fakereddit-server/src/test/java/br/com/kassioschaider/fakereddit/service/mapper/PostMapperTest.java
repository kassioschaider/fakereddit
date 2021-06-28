package br.com.kassioschaider.fakereddit.service.mapper;

import br.com.kassioschaider.fakereddit.model.Post;
import br.com.kassioschaider.fakereddit.service.dto.PostDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    private static Post post;
    private static PostDTO postDTO;
    private static List<Post> postList;
    private static List<PostDTO> postDTOList;

    @BeforeAll
    static void init() {
        post = new Post(1L, "CONTENT TEST 1", 1);
        Post post2 = new Post(2L, "CONTENT TEST 2", 2);
        Post post3 = new Post(3L, "CONTENT TEST 3", 3);

        postList = Arrays.asList(post, post2, post3);

        postDTO = new PostDTO(1L, "CONTENT TEST 1", 1);
        PostDTO postDTO2 = new PostDTO(2L, "CONTENT TEST 2", 2);
        PostDTO postDTO3 = new PostDTO(3L, "CONTENT TEST 3", 3);

        postDTOList = Arrays.asList(postDTO, postDTO2, postDTO3);
    }

    @Test
    void shouldConvertFromPostToPostDTO() {
        var newPostDto = postMapper.toDto(post);

        assertEquals(1L, newPostDto.getId());
        assertEquals("CONTENT TEST 1", newPostDto.getContent());
        assertEquals(1, newPostDto.getUpvotes());
    }

    @Test
    void shouldConvertFromPostDTOToPost() {
        var newPost = postMapper.toEntity(postDTO);

        assertEquals(1L, newPost.getId());
        assertEquals("CONTENT TEST 1", newPost.getContent());
        assertEquals(1, newPost.getUpvotes());
    }

    @Test
    void shouldConvertFromPostArrayToPostDTOArray() {
        var newPostDTOList = postMapper.toDto(postList);

        assertEquals(3, newPostDTOList.size());

        assertEquals(1L, newPostDTOList.get(0).getId());
        assertEquals("CONTENT TEST 1", newPostDTOList.get(0).getContent());
        assertEquals(1, newPostDTOList.get(0).getUpvotes());

        assertEquals(2L, newPostDTOList.get(1).getId());
        assertEquals("CONTENT TEST 2", newPostDTOList.get(1).getContent());
        assertEquals(2, newPostDTOList.get(1).getUpvotes());

        assertEquals(3L, newPostDTOList.get(2).getId());
        assertEquals("CONTENT TEST 3", newPostDTOList.get(2).getContent());
        assertEquals(3, newPostDTOList.get(2).getUpvotes());
    }

    @Test
    void shouldConvertFromPostDTOArrayToPostArray() {
        var newPostList = postMapper.toEntity(postDTOList);

        assertEquals(3, newPostList.size());

        assertEquals(1L, newPostList.get(0).getId());
        assertEquals("CONTENT TEST 1", newPostList.get(0).getContent());
        assertEquals(1, newPostList.get(0).getUpvotes());

        assertEquals(2L, newPostList.get(1).getId());
        assertEquals("CONTENT TEST 2", newPostList.get(1).getContent());
        assertEquals(2, newPostList.get(1).getUpvotes());

        assertEquals(3L, newPostList.get(2).getId());
        assertEquals("CONTENT TEST 3", newPostList.get(2).getContent());
        assertEquals(3, newPostList.get(2).getUpvotes());
    }

}