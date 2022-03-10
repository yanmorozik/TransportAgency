create materialized view driverstransports as
SELECT transports.license_plate AS number,
       drivers.first_name
FROM transports
         JOIN drivers ON transports.driver_id = drivers.id;

alter materialized view driverstransports owner to postgres;

