package org.rihazzahir.videostreaming.repositories;

import org.rihazzahir.videostreaming.domain.Video;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoLibraryRepository extends R2dbcRepository<Video, Integer> {
}
