
-- SSAFIT DB INIT DML FILE 
	-- 1팀 이민지 조아영 

-- 목차
    -- 데이터 조회 및 삽입
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
-- 1. 사용자
SELECT * FROM user;
INSERT INTO user (user_id, user_password, user_name, user_nickname, user_email, user_goal, user_exp) VALUES 
	('harry','1111','해리포터','번개흉터','potter@hw.ac.uk', 1, 600),
	('ron','2222','론위즐리','퀴디치위너','ron@hw.ac.uk', 1, 100),
	('hermione','3333','헤르미온느','모범생','granger@hw.ac.uk', 2, 1600),
	('severus','4444','스네이프','마법약고수','snape@hw.ac.uk', 3, 9999);

INSERT INTO user (user_id, user_password, user_name, user_nickname, user_email) VALUES 
	('minerva','5555','맥고나걸','변신최고','professor@hw.ac.uk'),
	('albus','6666','덤블도어','교장','dumble@dore.com'),
	('draco','7777','말포이','슬리데린1짱','malfoy@slytherin.com'),
	('voldemort','8888','톰리들','죽먹자','dontwannadie@azkaban.com'),
	('bella','9999','벨라트릭스','볼드짱팬','bella@azkaban.com'),
	('ssafy','0000','김싸피','관리자','ssafy@ssafy.com'),
	('dlalswl','1004','이민지','MJ','dlalswl@ssafy.com');
	

INSERT INTO user (user_id, user_password, user_name, user_nickname, user_email, user_exp) VALUES 
	('cho','1234','조아영','ay','whdkdud@ssafy.com', 90);
    
