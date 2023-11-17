DROP SCHEMA ssafit; 
CREATE SCHEMA IF NOT EXISTS ssafit DEFAULT CHARACTER SET utf8 ;
USE ssafit ;

-- qutoe
CREATE TABLE IF NOT EXISTS `ssafit`.`quote` (
  `quote_num` INT AUTO_INCREMENT PRIMARY KEY,
  `quote_writer` VARCHAR(20) NOT NULL,
  `quote_content` TEXT NOT NULL,
  `quote_weather` INT NOT NULL
  );
  
INSERT INTO quote (quote_content, quote_writer, quote_weather) VALUES
	("운동을 위해 시간을 내지 않으면, 병 때문에 시간을 내야 하게 될지도 모른다.", "로빈 샤르마", 0),
	("인생은 당신이 편안한 곳에서 나올 때 시작한다.", "닐 도날드 월쉬", 0),
	("포기하지 않는 사람을 이기기는 어렵다.", "베이브 루스", 0),
	("땀흘린 자에게 좋은 일이 찾아온다", "미상", 0),
	("운동은 하루를 짧게 하지만 인생을 길게 해준다.", "다니엘 W.조스린", 0),
	("일단 규칙적으로 운동하면, 이것을 멈추기가 어려울 것이다.", "에린 그레이", 1),
	("당신의 몸은 거의 모든 것을 견딜 수 있다. 당신이 설득해야 하는 것은 당신의 의지다.", "미상", 1),
	("위험을 무릅쓸 용기가 없으면 인생에서 아무것도 이룰 수 없다.", "무하마드 알리", 1),
	("자기 몸을 잘 돌보라. 몸은 내 영혼의 유일한 안식처다.", "짐 론", 1),
	("건강 계좌와 은행 계좌의 가치는 똑같다. 많이 쌓을수록 더 많이 사용할 수 있다.", "잭 라렌", 1),
	("세상에는 두 종류의 고통이 있다. 당신을 힘들게 하는 고통과 당신을 변화시키는 고통이다.", "미상", 2),
	("잘 훈련된 육체만큼 아름다운 것은 없다.", "미상", 2),
	("비 오는 날 우리 실내 운동 어때요?", "운영자", 2),
	("아직 목표에 도달하진 않았지만, 어제의 나보다 오늘의 내가 그 목표에 더 가까워졌다.", "존 N.해리스", 2),
	("오늘 할 수 있는 일에 최선을 다해라", "뉴턴", 2),
	("날씨도 좋은데 잠깐 산책하고 올까요?", "운영자", 3),
	("우리가 반복하는 것들로 우리 스스로를 구성한다. 우수함은 행동이 아니라 습관에서 나온다", "미상", 3),
	("오늘로부터 1년 뒤 당신은 '그때 시작할걸...' 할지도 모른다.", "카렌 램", 3),
	("운동할 시간이 없는 사람은 병들 시간을 찾아야만 한다.", "더비 백작", 3),
	("독서가 정신에 미치는 효과는 운동이 신체에 미치는 효과와 같다", "리처드 스틸", 3),
	("건강할 때 건강함을 지키는 것은 의외로 대단한 결단이 필요하다.","제러미 벤담", 4),
	("건강한 신체는 정신을 강하게 만든다", "토마스 제퍼슨", 4),
	("한 번 포기하면 습관이 된다. 절대 포기하지 마라", "마이클 조던", 4),
	("좋은 몸매는 단거리 빨리 달리기로 얻는 것이 아니다. 그것은 긴 여정이다.", "케리 월쉬 제닝스",4),
	("매일매일 반복된 작은 노력이 모여 성공을 이룬다.", "로버트 콜리어", 4);

SELECT * FROM quote;

-- playlist
CREATE TABLE IF NOT EXISTS `ssafit`.`playlist` (
  `playlist_num` INT AUTO_INCREMENT PRIMARY KEY,
  `playlist_title` VARCHAR(100) NOT NULL,
  `playlist_url` TEXT NOT NULL,
  `playlist_weather` INT NOT NULL
  );

