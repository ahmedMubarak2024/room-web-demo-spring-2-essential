CREATE TABLE ROOM
(
    ROOM_ID     BIGSERIAL PRIMARY KEY,
    NAME        VARCHAR(16) NOT NULL,
    ROOM_NUMBER CHAR(2)     NOT NULL UNIQUE,
    BED_INFO    CHAR(2)     NOT NULL
);

CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID CHAR(36) PRIMARY KEY,
    FIRST_NAME  VARCHAR(64),
    LAST_NAME   VARCHAR(64),
    POSITION    VARCHAR(64)
);

CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  SMALLINT     NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);

CREATE UNIQUE INDEX ix_auth_username
    on authorities (username, authority);