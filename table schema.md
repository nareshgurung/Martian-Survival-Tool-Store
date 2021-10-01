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

#### group
> group_id (primary key, auto_increment)  
> group_name  
> user_id (foreign key)  


#### group_contents (many to many)
> group_id (foreign key)  
> product_id (foreign key)  

#### products
> product_id (primary key, auto_increment)  
> product_name  
> category_id (foreign key)  
> product_price  
> product_quantity  
> user_id (vendor)  
> product_url  

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
> product_id (foreign key)  
> user_id (foreign key)  
> qa_question  
> qa_answer  
