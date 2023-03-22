package org.rihazzahir.videostreaming.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class VideoStreamingServiceImpl implements VideoStreamingService {

    private static final String VIDEO_PATH = "classpath:/videos/%s.mp4";
    private final ResourceLoader resourceLoader;

    @Override
    public Mono<Resource> fetchVideoData(String title) {
        System.out.println("title name is :" + title);
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(VIDEO_PATH, title)));
    }

    @Override
    public Mono<String> uploadVideo(String title, MultipartFile file) throws IOException {
        return null;
    }
}
