# Trips: Id-Client_Id-Driver_Id-City_Id-Status-Request_at
# Users: Users_Id-Banned-Role

# find the cancellation rate of requests made by unbanned clients between Oct 1, 2013 and Oct 3, 2013

SELECT Request_at as Day,
       ROUND(COUNT(IF(Status != 'completed', TRUE, NULL)) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips
WHERE (Request_at BETWEEN '2013-10-01' AND '2013-10-03')
      AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
GROUP BY Request_at;