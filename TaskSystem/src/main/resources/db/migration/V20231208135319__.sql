create table management_system.task
(
    task_id    UUID primary key   not null,
    title varchar(256),
    description  varchar(256),
    status      varchar(16),
    priority      varchar(16),
    author_id   UUID,
    assignee_id   UUID
);
