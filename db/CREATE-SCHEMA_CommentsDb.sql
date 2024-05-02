create database manage_comments;
CREATE USER 'CommentsDbuser1'@'%' IDENTIFIED BY 'ChangeMe';
GRANT ALL PRIVILEGES ON manage_comments.*  TO 'CommentsDbuser1'@'%';
use manage_comments;