# Users schema

# --- !Ups

CREATE TABLE users (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    fullname varchar(255) NOT NULL,
    isAdmin boolean NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (email, password, fullname, isAdmin)
VALUES ("demouser@demodemo.fi", "demopass", "Demo User #1", 0);

INSERT INTO users (email, password, fullname, isAdmin)
VALUES ("demouser2@demodemo.fi", "demopass2", "Demo User #2", 0);


# --- !Downs

DROP TABLE users;