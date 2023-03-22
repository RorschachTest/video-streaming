package org.rihazzahir.videostreaming.web.fn;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class VideoStreamingConfig {

    public static final String VIDEO_FETCH_PATH = "api/v1/videos/{title}";
    public static final String VIDEO_UPLOAD_PATH = "api/v1/videos/upload/{title}";
    private final VideoStreamingHandler handler;

    @Bean
    RouterFunction<ServerResponse> videoStreamingRoutes(){
        return RouterFunctions.route()
                .GET(VIDEO_FETCH_PATH, accept(APPLICATION_JSON), handler::getVideoStream)
                .POST(VIDEO_UPLOAD_PATH, accept(MULTIPART_FORM_DATA), handler::uploadVideo)
                .build();
    }

}
