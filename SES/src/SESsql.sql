--교육생을 저장할 테이블
create table trainee(
id varchar2(20) constraint pk_trainee primary key
,name varchar2(40) not null
,age number(3) not null
,address varchar2(100) not null
,major varchar2(40) not null
,jlpt varchar2(20) default '없음'
,eip varchar2(20) default '없음'
,phone varchar(30)
,groupof number(3)
);
-- 교육생의 IT반, 일본어 반을 저장
create table class(
id varchar2(20) constraint class_id_fk references trainee on delete cascade
,itCls varchar2(1) 
,jpCls varchar2(10) 
);
-- 교육생의 역량평가 점수를 저장
create table mark(
id varchar2(20) constraint mark_id_fk references trainee on delete cascade -- Trainee 테이블의 id를 참조
,firstTestIT number(3) default 0
,firstTestJP number(3) default 0
,secondTestIT number(3) default 0
,secondTestJP number(3) default 0
,thirdTestIT number(3) default 0
,thirdTestJP number(3) default 0
);
-- 교육생의 학사내역을 저장
create table manage(
id varchar2(20) constraint manage_id_fk references trainee on delete cascade -- Trainee 테이블의 id를 참조
,late number(3) default 0
,leave number(3) default 0
,absent number(3) default 0
);
-- 교수의 정보를 저장하는 테이블
create table professor(
id number(4) constraint professor_pnum_pk primary key
,name varchar(40) not null
,age number(3) not null
,subject varchar(20) not null
,cls varchar(20) not null --담당반 , IT면 A,B,C,D,E, 일본어면 초/중/고급이 들어감
);
-- 조퇴/결석을 신청하고 확인하는 테이블
create table excuse(
boardnum number
,id varchar2(40) 
,name varchar2(40) 
,content varchar2(400)
,hits number
,indate date
);
-- 조퇴/결석 테이블을 위한 시퀀스
create sequence boardsequ;

-- 전체 공지를 저장할 테이블
create table notice(
noticenum number
,content varchar2(400)
);

