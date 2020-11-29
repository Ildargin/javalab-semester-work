create database semester_work;

create table users
(
    id serial primary key,
    first_name varchar(40),
    last_name  varchar(40),
    email      varchar(40),
    password   varchar(80),
    birth_date date
);


create table posts
(
    id serial primary key,
    post_title  varchar(70),
    post_text  varchar(1000),
    comment_text  varchar(200),
    image_source varchar(100),
    likes    int,
    dislikes int
);

create table comments
(
    comment_id serial primary key,
    user_id  int,
    post_id  int,
    comment_text  varchar(200),
    constraint users_fk foreign key(user_id) references users(id),
    constraint posts_fk foreign key(post_id) references posts(id)
);

