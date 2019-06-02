SELECT CURRENT_TIMESTAMP;
--CREATE SCHEMA rest;
----DROP TABLE IF EXISTS time_event;
--CREATE TABLE time_event (
--    id INTEGER PRIMARY KEY AUTOINCREMENT,
--    event_date_time DATETIME
--);
CREATE TABLE IF NOT EXISTS  time_event (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_date_time DATETIME
);
CREATE TABLE IF NOT EXISTS  weight_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    measured_value decimal(5,1) NOT NULL,
    measured_date_time DATETIME
);

CREATE TABLE IF NOT EXISTS  hero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);