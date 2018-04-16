CREATE TABLE priority
(
  id     BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  detail VARCHAR(50) NOT NULL
);

CREATE TABLE role
(
  id   BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  role VARCHAR(30) NOT NULL
);

CREATE TABLE todo
(
  id           BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  name         VARCHAR(50) NOT NULL,
  status       VARCHAR(30) NOT NULL,
  creationDate VARCHAR(30) NOT NULL
);

CREATE TABLE todo_priority
(
  id          BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  todo_id     BIGINT NOT NULL,
  priority_id BIGINT NOT NULL,
  CONSTRAINT FK7admh4algc2653brlyre9wq4n
  FOREIGN KEY (todo_id) REFERENCES todo (id),
  CONSTRAINT `todo-priority_todo_id_fk`
  FOREIGN KEY (todo_id) REFERENCES todo (id),
  CONSTRAINT FKtm9naey6wcj3dbq6la3ynfbuv
  FOREIGN KEY (priority_id) REFERENCES Priority (id),
  CONSTRAINT `todo-priority_priority_id_fk`
  FOREIGN KEY (priority_id) REFERENCES priority (id)
);

CREATE INDEX FK7admh4algc2653brlyre9wq4n
  ON todo_priority (todo_id);

CREATE INDEX FKtm9naey6wcj3dbq6la3ynfbuv
  ON todo_priority (priority_id);

CREATE TABLE users
(
  id       BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  name     VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  email    VARCHAR(50) NOT NULL,
  role_id  BIGINT      NOT NULL,
  CONSTRAINT FK4qu1gr772nnf6ve5af002rwya
  FOREIGN KEY (role_id) REFERENCES role (id),
  CONSTRAINT users_role_id_fk
  FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE INDEX FK4qu1gr772nnf6ve5af002rwya
  ON users (role_id);

CREATE TABLE users_todo
(
  id       BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  users_id BIGINT NOT NULL,
  todo_id  BIGINT NOT NULL,
  CONSTRAINT FKj9lmgq0vovyij5eg35fblpxh5
  FOREIGN KEY (users_id) REFERENCES users (id),
  CONSTRAINT users_todo_users_id_fk
  FOREIGN KEY (users_id) REFERENCES users (id),
  CONSTRAINT FKhhfycp8h7vvvh2c16ypwdu1a4
  FOREIGN KEY (todo_id) REFERENCES todo (id),
  CONSTRAINT users_todo_todo_id_fk
  FOREIGN KEY (todo_id) REFERENCES todo (id)
);

CREATE INDEX FKj9lmgq0vovyij5eg35fblpxh5
  ON users_todo (users_id);

CREATE INDEX FKhhfycp8h7vvvh2c16ypwdu1a4
  ON users_todo (todo_id);




