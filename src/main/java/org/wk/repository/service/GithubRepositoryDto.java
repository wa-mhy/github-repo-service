package org.wk.repository.service; /**
 * Data Transfer Object for GitHub repository data.
 * Maps directly to the JSON response from GitHub API.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepositoryDto {

    @JsonProperty("full_name")
    private String fullName;

    private String description;

    @JsonProperty("clone_url")
    private String cloneUrl;

    @JsonProperty("stargazers_count")
    private Integer stars;

    @JsonProperty("created_at")
    private java.time.Instant createdAt;

    // Getters only (Jackson can deserialize to private fields)
    /**
     * Gets the full name of the repository
     * @return the full name
     */
    public String getFullName() { return fullName; }

    /**
     * Gets the description of the repository
     * @return the description
     */
    public String getDescription() { return description; }

    /**
     * Gets the clone URL of the repository
     * @return the clone URL
     */
    public String getCloneUrl() { return cloneUrl; }

    /**
     * Gets the star count of the repository
     * @return the star count
     */
    public Integer getStars() { return stars; }

    /**
     * Gets the creation timestamp of the repository
     * @return the creation timestamp
     */
    public java.time.Instant getCreatedAt() { return createdAt; }
}
