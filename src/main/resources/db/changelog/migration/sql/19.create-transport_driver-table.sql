create table transport_driver(
    driver_id int8 references drivers(id),
    transport_id int8 references  transports(id)
);