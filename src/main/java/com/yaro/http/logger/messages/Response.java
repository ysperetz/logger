package com.yaro.http.logger.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * @author v-yshneykin
 * @since 4/6/18
 */
public class Response {
    private long id;

    @Length(max = 3)
    private String content;

    public Response() {
        // Jackson deserialization
    }

    public Response(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
