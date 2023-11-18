
-- SSAFIT DB INIT DDL FILE 
	-- 1팀 이민지 조아영 

-- 목차 
	-- 스키마 생성
		-- 0. (ssafit) 데이터베이스 
	-- 테이블 생성 
		-- 1. (user) 사용자 
		-- 2. (video) 운동 영상 
		-- 3. (review) 리뷰 
		-- 4. (calendar) 캘린더 
		-- 5. (daily) 운동 체크
		-- 6. (viewlog) 영상 시청 여부 저장
		-- 7. (wish) 운동 찜
		-- 8. (playlist) 운동용 플레이리스트 
		-- 9. (quote) 명언, 응원문구
		-- 10. (follow) 팔로우
		-- 11. (map) 카카오 map api
		-- 12. (grade) 회원 등급
		-- 13. (weather) 날씨 

-- 0. 데이터베이스 생성 
DROP SCHEMA ssafit; 
CREATE SCHEMA IF NOT EXISTS ssafit DEFAULT CHARACTER SET utf8mb4;
USE ssafit;

-- 1. 사용자 
CREATE TABLE IF NOT EXISTS `ssafit`.`user` (
  `user_num` INT AUTO_INCREMENT PRIMARY KEY,
  `user_id` VARCHAR(20) NOT NULL,
  `user_password` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_nickname` VARCHAR(20) NOT NULL,
  `user_email` VARCHAR(50) NOT NULL,
  `user_regdate` datetime NOT NULL DEFAULT now(),
  `user_goal` INT,
  `user_exp` INT DEFAULT 0
  );
  
-- 2. 운동 영상 
CREATE TABLE IF NOT EXISTS `ssafit`.`video` (
  `video_num` INT PRIMARY KEY AUTO_INCREMENT,
  `video_title` VARCHAR(200) NOT NULL,
  `video_keyword` VARCHAR(10) COMMENT '키워드',
  `video_channel` VARCHAR(50) NOT NULL,
  `video_url` TEXT NOT NULL,
  `video_viewcnt` INT NOT NULL DEFAULT '0',
  `video_intensity` INT NOT NULL COMMENT '운동 강도 : 3상 2중 1하 0릴랙스'
  );

-- 3. 운동 리뷰 
CREATE TABLE IF NOT EXISTS `ssafit`.`review` (
  `review_num` INT PRIMARY KEY AUTO_INCREMENT,
  `review_writer` INT NOT NULL,
  `review_title` VARCHAR(50) NOT NULL,
  `review_content` TEXT NOT NULL,
  `review_viewcnt` INT NOT NULL DEFAULT '0',
  `review_regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `video_num` INT NOT NULL,
  CONSTRAINT `fk_review_user`
    FOREIGN KEY (`review_writer`)
    REFERENCES `ssafit`.`user` (`user_num`),
  CONSTRAINT `fk_review_video`
    FOREIGN KEY (`video_num`)
    REFERENCES `ssafit`.`video` (`video_num`)
    );
    
-- 4. 캘린더 
CREATE TABLE IF NOT EXISTS `ssafit`.`calendar` (
  `calendar_num` INT AUTO_INCREMENT PRIMARY KEY,
  `calendar_title` VARCHAR(45) NULL,
  `calendar_content` VARCHAR(45) NULL,
  `calendar_start` DATE NULL,
  `calendar_end` DATE NULL,
  `user_num` INT NOT NULL,
  CONSTRAINT `fk_calendar_user1`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
);

-- 5. 날마다 운동 여부 체크
CREATE TABLE IF NOT EXISTS `ssafit`.`daily` (
  `exercise_date` DATE NOT NULL,
  `user_num` INT PRIMARY KEY,
  CONSTRAINT `fk_#dailyExercise_user1`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
);

-- 6. 영상 시청 여부 저장 테이블 
CREATE TABLE IF NOT EXISTS `ssafit`.`viewlog` (
  `view_date` DATETIME NOT NULL,
  `video_num` INT NOT NULL,
  `user_num` INT NOT NULL,
  CONSTRAINT `fk_viewLog_video`
    FOREIGN KEY (`video_num`)
    REFERENCES `ssafit`.`video` (`video_num`),
  CONSTRAINT `fk_viewLog_user1`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
);

-- 7. 운동 찜 
CREATE TABLE IF NOT EXISTS `ssafit`.`wish` (
  `wish_num` INT PRIMARY KEY AUTO_INCREMENT,
  `video_num` INT NOT NULL,
  `user_num` INT NOT NULL,
  CONSTRAINT `fk_wish_user`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`),
  CONSTRAINT `fk_wish_video`
    FOREIGN KEY (`video_num`)
    REFERENCES `ssafit`.`video` (`video_num`)
);

-- 8. 운동용 음악 목록
CREATE TABLE IF NOT EXISTS `ssafit`.`playlist` (
  `playlist_num` INT AUTO_INCREMENT PRIMARY KEY,
  `playlist_title` VARCHAR(100) NOT NULL,
  `playlist_url` TEXT NOT NULL,
  `playlist_weather` INT NOT NULL
  );

-- 9. 명언, 응원문구
CREATE TABLE IF NOT EXISTS `ssafit`.`quote` (
  `quote_num` INT AUTO_INCREMENT PRIMARY KEY,
  `quote_writer` VARCHAR(20) NOT NULL,
  `quote_content` TEXT NOT NULL,
  `quote_weather` INT NOT NULL
  );
  
-- 10. 카카오 map api 사용을 위한 테이블 
CREATE TABLE IF NOT EXISTS `ssafit`.`map` (
  `user_num` INT NOT NULL,
  `map_id` INT AUTO_INCREMENT PRIMARY KEY,
  `map_latitud` FLOAT(10,6) NOT NULL,
  `map_longitud` FLOAT(10,6) NOT NULL,
  `map_title` VARCHAR(100) NOT NULL,
  `map_content` VARCHAR(45) NOT NULL,
  CONSTRAINT `fk_map_user1`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
);

-- 11. 팔로우 
CREATE TABLE IF NOT EXISTS `ssafit`.`follow` (
  `follow_num` INT PRIMARY KEY AUTO_INCREMENT,
  `follower_num` INT NOT NULL COMMENT '팔로우를 하는 사람',
  `followee_num` INT NOT NULL COMMENT '팔로우를 받는 사람',
  CONSTRAINT `follow_ibfk_1`
    FOREIGN KEY (`follower_num`)
    REFERENCES `ssafit`.`user` (`user_num`),
  CONSTRAINT `follow_ibfk_2`
    FOREIGN KEY (`followee_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
    );

-- 12. 회원 등급 
CREATE TABLE IF NOT EXISTS ssafit.grade (
	grade_num INT PRIMARY KEY AUTO_INCREMENT,
    grade_name VARCHAR(10) NOT NULL,
    grade_min_exp INT NOT NULL
	);

-- 13. 날씨
CREATE TABLE IF NOT EXISTS ssafit.weather (
	weather_num INT PRIMARY KEY AUTO_INCREMENT, 
    weather_category VARCHAR(10) NOT NULL
    );






