package org.wk.repository.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wk.repository.dto.RepositoryResponse;
import org.wk.repository.service.RepositoryService;

/**
 * REST controller for managing repository-related HTTP requests.
 * Provides endpoints to retrieve repository information from GitHub.
 *
 * @author wangkang@yinhai.com
 * @date 2025/12/10
 */
@RestController
public class RepositoryController {

    private final RepositoryService repositoryService;

    /**
     * Constructs a RepositoryController with the specified RepositoryService.
     *
     * @param repositoryService the service responsible for fetching and managing repository data
     */
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    /**
     * Retrieves information about a specific repository identified by owner and repository name.
     *
     * @param owner the owner of the repository (e.g., "spring-projects")
     * @param repoName the name of the repository (e.g., "spring-boot")
     * @return a RepositoryResponse containing the repository details
     */
    @GetMapping("/repositories/{owner}/{repository}")
    public RepositoryResponse getRepository(
            @PathVariable String owner,
            @PathVariable("repository") String repoName) {
        return repositoryService.getRepository(owner, repoName);
    }
}
