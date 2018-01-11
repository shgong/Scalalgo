# Suppose that a website contains two tables,
#   the Customers table    Id-Name
#   the Orders table       Id-CustomerId
#
# Write a SQL query to find all customers who never order anything

Select Name AS Customers FROM Customers WHERE Id NOT IN (Select DISTINCT CustomerId from Orders)

