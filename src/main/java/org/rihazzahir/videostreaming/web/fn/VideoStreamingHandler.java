package org.rihazzahir.videostreaming.web.fn;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import org.rihazzahir.videostreaming.services.VideoStreamingService;

import java.io.IOException;
import java.util.Map;

@Component
public class VideoStreamingHandler {

    private  static final String TITLE = "title";

    VideoStreamingService streamingService;

    public VideoStreamingHandler(@Qualifier("Stored") VideoStreamingService streamingService) {
        this.streamingService = streamingService;
    }

    public Mono<ServerResponse> getVideoStream(ServerRequest request) {
        Mono<Resource> videoResource = Mono.just(request.pathVariable(TITLE))
                .flatMap(title -> streamingService.fetchVideoData(title));

        return ServerResponse.ok().body(videoResource, Resource.class);
    }

    public Mono<ServerResponse> uploadVideo(ServerRequest request) {
        String title = request.pathVariable(TITLE);

        request.bodyToMono(MultipartFile.class).map(file -> {
            try {
                return streamingService.uploadVideo(title, file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        return ServerResponse.ok().build();
    }
}
