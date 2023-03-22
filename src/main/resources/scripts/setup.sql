CREATE TABLE if NOT EXISTS video
(
    id                 integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    video_title        varchar(255),
    content              longblob,
    created_date       timestamp,
    last_modified_date timestamp
);

-- INSERT INTO `video` VALUES (1, 'video-streaming-test', LOAD_FILE('/Users/ahrazzahir/Desktop/rihazzahir/videos-raw/'))