-- 2. (video) 운동 영상 
SELECT * FROM video;
INSERT INTO video (video_keyword, video_title, video_url, video_channel, video_intensity) VALUES 
	('연예인','르세라핌 카즈하가 실.제.로 하고있는 복근운동 루틴 10분', 'P81i-Umj6i8','에이핏',3),
	('연예인','와...르세라핌이 ‘이 동작’으로 살을 뺐구나....[극강의 9분 전신운동]', 'N7W4mvOyxIk','비타민신지니',3),
	('연예인','와...장원영님 몸매가 이쁜 이유가 ‘이 동작’ 때문이구나...[단기속성 9분 전신운동]','5WkxRsNX9U8','비타민신지니',3),
	('연예인','[여자아이돌 다이어트댄스] 실제 감량 후기 폭발했던 4세대 여돌 플레이리스트로 2주 -5kg 도전 해보세요!','2paxL9MmxWM','흥둥이',3),
	('연예인','[여자아이돌 다이어트댄스]실제 감량후기 폭발! 4세대 여돌 플리로 2주 -5kg 도전해보세요🔥','d1j06bW5VO4','흥둥이',3),
	('연예인','[남돌 다이어트 댄스 모음] 살 쭉 빠졌다는 실제 후기가 가득한 다이어트댄스, 딱 2주만 도전 해보세요 🔥','sAphP_KZkHE','흥둥이',3),
	('해외','Billy Blanks BootCamp 1 Basic Training','HsvBCDU9EsM','빌리의부트캠프','3'),
	('해외','2008편집본 Hana Kang Lower Body Stretching 2018 - Thinner Legs Here I Come! - 강하나 스트레칭(2018)','LZWORB39zQk','강하나','2'),
	('해외','Miley Cyrus Workout: Sexy Legs','MG69sFM1UIw','마일리사일러스',3),
	('해외','Drive By Inner Thighs Challenge Workout','kJyZhOJ2Tag','캐시',3),
	('해외','10 min Booty Shaking Waist Workout- Lose inches off your waist | TiffanyRotheWorkouts','r_J8btnIEKQ','티파니',3),
	('해외','줌바댄스 1000칼로리 소비 /Zumba dance','dZbPtAgofwI','다이어트의모든것',3),
    ('108배','간단하지만 땀나는 108배 절운동 확언 명상','B2xUVl_XnTE','섬마을 요가원',2),
	('108배','발리 일출을 담은 108배 절요가. 함께 몸마음수련해요','V-e1rgzaRfI','미라요가명상TV',2),
	('108배','배우 문소리의 모닝 루틴 대공개~! 108배부터 고난도 스트레칭까지?!, MBC 210123 방송','zmgPhumEy1E','MBCentertainment',2),
	('108배','[1분 투자체조]13강.고소영 108배 체조','6zBO7LaGY44','한국경제TV주식창',2),
	('명상','10분 명상⏳️몸이 이완되고 마음이 편안해지는 호흡명상 가이드 ㅣ 불안 스트레스 해소','6soiPqRSfU4','명상하는그녀_내안의별',0),
	('명상','마음이 평온해지는 10분 명상 | 스트레스 해소, 호흡 명상 가이드','_MTd1opMBk0','에일린 mind yoga',0),
	('명상','5분 호흡명상 - 뇌를 위한 최고의 휴식법 (스트레스 해소, 뇌 피로회복)','dZewQEbQQM0','에일린 mind yoga',0),
	('명상','불안과 근심걱정을 잠재우는 10분 명상가이드🧘 내안의 안식처 키우기','5queBOE-zzE','명상하는그녀_내안의별',0),
	('명상','몸과 마음의 완전한 휴식을 위한 이완명상 (ASMR · 바디스캔 · 자기암시) | 20분 요가니드라 | 요가소년 044','CNYYWuH_Fcc','요가소년',0),
	('명상','호흡 명상 - 김정호 교수님','E1Sfv6xeTpY','마보TV',0),
	('시즌','살 빠지는 캐롤 다이어트 댄스 4탄! 쉽게 따라할 수 있고 너무 신나고 땀도 쫙! carol diet dance','WeAhQYuNH3E','삐약스핏',2),
	('시즌','[삐약스핏 다이어트 댄스] 살빠지는 캐롤 다이어트댄스!! 너무 신나도 책임 못집니다!! 쉽게 따라할 수 있는 다이어트댄스! [carol diet dance]','aFRil1vyX2Q','삐약스핏',2),
	('시즌','🔥몸에 쌓인 지방을 3분만에 녹여버리는🔥체중감량 끝판왕 크리스마스 다이어트 댄스','ZG5_dwCmWvo','비타민신지니',2),
	('시즌','15 MIN CHRISTMAS DANCE PARTY WORKOUT - burn calories to the classics!','sJhJZBjBWGk','MadFit',2),
	('시즌','10 MIN CHRISTMAS DANCE WORKOUT - 10/10 for happiness / Sweaty Version I Pamela Reif','pzj78YA1zws','Pamela Reif',2),
	('시즌','14 MIN CHRISTMAS DANCE PARTY - Beginner Friendly Fun Sweat','BCMtrC9Xb0k','growwithjo',2),
	('시즌','The Ultra Christmas Cardio Challenge','QqAn8BJhv2w','Cardio Party Mashup Fitness',2),
	('시즌','할로윈 파티 대신 우리는 홈트 한다 👻 10분 논스톱 근력 유산소','vRTymm71tPo','빅씨스',2);
    
    
