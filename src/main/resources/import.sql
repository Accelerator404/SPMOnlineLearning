INSERT INTO Role (role_name) VALUES ("ROLE_ADMIN");
INSERT INTO Role (role_name) VALUES ("ROLE_STUDENT");
INSERT INTO Role (role_name) VALUES ("ROLE_TEACHER");

INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("admin@example.com","管理员","admin","1","admin","1");

INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student1@example.com","学生甲","student1","2","student1","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student2@example.com","学生乙","student2","3","student2","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student3@example.com","学生丙","student3","4","student3","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student4@example.com","学生丁","student4","5","student4","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student5@example.com","学生戊","student5","6","student5","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student6@example.com","学生己","student6","7","student6","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student7@example.com","学生庚","student7","8","student7","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student8@example.com","学生辛","student8","9","student8","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student9@example.com","学生壬","student9","10","student9","2");
INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("student10@example.com","学生癸","student10","11","student10","2");

INSERT INTO User (email,name,password_hash,phone_number,username,role_id) VALUES ("teacher1@example.com","老师甲","teacher1","12","teacher1","3");

INSERT INTO Student (user_id) VALUES ("2")
INSERT INTO Student (user_id) VALUES ("3")
INSERT INTO Student (user_id) VALUES ("4")
INSERT INTO Student (user_id) VALUES ("5")
INSERT INTO Student (user_id) VALUES ("6")
INSERT INTO Student (user_id) VALUES ("7")
INSERT INTO Student (user_id) VALUES ("8")
INSERT INTO Student (user_id) VALUES ("9")
INSERT INTO Student (user_id) VALUES ("10")
INSERT INTO Student (user_id) VALUES ("11")