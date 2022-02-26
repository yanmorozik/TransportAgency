create procedure insert_user_data()
    language sql
    as
$$
INSERT INTO users (first_name, surname, telephone, email)
values ('testP','testP','testP','testP')
$$;

alter procedure insert_user_data() owner to postgres;