INSERT INTO video (video_title, video_url, video_channel, video_intensity) VALUES 
	('앉아서 하는 스트레칭 루틴!ㅣ의자 스트레칭','2DRvc74GgYM','관절사용설명서',1),
	('가만히 서 있었는데 뱃살이 쫙 빠지고 하체가 단단해지는 운동 루틴! [하루 10분 홈트]','GUhTT21IHI0','관절사용설명서',2),
	('복부가 단단해지고 허리통증 없애는 코어운동 초보 하루 10분 루틴!(3단계)','ZpeX7pX9u1Q','관절사용설명서',2),
	('코어운동 초보들이 무조건 먼저 해야할 운동!','xrAtsN5mhDE','관절사용설명서',1),
	('코어운동 초보 루틴 BESTㅣ하루 10분으로 초보자 코어근육강화!','_RKJL6vwx_U','관절사용설명서',1),
	('플랭크 아직도 버티기만 하세요?','-Mqno-gaztM','관절사용설명서',1),
	('하루 10분 초급 코어강화 운동💛 청소년 필수시청 영상입니다 (Beginner core workout)','LWKpDLeVivI','빵느',1),
	('하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭 - 피로회복, 디톡스, 심신안정, 혈액순환, 라인정리 효과','Kk7TQGqQ3nA','빵느',1),
	('하루 30분🧘🏻 반드시 해야하는 전신순환 스트레칭 - 피로회복, 붓기제거, 디톡스, 심신안정, 라인정리 효과','ejcfa2prYmI','빵느',2),
	('매일 아침 꼭 해야하는 15분 기상 스트레칭｜혈액순환, 피로회복, 신진대사 향상 (Morning stretch)','xCIid6LG354','빵느',1),
	('만성두통, 어깨결림, 뭉친등에 효과가 좋은 상체 폼롤러 마사지 (Foam roller massage - fascial plasticity)','EhvmSFeYqWY','빵느',2),
	('※30분 걷기운동※ 집에서 3km 걸으면서 전신칼로리 불태우기!! (Walking workout)','aGOvDH3UY2A','빵느',2),
	('뱃살빼기! 효과보장!! 15MIN STANDING ABS WORKOUT - No Talking , No Equipment','0iqP6WP2ET4','미지',2),
	('매일 따라하는 8분 상체 스트레칭 - 거북목, 뭉친 어깨, 굽은 등 교정','0XBcrjkkwQo','미지',1),
	('살이 이렇게나 빠진다구?! 층간소음❌ 지방 태우기🔥 No Jumping Cardio Workout','s82_Hi_5ItA','미지',3),
	('일주일만에 팔뚝살 폭파🔥 일자 팔뚝 만들기 8분 운동','KZdQdzcrMOg','미지',2),
	('일주일만에 슬림한 일자 팔뚝 만들기! - 출렁이는 팔뚝살 없애는 9분 루틴','6rDlOwn4q0Q','미지',2),
	('서서하는 복근운동 이 영상하나로 끝! 16MIN STANDING ABS FOR BEGINNER','6rDlOwn4q0Q','미지',2),
	('[ENG] 운동 전 최고의 스트레칭! 10분만 따라해도 운동효과 대박!','yyjOhsNEqtE','힙으뜸',1),
	('ENG)매일 아침 8분 스트레칭 l 8minutes morning full body stretch','ojWHzxUzEVk','힙으뜸',1),
	('ENG)하루10분 스쿼트로 기초 체력 기르기!','q6hBSSfokzY','힙으뜸',2),
	('ENG)매일하는 30일 플랭크 챌린지 (feat.기초근력, 코어힘 기르기)','v54Jtmi2BwU','힙으뜸',3),
	('[ENG] (층간소음X, 설명O) 복근운동과 유산소를 한번에❗️서서하는 복근운동 1탄🔥','kETh8T3it4k','힙으뜸',3),
	('운동후 스트레칭 모음, 이거 하나면 운동효과 2배! 쿨다운 끝!','4TwQwVFLi4Q','힙으뜸',1),
	('[EN/CH]하체비만 탈출 첫번째는 골반교정! 저녁에도 아침같은 다리 완성 (Lower Body Stretching, 다노레전드 스트레칭, 골반교정 스트레칭) ㅣ 다노티비','VVn5IUM8sms','다노',1),
	('다노 레전드 상체 스트레칭으로 허리/어깨통증/거북목 잠재우고, 겨살/팔살/등살 상체 군살까지 싹 정리!ㅣ다노티비','PCLEMCSVx_M','다노',1),
	('한번만 따라 해도 시원함에 중독되는 폼롤러 마사지!! (근막이완 마사지, 폼롤러운동)ㅣ다노티비','NlMjP_uaIW8','다노',1),
	('매일매일 꼭 하고 자는 10분 스트레칭! (워밍업, 쿨 다운, 아침, 저녁용 스트레칭영상) total body stretch | 다노티비','SAsE6JUbSWQ','다노',1),
	('[EN/CH]눈뜨스:아침에 눈뜨자마자 따라하는 스트레칭 (First Thing in the Morning Stretching, Morning Stretching)ㅣ다노티비','6_LYz_XxD-g','다노',1),
	('종아리 가늘어지는 5분 셀프 마사지 (5min calf massage)','prkgLZUX2Dk','다노',1),
	('NO 층간소음 올인원 운동 - 40분 유산소운동 홈트 - 관절에 무리없이 체지방 태우기','myNjmnvI6x0','빅씨스',3),
	('몸 무거운 월요일 - 가볍게 부담없이 28분 층간소음 없는 관절무리없는 유산소 운동 - 초보 홈트','0IWibGOf1jU','빅씨스',2),
	('NO 층간소음 - 고민없이 하나로 끝내는 전신운동 근력 유산소 - 운동 못한 날 죄책감 씻어줄 30분 홈트','4kZHHPH6heY','빅씨스',3),
	('떡국 타파👊 칼로리 폭파👊 근력 유산소 - NO 층간소음, NO 반복 홈트','tE5WqR-IDiM','빅씨스',3),
	('땀폭발 타바타 홈트 신나고 경쾌한 10분 다이어트 운동','fbYu5yzo4lc','빅씨스',3),
	('8분 루틴 꼭 해주세요! 운동 후 전신 스트레칭 - 8분 쿨다운 스트레칭','zDcOqeLGymE','빅씨스',1),
	('무.조.건! 뱃살 빠지는 운동 베스트5','','땅크부부',3),
	('','iOSYLKBk894','땅크부부',3),
	('집에서 하는 유산소운동 다이어트 [칼소폭]','VNQpP6C1fJg','땅크부부',3),
	('허벅지 안쪽살 빨리 빼는 운동 3가지','Q70jQVPkMnc','땅크부부',3),
	('아랫뱃살 똥배 폭파 운동','2Uv1B3kjCOI','땅크부부',3),
	('집에서 칼로리 불태우는 최고의 유산소운동 [칼소폭 매운맛]','lKwZ2DU4P-A','땅크부부',3);


