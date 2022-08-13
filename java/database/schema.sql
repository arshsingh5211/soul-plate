BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, user_preferences, user_restaurants CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, restaurant_serial, preferences_serial;

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
        yelp_id varchar UNIQUE,
        state varchar(2),
        CONSTRAINT PK_restaurant PRIMARY KEY (yelp_id)
);

CREATE SEQUENCE preferences_serial;
CREATE TABLE user_preferences (
        preferences_id int NOT NULL DEFAULT nextval('preferences_serial'),
        user_id int UNIQUE,
        name varchar, 
        home_zip VARCHAR(5),
        preference varchar,
        CONSTRAINT PK_preferences PRIMARY KEY (preferences_id),
        CONSTRAINT FK_user_preferences FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE user_restaurants (
        user_restaurants_id serial NOT NULL PRIMARY KEY,
        user_id int NOT NULL , 
        yelp_id varchar NOT NULL ,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_yelp_id FOREIGN KEY (yelp_id) REFERENCES restaurants(yelp_id)

);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




COMMIT TRANSACTION;