insert into trainee
values ('gutav','노태우',28,'서울시 영등포구 45-9','경영',default,default,'010-6542-6321',34);
insert into trainee
values ('catholic','오삼성',24,'부산시 남구 25-4','행정','N2',default,'010-8712-3742',34);
insert into trainee
values ('sasu3','보나파',23,'서울시 성동구 7-9','디지털미디어','N1','있음','010-9765-1110',34);
insert into trainee
values ('john1','조온나',25,'경기도 세종시','심리학','N2',default,'010-8473-1324',34);
insert into trainee
values ('tibery13','아체베',30,'서울시 노원구 14-7','철학','N3','있음','010-9791-2354',34);
insert into trainee
values ('bangbang23','차지철',25,'서울시 중랑구','국어국문','N2','필기','010-5110-0473',34);
insert into trainee
values ('hypo45','김준현',26,'인천광역시 남구 도화동 12-2','소프트엔지니어공학','N2','있음','010-7741-8824',34);
insert into trainee
values ('nigire21','김세희',23,'서울시 송파구','중어중문','N2','필기','010-9841-1332',34);
insert into trainee
values ('singer34','박형식',26,'서울시 강남구 ','뮤지컬',default,default,'010-1104-8913',34);
insert into trainee
values ('minong56','김민형',25,'경기도 성남시','감귤포장','N1','있음','010-9999-1320',34);
insert into trainee
values ('henry651','최재서',25,'서울시 서대문구','오징어심리','N1','필기','010-8712-1365',34);
insert into trainee
values ('nokrules3','최덕신',29,'서울시 마포구 ','영어영문','N2',default,'010-6163-1644',34);
insert into trainee
values ('freedman14','김자옥',27,'경기도 수원시','법학','N1',default,'010-9611-0187',34);
insert into trainee
values ('akino342','이규완',28,'서울시 강서구','불어불문',default,'있음','010-7777-2222',34);
insert into trainee
values ('mccathy14','차범석',31,'서울시 은평구','국제통상','N1',default,'010-9846-8722',34);
insert into trainee
values ('dlser24','전원주',20,'서울시 강남구 삼성동','문헌정보','N1',default,'010-4156-7113',34);
insert into trainee
values ('basketcase134','전주원',24,'서울시 동작구','독어독문','N3','있음','010-6132-1173',34);
insert into trainee
values ('sergiour554','박태원',22,'서울시 구로구','경제','N1',default,'010-7192-1030',34);
insert into trainee
values ('ulala34','임윤택',29,'경기도 부천시','뮤지컬','N2',default,'010-1651-1873',34);
insert into trainee
values ('paul29','진보라',25,'경기도 부천시','아동심리','N2',default,'010-7813-3365',34);
insert into trainee
values ('josep14','주요섭',30,'서울시 양천구','문예창작',default,'있음','010-9841-7778',34);
insert into trainee
values ('gogomi34','김원룡',25,'서울시 관악구','수학',default,default,'010-9841-1507',34);
insert into trainee
values ('thekwan4','조덕환',21,'경기도 용인시','일어일문','N1',default,'010-5557-8888',34);
insert into trainee
values ('deseyo155','이대용',20,'서울시 마포구','소프트웨어',default,'있음','010-6511-0047',34);
insert into trainee
values ('edward553','석주명',26,'서울시 도봉구','생물',default,default,'010-7854-2214',34);
insert into trainee
values ('albert534','안택수',27,'경기도 평택시','정치학','N2','필기','010-7781-2774',34);
insert into trainee
values ('hooker53','김호철',27,'서울시 성북구','사회체육','N3','필기','010-3347-1473',34);
insert into trainee
values ('ludovika43','조혜영',29,'서울시 은평구','뷰티','N4',default,'010-6178-1101',34);
insert into trainee
values ('pissaro234','전태일',23,'경기도 안양시','사회복지','N1','필기','010-1147-4711',34);
insert into trainee
values ('nicolas453','임부택',26,'서울시 종로구 ','부동산',default,'있음','010-8741-7715',34);
insert into trainee
values ('rions3','김상현',33,'서울시 동대문구','정치외교','N2','필기','010-9771-7741',34);
insert into trainee
values ('supersupport43','왕지원',27,'서울시 강남구','연극','N3',default,'010-6516-7712',34);
insert into trainee
values ('akb48love','김굉필',24,'서울시 종로구 사직동 45-9','문화재보존','N1',default,'010-1552-2442',34);
insert into trainee
values ('zzamgirl','이주리',27,'과천시 과천동 9-24','멀티미디어',default,'있음','010-2473-3195',34);
insert into trainee
values ('mojito44','안상구',29,'성남시 중원구 중앙동 11-9','의상','N1',default,'010-1558-3672',34);
insert into trainee
values ('beyond115','유태주',25,'서울시 중랑구 면목본동 5-19','건축학',default,default,'010-7523-8122',34);
insert into trainee
values ('lott204','민영준',29,'서울시 동대문구 혜화동 11-7','경영','N2','필기','010-1225-6455',34);
insert into trainee
values ('dutu442','선우진',28,'서울시 성동구 옥수동 8-22','산업디자인','N2','필기','010-5517-9400',34);
insert into trainee
values ('jpdack55','이언주',28,'인천광역시 계양구 갈현동 2-12','해양','N1','필기','010-5711-5452',34);
insert into trainee
values ('odin143','강주희',26,'서울시 서초구 양재동 11-2','소프트웨어',default,'있음','010-3414-7173',34);
insert into trainee
values ('jobs','이진우',30,'성남시 중원구 도촌동 44-10','안경광학','N1','필기','010-5517-4323',34);
insert into trainee
values ('catsy103','이동석',27,'서울시 영등포구 신길동 6-29','사회체육','N2',default,'010-6933-2518',34);
insert into trainee
values ('abubu','민지혜',25,'서울시 광진구 자양동 66-5','간호학','N2','필기','010-4031-0047',34);
insert into trainee
values ('friends220','유지영',26,'서울시 노원구 하계동 11-9','건축행정',default,'있음','010-6511-1143',34);
insert into trainee
values ('cheap331','김주철',30,'수원시 장안구 연무동 7-9','멀티미디어',default,'필기','010-5144-4122',34);
insert into trainee
values ('jdons22','이유리',26,'서울시 동작구 사당동 31-22','물류유통','N2','있음','010-2668-4211',34);
insert into trainee
values ('sulgi55','이지안',27,'서울시 강남구 청담동 21-2','무역','N1','있음','010-1883-5242',34);
insert into trainee
values ('petit11','민지윤',28,'서울시 강남구 삼성동 15-3','미술사','N2','필기','010-1054-5115',34);
insert into trainee
values ('orkid113','김기웅',29,'수원시 팔달구 지동 11-9','서지학','N1','있음','010-9324-2212',34);
insert into trainee
values ('apep1202','조한울',25,'대전광역시 중구 대흥동 25-4','철도',default,'있음','010-5012-6115',34);
insert into trainee
values ('mark153','조진규',29,'성남시 동작구 신대방동 11-9','미디어영상','N2','필기','010-1965-8642',34);
insert into trainee
values ('cho1033','조광준',24,'서울시 송파구 석촌동 24-7','전자공학','N2','필기','010-7053-2218',34);
insert into trainee
values ('mecha140','이정준',25,'서울시 강동구 고덕동 15-8','소프트웨어',default,'있음','010-3425-1485',34);
insert into trainee
values ('tommy336','이지훈',25,'서울시 강남구 압구정동 11-2','항공학','N1','있음','010-3007-9140',34);
insert into trainee
values ('eric1733','우정훈',26,'인천광역시 연수구 연수동 10-42','사회복지','N2','필기','010-5876-2462',34);
insert into trainee
values ('zenith43','허일',27,'서울시 서대문구 홍은동 41-2','영상정보',default,'있음','010-3414-7333',34);
insert into trainee

