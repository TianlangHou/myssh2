drop table if exists user;
CREATE TABLE user (
	id integer not null auto_increment,
    name varchar(40),
    password varchar(40),
    type integer,
    primary key(id)
)default charset utf8;

drop table if exists message;
CREATE TABLE message (
	id integer not null auto_increment,
    time datetime default NULL,
    content text,
    source integer,
    primary key(id)
)default charset utf8;