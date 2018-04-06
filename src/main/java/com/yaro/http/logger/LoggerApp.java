package com.yaro.http.logger;

import com.yaro.http.logger.config.AppConfiguration;
import com.yaro.http.logger.resources.LoggingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

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
        final LoggingResource resource = new LoggingResource();
        environment.jersey().register(resource);
    }
}
