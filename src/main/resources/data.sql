create table customer (id bigint not null auto_increment, active bit, active_date datetime, admin bit, de_active_date date, enable bit, password varchar(255), user_id varchar(255) not null, customer_detail_id bigint, primary key (id))
create table customer_refference (customer_id bigint not null, refference_refference_id bigint not null)
create table customer_details (id bigint not null auto_increment, email varchar(255), firstname varchar(255), gender varchar(255), lastname varchar(255), primary key (id))
create table mail (mailid bigint not null auto_increment, message varchar(255), send bit, subject varchar(255), tomail_id varchar(255), userid bigint, username varchar(255) not null, primary key (mailid))
create table refference (refference_id bigint not null auto_increment, name varchar(255), relation varchar(255), customer_id bigint, primary key (refference_id))
create table verification_token (id bigint not null auto_increment, created_date datetime, customer_id bigint, expiry_date datetime, status varchar(255), token varchar(255), updated_date datetime, primary key (id))
alter table customer add constraint UK_j7ja2xvrxudhvssosd4nu1o92 unique (user_id)
alter table customer_refference add constraint UK_bcmj6nxib8gd6g794cehyl7eu unique (refference_refference_id)
alter table customer add constraint FKmg8c7xndkp9jw2nwk51qwgm03 foreign key (customer_detail_id) references customer_details (id)
alter table customer_refference add constraint FKhjuc6uxkpjqagvxrhrf716fcj foreign key (refference_refference_id) references refference (refference_id)
alter table customer_refference add constraint FKeq9r6kvshlyu0t2rk67sq4iv5 foreign key (customer_id) references customer (id)
alter table refference add constraint FKl2be2xqkyn8q4r7ipmts4b3wj foreign key (customer_id) references customer (id)
