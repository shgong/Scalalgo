# Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

DELETE p from Person p, Person q where p.Id>q.Id AND q.Email=p.Email 