-- 3. (review) 리뷰 
SELECT * FROM review;
INSERT INTO review (review_writer, review_title, review_content, video_num, review_regdate) VALUES 
(11, '오늘부터 시작', 'day 1 완료', 1,"2023-10-19 16:33:23"),
(11, '이틀차', 'day 2 완료', 1,"2023-10-20 20:59:59"),
(11, '포기...', '죽을 것 같음ㅠㅠ카즈하 당신은 대체..', 1,"2023-10-23 18:13:23");
INSERT INTO review (review_writer, review_title, review_content, video_num) VALUES 
(12, '카즈하 사랑해', '마음으로 따라했습니다', 1),
(12, '으악', '여기가...지옥?',18),
(12, '나의 빛 안쌤', '안쌤없이 못살아 정말못살아', 13),
(12, '흠...', '하고는 싶은데 스트레칭 할바에 15분 더잠 ㅅㄱ',22),
(12, '맨날 하는데 감량 안되던데요', '사실 맨날 한다는건 뻥임',4);

-- 4. (calendar) 캘린더 
SELECT * FROM calendar;
INSERT INTO calendar (calendar_title, calendar_content, calendar_start, calendar_end, user_num) VALUES
	("유산소", "", "2023-11-01", "2023-11-02", 1),
    ("상체", "", "2023-11-03", "2023-11-04", 1),
    ("하체", "", "2023-11-15", "2023-11-16", 1),
    ("유산소", "", "2023-11-05", "2023-11-06", 12),
    ("러닝", "", "2023-11-12", "2023-11-13", 12),
    ("요가", "", "2023-11-19", "2023-11-20", 12),
    ("르세라핌 이프케 연습", "", "2023-11-15", "2023-11-16", 12),
    ("뉴진스 디토 연습", "", "2023-11-23", "2023-11-24", 12);

