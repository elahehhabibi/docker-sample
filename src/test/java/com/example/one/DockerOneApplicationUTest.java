package com.example.one;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.one.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = HelloController.class)
@WithMockUser
class DockerOneApplicationUTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void retrieveDefaultHello() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/helloworld").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        assertEquals("Hello Stranger", result.getResponse()
                .getContentAsString());
    }

    @Test
    public void retrieveAutorName() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/author").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        assertEquals("Elaheh Habibi", result.getResponse()
                .getContentAsString());
    }


    @Test
    public void retrieveHelloWithName() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/helloworld").queryParam("name","ElahehHabibi").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        assertEquals("Hello ElahehHabibi", result.getResponse()
                .getContentAsString());
    }

}
