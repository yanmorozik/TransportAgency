create procedure insert_user_data(first_namep character varying, surnamep character varying, telephonep character varying, emailp character varying)
    language sql
    as
$$
INSERT INTO users (first_name, surname, telephone, email)
VALUES (first_nameP, surnameP, telephoneP, emailP);
$$;

alter procedure insert_user_data(varchar, varchar, varchar, varchar) owner to postgres;

