SELECT * FROM supertype_details;
SELECT * FROM organisation_contact_details;
SELECT * FROM organisation_details;
SELECT * FROM superpower_details;
SELECT * FROM super_details;    
SELECT * FROM superhero_organisation_details;    
SELECT * FROM location_details;
SELECT * FROM sighting_details;

SELECT * 
FROM sighting_details 
INNER JOIN super_details ON super_details.super_id = sighting_details.super_id
WHERE sighting_details.location_id = 3;