CREATE DATABASE DB_FIFA;

show databases;

USE DB_FIFA;

CREATE TABLE IF NOT EXISTS coach(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    nationality VARCHAR(50) NOT NULL, 
    age INT NOT NULL
);

CREATE TABLE IF NOT EXISTS club(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    stadium_name VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    website VARCHAR(100),
    address VARCHAR(255),
    coach_id INT NOT NULL,
    FOREIGN KEY(coach_id) REFERENCES coach(id)
);

CREATE TABLE IF NOT EXISTS competition (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    start_date DATE,
    end_date DATE
);

CREATE TABLE IF NOT EXISTS club_competition_association(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    club_id INT NOT NULL,
    competition_id INT NOT NULL,
    FOREIGN KEY (club_id) REFERENCES club(id),
    FOREIGN KEY (competition_id) REFERENCES competition(id)
);

CREATE TABLE IF NOT EXISTS player(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nip INT NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    nationality VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    position VARCHAR(50) NOT NULL DEFAULT 'DEF',
    club_id INT NOT NULL,
    FOREIGN KEY(club_id) REFERENCES club(id)
);



