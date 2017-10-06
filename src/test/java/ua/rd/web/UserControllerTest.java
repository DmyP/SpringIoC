package ua.rd.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.rd.WebConfig;
import ua.rd.domain.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void user() throws Exception {
        String uName = "SomeName";
        User user = new User("With binder "+ uName);
        mockMvc.perform(get("/user/{name}", uName))
                .andExpect(view().name("user"))
                .andExpect(model().attribute("user", user));
    }

    @Test
    public void error() throws Exception {
        mockMvc.perform(get("/user/exception"))
                .andExpect(status().isBadRequest())
                .andExpect(view().name("errors"))
                .andExpect(model().attributeExists("ex"));
    }

}