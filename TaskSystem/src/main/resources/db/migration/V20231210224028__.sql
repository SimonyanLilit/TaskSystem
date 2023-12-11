create table management_system.comments
(
    comment_id    UUID primary key not null,
    text varchar(256),
    task_id   UUID,
    user_id   UUID
);
