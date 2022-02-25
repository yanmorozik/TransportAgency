create table contents
(
    id          bigserial primary key,
    count       int,
    weight      int,
    height      int,
    width       int,
    entity_name varchar(64)
)