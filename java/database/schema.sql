BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, preferences, user_preferences CASCADE;
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

CREATE TABLE preferences (
        preferences_id serial NOT NULL PRIMARY KEY,
        preference varchar NOT NULL,
        home_zip VARCHAR(5) NOT NULL
);


CREATE TABLE user_preferences (
        user_preferences_id serial NOT NULL PRIMARY KEY,
        user_id int NOT NULL ,
        preferences_id int NOT NULL,
        name varchar,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_preferences_id FOREIGN KEY (preferences_id) REFERENCES preferences(preferences_id),
        CONSTRAINT UQ_preferences_id_user_preferences_id UNIQUE(preferences_id, user_preferences_id)
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




COMMIT TRANSACTION;