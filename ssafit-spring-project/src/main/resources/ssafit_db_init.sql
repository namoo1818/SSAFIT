## 스키마 생성

# DROP SCHEMA ssafit; 
CREATE SCHEMA IF NOT EXISTS ssafit DEFAULT CHARACTER SET utf8mb4;
USE ssafit;


## 테이블 생성

# VIDEO 테이블 
CREATE TABLE IF NOT EXISTS video (
	video_num int AUTO_INCREMENT PRIMARY KEY,
    video_title VARCHAR(50) NOT NULL,
    video_part VARCHAR(10) NOT NULL,
    video_channel VARCHAR(50) NOT NULL,
    video_url TEXT NOT NULL,
    video_viewcnt INT NOT NULL DEFAULT 0
);

# USER 테이블 
CREATE TABLE IF NOT EXISTS user (
	user_num INT AUTO_INCREMENT PRIMARY KEY,
	user_id VARCHAR(20) NOT NULL UNIQUE,
    user_password VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    user_nickname VARCHAR(20) NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_regdate datetime NOT NULL DEFAULT now()
);

# REVIEW 테이블 
CREATE TABLE IF NOT EXISTS review (
	review_num INT AUTO_INCREMENT PRIMARY KEY,
	review_writer INT NOT NULL,
    review_title VARCHAR(50) NOT NULL,
    review_content TEXT NOT NULL,
    review_viewcnt INT NOT NULL DEFAULT 0,
    review_regdate datetime NOT NULL DEFAULT now(),
    video_num INT NOT NULL,
    CONSTRAINT fk_review_video FOREIGN KEY(video_num) 
		REFERENCES video(video_num),
	CONSTRAINT fk_review_user FOREIGN KEY(review_writer)
		REFERENCES user(user_num)
);

# WISH 테이블 
CREATE TABLE IF NOT EXISTS wish (
	wish_num INT AUTO_INCREMENT PRIMARY KEY,
    video_num INT NOT NULL,
    wish_writer INT NOT NULL,
    CONSTRAINT fk_wish_video FOREIGN KEY(video_num) 
		REFERENCES video(video_num),
	CONSTRAINT fk_wish_user FOREIGN KEY(wish_writer)
		REFERENCES user(user_num)
);

# FOLLOW 테이블 
CREATE TABLE IF NOT EXISTS follow (
	follow_num INT AUTO_INCREMENT PRIMARY KEY,
    follower_num INT NOT NULL COMMENT '팔로우를 하는 사람',
    followee_num INT NOT NULL COMMENT '팔로우를 받는 사람',
    FOREIGN KEY(follower_num) REFERENCES user(user_num),
    FOREIGN KEY(followee_num) REFERENCES user(user_num)
);


## 더미 데이터 생성 

INSERT INTO video (video_title, video_part, video_channel, video_url) VALUES 
	('하루 15분! 전신 칼로리 불태우는 다이어트 운동', '전신', '땡큐부부', 'https://www.youtube.com/embed/swRNeYw1JkY'),
	('상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', '상체', '땡큐부부', 'https://www.youtube.com/embed/54tTYO-vU2E'),
	('상체비만 다이어트 최고의 운동 [상체 핵매운맛]', '상체', '땡큐부부', 'https://www.youtube.com/embed/QqqZH3j_vH0'),
	('하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', '하체', '땡큐부부', 'https://www.youtube.com/embed/tzN6ypk6Sps'),
	('저는 하체 식주의자 입니다', '하체', '땡큐부부', 'https://www.youtube.com/embed/u5OgcZdNbMo'),
	('11자복근 복부 최고의 운동 [복근 핵매운맛]', '복부', '땡큐부부', 'https://www.youtube.com/embed/PjGcOP-TQPE'),
	('(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)', '복부', '땡큐부부', 'https://www.youtube.com/embed/7TLk7pscICk');

INSERT INTO user (user_id, user_password, user_name, user_nickname, user_email) VALUES 
	('ssafy', '1234', '김싸피', '관리자','ssafy@email.com'),
	('ssafy1', '0000', '이민지', 'MZ','ssafy1@email.com'),
	('ssafy2', 'pwpw', '조아영', 'AY','ssafy2@email.com');
    
INSERT INTO review (review_writer, review_title, review_content, video_num) VALUES 
	(1, '제목1', '내용1', 1),
	(2, '제목2', '내용2', 3),
	(3, '제목3', '내용3', 3),
	(1, '제목4', '내용4', 4);    

INSERT INTO wish (video_num, wish_writer) VALUES
	(1, 3), 
	(2, 3);

INSERT INTO follow (follower_num, followee_num) VALUES
	(1, 3), 
	(2, 3), 
	(2, 1);


## 테이블 조회 

SELECT * FROM video;

SELECT * FROM user;

SELECT * FROM review;

SELECT * FROM wish;

SELECT * FROM follow;










