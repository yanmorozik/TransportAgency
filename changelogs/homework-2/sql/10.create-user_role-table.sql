create table user_role
(
    user_id int8 references users (id),
    role_id int8 references roles (id)
)