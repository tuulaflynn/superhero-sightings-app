DROP DATABASE IF EXISTS superhero;
CREATE DATABASE superhero;
USE superhero;

CREATE TABLE supertype_details (
	supertype_id INT AUTO_INCREMENT PRIMARY KEY,
    supertype_name VARCHAR(25) NOT NULL
);

CREATE TABLE organisation_contact_details (
	organisation_contact_id INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(100) NOT NULL,
    zipcode VARCHAR(10) NOT NULL, 
    phone_number VARCHAR(20)
);

CREATE TABLE organisation_details (
	organisation_id INT AUTO_INCREMENT PRIMARY KEY,
    organisation_name VARCHAR(50) NOT NULL,
    organisation_desc VARCHAR(100),
    organisation_contact_id INT NOT NULL,
    supertype_id INT NOT NULL,
    FOREIGN KEY (organisation_contact_id) REFERENCES organisation_contact_details(organisation_contact_id) ON DELETE RESTRICT, 
    FOREIGN KEY (supertype_id) REFERENCES supertype_details(supertype_id) ON DELETE RESTRICT -- note this is the default setting so does not need to be specified.
);

CREATE TABLE superpower_details (
	superpower_id INT AUTO_INCREMENT PRIMARY KEY,
    superpower_name VARCHAR(25) NOT NULL,
	superpower_desc VARCHAR(100)
);

CREATE TABLE super_details (
	super_id INT AUTO_INCREMENT PRIMARY KEY,
    super_name VARCHAR(20) NOT NULL,
    super_desc VARCHAR(100),
    superpower_id INT NOT NULL, 
    supertype_id INT NOT NULL,
    FOREIGN KEY (superpower_id) REFERENCES superpower_details(superpower_id) ON DELETE RESTRICT,
    FOREIGN KEY (supertype_id) REFERENCES supertype_details(supertype_id) ON DELETE RESTRICT 
);

CREATE TABLE superhero_organisation_details (
	super_id INT,
    organisation_id INT,
    PRIMARY KEY (super_id, organisation_id),
    FOREIGN KEY (super_id) REFERENCES super_details(super_id) ON DELETE CASCADE,
    FOREIGN KEY (organisation_id) REFERENCES organisation_details(organisation_id) ON DELETE CASCADE
);

CREATE TABLE location_details (
	location_id INT AUTO_INCREMENT PRIMARY KEY,
	location_name VARCHAR(30) NOT NULL,
    location_desc VARCHAR(100), 
	location_address VARCHAR(100) NOT NULL,
    location_latitude_degree DECIMAL(8, 4),
    location_longitude_degree DECIMAL(8, 4)
);

CREATE TABLE sighting_details (
	sighting_id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT NOT NULL,
    super_id INT NOT NULL,
    sighting_date DATE NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location_details(location_id) ON DELETE RESTRICT, 
    FOREIGN KEY (super_id) REFERENCES super_details(super_id) ON DELETE RESTRICT
);