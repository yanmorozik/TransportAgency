create table users
(
    id            bigserial primary key,
    credential_id int8 references credentials (id),
    first_name    varchar(64),
    surname       varchar(64),
    telephone     varchar(64),
    email         varchar(128)
)