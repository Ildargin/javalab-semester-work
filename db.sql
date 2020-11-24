create database semester_work;

create table "user"
(
    id serial primary key,
    first_name varchar(40),
    last_name  varchar(40),
    email      varchar(40),
    password   varchar(80),
    birth_date date
);


create table "post"
(
    id serial primary key,
    post_title  varchar(70),
    post_text  varchar(1000),
    comment_text  varchar(200),
    image_source varchar(100),
    likes    int,
    dislikes int
);

create table "comment"
(
    comment_id serial primary key,
    user_id  int,
    post_id  int,
    comment_text  varchar(200),
    constraint user_fk foreign key(user_id) references "user"(id),
    constraint post_fk foreign key(post_id) references post(id)
);

