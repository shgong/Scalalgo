# movies with an odd numbered ID and a description that is not 'boring'
# cinema: id-movie-description-rating

SELECT * FROM cinema
WHERE
(id % 2) = 1
AND
description!="boring"
ORDER BY rating DESC