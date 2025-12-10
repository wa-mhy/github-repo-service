package org.wk.repository.dto; /**
 * Data Transfer Object (DTO) representing a repository response.
 * This class is used to transfer repository information to the client,
 * typically serialized as JSON in REST API responses.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;

public class RepositoryResponse {
    /**
     * The full name of the repository, typically in the format "owner/repository"
     */
    private String fullName;

    /**
     * A brief description of the repository
     */
    private String description;

    /**
     * The HTTPS URL used to clone the repository
     */
    private String cloneUrl;

    /**
     * The number of stars (likes) the repository has received
     */
    private Integer stars;

    /**
     * The creation timestamp of the repository
     * Formatted as ISO 8601 date-time string in UTC timezone
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant createdAt;

    // Getters and Setters
    /**
     * Gets the full name of the repository
     * @return the full name
     */
    public String getFullName() { return fullName; }

    /**
     * Sets the full name of the repository
     * @param fullName the full name to set
     */
    public void setFullName(String fullName) { this.fullName = fullName; }

    /**
     * Gets the description of the repository
     * @return the description
     */
    public String getDescription() { return description; }

    /**
     * Sets the description of the repository
     * @param description the description to set
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the clone URL of the repository
     * @return the clone URL
     */
    public String getCloneUrl() { return cloneUrl; }

    /**
     * Sets the clone URL of the repository
     * @param cloneUrl the clone URL to set
     */
    public void setCloneUrl(String cloneUrl) { this.cloneUrl = cloneUrl; }

    /**
     * Gets the star count of the repository
     * @return the star count
     */
    public Integer getStars() { return stars; }

    /**
     * Sets the star count of the repository
     * @param stars the star count to set
     */
    public void setStars(Integer stars) { this.stars = stars; }

    /**
     * Gets the creation timestamp of the repository
     * @return the creation timestamp
     */
    public Instant getCreatedAt() { return createdAt; }

    /**
     * Sets the creation timestamp of the repository
     * @param createdAt the creation timestamp to set
     */
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
