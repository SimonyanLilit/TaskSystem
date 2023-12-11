create table management_system.user
(
    user_id    UUID primary key   not null,
    first_name varchar(256),
    last_name  varchar(256),
    email      varchar(160) unique not null,
    password   varchar(160)
);
