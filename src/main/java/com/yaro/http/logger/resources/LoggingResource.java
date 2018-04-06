package com.yaro.http.logger.resources;

import com.codahale.metrics.annotation.Timed;
import com.yaro.http.logger.messages.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author v-yshneykin
 * @since 4/6/18
 */
@Path("/log")
@Produces(MediaType.APPLICATION_JSON)
public class LoggingResource {

    private final AtomicLong counter;

    public LoggingResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Response sayHello(@QueryParam("name") Optional<String> name) {
        return new Response(counter.incrementAndGet(), "ok");
    }
}
