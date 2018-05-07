--�������� ������ ���̺�
create table trainee(
id varchar2(20) constraint pk_trainee primary key
,name varchar2(40) not null
,age number(3) not null
,address varchar2(100) not null
,major varchar2(40) not null
,jlpt varchar2(20) default '����'
,eip varchar2(20) default '����'
,phone varchar(30)
,groupof number(3)
);
-- �������� IT��, �Ϻ��� ���� ����
create table class(
id varchar2(20) constraint class_id_fk references trainee on delete cascade
,itCls varchar2(1) 
,jpCls varchar2(10) 
);
-- �������� ������ ������ ����
create table mark(
id varchar2(20) constraint mark_id_fk references trainee on delete cascade -- Trainee ���̺��� id�� ����
,firstTestIT number(3) default 0
,firstTestJP number(3) default 0
,secondTestIT number(3) default 0
,secondTestJP number(3) default 0
,thirdTestIT number(3) default 0
,thirdTestJP number(3) default 0
);
-- �������� �л系���� ����
create table manage(
id varchar2(20) constraint manage_id_fk references trainee on delete cascade -- Trainee ���̺��� id�� ����
,late number(3) default 0
,leave number(3) default 0
,absent number(3) default 0
);
-- ������ ������ �����ϴ� ���̺�
create table professor(
id number(4) constraint professor_pnum_pk primary key
,name varchar(40) not null
,age number(3) not null
,subject varchar(20) not null
,cls varchar(20) not null --���� , IT�� A,B,C,D,E, �Ϻ���� ��/��/����� ��
);
-- ����/�Ἦ�� ��û�ϰ� Ȯ���ϴ� ���̺�
create table excuse(
boardnum number
,id varchar2(40) 
,name varchar2(40) 
,content varchar2(400)
,hits number
,indate date
);
-- ����/�Ἦ ���̺��� ���� ������
create sequence boardsequ;

-- ��ü ������ ������ ���̺�
create table notice(
noticenum number
,content varchar2(400)
);

