create table public.rating
(
    id         bigserial primary key,
    date       timestamp,
    name       varchar(255),
    position   int4,
    rating     varchar(255),
    vote_count varchar(255)
);