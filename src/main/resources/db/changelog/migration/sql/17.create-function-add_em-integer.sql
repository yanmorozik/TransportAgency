create function add_em(x integer, y integer) returns integer
    language sql
    as
$$
SELECT x + y;
$$;

alter function add_em(integer, integer) owner to postgres;

