package com.yaro.http.logger.resources;

import com.codahale.metrics.annotation.Timed;
import com.yaro.http.logger.kinesis.KinesisPublisher;
import com.yaro.http.logger.messages.LogRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutorService;

/**
 * @author v-yshneykin
 * @since 4/6/18
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class LoggingResource {
    //Logging framework will write logs asynchronously to the file.
    private static Logger logger = LoggerFactory.getLogger(LoggingResource.class);
    private final ExecutorService kinesisPublishPool;
    private final KinesisPublisher publisher;

    public LoggingResource(ExecutorService kinesisPublishPool, KinesisPublisher publisher) {
        this.kinesisPublishPool = kinesisPublishPool;
        this.publisher = publisher;
    }

    @POST
    @Path("/log")
    @Timed
    public void sayHello(LogRequest request) {
        //TODO: validate the message
        logger.info(request.getMessage());
        kinesisPublishPool.execute(() -> {
            publisher.publish(request.getMessage());
        });
    }
}
