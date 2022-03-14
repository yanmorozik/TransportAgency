create table addresses
(
    id        bigserial primary key,
    country   varchar(64),
    city      varchar(64),
    street    varchar(64),
    house     varchar(64),
    apartment int8
)