-- user
CREATE TABLE IF NOT EXISTS `ssafit`.`user` (
  `user_num` INT AUTO_INCREMENT PRIMARY KEY,
  `user_id` VARCHAR(20) NOT NULL,
  `user_password` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_nickname` VARCHAR(20) NOT NULL,
  `user_email` VARCHAR(50) NOT NULL,
  `user_regdate` datetime NOT NULL DEFAULT now(),
  `user_goal` INT NOT NULL,
  `user_exp` INT NOT NULL
  );
  
INSERT INTO user (user_id, user_password, user_name, user_nickname, user_email, user_goal, user_exp) VALUES 
	('ssafy', '1234', '김싸피', '관리자','ssafy@email.com', 0, 9999),
	('ssafy1', '0000', '이민지', 'MZ','ssafy1@email.com', 1, 10),
	('ssafy2', 'pwpw', '조아영', 'AY','ssafy2@email.com', 2, 1000);

SELECT * FROM user;

-- calendar
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

-- dailyExercise
CREATE TABLE IF NOT EXISTS `ssafit`.`dailyExercise` (
  `exercise_date` DATE NOT NULL,
  `user_num` INT PRIMARY KEY,
  CONSTRAINT `fk_#dailyExercise_user1`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
);

-- map
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

-- follow
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


-- video
CREATE TABLE IF NOT EXISTS `ssafit`.`video` (
  `video_num` INT PRIMARY KEY AUTO_INCREMENT,
  `video_title` VARCHAR(50) NOT NULL,
  `video_keyword` VARCHAR(10) NOT NULL,
  `video_channel` VARCHAR(50) NOT NULL,
  `video_url` TEXT NOT NULL,
  `video_viewcnt` INT NOT NULL DEFAULT '0',
  `video_goal` INT NOT NULL,
  `video_weather` INT NOT NULL,
  `video_intensity` INT NOT NULL
  );


-- review
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


-- wish
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

-- viewLog
CREATE TABLE IF NOT EXISTS `ssafit`.`viewLog` (
  `view_date` DATE NOT NULL,
  `video_num` INT NOT NULL,
  `user_num` INT NOT NULL,
  CONSTRAINT `fk_viewLog_video`
    FOREIGN KEY (`video_num`)
    REFERENCES `ssafit`.`video` (`video_num`),
  CONSTRAINT `fk_viewLog_user1`
    FOREIGN KEY (`user_num`)
    REFERENCES `ssafit`.`user` (`user_num`)
);

INSERT INTO video (video_title, video_keyword, video_channel, video_url, video_goal, video_weather, video_intensity) VALUES 
	('하루 15분! 전신 칼로리 불태우는 다이어트 운동', '전신', '땡큐부부', 'https://www.youtube.com/embed/swRNeYw1JkY', 1, 1, 1),
	('상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', '상체', '땡큐부부', 'https://www.youtube.com/embed/54tTYO-vU2E', 1,1,1),
	('상체비만 다이어트 최고의 운동 [상체 핵매운맛]', '상체', '땡큐부부', 'https://www.youtube.com/embed/QqqZH3j_vH0',2,2,2),
	('하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', '하체', '땡큐부부', 'https://www.youtube.com/embed/tzN6ypk6Sps',2,2,2),
	('저는 하체 식주의자 입니다', '하체', '땡큐부부', 'https://www.youtube.com/embed/u5OgcZdNbMo',3,3,3),
	('11자복근 복부 최고의 운동 [복근 핵매운맛]', '복부', '땡큐부부', 'https://www.youtube.com/embed/PjGcOP-TQPE',3,3,3),
	('(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)', '복부', '땡큐부부', 'https://www.youtube.com/embed/7TLk7pscICk',4,4,4);

INSERT INTO review (review_writer, review_title, review_content, video_num) VALUES 
	(1, '제목1', '내용1', 1),
	(2, '제목2', '내용2', 3),
	(3, '제목3', '내용3', 3),
	(1, '제목4', '내용4', 4);    

INSERT INTO wish (video_num, user_num) VALUES
	(1, 3), 
	(2, 3);

INSERT INTO follow (follower_num, followee_num) VALUES
	(1, 3), 
	(2, 3), 
	(2, 1);