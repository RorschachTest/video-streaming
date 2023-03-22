package org.rihazzahir.videostreaming.services;

import lombok.RequiredArgsConstructor;
import org.rihazzahir.videostreaming.domain.Video;
import org.rihazzahir.videostreaming.repositories.VideoLibraryRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service("Stored")
@RequiredArgsConstructor
public class StoredVideoStreamingServiceImpl implements VideoStreamingService {

    final VideoLibraryRepository videoLibraryRepository;

    @Override
    public Mono<Resource> fetchVideoData(String title) {
        Mono<Video> video =  videoLibraryRepository.findAll().single();
        return  video.map(videoEntity -> new ByteArrayResource(videoEntity.getContent()));
    }

    @Override
    public Mono<String> uploadVideo(String title, MultipartFile file) throws IOException {


        return videoLibraryRepository.save(Video.builder()
                .videoTitle(title)
                .content(file.getBytes())
                .build()).map(video -> video.getVideoTitle());
    }
}