insert into trainee
values ('gutav','���¿�',28,'����� �������� 45-9','�濵',default,default,'010-6542-6321',34);
insert into trainee
values ('catholic','���Ｚ',24,'�λ�� ���� 25-4','����','N2',default,'010-8712-3742',34);
insert into trainee
values ('sasu3','������',23,'����� ������ 7-9','�����й̵��','N1','����','010-9765-1110',34);
insert into trainee
values ('john1','���³�',25,'��⵵ ������','�ɸ���','N2',default,'010-8473-1324',34);
insert into trainee
values ('tibery13','��ü��',30,'����� ����� 14-7','ö��','N3','����','010-9791-2354',34);
insert into trainee
values ('bangbang23','����ö',25,'����� �߶���','�����','N2','�ʱ�','010-5110-0473',34);
insert into trainee
values ('hypo45','������',26,'��õ������ ���� ��ȭ�� 12-2','����Ʈ�����Ͼ����','N2','����','010-7741-8824',34);
insert into trainee
values ('nigire21','�輼��',23,'����� ���ı�','�߾��߹�','N2','�ʱ�','010-9841-1332',34);
insert into trainee
values ('singer34','������',26,'����� ������ ','������',default,default,'010-1104-8913',34);
insert into trainee
values ('minong56','�����',25,'��⵵ ������','��������','N1','����','010-9999-1320',34);
insert into trainee
values ('henry651','���缭',25,'����� ���빮��','��¡��ɸ�','N1','�ʱ�','010-8712-1365',34);
insert into trainee
values ('nokrules3','�ִ���',29,'����� ������ ','�����','N2',default,'010-6163-1644',34);
insert into trainee
values ('freedman14','���ڿ�',27,'��⵵ ������','����','N1',default,'010-9611-0187',34);
insert into trainee
values ('akino342','�̱Կ�',28,'����� ������','�Ҿ�ҹ�',default,'����','010-7777-2222',34);
insert into trainee
values ('mccathy14','������',31,'����� ����','�������','N1',default,'010-9846-8722',34);
insert into trainee
values ('dlser24','������',20,'����� ������ �Ｚ��','��������','N1',default,'010-4156-7113',34);
insert into trainee
values ('basketcase134','���ֿ�',24,'����� ���۱�','�����','N3','����','010-6132-1173',34);
insert into trainee
values ('sergiour554','���¿�',22,'����� ���α�','����','N1',default,'010-7192-1030',34);
insert into trainee
values ('ulala34','������',29,'��⵵ ��õ��','������','N2',default,'010-1651-1873',34);
insert into trainee
values ('paul29','������',25,'��⵵ ��õ��','�Ƶ��ɸ�','N2',default,'010-7813-3365',34);
insert into trainee
values ('josep14','�ֿ伷',30,'����� ��õ��','����â��',default,'����','010-9841-7778',34);
insert into trainee
values ('gogomi34','�����',25,'����� ���Ǳ�','����',default,default,'010-9841-1507',34);
insert into trainee
values ('thekwan4','����ȯ',21,'��⵵ ���ν�','�Ͼ��Ϲ�','N1',default,'010-5557-8888',34);
insert into trainee
values ('deseyo155','�̴��',20,'����� ������','����Ʈ����',default,'����','010-6511-0047',34);
insert into trainee
values ('edward553','���ָ�',26,'����� ������','����',default,default,'010-7854-2214',34);
insert into trainee
values ('albert534','���ü�',27,'��⵵ ���ý�','��ġ��','N2','�ʱ�','010-7781-2774',34);
insert into trainee
values ('hooker53','��ȣö',27,'����� ���ϱ�','��ȸü��','N3','�ʱ�','010-3347-1473',34);
insert into trainee
values ('ludovika43','������',29,'����� ����','��Ƽ','N4',default,'010-6178-1101',34);
insert into trainee
values ('pissaro234','������',23,'��⵵ �Ⱦ��','��ȸ����','N1','�ʱ�','010-1147-4711',34);
insert into trainee
values ('nicolas453','�Ӻ���',26,'����� ���α� ','�ε���',default,'����','010-8741-7715',34);
insert into trainee
values ('rions3','�����',33,'����� ���빮��','��ġ�ܱ�','N2','�ʱ�','010-9771-7741',34);
insert into trainee
values ('supersupport43','������',27,'����� ������','����','N3',default,'010-6516-7712',34);
insert into trainee
values ('akb48love','�豲��',24,'����� ���α� ������ 45-9','��ȭ�纸��','N1',default,'010-1552-2442',34);
insert into trainee
values ('zzamgirl','���ָ�',27,'��õ�� ��õ�� 9-24','��Ƽ�̵��',default,'����','010-2473-3195',34);
insert into trainee
values ('mojito44','�Ȼ�',29,'������ �߿��� �߾ӵ� 11-9','�ǻ�','N1',default,'010-1558-3672',34);
insert into trainee
values ('beyond115','������',25,'����� �߶��� ��񺻵� 5-19','������',default,default,'010-7523-8122',34);
insert into trainee
values ('lott204','�ο���',29,'����� ���빮�� ��ȭ�� 11-7','�濵','N2','�ʱ�','010-1225-6455',34);
insert into trainee
values ('dutu442','������',28,'����� ������ ������ 8-22','���������','N2','�ʱ�','010-5517-9400',34);
insert into trainee
values ('jpdack55','�̾���',28,'��õ������ ��籸 ������ 2-12','�ؾ�','N1','�ʱ�','010-5711-5452',34);
insert into trainee
values ('odin143','������',26,'����� ���ʱ� ���絿 11-2','����Ʈ����',default,'����','010-3414-7173',34);
insert into trainee
values ('jobs','������',30,'������ �߿��� ���̵� 44-10','�Ȱ汤��','N1','�ʱ�','010-5517-4323',34);
insert into trainee
values ('catsy103','�̵���',27,'����� �������� �ű浿 6-29','��ȸü��','N2',default,'010-6933-2518',34);
insert into trainee
values ('abubu','������',25,'����� ������ �ھ絿 66-5','��ȣ��','N2','�ʱ�','010-4031-0047',34);
insert into trainee
values ('friends220','������',26,'����� ����� �ϰ赿 11-9','��������',default,'����','010-6511-1143',34);
insert into trainee
values ('cheap331','����ö',30,'������ ��ȱ� ������ 7-9','��Ƽ�̵��',default,'�ʱ�','010-5144-4122',34);
insert into trainee
values ('jdons22','������',26,'����� ���۱� ��絿 31-22','��������','N2','����','010-2668-4211',34);
insert into trainee
values ('sulgi55','������',27,'����� ������ û�㵿 21-2','����','N1','����','010-1883-5242',34);
insert into trainee
values ('petit11','������',28,'����� ������ �Ｚ�� 15-3','�̼���','N2','�ʱ�','010-1054-5115',34);
insert into trainee
values ('orkid113','����',29,'������ �ȴޱ� ���� 11-9','������','N1','����','010-9324-2212',34);
insert into trainee
values ('apep1202','���ѿ�',25,'���������� �߱� ���ﵿ 25-4','ö��',default,'����','010-5012-6115',34);
insert into trainee
values ('mark153','������',29,'������ ���۱� �Ŵ�浿 11-9','�̵���','N2','�ʱ�','010-1965-8642',34);
insert into trainee
values ('cho1033','������',24,'����� ���ı� ���̵� 24-7','���ڰ���','N2','�ʱ�','010-7053-2218',34);
insert into trainee
values ('mecha140','������',25,'����� ������ ����� 15-8','����Ʈ����',default,'����','010-3425-1485',34);
insert into trainee
values ('tommy336','������',25,'����� ������ �б����� 11-2','�װ���','N1','����','010-3007-9140',34);
insert into trainee
values ('eric1733','������',26,'��õ������ ������ ������ 10-42','��ȸ����','N2','�ʱ�','010-5876-2462',34);
insert into trainee
values ('zenith43','����',27,'����� ���빮�� ȫ���� 41-2','��������',default,'����','010-3414-7333',34);
insert into trainee

