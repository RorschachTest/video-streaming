package org.rihazzahir.videostreaming.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface VideoStreamingService {

    Mono<Resource> fetchVideoData(String title);

    Mono<String> uploadVideo(String title, MultipartFile file) throws IOException;
}
