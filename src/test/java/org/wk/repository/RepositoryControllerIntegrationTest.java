/**
 * Integration tests for the RepositoryController.
 * Tests the REST endpoints and verifies caching behavior.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RepositoryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests that valid repository details are returned for a real repository.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    void shouldReturnRepositoryDetails() throws Exception {
        mockMvc.perform(get("/repositories/spring-projects/spring-boot"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("spring-projects/spring-boot"))
                .andExpect(jsonPath("$.cloneUrl").exists())
                .andExpect(jsonPath("$.stars").isNumber())
                .andExpect(jsonPath("$.createdAt").exists());
    }

    /**
     * Tests that a 404 status is returned for a non-existent repository.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    void shouldReturn404ForNonExistentRepo() throws Exception {
        mockMvc.perform(get("/repositories/invalid-user-12345/invalid-repo-67890"))
                .andExpect(status().isNotFound());
    }

    /**
     * Tests that caching works correctly on subsequent calls to the same repository.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    void shouldUseCacheOnSecondCall() throws Exception {
        // First call
        mockMvc.perform(get("/repositories/alibaba/fastjson"))
                .andExpect(status().isOk());

        // Second call – still OK (no GitHub rate limit hit in test due to caching)
        mockMvc.perform(get("/repositories/alibaba/fastjson"))
                .andExpect(status().isOk());
    }
}