values ('kogeek211','ȫ����',25,'����� �������� ��굿 40-7','�濵','N1','����','010-6343-1913',34);
insert into trainee
values ('kadin401','���ֿ�',26,'����� ���α� �Ұ��� 7-19','�ð�������',default,'�ʱ�','010-6423-2102',34);
insert into trainee
values ('music606','���ؿ�',28,'����� ������ �Ｚ�� 65-2','��ȸ����','N2','�ʱ�','010-2431-6825',34);
insert into trainee
values ('mymi995','������',27,'������ �д籸 ���ڵ� 10-9','��������','N1',default,'010-5433-8315',34);
insert into trainee
values ('wowbee705','���ؿ�',26,'����� ���ı� ��ǵ� 22-9','��ȸ����',default,default,'010-2123-3062',34);
insert into trainee
values ('jhr244','������',26,'����� ������ �Ｚ�� 33-7','�۷ι��濵','N1','����','010-2026-6231',34);
insert into trainee
values ('anamorp105','������',32,'������ ��ȱ� �󱤱��� 10-12','����','N2','����','010-3044-1872',34);
insert into trainee
values ('champ805','������',25,'����� ������ �Ｚ�� 17-9','�����Ʈ',default,'�ʱ�','010-4017-2316',34);
insert into trainee
values ('ordinal225','���ر�',29,'������ �д籸 �ݰ 21-5','ȸ��','N1','����','010-1022-8747',34);
insert into trainee
values ('ost188','���ر�',28,'����� �������� ���ǵ��� 9-29','��������','N2','�ʱ�','010-4005-4683',34);
insert into trainee
values ('drived002','������',31,'��õ�� ������ 105-7','�濵','N2','����','010-8863-4261',34);
insert into trainee
values ('mobst55','������',29,'����� ��õ�� ���굿 8-30','��Ƽ�̵��','N2',default,'010-2274-6872',34);
insert into trainee
values ('wjjw8855','�տ���',24,'����� ��걸 �ѳ��� 17-9','��������',default,'�ʱ�','010-2033-4472',34);
insert into trainee
values ('akakim','������',27,'����� ���α� �� 45-9','�ð�������','N2',default,'010-3433-5662',34);
insert into trainee
values ('sooa1022','�ּ���',24,'���ֱ����� ������ ������ 25-4','�Ƿ�����',default,default,'010-4173-3385',34);
insert into trainee
values ('dhtkddn','�����',29,'������ �д籸 �ݰ 7-9','�̵���','N1','����','010-9915-6642',34);
insert into trainee
values ('ahnd103','������',25,'������ ��⺻�� 15-9','�ڵ�������','N2',default,'010-7523-8122',34);
insert into trainee
values ('mode220','���ö',30,'����� ���빮�� �̹��� 14-7','���ڰ���',default,'����','010-1225-6455',34);
insert into trainee
values ('headycool','�ϼ���',25,'����� �߱� ���浿 8-22','��������','N1','����','010-5517-9400',34);
insert into trainee
values ('dpdpdh25','�̴���',26,'��õ������ ���� ��ȭ�� 12-2','�������','N2','����','010-5833-1162',34);
insert into trainee
values ('ohmy1443','����ȣ',28,'����� ������ ȭ�絿 11-2','����Ʈ����',default,'����','010-3414-7173',34);
insert into trainee
values ('tbko211','������',26,'����� ������ ��ġ�� 44-7','�濵','N1','����','010-3563-9113',34);
insert into trainee
values ('molka443','������',27,'��õ������ ���� ������ 15-9','�ð�������','N2',default,'010-1933-2262',34);
insert into trainee
values ('abbu11','�ּ���',25,'����� ������ �ھ絿 65-2','�ǻ������','N1',default,'010-6331-1125',34);
insert into trainee
values ('moodnot','������',29,'����� ������ ������ 7-9','��������','N2','����','010-6933-9613',34);
insert into trainee
values ('slipknot','������',27,'������ �߿��� ������ 75-29','��ȸ����',default,default,'010-5623-4462',34);
insert into trainee
values ('jhkim244','������',26,'����� ������ �Ｚ�� 33-7','�����ξ�',default,'����','010-2668-4211',34);
insert into trainee
values ('meddot455','������',27,'����� ������ ���ǵ� 21-2','�������','N2','����','010-4623-1182',34);
insert into trainee
values ('apple335','����ö',25,'����� ������ �Ｚ�� 61-3','��������','N1',default,'010-1154-9335',34);


