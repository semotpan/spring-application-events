DROP TABLE IF EXISTS post;
CREATE TABLE post
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(50) NOT NULL,
    payload  VARCHAR NOT NULL
);

DROP TABLE IF EXISTS post_log;
CREATE TABLE post_log
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    issued_on TIMESTAMP NOT NULL,
    post_id   INT NOT NULL references post(id)
);