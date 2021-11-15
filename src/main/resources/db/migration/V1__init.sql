create table public.rating
(id int8 generated by default as identity,
date date,
name varchar(255),
position int4,
rating varchar(255),
vote_count varchar(255),
primary key (id));