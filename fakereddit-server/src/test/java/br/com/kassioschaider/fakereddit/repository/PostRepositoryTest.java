package br.com.kassioschaider.fakereddit.repository;

import br.com.kassioschaider.fakereddit.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void shouldSavePostTest() {
        var post = new Post();
        post.setContent("CONTENT TEST 1");

        var postReturned = postRepository.save(post);

        assertNotNull(postReturned);
        assertEquals(post.getContent(), postReturned.getContent());
        assertEquals(0, postReturned.getUpvotes());
    }

    @Test
    void shouldGetPostsTest() {
        var post = new Post();
        post.setContent("CONTENT TEST 1");
        var post2 = new Post();
        post.setContent("CONTENT TEST 2");
        var post3 = new Post();
        post.setContent("CONTENT TEST 3");
        var postList = Arrays.asList(post, post2, post3);
        postRepository.saveAll(postList);

        var newPostList = postRepository.findAll();

        assertNotNull(newPostList);
        assertEquals(3, newPostList.size());
        assertEquals(post.getContent(), newPostList.get(0).getContent());
        assertEquals(0, newPostList.get(0).getUpvotes());
        assertEquals(post2.getContent(), newPostList.get(1).getContent());
        assertEquals(0, newPostList.get(1).getUpvotes());
        assertEquals(post3.getContent(), newPostList.get(2).getContent());
        assertEquals(0, newPostList.get(2).getUpvotes());
    }

    @Test
    void shouldAddUpvoteToPost() {
        var post = new Post();
        post.setContent("CONTENT TEST 1");
        var postReturned = postRepository.save(post);

        postReturned.setUpvotes(postReturned.getUpvotes() + 1);
        postRepository.save(postReturned);
        var optionalPost = postRepository.findById(postReturned.getId());

        assertTrue(optionalPost.isPresent());
        var newPost = optionalPost.get();
        assertEquals(1, newPost.getUpvotes());
    }

}