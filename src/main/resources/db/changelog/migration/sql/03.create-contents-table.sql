create table contents
(
    id          bigserial primary key,
    count       int,
    weight      real,
    height      real,
    width       real,
    entity_name varchar(64)
)