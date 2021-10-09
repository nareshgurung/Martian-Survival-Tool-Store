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
> product_description
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
> 	group_contents_id int(10) PRIMARY KEY AUTO_INCREMENT,
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
> 	product_description varchar(300) NOT NULL,
> 	product_price double(20,2) NOT NULL,  
> 	product_quantity int(10),  
> 	product_url varchar(300),
> 	user_id int(10)NOT NULL,  
> 	category_id int(11) NOT NULL,  
> 	CONSTRAINT `fk_user_prod`  
> 		FOREIGN KEY (user_id) REFERENCES users (user_id)  
> 		ON DELETE CASCADE  
> 		ON UPDATE CASCADE,  
> 	CONSTRAINT `fk_catid`  
> 		FOREIGN KEY (category_id) REFERENCES categories (category_id)  
>		ON DELETE CASCADE  
>		ON UPDATE CASCADE  
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

> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "george.washington@pres.gov", "George", "T", "Washington", "1 Main Street", 22520, "Westmoreland", "VA", "presGeorge", "georgewashington");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (0, "vfilov0@ft.com", "Vitia", "S", "Filov", "286 Basil Park", 55588, "West Palm Beach", "FL", "vfilov0", "0lPoa1h");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "njorg1@businessinsider.com", "Noland", "X", "Jorg", "58 Killdeer Circle", 11376, "Cleveland", "OH", "njorg1", "IR6oe8GMy");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "kalbrook2@fastcompany.com", "Kalindi", "A", "Albrook", "23178 Vahlen Avenue", 66321, "Silver Spring", "MD", "kalbrook2", "ckPgUe");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (0, "bshearsby3@icq.com", "Barr", "M", "Shearsby", "9306 Hermina Junction", 45328, "Kansas City", "KS", "bshearsby3", "GnxP1pC8SiNO");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "ainseal4@theguardian.com", "Alfie", "M", "Inseal", "65206 La Follette Avenue", 38432, "Denver", "CO", "ainseal4", "7Gonz66KOO");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (0, "ascantlebury5@wix.com", "Armand", "T", "Scantlebury", "32 Commercial Road", 88026, "Canton", "OH", "ascantlebury5", "osRxYvHz");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (0, "cakess6@tripod.com", "Cindie", "A", "Akess", "708 Summer Ridge Hill", 87325, "Houston", "TX", "cakess6", "9lFFPaErqe7");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "cgooddie7@yolasite.com", "Corey", "F", "Gooddie", "83863 Lyons Trail", 33354, "Alexandria", "VA", "cgooddie7", "sjHENBB");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "rsutton8@t-online.de", "Rozalin", "L", "Sutton", "557 Red Cloud Place", 11143, "Syracuse", "NY", "rsutton8", "Q22Ekkd24");
> INSERT INTO users (user_role, user_email, user_fname, user_midinnitial, user_lname, user_street, user_zip, user_city, user_state, user_username, user_password) values (1, "mdracksford9@ning.com", "Marquita", "U", "Dracksford", "1 Carioca Junction", 88822, "Saginaw", "MI", "mdracksford9", "KSGBoYi9");

> INSERT INTO products values (112200, "Airborne Cargo MiniDrone", "Super Pro drone with 5K camera: anafi work is an ultra-compact device for all professionals. Its 5K HDR/ 21 MP Camera captures high-resolution aerial images with a unique 180° orientation, enabling you to inspect, monitor and film difficult-to-access areas.", 999.00, 12, "https://m.media-amazon.com/images/I/61Ne9wV9HGL._AC_SY450_.jpg", 2, 1);
> INSERT INTO products values (3451, "Holy Stone HS110D", "Pro drone with 4K camera: anafi work is an ultra-compact device for all professionals. Its 4K HDR/ 21 MP Camera captures high-resolution aerial images with a unique 180° orientation, enabling you to inspect, monitor and film difficult-to-access areas.", 568.00, 26, "https://m.media-amazon.com/images/I/712-lVMgXnL._AC_SY450_.jpg", 1, 1);
> INSERT INTO products values (127, "Holy Stone HS720", "Straightforward Operation: With the help of One-Key Start and Altitude Hold, the drone will take off and hover at a certain height. In the Headless Mode, you can operate the drone easily without the loss of direction. Emergency Stop can prevent most urgent situations.", 189.99, 12, "https://m.media-amazon.com/images/I/71z9yO2j3SL._AC_SY450_.jpg", 4, 1);
> INSERT INTO products values (9032, "Holy Stone 1080P", "Built for Adventure: The specially designed backpack can carry everything for HS120D, allows you to take this drone anywhere, incredibly convenient for travel and outdoor. Capture high definition footage ( 2048x1152p) and directly save to your smartphone.", 169.99, 38, "https://m.media-amazon.com/images/I/71FFOwK-zbL._AC_SX425_.jpg", 4, 1);
> INSERT INTO products values (621, "Holy Stone HS420", "The optimized full HD Camera built with Shock Absorption holder ensures shooting 3840 x 2160 high resolution images and videos without camera vibration. 5GHz FPV transmission and 90°adjustable lens enables you to see the word from different angle..", 289.99, 17, "https://m.media-amazon.com/images/I/71zjcoYtp5L._AC_SY450_.jpg", 9, 1);
> INSERT INTO products values (543, "FLOWTECH ABS V2", "FLOWTECH ADVANCED AIR INTAKE SYSTEM- Flowtech has two chambers and 4 intake valves to allow air to circulate in and out freely. Using one-way valves and a separate breathing chamber ensures fresh air is always circulating through the mask.", 69.99, 123, "https://m.media-amazon.com/images/I/71FytTVlZlL._AC_SY450_.jpg", 8, 2);
> INSERT INTO products values (7531, "Oxygen Plus – O+", "O+ restores depleted O2 levels to normal, healthy levels – on-demand. O+ compresses its pure, revitalizing oxygen in durable, recyclable aluminum canisters.", 49.99, 156, "https://m.media-amazon.com/images/I/71FFOwK-zbL._AC_SX425_.jpg", 8, 2);
> INSERT INTO products values (84123, "Drager Panorama Nova", "The Drager Panorama Nova is a full-face mask with an integrated relief valve system. The face mask has integral nose clips for pressure equalization. 3 connections ports offer individual configuration (P-Con regulator connection).", 889.99, 9, "https://m.media-amazon.com/images/I/81zIOJquieL._AC_SY450_.jpg", 7, 2);
