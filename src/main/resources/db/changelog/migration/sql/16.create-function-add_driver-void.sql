create function add_driver(first_namep character varying, surnamep character varying) returns void
    language sql
    as
$$
insert into drivers(first_name,surname) values (first_nameP, surnameP);
$$;

alter function add_driver(varchar, varchar) owner to postgres;