values ('kogeek211','홍유진',25,'서울시 영등포구 당산동 40-7','경영','N1','있음','010-6343-1913',34);
insert into trainee
values ('kadin401','이주원',26,'서울시 종로구 소공동 7-19','시각디자인',default,'필기','010-6423-2102',34);
insert into trainee
values ('music606','고준영',28,'서울시 강남구 삼성동 65-2','사회복지','N2','필기','010-2431-6825',34);
insert into trainee
values ('mymi995','조유진',27,'성남시 분당구 정자동 10-9','제약행정','N1',default,'010-5433-8315',34);
insert into trainee
values ('wowbee705','김준영',26,'서울시 송파구 잠실동 22-9','사회복지',default,default,'010-2123-3062',34);
insert into trainee
values ('jhr244','유혜진',26,'서울시 강남구 삼성동 33-7','글로벌경영','N1','있음','010-2026-6231',34);
insert into trainee
values ('anamorp105','서지헌',32,'수원시 장안구 상광교동 10-12','무역','N2','있음','010-3044-1872',34);
insert into trainee
values ('champ805','전상훈',25,'서울시 강남구 삼성동 17-9','모던아트',default,'필기','010-4017-2316',34);
insert into trainee
values ('ordinal225','강준기',29,'성남시 분당구 금곡동 21-5','회계','N1','있음','010-1022-8747',34);
insert into trainee
values ('ost188','민준규',28,'서울시 영등포구 여의도동 9-29','공연설계','N2','필기','010-4005-4683',34);
insert into trainee
values ('drived002','남지섭',31,'과천시 문원동 105-7','경영','N2','있음','010-8863-4261',34);
insert into trainee
values ('mobst55','안진영',29,'서울시 금천구 독산동 8-30','멀티미디어','N2',default,'010-2274-6872',34);
insert into trainee
values ('wjjw8855','손우재',24,'서울시 용산구 한남동 17-9','문헌정보',default,'필기','010-2033-4472',34);
insert into trainee
values ('akakim','김종직',27,'서울시 종로구 경운동 45-9','시각디자인','N2',default,'010-3433-5662',34);
insert into trainee
values ('sooa1022','최수아',24,'전주광역시 덕진구 성덕동 25-4','의료행정',default,default,'010-4173-3385',34);
insert into trainee
values ('dhtkddn','오상우',29,'성남시 분당구 금곡동 7-9','미디어영상','N1','있음','010-9915-6642',34);
insert into trainee
values ('ahnd103','안종영',25,'김포시 장기본동 15-9','자동차공학','N2',default,'010-7523-8122',34);
insert into trainee
values ('mode220','김대철',30,'서울시 동대문구 이문동 14-7','전자공학',default,'있음','010-1225-6455',34);
insert into trainee
values ('headycool','하성진',25,'서울시 중구 장충동 8-22','문헌정보','N1','있음','010-5517-9400',34);
insert into trainee
values ('dpdpdh25','이덕형',26,'인천광역시 남구 도화동 12-2','기상정보','N2','있음','010-5833-1162',34);
insert into trainee
values ('ohmy1443','윤정호',28,'서울시 광진구 화양동 11-2','소프트웨어',default,'있음','010-3414-7173',34);
insert into trainee
values ('tbko211','구본영',26,'서울시 강남구 대치동 44-7','경영','N1','있음','010-3563-9113',34);
insert into trainee
values ('molka443','서진식',27,'인천광역시 서구 신현동 15-9','시각디자인','N2',default,'010-1933-2262',34);
insert into trainee
values ('abbu11','주서현',25,'서울시 광진구 자양동 65-2','의상디자인','N1',default,'010-6331-1125',34);
insert into trainee
values ('moodnot','이진아',29,'서울시 마포구 공덕동 7-9','제약행정','N2','있음','010-6933-9613',34);
insert into trainee
values ('slipknot','김주현',27,'성남시 중원구 갈현동 75-29','사회복지',default,default,'010-5623-4462',34);
insert into trainee
values ('jhkim244','강미지',26,'서울시 강남구 삼성동 33-7','스페인어',default,'있음','010-2668-4211',34);
insert into trainee
values ('meddot455','서준한',27,'서울시 광진구 구의동 21-2','국제통상','N2','있음','010-4623-1182',34);
insert into trainee
values ('apple335','전명철',25,'서울시 강남구 삼성동 61-3','문헌정보','N1',default,'010-1154-9335',34);


