create database digilearn;

use digilearn;

create table digilearn.employee ( EmployeeID int primary key,
							   EmployeeName varchar(255) not null,                           
							   EmployeeSkills varchar(255) not null);
                                  
						
create table digilearn.project (	ProjectId int PRIMARY KEY,
								EmployeeID int not null,
								ProjectRequirements VARCHAR(255) NOT NULL,
								FOREIGN KEY (EmployeeID)
								REFERENCES employee (EmployeeID)
);

create table digilearn.course ( CourseNo int primary key AUTO_INCREMENT,
								CourseType varchar(255) not null, 
								CourseName varchar(255) not null,
								CourseLink varchar(255) not null
);
                                
								
insert into digilearn.course( CourseType,CourseName,CourseLink) values('databases','The Ultimate MySQL Bootcamp: Go from SQL Beginner to Expert ','https://www.udemy.com/course/the-ultimate-mysql-bootcamp-go-from-sql-beginner-to-expert/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('java','Java Programming Masterclass for Software Developers ','https://www.udemy.com/course/java-the-complete-java-developer-course/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('spring','Spring Framework 5: Beginner to Guru ','https://www.udemy.com/course/spring-framework-5-beginner-to-guru/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('java','Java Programming for Complete Beginners ','https://www.udemy.com/course/java-programming-tutorial-for-beginners/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('html','Learn HTML5 Programming From Scratch ','https://www.udemy.com/course/learn-html5-programming-from-scratch/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('jsp','Servlets and JSPs Tutorial: Learn Web Applications With Java ','https://www.udemy.com/course/javawebtut/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('databases','Learn Database common with MySQL ','https://www.udemy.com/course/learn-database-common-with-mysql/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('spring','Spring Framework Master Class - Java Spring the Modern Way ','https://www.udemy.com/course/spring-tutorial-for-beginners/');	
insert into digilearn.course( CourseType,CourseName,CourseLink) values('cybersecurity','The Complete Cyber Security Course : Network Security!','https://www.udemy.com/course/network-security-course/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('cybersecurity','The Complete Cyber Security Course : Hackers Exposed!','https://www.udemy.com/course/the-complete-internet-security-privacy-course-volume-1/');
insert into digilearn.course( CourseType,CourseName,CourseLink) values('python','Complete Python Bootcamp From Zero to Hero in Python','https://www.udemy.com/course/complete-python-bootcamp/');


insert into digilearn.employee values(1,"Kushal","java,databases");
insert into digilearn.employee values(2,"Shubham","java");
insert into digilearn.employee values(3,"Mohan","databases");
insert into digilearn.employee values(4,"Rohit","java,databases,spring");
insert into digilearn.employee values(5,"Manohar","java,spring");         
insert into digilearn.employee values(6,"Abhishek","java,databases,spring");
insert into digilearn.employee values(7,"Parth","java,spring");            


insert into digilearn.project values(1,1,'java');
insert into digilearn.project values(2,2,'databases');
insert into digilearn.project values(3,3,'spring');
insert into digilearn.project values(4,4,'java,databases');
insert into digilearn.project values(5,5,'java,databases,spring');
insert into digilearn.project values(6,6,'html,java,databases,spring');
insert into digilearn.project values(7,7,'html,java,databases');            
								
