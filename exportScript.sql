drop table if exists companys;
drop table if exists hibernate_sequence;
drop table if exists orders;
drop table if exists positions;
drop table if exists rols;
drop table if exists sectors;
drop table if exists users;
create table companys (id bigint not null, create_at date, description varchar(255), name varchar(255), update_at date, address varchar(255), web varchar(255), id_sector bigint, primary key (id))  ;
create table hibernate_sequence (next_val bigint)  ;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table orders (id bigint not null, create_at date, update_at date, complete bit, date_finish date, date_Init date, description varchar(255), title varchar(255), id_user bigint, primary key (id))  ;
create table positions (id bigint not null, description varchar(255), name varchar(255), primary key (id))  ;
create table rols (id bigint not null, description varchar(255), name varchar(255), primary key (id))  ;
create table sectors (id bigint not null, description varchar(255), name varchar(255), primary key (id))  ;
create table users (id bigint not null, create_at date, update_at date, activated bit, email varchar(255), name varchar(255), password varchar(255), path_photo varchar(255), surname varchar(255), id_company bigint, id_position bigint, id_rol bigint, primary key (id))  ;
alter table companys add constraint FKhed7vyw876s7folkcgioqlsx4 foreign key (id_sector) references sectors (id);
alter table orders add constraint FKtb6jdc061vu6ydv1445lrigtb foreign key (id_user) references users (id);
alter table users add constraint FKa3e8swm0tyre9c528f7yr64nw foreign key (id_company) references companys (id);
alter table users add constraint FKrg3ytgr4df78ccddrjyr6l169 foreign key (id_position) references positions (id);
alter table users add constraint FKs5iqcyjr6uv576cd5wqcgnjjl foreign key (id_rol) references rols (id);