insert into professor
values ('1003','김상식',39,'IT','B');
insert into professor
values ('1004','서지원',31,'IT','D');
insert into professor
values ('1005','박종원',34,'IT','E');
insert into professor
values ('1006','구혜성',29,'IT','C');
insert into professor
values ('2003','노모 히데오',39,'일본어','중');
insert into professor
values ('2004','타키시타 소타로',39,'일본어','고');
insert into professor
values ('2005','아베 미호',29,'일본어','고');
insert into professor
values ('2006','사사키 하츠미',34,'일본어','초');
insert into professor
values ('2007','사에 키쿠치',28,'일본어','초');
insert into professor
values ('2008','타카하시 마유',30,'일본어','중');
insert into professor
values ('2009','키쿠타니 미츠키',39,'일본어','고');
insert into professor
values('9999','김학사',27,'학사','없음');
insert into professor
values ('1003','김상식',39,'IT','B');
insert into professor
values ('1004','서지원',31,'IT','D');
insert into professor
values ('1005','박종원',34,'IT','E');
insert into professor
values ('1006','구혜성',29,'IT','C');
insert into professor
values ('2003','노모 히데오',39,'일본어','중');
insert into professor
values ('2004','타키시타 소타로',39,'일본어','고');
insert into professor
values ('2005','아베 미호',29,'일본어','고');
insert into professor
values ('2006','사사키 하츠미',34,'일본어','초');
insert into professor
values ('2007','사에 키쿠치',28,'일본어','초');
insert into professor
values ('2008','타카하시 마유',30,'일본어','중');
insert into professor
values ('2009','키쿠타니 미츠키',39,'일본어','고');
insert into professor
values(1001,'오태진',42,'IT','C');
insert into professor
values(1002,'한상준',32,'IT','A');
insert into professor
values(2001,'미우라 마이코',37,'일본어','중');
insert into professor
values(2002,'오자와 세나',31,'일본어','초');

insert into professor
values('9999','김학사',27,'학사','없음');


insert into mark(id)
select id from trainee;

insert into manage(id)
select id from trainee;

insert into class(id)
select id from trainee;



update class
set jpcls='고급'
where id in(select id from trainee where jlpt='N1');

update class
set jpcls='중급'
where id in(select id from trainee where jlpt='N2'or jlpt='N3');

update class
set jpcls='초급'
where id in(select id from trainee where jlpt='없음'or jlpt='N4');
--JLPT N1부터 무급의 학생들의 ID를 CLASS에 옮김 


update mark 
set FIRSTTESTJP=round(DBMS_RANDOM.value(80,99))
where id in(select id from class where jpcls='고급');

update mark
set FIRSTTESTJP=round(DBMS_RANDOM.value(71,85))
where id in(select id from class where jpcls='중급');

update mark 
set FIRSTTESTJP=round(dbms_random.value(71,80))
where id in(select id from class where jpcls='초급');
--고급부터 초급까지 모든 인원의 1차 일본어 역량평가 성적을 난수를 생성하여 입력.
--(고급 : 최저 80점, 최고 99점 중급 : 최저 70점, 최고 85점 초급 : 최저 70점, 최고 80점)

