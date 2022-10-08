BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, preferences, user_preferences, user_restaurants CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, seq_preferences_id, seq_user_preferences_id, seq_user_restaurants_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_preferences_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_user_preferences_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_user_restaurants_id
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
        yelp_id varchar(50) UNIQUE,
        restaurant_name varchar(50) NOT NULL,
        rating DECIMAL (2, 1),
        address varchar(50) NOT NULL,
        city varchar(16) NOT NULL,
        state varchar(2) NOT NULL,
        zip_code varchar(5) NOT NULL,
        phone_number varchar(12),
        CONSTRAINT PK_restaurant PRIMARY KEY (yelp_id)
);

CREATE TABLE preferences (
        preferences_id int DEFAULT nextval('seq_preferences_id'::regclass) NOT NULL,
        preference varchar NOT NULL,
        home_zip VARCHAR(5) NOT NULL,
        CONSTRAINT PK_preferences PRIMARY KEY (preferences_id),
        CONSTRAINT UQ_preference_home_zip UNIQUE (preference, home_zip)
);


CREATE TABLE user_preferences (
        user_preferences_id int DEFAULT nextval('seq_user_preferences_id'::regclass) NOT NULL,
        user_id int NOT NULL ,
        preferences_id int NOT NULL,
        CONSTRAINT PK_user_preferences PRIMARY KEY (user_preferences_id),
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_preferences_id FOREIGN KEY (preferences_id) REFERENCES preferences(preferences_id),
        CONSTRAINT UQ_preferences_id_user_id UNIQUE(preferences_id, user_id)
);

CREATE TABLE user_restaurants (
        user_restaurants_id int DEFAULT nextval('seq_user_restaurants_id'::regclass) NOT NULL,
        user_id int NOT NULL, 
        yelp_id varchar NOT NULL,
        CONSTRAINT PK_user_restaurants PRIMARY KEY (user_restaurants_id),
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_yelp_id FOREIGN KEY (yelp_id) REFERENCES restaurants(yelp_id)
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




COMMIT TRANSACTION;