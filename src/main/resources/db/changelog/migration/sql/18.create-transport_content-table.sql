create table transport_content(
    content_id int8 references contents(id),
    transport_id int8 references  transports(id)
);