USE superhero;

INSERT INTO supertype_details(supertype_name) VALUES ("superhero"), ("supervillian");

INSERT INTO organisation_contact_details(address, zipcode, phone_number) VALUES 
	("379 Old Shore Street", "51501", "(291) 553-0508"),
    ("750 Wintergreen Dr.", "99654","(478) 277-9632"),
    ("9662 Foxrun Lane", "78552", "(308) 494-0198"),
    ("9378 W. Augusta Ave.", "08096", "(214) 730-0298"),
    ("762 Wild Rose Street", "48601", "(377) 507-0974");
    
INSERT INTO organisation_details(organisation_name, organisation_desc, organisation_contact_id, supertype_id) VALUES
	("Heros First", "Organisation to value and publicise superheros.", 1, 1),
    ("Superheros Representation", "Legal advice for superheros", 2, 1),
    ("All together Villians", "Organisation which funds supervillians for various contracts", 3, 2),
    ("SuperVillians Unite", "Heightens the socialisation of supervillians between one another", 4, 2),
    ("Utilise the power", "Organisation to publisise the potential uses of superheros", 5, 1);
    
INSERT INTO superpower_details(superpower_name, superpower_desc) VALUES 
	("invisibility", "invisible through all matter"),
    ("strength", null),
	("knowledge", null),
    ("supernatural skills", "undefined superpower but abnormal abilities"),
    ("speed", "can travel on ground at any speed"),
    ("transportation", null);
         
    
INSERT INTO super_details(super_name, super_desc, superpower_id, supertype_id) VALUES 
	("Bolt", "famous short male", 5, 1),
	("Flash", "young male", 5, 1),
    ("Violet", "daughter from the incredibles movie", 1, 1),
    ("Doctor Doom", null, 3, 2),
    ("The Joker", null, 4, 2),
    ("The Hulk", "massive strong green being", 2, 1),
    ("The Transformers", "turns into cars", 6, 2);
    
    
INSERT INTO superhero_organisation_details(super_id, organisation_id) VALUES 
	(1, 1),
    (1, 2),
    (3, 5),
    (2, 2),
    (6, 2),
    (1, 5),
    (4, 3),
    (5, 3),
    (7, 3),
    (4, 4),
    (7, 4);
    
    
INSERT INTO location_details(location_name, location_desc, location_address, location_latitude_degree, location_longitude_degree) VALUES
	("Pizza Joe's", "Behind Pizza Joe's", "7 Poplar Dr.", 40.7128, -74.0060),
    ("Los Angeles Parade", null ,"70 Oakwood St", 34.0522, -118.2437),
    ("Chicago centre", null, "7556 Arrowhead St.", 41.8781,-87.6298),
    ("Miami beach", "by the lifeguard chair", "77 West Surrey Street", 25.7617, -80.1918);
    
INSERT INTO sighting_details(location_id, super_id, sighting_date) VALUES 
	(1, 7, "2023-02-22"),
	(1, 5, "2023-03-07"),
    (3, 6, "2023-03-20"),
    (2, 1, "2023-04-05"),
    (3, 2, "2023-06-14"),
    (4, 3, "2023-06-14"),
    (3, 7, "2023-07-18"),
    (3, 4, "2023-07-22"),
    (4, 7, "2023-08-13");
