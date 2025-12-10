package org.wk.repository.service; /**
 * Client for interacting with the GitHub API.
 * Fetches repository data from GitHub's public API.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubApiClient {

    private final RestTemplate restTemplate;

    /**
     * Constructs a GithubApiClient with the specified RestTemplate.
     *
     * @param restTemplate the template used for making HTTP requests
     */
    public GithubApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches repository data from GitHub API.
     *
     * @param owner the owner of the repository
     * @param repoName the name of the repository
     * @return a GithubRepositoryDto containing the repository data
     * @throws RuntimeException if failed to fetch data from GitHub
     */
    public GithubRepositoryDto fetchRepositoryFromGithub(String owner, String repoName) {
        String url = "https://api.github.com/repos/" + owner + "/" + repoName;
        try {
            ResponseEntity<GithubRepositoryDto> response = restTemplate.getForEntity(url, GithubRepositoryDto.class);
            return response.getBody();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to fetch from GitHub", ex);
        }
    }
}
