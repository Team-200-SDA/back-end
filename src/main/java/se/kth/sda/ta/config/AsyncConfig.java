package se.kth.sda.ta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AsyncConfig implements WebMvcConfigurer {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(10); // This might be overkill. Can't figure out how threads are allocated to mongo streams. It's not 1:1 🤷‍️
        executor.setThreadNamePrefix("mongo-flux-stream-");
        executor.initialize();
        configurer.setTaskExecutor(executor);
    }
}
