create table transports
(
    id                   bigserial primary key,
    content_id           int8 references contents (id),
    driver_id            int8 references drivers (id),
    purpose_transport_id int8 references purposes_transport (id),
    type_transport_id    int8 references types_transport (id),
    license_plate        varchar(64),
    color                varchar(32),
    UNIQUE (license_plate)
)