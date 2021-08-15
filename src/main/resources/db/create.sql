SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 health VARCHAR,
 age VARCHAR,
 location VARCHAR,
 rangerName VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS sightings (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);