create table bookings
(
    id            bigserial primary key,
    user_id       int8 references users (id),
    transport_id  int8 references transports (id) on delete cascade,
    address_id    int8 references addresses (id),
    booking_date  timestamp without time zone,
    delivery_date timestamp without time zone
)