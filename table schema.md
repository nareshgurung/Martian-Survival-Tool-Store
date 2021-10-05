## tables for store:
#### users
> user_id (primary key)  
> user_role(int 10)  
> user_email (unique)  
> user_fname (varchar 30 not null)  
> user_midinnitial (varchar 1)  
> user_lname (varchar 30 not null)  
> user_street (varchar)  
> user_zip (number)  
> user_city (varchar 30)  
> user_state (varchar 2)  
> user_username(varchar 15 unique not null)  
> user_password (varchar 20 not null)  

#### groups
> group_id (primary key, auto_increment)  
> group_name  
> user_id (foreign key)  


#### group_contents (many to many)
> group_id (foreign key)  
> product_id (foreign key)  

#### products
> product_id (primary key, auto_increment)  
> product_name  
> product_price  
> product_quantity  
> product_url  
> user_id (vendor)  
> category_id (foreign key)  

#### categories
> category_id (primary key)  
> category_name  

#### comments
> comment_id (primary key)  
> product_id (foreign key)  
> user_id (foreign key)  
> comment  

#### qa
> qa_id (primary key)  
> qa_question  
> qa_answer  
> product_id (foreign key)  
> user_id (foreign key)  


### SQL commands used for building the database
> drop table comments  
> drop table group_contents  
> drop table groups  
> drop table qa  
> drop table products  
> drop table categories  
> drop table users  

> CREATE TABLE users (  
> 	user_id int(10) AUTO_INCREMENT,  
> 	user_role int(10) NOT NULL,  
> 	user_email varchar(60) NOT NULL UNIQUE,  
> 	user_fname varchar(30) not null,  
> 	user_midinnitial varchar(1),  
> 	user_lname varchar(30),  
> 	user_street varchar(30),  
> 	user_zip int(5),  
> 	user_city varchar(30),  
> 	user_state varchar(2),  
> 	user_username varchar(15) not null unique,  
> 	user_password varchar(20) not null,  
> 	CONSTRAINT table_pk PRIMARY KEY (user_id)  
> );  

> CREATE TABLE groups (  
> 	group_id int(10) PRIMARY KEY AUTO_INCREMENT,  
> 	group_name varchar(30) NOT NULL,  
> 	user_id int(10) NOT NULL,  
> 	CONSTRAINT `fk_user`  
> 		FOREIGN KEY (user_id) REFERENCES users (user_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE  
> 	);  

> CREATE TABLE group_contents (  
> 	group_id int(10) NOT NULL,  
> 	product_id int(100) NOT NULL,  
> 	CONSTRAINT `fk_group_id_group_contents`  
> 		FOREIGN KEY (product_id) REFERENCES products (product_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE,  
> 	CONSTRAINT `fk_product_id_group_contents`  
> 		FOREIGN KEY (group_id) REFERENCES groups (group_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE  
> );  

> CREATE TABLE products (  
> 	product_id int(100) PRIMARY KEY AUTO_INCREMENT,  
> 	product_name varchar(30) NOT NULL,  
> 	product_price double(20,2) NOT NULL,  
> 	product_quantity int(10),  
> 	product_url varchar(30),
> 	user_id int(10)NOT NULL,  
> 	category_id int(11) NOT NULL,  
> 	CONSTRAINT `fk_user_prod`  
> 		FOREIGN KEY (user_id) REFERENCES users (user_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE,  
> 	CONSTRAINT `fk_catid`  
> 		FOREIGN KEY (category_id) REFERENCES categories (category_id)  
v		ON DELETE CASCADE  
v		ON UPDATE CASCADE  
> );  

> CREATE TABLE categories (  
> 	category_id int AUTO_INCREMENT,  
> 	category_name varchar(30),  
> 	CONSTRAINT table_pk PRIMARY KEY (category_id)  
> 	);  
	
> CREATE TABLE comments (  
> 	comment_id int(10) primary key auto_increment,  
> 	product_id int(100) not null,  
> 	user_id int(10) not null,  
> 	comment varchar(300) NOT NULL,  
> 	CONSTRAINT `fk_product_id_comments`  
> 		foreign key (product_id) REFerences products (product_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE,  
> 	CONSTRAINT `fk_user_id_comments`  
> 		FOREIGN KEY (user_id) REFERENCES users (user_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE  
> );  

> CREATE TABLE qa (   
> 	qa_id int(10) primary key auto_increment,  
> 	qa_question varchar(300) not null,  
> 	qa_answer varchar(300),  
> 	product_id int(100) not null,  
> 	user_id int(10) not null,  
> 	CONSTRAINT `fk_user_id_qa`  
> 		FOREIGN KEY (user_id) REFERENCES users (user_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE,  
> 	CONSTRAINT `fk_product_id_qa`  
> 		FOREIGN KEY (product_id) REFERENCES products (product_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE  
> );  

> INSERT INTO categories (category_name) VALUES ('Drones');  
> INSERT INTO categories (category_name) VALUES ('Breathing Gear');  
> INSERT INTO categories (category_name) VALUES ('Prefabs');  
