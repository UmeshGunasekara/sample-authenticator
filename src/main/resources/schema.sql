DROP TABLE IF EXISTS sa_user;

CREATE TABLE sa_user (
    user_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(250) NULL,
    last_name VARCHAR(250) NULL,
    email VARCHAR(100) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    password VARCHAR(250) NOT NULL,
    reset_token VARCHAR(32) NULL,
    create_date_time TIMESTAMP NOT NULL,
    update_date_time TIMESTAMP NOT NULL,
    PRIMARY KEY  (user_id),
    UNIQUE KEY uk_sa_user_user_name (user_name),
    UNIQUE KEY uk_sa_user_email (email)
);

CREATE INDEX ix_sa_user_a_user_name_password ON sa_user (user_name, password);