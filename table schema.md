## Tables for Store:
#### users
1. user_id (Primary key)
1. user_role(varchar 20 unique)
1. user_email (varchar 50 unique) 
1. user_fname (varchar 30 not null)
1. user_midInnitial (varchar 5 not null)
1. user_lname (varchar 30 not null)
1. user_street (varchar 20 not null)
1. user_zip (number)
1. user_city (varchar 30)
1. user_state (varchar 10)
1. user_username(varchar 15 unique not null)
1. user_password (varchar 20)

#### Group
1. Group_id (primary key, auto_increment)
1. Group_name
1. user_id (foreign key)


#### group_contents (many to many)
1. Group_id (foreign key)
1. Product_id (foreign key)

#### Products
1. Product_id (primary key, auto_increment)
1. Product_name
1. Category_id (foreign key)
1. Product_price
1. Product_quantity
1. User_id (vendor)
1. product_url

#### Categories
1. Category_id (primary key)
1. Category_name

#### Comments
1. Comment_id (primary key)
1. Product_id (foreign key)
1. User_id (foreign key)
1. Comment

#### QA
1. QA_id (primary key)
1. Product_id (foreign key)
1. User_id (foreign key)
1. Qa_question
1. qa_answer
