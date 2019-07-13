insert into Book (ISBN, title, author, price) values ('978-0-306-40615-7', 'TITLE1', 'Author1', 100);
insert into Book (ISBN, title, author, price) values ('978-0-306-40615-7', 'TITLE2', 'Author2', 200);
insert into Book (ISBN, title, author, price) values ('978-0-306-40615-7', 'TITLE3', 'Author3', 300);
insert into Book (ISBN, title, author, price) values ('978-0-306-40615-7', 'TITLE4', 'Author4', 400);
insert into Book (ISBN, title, author, price) values ('978-0-306-40615-7', 'TITLE5', 'Author5', 400);

insert into Authority (id, `name`, request_method, link) values (1, 'css', null, '/**/*.css');
insert into Authority (id, `name`, request_method, link) values (2, 'books_get', 'GET', '/books');
insert into Authority (id, `name`, request_method, link) values (3, 'books_*', null, '/books/**');

insert into Role (id, `name`, importance) values (1, 'USER', 0);
insert into Role (id, `name`, importance) values (2, 'ADMIN', 100);

insert into `User` (id, username, password) values (1, 'user', '123');
insert into `User` (id, username, password) values (2, 'admin', '123');

insert into Role_Authority (role_id, authority_id) values (1, 1);
insert into Role_Authority (role_id, authority_id) values (1, 2);
insert into Role_Authority (role_id, authority_id) values (2, 3);

insert into User_Role (role_id, user_id) values (1, 1);
insert into User_Role (role_id, user_id) values (1, 2);
insert into User_Role (role_id, user_id) values (2, 2);

