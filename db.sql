create database semester_work;

create table users
(
    id serial primary key,
    first_name varchar(40),
    last_name  varchar(40),
    email      varchar(40) not null,
    image_path varchar(80) default 'https://picsum.photos/500',
    password   varchar(80) not null,
    birth_date date
);

create table posts
(
    id serial primary key,
    user_id int not null,
    post_title  varchar(70),
    post_text  varchar(1000),
    likes    int default 0,
    dislikes int default 0,
    constraint users_fk foreign key(user_id) references users(id)
);

create table comments
(
    comment_id serial primary key not null,
    user_id  int not null,
    post_id  int not null,
    comment_text  varchar(200) not null,
    constraint users_fk foreign key(user_id) references users(id),
    constraint posts_fk foreign key(post_id) references posts(id)
);
