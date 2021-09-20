BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, restaurant_categories, profiles, categories, profile_preferences CASCADE;
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
        rating int,
        review_id int,
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

CREATE TABLE profiles (
        profile_id int,
        user_id int,
        last_active date,
        CONSTRAINT PK_profile PRIMARY KEY(profile_id),
        CONSTRAINT FK_profile FOREIGN KEY(user_id) REFERENCES users(user_id)
);



CREATE SEQUENCE preferences_serial;
CREATE TABLE profile_preferences (
        preferences_id int NOT NULL DEFAULT nextval('preferences_serial'),
        restaurant_id int,
        profile_id int,
        home_zip int,
        CONSTRAINT PK_preferences PRIMARY KEY (preferences_id),
        CONSTRAINT FK_preferences_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id),
        CONSTRAINT FK_preferences_profile FOREIGN KEY (profile_id) REFERENCES profiles(profile_id)
);



INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
