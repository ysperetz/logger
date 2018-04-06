package com.yaro.http.logger.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

/**
 * @author v-yshneykin
 * @since 4/6/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class LogRequest {
    @NotNull
    private String message;

    public LogRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
