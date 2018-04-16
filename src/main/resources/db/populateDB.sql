
INSERT INTO role(role) VALUES ('ADMIN');
INSERT INTO role(role) VALUES ('USER');

INSERT INTO todo(name, status, creationDate) VALUES ('Maven Project','inProgress','2017');
INSERT INTO todo(name, status, creationDate) VALUES ('Gradle Project','todo','2019');
INSERT INTO todo(name, status, creationDate) VALUES ('Angular Project','done','2018');
INSERT INTO todo(name, status, creationDate) VALUES ('Java Project','inProgress','2018');

INSERT INTO users(name, password, email ,role_id) VALUES ('Ira','aaa','ira@gmail.com',1);
INSERT INTO users(name, password, email ,role_id) VALUES ('Ivan','bbb','ivan@gmail.com',2);
INSERT INTO users(name, password, email ,role_id) VALUES ('Sasha','ccc','sasha@gmail.com',1);
INSERT INTO users(name, password, email ,role_id) VALUES ('Vadim','ddd','vadim@gmail.com',2);
INSERT INTO users(name, password, email ,role_id) VALUES ('Ihor','eee','ihor@gmail.com',1);

INSERT INTO todo_priority(todo_id, priority_id) VALUES (1,1),(1,2),(2,1),(2,2),(3,1),(3,2),(3,3),(4,1),(4,3);
