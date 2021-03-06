import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by luoyishuai on 17/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration 指定加载的 spring 配置文件（一个或多个）的位置, locations=xml配置文件， classes=class配置文件
@ContextConfiguration(locations = "classpath:applicationContext-integrationTest.xml")
@WebAppConfiguration
@ActiveProfiles("integration-test")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
                DirtiesContextTestExecutionListener.class,
                TransactionalTestExecutionListener.class,
                DbUnitTestExecutionListener.class }
)
@DatabaseSetup("setUpDbSample.xml")
public class ITHelloWorldControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test() throws Exception {

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world from repository."));
    }

    @Test
    public void testGetJackDesc() throws Exception {

        mockMvc.perform(get("/{name}/desc", "jack"))
                .andExpect(status().isOk())
                .andExpect(content().string("jack_desc"));
    }

    @Transactional
    @ExpectedDatabase("expectedDbSample.xml")
    @Test
    public void testAddHelloWorld() throws Exception {
        mockMvc.perform(post("/hello-world")
                .param("name", "Mark")
                .param("nameDesc", "Mark_desc"))
                .andExpect(jsonPath("$.name", is("Mark")))
                .andExpect(jsonPath("$.nameDesc", is("Mark_desc")));
    }
}
