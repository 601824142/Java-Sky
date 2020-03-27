drop table if exists `books`;
create table `books` (
  `id` int(11) not null auto_increment,
  `name` varchar(50) default null,
  `author` varchar(20) default null,
  `price` decimal(11,0) default null,
  `quantity` int(11) default '0',
  primary key  (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
insert into `books` values ('1', '水浒', '施耐庵', '188', '3');
insert into `books` values ('2', '计算机网络', '谢希仁', '49', '3');
insert into `books` values ('3', '计算方法', '严蔚敏', '58', '3');
insert into `books` values ('4', '计算方法习题集', '殷人昆', '188', '3');
insert into `books` values ('5', '数据库技术及应用', '王珊', '38', '3');
insert into `books` values ('6', '组合数学', '周伟', '28', '3');
insert into `books` values ('7', 'Redis初探', '周旭龙', '25', '3');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
drop table if exists `borrow`;
create table `borrow` (
  `pk` int(11) not null auto_increment,
  `cardId` int(11) default null,
  `bookId` int(11) default null,
  `returnDate` timestamp null default current_timestamp,
  primary key  (`pk`),
  unique key `pk` (`pk`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
insert into `borrow` values ('4', '1', '1', '2017-02-16 00:00:00');
insert into `borrow` values ('5', '2', '1', '2017-02-16 00:00:00');
insert into `borrow` values ('6', '3', '1', '2016-12-14 11:00:44');
insert into `borrow` values ('7', '4', '3', '2016-12-14 11:00:48');
insert into `borrow` values ('8', '4', '6', '2016-12-14 11:00:53');
insert into `borrow` values ('9', '5', '6', '2016-12-14 11:00:57');
insert into `borrow` values ('10', '7', '7', '2016-12-14 11:01:01');

-- ----------------------------
-- Table structure for cards
-- ----------------------------
drop table if exists `cards`;
create table `cards` (
  `id` int(11) not null auto_increment,
  `name` varchar(20) default null,
  `class` varchar(20) default null,
  primary key  (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of cards
-- ----------------------------
insert into `cards` values ('1', '张三', '计科一班');
insert into `cards` values ('2', '李四', '计科一班');
insert into `cards` values ('3', '王五', '计科二班');
insert into `cards` values ('4', '六四', '计科二班');
insert into `cards` values ('5', '七七', '软工一班');
insert into `cards` values ('6', '粑粑', '软工二班');

-- ----------------------------
-- Table structure for course
-- ----------------------------
drop table if exists `course`;
create table `course` (
  `courseNo` int(11) default null,
  `name` varchar(20) default null,
  `teacherNo` int(11) default null
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
insert into `course` values ('1', '语文', '1');
insert into `course` values ('2', '数学', '2');
insert into `course` values ('3', '英语', '3');
insert into `course` values ('4', '物理', '4');

-- ----------------------------
-- Table structure for fruits
-- ----------------------------
drop table if exists `fruits`;
create table `fruits` (
  `type` varchar(20) default null,
  `variety` varchar(20) default null,
  `price` double(15,3) default null
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of fruits
-- ----------------------------
insert into `fruits` values ('apple', 'gala', '2.790');
insert into `fruits` values ('apple', 'fuji', '0.240');
insert into `fruits` values ('apple', 'limbertwig', '2.870');
insert into `fruits` values ('orange', 'valencia', '3.590');
insert into `fruits` values ('orange', 'navel', '9.360');
insert into `fruits` values ('pear', 'bradford', '6.050');
insert into `fruits` values ('pear', 'bartlett', '2.140');
insert into `fruits` values ('cherry', 'bing', '2.550');
insert into `fruits` values ('cherry', 'chelan', '6.330');

-- ----------------------------
-- Table structure for score
-- ----------------------------
drop table if exists `score`;
create table `score` (
  `StudentNo` int(11) default null,
  `CourseNo` int(11) default null,
  `score` int(11) default null
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
insert into `score` values ('1', '2', '78');
insert into `score` values ('1', '3', '67');
insert into `score` values ('1', '4', '67');
insert into `score` values ('2', '1', '52');
insert into `score` values ('2', '2', '81');
insert into `score` values ('2', '3', '92');
insert into `score` values ('2', '4', '67');
insert into `score` values ('3', '1', '52');
insert into `score` values ('3', '2', '47');
insert into `score` values ('3', '3', '88');
insert into `score` values ('3', '4', '67');
insert into `score` values ('4', '2', '88');
insert into `score` values ('4', '3', '90');
insert into `score` values ('4', '4', '67');
insert into `score` values ('5', '1', '52');
insert into `score` values ('5', '3', '78');
insert into `score` values ('5', '4', '67');
insert into `score` values ('6', '1', '52');
insert into `score` values ('6', '2', '68');
insert into `score` values ('6', '4', '67');
insert into `score` values ('1', '1', '52');
insert into `score` values ('5', '2', '72');
insert into `score` values ('7', '2', '72');

-- ----------------------------
-- Table structure for student
-- ----------------------------
drop table if exists `student`;
create table `student` (
  `name` varchar(32) default null,
  `age` int(11) default null,
  `sex` varchar(8) default null,
  `studentNo` int(11) default null
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
insert into `student` values ('钱二', '19', '女', '2');
insert into `student` values ('刘一', '18', '男', '1');
insert into `student` values ('张三', '17', '男', '3');
insert into `student` values ('李四', '18', '女', '4');
insert into `student` values ('王五', '17', '男', '5');
insert into `student` values ('赵6', '19', '女', '6');
insert into `student` values ('钱二', '25', '男', '7');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
drop table if exists `teacher`;
create table `teacher` (
  `teacherNo` int(11) default null,
  `name` varchar(20) default null
) engine=innodb default charset=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
insert into `teacher` values ('1', '叶平');
insert into `teacher` values ('2', '贺高');
insert into `teacher` values ('3', '杨艳');
insert into `teacher` values ('4', '叶平');

（1）查询“001”课程比“002”课程成绩低的所有学生的学号、001学科成绩、002学科成绩
	#成绩表
	
	#找到即选择了001课程，也选择了002号课程的学生
	select t1.StudentNo, t1.score, t2.score from
	(select StudentNo, score from score where CourseNo = 1) t1
	join
	(select StudentNo, score from score where CourseNo = 2) t2
	on t1.StudentNo = t2.StudentNo where t1.score < t2.score
			

（2）查询平均成绩大于70分的同学的学号和平均成绩
	#成绩表	
	select studentNo, avg(score) from score 
		group by studentNo having avg(score) > 70


（3）查询所有同学的学号、姓名、选课数、总成绩
	#学生表、成绩表
	
	select s.studentNo, s.name, count(*) as '选课数', sum(sc.score) as '总成绩'
		from student s 
		join score sc 
		on s.studentNo = sc.studentNo
		group by s.studentNo

（4）查询姓“李”的老师的个数

（5）查询没学过“叶平”老师课的同学的学号、姓名
	#教师表、课程表、成绩表、学生表
	
	#查询叶平老师教过哪些课
	select courseNo from course where teacherNo in (
		select teacherNo from teacher where name = '叶平')
		
	#找到学过1 4号课程的学生
	select studentNo from score where courseNo in (
		select courseNo from course where teacherNo in (
		select teacherNo from teacher where name = '叶平')
	)	
	
	#对结果取反
	select studentNo, name from student where studentNo not in(	
		select studentNo from score where courseNo in (
			select courseNo from course where teacherNo in (
			select teacherNo from teacher where name = '叶平')
		)
	)

（6）查询学过“001”并且也学过编号“002”课程的同学的学号、姓名

	同第一题

（7）查询学过“叶平”老师所教的所有课的同学的学号、姓名

	#教师表、课程表、成绩表、学生表
	#查询叶平老师授课的数量
	select count(*) from course where teacherNo in (
	select teacherNo from teacher where name = '叶平')	
	
	#选择了叶平老师课程的学生以及选择叶平老师课程的数量
	select studentNo, count(*) from score where courseNo in(
		select courseNo from course where teacherNo in (
		select teacherNo from teacher where name = '叶平')
	) group by studentNo
	
	#学习叶平老师课程的学生学了叶平老师的几门课 -
	select studentNo, name from student where studentNo in (
		select studentNo from score where courseNo in(
			select courseNo from course where teacherNo in (
			select teacherNo from teacher where name = '叶平')
		) group by studentNo having count(*) = (
			select count(*) from course where teacherNo in (
			select teacherNo from teacher where name = '叶平')
		)
	)
	
（8）查询课程编号“002”的成绩比课程编号“001”课程低的所有同学的学号、姓名

	同第一题

（9）查询有课程成绩小于60分的同学的学号、姓名
	#成绩表、学生表
	
	select * from student where studentNo in(
		select studentNo from score where score < 60
	)	
	

（10）查询没有学全所有课的同学的学号、姓名
	#所有课程的数量
	#学生学过的课程数量 
	# 类似第7题

（11）查询至少有一门课与学号为“001”的同学所学相同的同学的学号和姓名
	#查询与刘一同学学过相同课程的学生学号和姓名
	
	#学生表、成绩表
	
	#001号学生选过的课程id
	select courseNo from score where studentNo = "1"
	
	#和这些课程id相同的学生信息
	select studentNo, name from student where studentNo in(
		select studentNo from score where courseNo in (
			select courseNo from score where studentNo = "1"
		) and studentNo != "1"
	)
	

（12）查询学过学号为“001”同学所有选课的其他同学学号和姓名
	#刘一 1 2 4 
	#王二 1 2 3 4 5
	#张三 1 2 5
	
	#成绩表 学生表
	
	#查询001号学生学过的所有课程
	select courseNo from score where studentNo = "1"
	
	#回表查询学过这些课程的所有学生编号
	select studentNo from score where courseNo in (
		select courseNo from score where studentNo = "1"
	) and studentNo != "1"		
	
	#计算和001号学生有交叉课程的数量
	select * from student where studentNo in(
		select studentNo from score where courseNo in (
			select courseNo from score where studentNo = "1"
		) and studentNo != "1" group by studentNo having count(*) = (
			select count(*) from score where studentNo = "1"
		)
	)

（13）把“score”表中“叶平”老师教的课的成绩都更改为此课程的平均成绩

	#教师表、成绩表、课程表
	
	update score sc1 set sc1.score = 
		(select avg(sc.score) from (select * from score) sc 
			group by sc.courseNo 
			having sc.courseNo = sc1.courseNo) where sc1.courseNo in (
		select courseNo from course where teacherNo in (
			select teacherNo from teacher where name = "叶平"
		)
	)		
	


（14）查询和“002”号的同学学习的课程完全相同的其他同学学号和姓名

（15）删除学习“叶平”老师课的SC表记录
	delete from score where courseNo in (
		#叶平老师授课的id
		select courseNo from course where teacherNo in (
			select teacherNo from teacher where name = "叶平"
		)
	)

（16）向SC表中插入一些记录，这些记录要求符合以下条件：
	1、没有上过编号“003”课程的同学学号；
	2、插入“002”号课程的平均成绩
	
	#1 没有上过3号课程的同学学号
	insert into score(studentNo)
	select distinct studentNo from score where studentNo not in(
		select studentNo from score where courseNo = 3
	)
	
	#2
	

（17）按学号由低到高显示所有学生的“语文”、“数学”、“英语”三门的课程成绩，按如下形式显示： 学生ID,语文,数学,英语,有效课程数,有效平均分

（18）查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分；

（19）按各科平均成绩从低到高和及格率的百分数从高到低顺序；

（20）查询不同老师所教不同课程平均分从高到低显示

（21）统计打印各科成绩，各分数段人数：课程ID，课程名称，(100-85)，(85-70)，(70-60)，( 低于60)
	# 课程id   课程名称    100-85   85-70   70-60  <60
	#  1        语文        2        5        1     0  
	
		
	#成绩表、课程表
	
	select c.courseNo as "课程id",
		c.name as "课程名称",
		ifnull((select count(*) from score sc 
		where sc.score <= 100 and sc.score > 85 
		group by sc.courseNo having sc.courseNo = c.courseNo),0) as "(100-85)" 
		from course c	
	
（22）查询各科成绩前三名的记录（不考虑成绩并列情况）
	#查询1号课程成绩的前三名 - 成绩表
	select * from score where courseNo = 1 order by score desc limit 3

	

（23）查询每门课程被选修的学生数

（24）查询出只选修了一门课程的全部学生的学号和姓名

（25）查询男生、女生的人数

（26）查询同名同姓学生名单，并统计同名人数

（27）查询1991年出生的学生名单
	select * from student where year(birthday) = 1991 


（28）查询每门课程的平均成绩，结果按平均成绩升序排列

（29）查询平均成绩大于85的所有学生的学号、姓名和平均成绩

（30）查询课程名称为“数学”，且分数低于60的学生姓名和分数

（31）查询所有学生的选课情况

（32）查询任何一门课程成绩在70分以上的姓名、课程名称和分数

（33）查询不及格的课程，并按课程号从大到小排列