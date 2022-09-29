-- Ex1: movie.csv til database tabel
CREATE DATABASE imdb;
USE imdb;

CREATE TABLE movie
(
    id         int auto_increment,
    year       int,
    length     int,
    title      varchar(50),
    subject    varchar(50),
    popularity tinyint,
    awards     bit,
    PRIMARY KEY (id)
);

-- insert data manually
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1962, 138, '8 1/2', 'Drama', 80, 1);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1968, 139, '2001: A Space Odyssey', 'Science Fiction', 83, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1982, 92, '48 Hrs.', 'Action', 67, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1966, 95, 'A Big Hand for the Little Lady', 'Comedy', 12, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1992, 60, 'A Certain Sacrifice', 'Music', 24, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1962, 105, 'A Child Is Waiting', 'Drama', 60, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1985, 118, 'A Chorus Line, The Movie', 'Music', 71, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1990, 89, 'A Chorus of Disapproval', 'Comedy', 0, 0);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1971, 138, 'A Clockwork Orange', 'Science Fiction', 83, 1);
INSERT INTO movie (year, length, title, subject, popularity, awards)
VALUES (1967, 100, 'A Coeur Joie, (Head Over Heels)', 'Action', 54, 0);

-- Alle info på film fra 1962
SELECT *
FROM movie
WHERE year = 1962;

-- Alle info på film med en længde over 100 minutter.
SELECT *
FROM movie
WHERE length <= 100;

-- Tilterne på film fra Science Fiction genren.
SELECT title
FROM movie
WHERE subject = 'Science Fiction';

-- Info på alle film fra Drama genren som har modtaget en Award.
SELECT *
FROM movie
WHERE subject = 'Drama'
  AND awards = 1;

-- Alle info på den film med højest popularity
SELECT *
FROM movie
WHERE popularity = (SELECT MAX(popularity)
                    FROM movie);

-- Find den gennemsnitlige rating på alle film i databasen.
SELECT AVG(popularity) AS AveragePopularity
FROM movie;


-- Ex2: Nasa Mars Rover API data
CREATE DATABASE nasa;
USE nasa;

CREATE TABLE photo
(
    id         int auto_increment,
    sol        int,
    camera     varchar(20),
    img_src    varchar(200),
    earth_date date,
    rover      varchar(50),
    PRIMARY KEY (id)
);

-- insert data manually
INSERT INTO photo (id, sol, camera, img_src, earth_date, rover)
VALUES (102693, 1000, 'FHAS',
        'http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG',
        '2015-05-30', 'Curiosity');
INSERT INTO photo (id, sol, camera, img_src, earth_date, rover)
VALUES (102694, 1000, 'FHAS',
        'http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FRB_486265257EDR_F0481570FHAZ00323M_.JPG',
        '2015-05-30', 'Curiosity');
INSERT INTO photo (id, sol, camera, img_src, earth_date, rover)
VALUES (102850, 1000, 'RHAZ',
        'http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RLB_486265291EDR_F0481570RHAZ00323M_.JPG',
        '2015-05-30', 'Curiosity');
INSERT INTO photo (id, sol, camera, img_src, earth_date, rover)
VALUES (102851, 1000, 'RHAZ',
        'http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RRB_486265291EDR_F0481570RHAZ00323M_.JPG',
        '2015-05-30', 'Curiosity');

-- 1. url´en til billederne taget af kameraet "FHAS"
SELECT img_src
FROM photo
WHERE camera = 'FHAS';

-- 2. Alt info om billedet med id 102694
SELECT *
FROM photo
WHERE id = 102694;

-- 3. Alt info om alle billeder.
SELECT *
FROM photo;