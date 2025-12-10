package org.wk.repository.entitty;


/**
 * Entity class representing a repository stored in memory cache.
 * Used to cache repository information retrieved from GitHub API.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */

public class RepositoryEntity {

    /**
     * Full name of the repository
     */
    private String fullName;
    
    /**
     * Description of the repository
     */
    private String description;
    
    /**
     * Clone URL of the repository
     */
    private String cloneUrl;
    
    /**
     * Star count of the repository
     */
    private Integer stars;
    
    /**
     * Creation timestamp of the repository
     */
    private java.time.Instant createdAt;

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCloneUrl() { return cloneUrl; }
    public void setCloneUrl(String cloneUrl) { this.cloneUrl = cloneUrl; }

    public Integer getStars() { return stars; }
    public void setStars(Integer stars) { this.stars = stars; }

    public java.time.Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.Instant createdAt) { this.createdAt = createdAt; }
}
