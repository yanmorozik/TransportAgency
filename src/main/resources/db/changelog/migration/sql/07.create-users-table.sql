create table users
(
    id            bigserial primary key,
    email         varchar(128),
    first_name    varchar(64),
    surname       varchar(64),
    password      varchar (255),
    role          varchar (20) default 'USER',
    status        varchar(20) default 'ACTIVE',
    UNIQUE (email)
)