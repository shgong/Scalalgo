# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+

# Write your MySQL query statement below
select DISTINCT a.Email From Person a, Person b WHERE a.Email=b.Email AND a.Id!=b.Id