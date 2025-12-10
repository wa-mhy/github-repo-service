package org.wk.repository.service;

import org.springframework.stereotype.Service;
import org.wk.repository.dto.RepositoryResponse;
import org.wk.repository.entitty.RepositoryEntity;
import org.wk.repository.service.GithubApiClient;
import org.wk.repository.service.GithubRepositoryDto;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Service class for managing repository data.
 * Handles caching and communication with GitHub API.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */

@Service
public class RepositoryService {

    // In-memory cache: thread-safe Map
    private final ConcurrentHashMap<String, RepositoryEntity> cache = new ConcurrentHashMap<>();

    private final GithubApiClient githubClient;

    /**
     * Constructs a RepositoryService with the specified GithubApiClient.
     *
     * @param githubClient the client used to fetch data from GitHub API
     */
    public RepositoryService(GithubApiClient githubClient) {
        this.githubClient = githubClient;
    }

    /**
     * Gets repository information by owner and repository name.
     * First checks the cache, and if not found, fetches from GitHub API.
     *
     * @param owner the owner of the repository
     * @param repoName the name of the repository
     * @return a RepositoryResponse containing the repository details
     * @throws RuntimeException if the repository is not found on GitHub
     */
    public RepositoryResponse getRepository(String owner, String repoName) {
        String fullName = owner + "/" + repoName;

        // Check cache first
        RepositoryEntity cached = cache.get(fullName);
        if (cached != null) {
            return mapToResponse(cached);
        }

        // Cache miss, call GitHub
        GithubRepositoryDto dto;
        try {
            dto = githubClient.fetchRepositoryFromGithub(owner, repoName);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Repository " + fullName + " not found on GitHub");
        }

        // Build entity and put into cache
        RepositoryEntity entity = new RepositoryEntity();
        entity.setFullName(dto.getFullName());
        entity.setDescription(dto.getDescription() != null ? dto.getDescription() : "");
        entity.setCloneUrl(dto.getCloneUrl());
        entity.setStars(dto.getStars());
        entity.setCreatedAt(dto.getCreatedAt());

        cache.put(fullName, entity); // Write to cache

        return mapToResponse(entity);
    }

    /**
     * Maps a RepositoryEntity to a RepositoryResponse.
     *
     * @param entity the entity to map
     * @return the mapped response object
     */
    private RepositoryResponse mapToResponse(RepositoryEntity entity) {
        RepositoryResponse resp = new RepositoryResponse();
        resp.setFullName(entity.getFullName());
        resp.setDescription(entity.getDescription());
        resp.setCloneUrl(entity.getCloneUrl());
        resp.setStars(entity.getStars());
        resp.setCreatedAt(entity.getCreatedAt());
        return resp;
    }
}
