create view userscontents(first_name, surname, telephone, entity_name, count) as
SELECT users.first_name,
       users.surname,
       users.telephone,
       contents.entity_name,
       contents.count
FROM bookings
         LEFT JOIN users ON bookings.user_id = users.id
         LEFT JOIN transports ON bookings.transport_id = transports.id
         LEFT JOIN contents ON transports.content_id = contents.id;

alter table userscontents
    owner to postgres;