-- 5. (daily) 운동 체크
SELECT * FROM daily;
	-- 생략 (작성하게 되면 여기에 추가)

-- 6. (viewlog) 영상 시청 여부 저장
SELECT * FROM viewlog;
INSERT INTO viewlog (view_date, video_num, user_num) VALUES 
	("2023-11-17 16:33:23", 2, 1),
    ("2023-11-20 16:33:23", 1, 1),
    ("2023-11-22 16:33:23", 2, 1),
    ("2023-11-30 16:33:23", 3, 1),
    ("2023-12-30 16:33:23", 1, 1),
    ("2023-11-17 16:33:23", 2, 2),
    ("2023-11-20 16:33:23", 1, 2),
    ("2023-11-22 16:33:23", 2, 2);
	
-- 7. (wish) 운동 찜
SELECT * FROM wish;
SELECT video_num, user_nickname FROM wish LEFT JOIN user ON wish.user_num = user.user_num;
INSERT INTO wish (video_num, user_num) VALUES
	(2,1),(3,1),(4,1),
	(1,10),(3,10),(5,10),(7,10),(9,10),
    (11,12),(6,12),(40,12);

-- 8. (playlist) 운동용 플레이리스트 
SELECT * FROM playlist;
INSERT INTO playlist (playlist_title, playlist_url, playlist_weather) VALUES
	('비 오는 날, 처진 기분을 업시켜줄 플레이리스트', 'https://www.youtube.com/embed/Oz7MAt-5iKY?si=3uxe-ggzoG5J1UMB', '비'),
    ('눈도 오는데, 크리스마스 기분 내 볼래?', 'https://www.youtube.com/embed/GFb_kXitoG0?si=ffHyICPwPxW0EYqU', '눈'),
    ('안개 낀 날, 비장하게 운동해 보자', 'https://www.youtube.com/embed/7yg3Cp7Y0sQ?si=8g6DaN8dnEfFXkwn', '안개'),
    ('맑은 날, 설레는 마음으로 운동 go go!', 'https://www.youtube.com/embed/AzpDd4ZBW1w?si=g7ewcnPXQSG54MKM', '화창'),
    ('흐린 날이지만 살살 워밍업부터 해 봐요', 'https://www.youtube.com/embed/S3b641gs830?si=9HD5-sWYljxaue-u', '구름'), 
    ('먼지도 이겨내는 운동 타임', 'https://www.youtube.com/embed/MUpIS_9ontQ?si=oJGqVOMVmOLVVnk6', '먼지');

