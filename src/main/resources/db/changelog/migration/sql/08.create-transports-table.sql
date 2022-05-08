create table transports
(
    id                bigserial primary key,
    content_id        int8 references contents (id) on delete cascade,
    driver_id         int8 references drivers (id) on delete cascade,
    purpose_transport varchar(64),
    type_transport_id int8 references types_transport (id),
    license_plate     varchar(64),
    color             varchar(32),
    UNIQUE (license_plate)
)