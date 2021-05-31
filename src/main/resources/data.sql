-- DROP TABLE IF EXISTS sa_user;
--
-- CREATE TABLE sa_user (
--   user_id INT NOT NULL AUTO_INCREMENT,
--   first_name VARCHAR(250) NOT NULL,
--   last_name VARCHAR(250) NOT NULL,
--   email VARCHAR(100) NOT NULL,
--   user_name VARCHAR(20) NOT NULL,
--   password VARCHAR(250) NOT NULL,
--   reset_token VARCHAR(30) NOT NULL,
--   PRIMARY KEY  (user_id),
--   UNIQUE KEY sa_user_user_name (user_name),
--   UNIQUE KEY sa_user_email (email)
-- );

INSERT INTO sa_user (first_name, last_name, email, user_name, password, reset_token, create_date_time, update_date_time) VALUES
  ('First 1', 'Last 1', 'first1@slmora.com', 'user1', 'user1', '1', '2021-05-30 00:00:01', '2021-05-30 00:00:01'),
  ('First 2', 'Last 2', 'first2@slmora.com', 'user2', 'user2', '2', '2021-05-30 00:00:01', '2021-05-30 00:00:01'),
  ('First 3', 'Last 3', 'first3@slmora.com', 'user3', 'user3', '3', '2021-05-30 00:00:01', '2021-05-30 00:00:01');