-- 9. (quote) 명언, 응원문구
SELECT * FROM quote;
INSERT INTO quote (quote_content, quote_writer, quote_weather) VALUES
	("비 오는 날 우리 실내 운동 어때요?", "운영자", '비'),
	("운동을 위해 시간을 내지 않으면, 병 때문에 시간을 내야 하게 될지도 모른다.", "로빈 샤르마", '비'),
	("인생은 당신이 편안한 곳에서 나올 때 시작한다.", "닐 도날드 월쉬", '비'),
	("포기하지 않는 사람을 이기기는 어렵다.", "베이브 루스", '비'),
	("땀흘린 자에게 좋은 일이 찾아온다", "미상", '눈'),
	("운동은 하루를 짧게 하지만 인생을 길게 해준다.", "다니엘 W.조스린", '눈'),
	("일단 규칙적으로 운동하면, 이것을 멈추기가 어려울 것이다.", "에린 그레이", '눈'),
	("당신의 몸은 거의 모든 것을 견딜 수 있다. 당신이 설득해야 하는 것은 당신의 의지다.", "미상", '눈'),
	("위험을 무릅쓸 용기가 없으면 인생에서 아무것도 이룰 수 없다.", "무하마드 알리", '안개'),
	("자기 몸을 잘 돌보라. 몸은 내 영혼의 유일한 안식처다.", "짐 론", '안개'),
	("건강 계좌와 은행 계좌의 가치는 똑같다. 많이 쌓을수록 더 많이 사용할 수 있다.", "잭 라렌", '안개'),
	("세상에는 두 종류의 고통이 있다. 당신을 힘들게 하는 고통과 당신을 변화시키는 고통이다.", "미상", '안개'),
	("잘 훈련된 육체만큼 아름다운 것은 없다.", "미상", '화창'),
	("아직 목표에 도달하진 않았지만, 어제의 나보다 오늘의 내가 그 목표에 더 가까워졌다.", "존 N.해리스", '화창'),
	("오늘 할 수 있는 일에 최선을 다해라", "뉴턴", '화창'),
	("날씨도 좋은데 잠깐 산책하고 올까요?", "운영자", '화창'),
	("우리가 반복하는 것들로 우리 스스로를 구성한다. 우수함은 행동이 아니라 습관에서 나온다", "미상", '구름'),
	("오늘로부터 1년 뒤 당신은 '그때 시작할걸...' 할지도 모른다.", "카렌 램", '구름'),
	("운동할 시간이 없는 사람은 병들 시간을 찾아야만 한다.", "더비 백작", '구름'),
	("독서가 정신에 미치는 효과는 운동이 신체에 미치는 효과와 같다", "리처드 스틸", '구름'),
	("건강할 때 건강함을 지키는 것은 의외로 대단한 결단이 필요하다.","제러미 벤담", 6),
	("건강한 신체는 정신을 강하게 만든다", "토마스 제퍼슨", '먼지'),
	("한 번 포기하면 습관이 된다. 절대 포기하지 마라", "마이클 조던", '먼지'),
	("좋은 몸매는 단거리 빨리 달리기로 얻는 것이 아니다. 그것은 긴 여정이다.", "케리 월쉬 제닝스",'먼지'),
	("매일매일 반복된 작은 노력이 모여 성공을 이룬다.", "로버트 콜리어", '먼지');

-- 10. (map) 카카오 map api
SELECT * FROM map;
INSERT INTO map (map_latitud, map_longitud, map_title, map_content, user_num) VALUES
	(37.4928, 126.9197, "보라매공원", "여기서 운동하고싶다", 12),
    (33.4256590636221, 126.395685567869, "애월연어", "언젠가 가고말테야", 12);

-- 11. 팔로우 (앞의 애가 뒤의 애를 팔로우하는 것)
SELECT * FROM follow;
INSERT INTO follow (follower_num, followee_num) VALUES
	(1,5),(2,5),(3,5),(4,5),(6,5),
	(5,4),(5,6),
	(7,3),(7,4),(7,9),
	(9,8),
	(12,1),(12,2),(12,3),(12,4),(12,5),(12,6),(12,7),(12,8),(12,9),(12,10),(12,11),
	(11,10),(11,12);

-- 12. (grade) 회원 등급
SELECT * FROM grade;
INSERT INTO grade (grade_name, grade_min_exp) VALUES 
	('Bronze',0), ('Silver',100), ('Gold',600), ('Platinum',1600);

-- 13. (weather) 날씨 
SELECT * FROM weather;
INSERT INTO weather (weather_main, weather_category) VALUES 
	('Thunderstorm', '비'),
    ('Drizzle', '비'),
    ('Rain', '비'),
    ('Thunderstorm', '비'),
    ('Snow', '눈'),
    ('Mist','안개'),
    ('Smoke','안개'),
    ('Haze','안개'),
    ('Dust', '먼지'),
    ('Fog', '안개'),
    ('Sand', '먼지'),
    ('Dust', '먼지'),
    ('Ash', '구름'),
    ('Squall', '구름'),
    ('Tornado', '구름'),
    ('Clear', '화창'),
    ('Clouds', '구름');


