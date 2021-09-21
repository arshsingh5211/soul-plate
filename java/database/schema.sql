BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, restaurant_categories, categories, profile_preferences CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE restaurant_serial;
CREATE TABLE restaurants (
        restaurant_id int NOT NULL DEFAULT nextval('restaurant_serial'),
        restaurant_name varchar(50),
        description varchar(200),
        phone_number varchar(10), -- fix datatype later
        address varchar(200),
        city varchar(25),
        state varchar(2),
        zip_code int,
        rating int,
        CONSTRAINT PK_restaurant PRIMARY KEY (restaurant_id)
);

CREATE SEQUENCE category_serial;
CREATE TABLE categories (
        category_id int NOT NULL DEFAULT nextval('category_serial'),
        category_name varchar(50),
        CONSTRAINT PK_category PRIMARY KEY (category_id)
);

CREATE SEQUENCE restaurant_category_serial;
CREATE TABLE restaurant_categories (
        category_id int NOT NULL DEFAULT nextval('restaurant_category_serial'),
        restaurant_id int NOT NULL,
        CONSTRAINT PK_restaurant_categories PRIMARY KEY(category_id, restaurant_id),
        CONSTRAINT FK_restaurant_categories_categories FOREIGN KEY(category_id) REFERENCES categories(category_id),
        CONSTRAINT FK_restaurant_category FOREIGN KEY(restaurant_id) REFERENCES restaurants(restaurant_id)
);


CREATE SEQUENCE preferences_serial;
CREATE TABLE profile_preferences (
        preferences_id int NOT NULL DEFAULT nextval('preferences_serial'),
        user_id int, 
        preference varchar,
        home_zip int,
        CONSTRAINT PK_preferences PRIMARY KEY (preferences_id),
        CONSTRAINT FK_user_preferences FOREIGN KEY (user_id) REFERENCES users(user_id)
);



INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO categories (category_id, category_name) VALUES (1, 'Afghan');
INSERT INTO categories (category_id, category_name) VALUES (2, 'African');
INSERT INTO categories (category_id, category_name) VALUES (3, 'American');
INSERT INTO categories (category_id, category_name) VALUES (4, 'Andalusian');
INSERT INTO categories (category_id, category_name) VALUES (5, 'Arabian');
INSERT INTO categories (category_id, category_name) VALUES (6, 'Argentine');
INSERT INTO categories (category_id, category_name) VALUES (7, 'Armenian');
INSERT INTO categories (category_id, category_name) VALUES (8, 'Asian Fusion');
INSERT INTO categories (category_id, category_name) VALUES (9, 'Asturian');
INSERT INTO categories (category_id, category_name) VALUES (10, 'Australian');
INSERT INTO categories (category_id, category_name) VALUES (11, 'Austrian');
INSERT INTO categories (category_id, category_name) VALUES (12, 'Baguettes ');
INSERT INTO categories (category_id, category_name) VALUES (13, 'Bangladeshi');
INSERT INTO categories (category_id, category_name) VALUES (14, 'Barbeque');
INSERT INTO categories (category_id, category_name) VALUES (15, 'Basque');
INSERT INTO categories (category_id, category_name) VALUES (16, 'Bavarian');
INSERT INTO categories (category_id, category_name) VALUES (17, 'Beer Garden');
INSERT INTO categories (category_id, category_name) VALUES (18, 'Beer Hall');
INSERT INTO categories (category_id, category_name) VALUES (19, 'Beisl');
INSERT INTO categories (category_id, category_name) VALUES (20, 'Belgian');
INSERT INTO categories (category_id, category_name) VALUES (21, 'Bistros');
INSERT INTO categories (category_id, category_name) VALUES (22, 'Black Sea ');
INSERT INTO categories (category_id, category_name) VALUES (23, 'Brazilian ');
INSERT INTO categories (category_id, category_name) VALUES (24, 'Breakfast & Brunch ');
INSERT INTO categories (category_id, category_name) VALUES (25, 'British');



COMMIT TRANSACTION;
