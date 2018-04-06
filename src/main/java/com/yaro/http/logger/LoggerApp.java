package com.yaro.http.logger;

import com.yaro.http.logger.config.AppConfiguration;
import com.yaro.http.logger.kinesis.KinesisPublisher;
import com.yaro.http.logger.resources.LoggingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author v-yshneykin
 * @since 4/6/18
 */
public class LoggerApp extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new LoggerApp().run(args);
    }

    @Override
    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        ExecutorService kinesisPublishPool = Executors.newFixedThreadPool(8);
        KinesisPublisher publisher = new KinesisPublisher();
        final LoggingResource resource = new LoggingResource(kinesisPublishPool, publisher);


        environment.jersey().register(resource);
    }
}
