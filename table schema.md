## Tables for Store:
#### users
> user_id (Primary key)
> user_role(varchar 20 unique)
> user_email (varchar 50 unique) 
> user_fname (varchar 30 not null)
> user_midInnitial (varchar 5 not null)
> user_lname (varchar 30 not null)
> user_street (varchar 20 not null)
> user_zip (number)
> user_city (varchar 30)
> user_state (varchar 10)
> user_username(varchar 15 unique not null)
> user_password (varchar 20)

#### Group
> Group_id (primary key, auto_increment)
> Group_name
> user_id (foreign key)


#### group_contents (many to many)
> Group_id (foreign key)
> Product_id (foreign key)

#### Products
> Product_id (primary key, auto_increment)
> Product_name
> Category_id (foreign key)
> Product_price
> Product_quantity
> User_id (vendor)
> product_url

#### Categories
> Category_id (primary key)
> Category_name

#### Comments
> Comment_id (primary key)
> Product_id (foreign key)
> User_id (foreign key)
> Comment

#### QA
> QA_id (primary key)
> Product_id (foreign key)
> User_id (foreign key)
> Qa_question
> qa_answer
