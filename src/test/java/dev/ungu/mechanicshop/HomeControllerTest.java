package dev.ungu.mechanicshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import dev.ungu.mechanicshop.config.SecurityConfig;
import dev.ungu.mechanicshop.controller.AuthController;
import dev.ungu.mechanicshop.controller.HomeController;
import dev.ungu.mechanicshop.service.TokenService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@WebMvcTest({HomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
public class HomeControllerTest {
    
    @Autowired
    MockMvc mvc;

    @Test
    void rootWhenUnauthenticatedThen401 () throws Exception {
        mvc.perform(get("/"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedThenSaysHelloUser () throws Exception {
        RequestPostProcessor postProcessor = httpBasic("ezra", "password");
    
        if (postProcessor == null) {
            throw new RuntimeException("postProcessor is null");
        } else {
            MvcResult result = mvc
                .perform(post("/token").with(postProcessor))
                // .andExpect(status().isOk())
                .andReturn();

            // DEBUG purposes
            System.out.println("Response status: " + result.getResponse().getStatus());
            System.out.println("Response headers: " + result.getResponse().getHeaderNames());
            System.out.println("Response body: " + result.getResponse().getContentAsString());
    
            String token = result.getResponse().getContentAsString();
    
            mvc.perform(get("/")
                .header("Authorization", "Bearer " + token))
                .andExpect(content().string("Hello, ezra!"));
        }
    }

    @Test
    @WithMockUser
    public void rootWithMockUsersStatusOK () throws Exception {
        mvc.perform(get("/"))
            .andExpect(status().isOk());
    }

}
