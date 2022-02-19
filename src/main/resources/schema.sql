CREATE TABLE EXPENSE(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    description varchar(100),
    date date,
    value decimal(10,2),
    category varchar(100)
);