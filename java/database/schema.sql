BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, restaurant_categories, categories, user_preferences, user_restaurants, user_category CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, restaurant_serial, category_serial, restaurant_category_serial, preferences_serial, user_category_serial;

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
        yelp_id varchar,
        CONSTRAINT PK_restaurant PRIMARY KEY (restaurant_id),
        UNIQUE (yelp_id)
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
CREATE TABLE user_preferences (
        preferences_id int NOT NULL DEFAULT nextval('preferences_serial'),
        user_id int,
        name varchar, 
        home_zip int,
        preference varchar,
        category_id int,
        CONSTRAINT PK_preferences PRIMARY KEY (preferences_id),
        CONSTRAINT FK_user_preferences FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE SEQUENCE user_category_serial;
CREATE TABLE user_category (
        user_category_id serial NOT NULL,
        preferences_id int NOT NULL,
        category_id int NOT NULL,
        CONSTRAINT PK_user_category PRIMARY KEY (user_category_id),
        CONSTRAINT FK_preferences_id FOREIGN KEY (preferences_id) REFERENCES user_preferences(preferences_id),
        CONSTRAINT FK_category_id FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE user_restaurants (
        user_restaurants_id serial NOT NULL PRIMARY KEY,
        user_id int NOT NULL , 
        restaurant_id int NOT NULL ,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)

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
INSERT INTO categories (category_id, category_name) VALUES (26, 'Buffets');
INSERT INTO categories (category_id, category_name) VALUES (27, 'Bulgarian');
INSERT INTO categories (category_id, category_name) VALUES (28, 'Burgers');
INSERT INTO categories (category_id, category_name) VALUES (29, 'Burmese');
INSERT INTO categories (category_id, category_name) VALUES (30, 'Cafes');
INSERT INTO categories (category_id, category_name) VALUES (31, 'Cafeteria');
INSERT INTO categories (category_id, category_name) VALUES (32, 'Cajun/Creole');
INSERT INTO categories (category_id, category_name) VALUES (33, 'Cambodian');
INSERT INTO categories (category_id, category_name) VALUES (34, 'Canadian');
INSERT INTO categories (category_id, category_name) VALUES (35, 'Canteen');
INSERT INTO categories (category_id, category_name) VALUES (36, 'Caribbean');
INSERT INTO categories (category_id, category_name) VALUES (37, 'Catalan');
INSERT INTO categories (category_id, category_name) VALUES (38, 'Cheesesteaks');
INSERT INTO categories (category_id, category_name) VALUES (39, 'Chicken Shop');
INSERT INTO categories (category_id, category_name) VALUES (40, 'Chicken Wings');
INSERT INTO categories (category_id, category_name) VALUES (41, 'Chilean');
INSERT INTO categories (category_id, category_name) VALUES (42, 'Chinese');
INSERT INTO categories (category_id, category_name) VALUES (44, 'Comfort Food');
INSERT INTO categories (category_id, category_name) VALUES (45, 'Corsican');
INSERT INTO categories (category_id, category_name) VALUES (46, 'Creperies');
INSERT INTO categories (category_id, category_name) VALUES (47, 'Cuban');
INSERT INTO categories (category_id, category_name) VALUES (48, 'Cypriot');
INSERT INTO categories (category_id, category_name) VALUES (49, 'Czech');
INSERT INTO categories (category_id, category_name) VALUES (50, 'Danish');
INSERT INTO categories (category_id, category_name) VALUES (51, 'Delis');
INSERT INTO categories (category_id, category_name) VALUES (52, 'Diners');
INSERT INTO categories (category_id, category_name) VALUES (53, 'Dinner Theater');
INSERT INTO categories (category_id, category_name) VALUES (54, 'Dumplings');
INSERT INTO categories (category_id, category_name) VALUES (55, 'Eastern European');
INSERT INTO categories (category_id, category_name) VALUES (56, 'Eritrean');
INSERT INTO categories (category_id, category_name) VALUES (57, 'Ethiopian');
INSERT INTO categories (category_id, category_name) VALUES (58, 'Fast Food');
INSERT INTO categories (category_id, category_name) VALUES (59, 'Filipino');
INSERT INTO categories (category_id, category_name) VALUES (60, 'Filipino');
INSERT INTO categories (category_id, category_name) VALUES (61, 'Flatbread');
INSERT INTO categories (category_id, category_name) VALUES (62, 'Fondue');
INSERT INTO categories (category_id, category_name) VALUES (63, 'Food Court');
INSERT INTO categories (category_id, category_name) VALUES (64, 'Food Stands');
INSERT INTO categories (category_id, category_name) VALUES (65, 'French');
INSERT INTO categories (category_id, category_name) VALUES (66, 'Game Meat');
INSERT INTO categories (category_id, category_name) VALUES (67, 'Gastropubs');
INSERT INTO categories (category_id, category_name) VALUES (68, 'Georgian');
INSERT INTO categories (category_id, category_name) VALUES (69, 'German');
INSERT INTO categories (category_id, category_name) VALUES (70, 'Giblets');
INSERT INTO categories (category_id, category_name) VALUES (71, 'Gluten-Free');
INSERT INTO categories (category_id, category_name) VALUES (72, 'Greek');
INSERT INTO categories (category_id, category_name) VALUES (73, 'Halal');
INSERT INTO categories (category_id, category_name) VALUES (74, 'Hawaiian');
INSERT INTO categories (category_id, category_name) VALUES (75, 'Himalayan/Nepalese');
INSERT INTO categories (category_id, category_name) VALUES (76, 'Honduran');
INSERT INTO categories (category_id, category_name) VALUES (77, 'Hot Dogs');
INSERT INTO categories (category_id, category_name) VALUES (78, 'Hot Pot');
INSERT INTO categories (category_id, category_name) VALUES (79, 'Hungarian');
INSERT INTO categories (category_id, category_name) VALUES (80, 'Iberian');
INSERT INTO categories (category_id, category_name) VALUES (81, 'Indian');
INSERT INTO categories (category_id, category_name) VALUES (82, 'Indonesian');
INSERT INTO categories (category_id, category_name) VALUES (83, 'Irish');
INSERT INTO categories (category_id, category_name) VALUES (84, 'Israeli');
INSERT INTO categories (category_id, category_name) VALUES (85, 'Italian');
INSERT INTO categories (category_id, category_name) VALUES (86, 'Japanese');
INSERT INTO categories (category_id, category_name) VALUES (87, 'Jewish');
INSERT INTO categories (category_id, category_name) VALUES (88, 'Kebab');
INSERT INTO categories (category_id, category_name) VALUES (89, 'Korean');
INSERT INTO categories (category_id, category_name) VALUES (90, 'Kosher');
INSERT INTO categories (category_id, category_name) VALUES (91, 'Kurdish');
INSERT INTO categories (category_id, category_name) VALUES (92, 'Laos');
INSERT INTO categories (category_id, category_name) VALUES (93, 'Laotian');
INSERT INTO categories (category_id, category_name) VALUES (94, 'Latin American');
INSERT INTO categories (category_id, category_name) VALUES (95, 'Live/Raw Food');
INSERT INTO categories (category_id, category_name) VALUES (96, 'Lyonnais');
INSERT INTO categories (category_id, category_name) VALUES (97, 'Malaysian');
INSERT INTO categories (category_id, category_name) VALUES (98, 'Meatballs');
INSERT INTO categories (category_id, category_name) VALUES (99, 'Mediterranean');
INSERT INTO categories (category_id, category_name) VALUES (100, 'Mexican');
INSERT INTO categories (category_id, category_name) VALUES (101, 'Middle Eastern');
INSERT INTO categories (category_id, category_name) VALUES (102, 'Mongolian');
INSERT INTO categories (category_id, category_name) VALUES (103, 'Moroccan');
INSERT INTO categories (category_id, category_name) VALUES (104, 'New Zealand');
INSERT INTO categories (category_id, category_name) VALUES (105, 'Nicaraguan');
INSERT INTO categories (category_id, category_name) VALUES (106, 'Noodles');
INSERT INTO categories (category_id, category_name) VALUES (107, 'Open Sandwiches');
INSERT INTO categories (category_id, category_name) VALUES (108, 'Pakistani');
INSERT INTO categories (category_id, category_name) VALUES (109, 'Pan Asian');
INSERT INTO categories (category_id, category_name) VALUES (110, 'Persian/Iranian');
INSERT INTO categories (category_id, category_name) VALUES (111, 'Peruvian');
INSERT INTO categories (category_id, category_name) VALUES (112, 'Pita');
INSERT INTO categories (category_id, category_name) VALUES (113, 'Pizza');
INSERT INTO categories (category_id, category_name) VALUES (114, 'Polish');
INSERT INTO categories (category_id, category_name) VALUES (115, 'Polynesian');
INSERT INTO categories (category_id, category_name) VALUES (116, 'Pop-Up Restaurants');
INSERT INTO categories (category_id, category_name) VALUES (117, 'Portuguese');
INSERT INTO categories (category_id, category_name) VALUES (118, 'Potatoes');
INSERT INTO categories (category_id, category_name) VALUES (119, 'Poutineries');
INSERT INTO categories (category_id, category_name) VALUES (120, 'Pub Food');
INSERT INTO categories (category_id, category_name) VALUES (121, 'Rice');
INSERT INTO categories (category_id, category_name) VALUES (122, 'Romanian');
INSERT INTO categories (category_id, category_name) VALUES (123, 'Rotisserie Chicken');
INSERT INTO categories (category_id, category_name) VALUES (124, 'Russian');
INSERT INTO categories (category_id, category_name) VALUES (125, 'Salad');
INSERT INTO categories (category_id, category_name) VALUES (126, 'Sandwiches');
INSERT INTO categories (category_id, category_name) VALUES (127, 'Scandinavian');
INSERT INTO categories (category_id, category_name) VALUES (128, 'Schnitzel');
INSERT INTO categories (category_id, category_name) VALUES (129, 'Scottish');
INSERT INTO categories (category_id, category_name) VALUES (130, 'Seafood');
INSERT INTO categories (category_id, category_name) VALUES (131, 'Serbo Croatian');
INSERT INTO categories (category_id, category_name) VALUES (132, 'Singaporean');
INSERT INTO categories (category_id, category_name) VALUES (133, 'Slovakian');
INSERT INTO categories (category_id, category_name) VALUES (134, 'Somali');
INSERT INTO categories (category_id, category_name) VALUES (135, 'Soul Food');
INSERT INTO categories (category_id, category_name) VALUES (136, 'Soup');
INSERT INTO categories (category_id, category_name) VALUES (137, 'Southern');
INSERT INTO categories (category_id, category_name) VALUES (138, 'Spanish');
INSERT INTO categories (category_id, category_name) VALUES (139, 'Sri Lankan');
INSERT INTO categories (category_id, category_name) VALUES (140, 'Steakhouses');
INSERT INTO categories (category_id, category_name) VALUES (141, 'Supper Clubs');
INSERT INTO categories (category_id, category_name) VALUES (142, 'Sushi Bars');
INSERT INTO categories (category_id, category_name) VALUES (143, 'Swabian');
INSERT INTO categories (category_id, category_name) VALUES (144, 'Swedish');
INSERT INTO categories (category_id, category_name) VALUES (145, 'Syrian');
INSERT INTO categories (category_id, category_name) VALUES (146, 'Taiwanese');
INSERT INTO categories (category_id, category_name) VALUES (147, 'Tapas Bars');
INSERT INTO categories (category_id, category_name) VALUES (148, 'Tapas/Small Plates');
INSERT INTO categories (category_id, category_name) VALUES (149, 'Tex-Mex');
INSERT INTO categories (category_id, category_name) VALUES (150, 'Thai');
INSERT INTO categories (category_id, category_name) VALUES (151, 'Trattorie');
INSERT INTO categories (category_id, category_name) VALUES (152, 'Turkish');
INSERT INTO categories (category_id, category_name) VALUES (153, 'Ukrainian');
INSERT INTO categories (category_id, category_name) VALUES (154, 'Uzbek');
INSERT INTO categories (category_id, category_name) VALUES (155, 'Vegan');
INSERT INTO categories (category_id, category_name) VALUES (156, 'Vegetarian');
INSERT INTO categories (category_id, category_name) VALUES (157, 'Venison');
INSERT INTO categories (category_id, category_name) VALUES (158, 'Vietnamese');
INSERT INTO categories (category_id, category_name) VALUES (159, 'Waffles');
INSERT INTO categories (category_id, category_name) VALUES (160, 'Wok');
INSERT INTO categories (category_id, category_name) VALUES (161, 'Wraps');
INSERT INTO categories (category_id, category_name) VALUES (162, 'Yugoslav');
INSERT INTO categories (category_id, category_name) VALUES (163, 'Keto');




COMMIT TRANSACTION;
