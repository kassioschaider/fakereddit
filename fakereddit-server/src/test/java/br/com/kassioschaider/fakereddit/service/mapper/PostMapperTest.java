package br.com.kassioschaider.fakereddit.service.mapper;

import br.com.kassioschaider.fakereddit.model.Post;
import br.com.kassioschaider.fakereddit.service.dto.PostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void shouldConvertFromPostToPostDTO() {
        var post = new Post(1L, "CONTENT TEST", 1);
        var postDto = postMapper.toDto(post);

        assertEquals(1L, postDto.getId());
        assertEquals("CONTENT TEST", postDto.getContent());
        assertEquals(1, postDto.getUpvotes());
    }

    @Test
    public void shouldConvertFromPostDTOToPost() {
        var postDto = new PostDTO(1L, "CONTENT TEST", 1);
        var post = postMapper.toEntity(postDto);

        assertEquals(1L, post.getId());
        assertEquals("CONTENT TEST", post.getContent());
        assertEquals(1, post.getUpvotes());
    }

    @Test
    public void shouldConvertFromPostArrayToPostDTOArray() {
        var post = new Post(1L, "CONTENT TEST 1", 1);
        var post2 = new Post(2L, "CONTENT TEST 2", 2);
        var post3 = new Post(3L, "CONTENT TEST 3", 3);
        var postList = Arrays.asList(post, post2, post3);
        var postDTOList = postMapper.toDto(postList);

        assertEquals(3, postDTOList.size());

        assertEquals(1L, postDTOList.get(0).getId());
        assertEquals("CONTENT TEST 1", postDTOList.get(0).getContent());
        assertEquals(1, postDTOList.get(0).getUpvotes());

        assertEquals(2L, postDTOList.get(1).getId());
        assertEquals("CONTENT TEST 2", postDTOList.get(1).getContent());
        assertEquals(2, postDTOList.get(1).getUpvotes());

        assertEquals(3L, postDTOList.get(2).getId());
        assertEquals("CONTENT TEST 3", postDTOList.get(2).getContent());
        assertEquals(3, postDTOList.get(2).getUpvotes());
    }

    @Test
    public void shouldConvertFromPostDTOArrayToPostArray() {
        var postDto = new PostDTO(1L, "CONTENT TEST 1", 1);
        var postDto2 = new PostDTO(2L, "CONTENT TEST 2", 2);
        var postDto3 = new PostDTO(3L, "CONTENT TEST 3", 3);
        var postDtoList = Arrays.asList(postDto, postDto2, postDto3);
        var postList = postMapper.toEntity(postDtoList);

        assertEquals(3, postList.size());

        assertEquals(1L, postList.get(0).getId());
        assertEquals("CONTENT TEST 1", postList.get(0).getContent());
        assertEquals(1, postList.get(0).getUpvotes());

        assertEquals(2L, postList.get(1).getId());
        assertEquals("CONTENT TEST 2", postList.get(1).getContent());
        assertEquals(2, postList.get(1).getUpvotes());

        assertEquals(3L, postList.get(2).getId());
        assertEquals("CONTENT TEST 3", postList.get(2).getContent());
        assertEquals(3, postList.get(2).getUpvotes());
    }

}