insert into professor
values ('1003','����',39,'IT','B');
insert into professor
values ('1004','������',31,'IT','D');
insert into professor
values ('1005','������',34,'IT','E');
insert into professor
values ('1006','������',29,'IT','C');
insert into professor
values ('2003','��� ������',39,'�Ϻ���','��');
insert into professor
values ('2004','ŸŰ��Ÿ ��Ÿ��',39,'�Ϻ���','��');
insert into professor
values ('2005','�ƺ� ��ȣ',29,'�Ϻ���','��');
insert into professor
values ('2006','���Ű ������',34,'�Ϻ���','��');
insert into professor
values ('2007','�翡 Ű��ġ',28,'�Ϻ���','��');
insert into professor
values ('2008','Ÿī�Ͻ� ����',30,'�Ϻ���','��');
insert into professor
values ('2009','Ű��Ÿ�� ����Ű',39,'�Ϻ���','��');
insert into professor
values('9999','���л�',27,'�л�','����');
insert into professor
values ('1003','����',39,'IT','B');
insert into professor
values ('1004','������',31,'IT','D');
insert into professor
values ('1005','������',34,'IT','E');
insert into professor
values ('1006','������',29,'IT','C');
insert into professor
values ('2003','��� ������',39,'�Ϻ���','��');
insert into professor
values ('2004','ŸŰ��Ÿ ��Ÿ��',39,'�Ϻ���','��');
insert into professor
values ('2005','�ƺ� ��ȣ',29,'�Ϻ���','��');
insert into professor
values ('2006','���Ű ������',34,'�Ϻ���','��');
insert into professor
values ('2007','�翡 Ű��ġ',28,'�Ϻ���','��');
insert into professor
values ('2008','Ÿī�Ͻ� ����',30,'�Ϻ���','��');
insert into professor
values ('2009','Ű��Ÿ�� ����Ű',39,'�Ϻ���','��');
insert into professor
values(1001,'������',42,'IT','C');
insert into professor
values(1002,'�ѻ���',32,'IT','A');
insert into professor
values(2001,'�̿�� ������',37,'�Ϻ���','��');
insert into professor
values(2002,'���ڿ� ����',31,'�Ϻ���','��');

insert into professor
values('9999','���л�',27,'�л�','����');


insert into mark(id)
select id from trainee;

insert into manage(id)
select id from trainee;

insert into class(id)
select id from trainee;



update class
set jpcls='���'
where id in(select id from trainee where jlpt='N1');

update class
set jpcls='�߱�'
where id in(select id from trainee where jlpt='N2'or jlpt='N3');

update class
set jpcls='�ʱ�'
where id in(select id from trainee where jlpt='����'or jlpt='N4');
--JLPT N1���� ������ �л����� ID�� CLASS�� �ű� 


update mark 
set FIRSTTESTJP=round(DBMS_RANDOM.value(80,99))
where id in(select id from class where jpcls='���');

update mark
set FIRSTTESTJP=round(DBMS_RANDOM.value(71,85))
where id in(select id from class where jpcls='�߱�');

update mark 
set FIRSTTESTJP=round(dbms_random.value(71,80))
where id in(select id from class where jpcls='�ʱ�');
--��޺��� �ʱޱ��� ��� �ο��� 1�� �Ϻ��� ������ ������ ������ �����Ͽ� �Է�.
--(��� : ���� 80��, �ְ� 99�� �߱� : ���� 70��, �ְ� 85�� �ʱ� : ���� 70��, �ְ� 80��)

