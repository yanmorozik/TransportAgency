create view usersaddresses(name, city) as
SELECT users.first_name AS name,
       addresses.city
FROM bookings
         JOIN users ON bookings.user_id = users.id
         JOIN addresses ON bookings.address_id = addresses.id;

alter table usersaddresses
    owner to postgres;

