package br.com.kassioschaider.fakereddit.controller;

import br.com.kassioschaider.fakereddit.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static URI uri;

    @BeforeAll
    public static void init() throws URISyntaxException {
        uri = new URI("/api/posts");
    }

    @Test
    void shouldRegisterNewPost() throws Exception {
        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"content\": \"anything anything anything\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        var content = mvcResult.getResponse().getContentAsString();
        var objectMapper = new ObjectMapper();
        var post = objectMapper.readValue(content, Post.class);

        assertEquals("anything anything anything", post.getContent());
        assertEquals(0, post.getUpvotes());
    }

    @Test
    void shouldAddVoteToPost() throws Exception {
        var mvcResultRegister = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"content\": \"anything anything anything\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        var content = mvcResultRegister.getResponse().getContentAsString();
        var objectMapper = new ObjectMapper();
        var post = objectMapper.readValue(content, Post.class);

        var upvoteUri = new URI(uri.getPath() + "/" + post.getId() + "/upvote");

        var mvcResultUpvote = mockMvc.perform(MockMvcRequestBuilders.put(upvoteUri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(""))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        var upvoteContent = mvcResultUpvote.getResponse().getContentAsString();

        assertEquals("1", upvoteContent);
    }

}