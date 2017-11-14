

# Write your MySQL query statement below
# print all three lines output (3 where condition)
SELECT a.* FROM stadium AS a, stadium AS b, stadium as c
    WHERE
    ((a.id + 1 = b.id AND a.id + 2 = c.id)
    OR
    (a.id - 1 = b.id AND a.id + 1 = c.id)
    OR
    (a.id - 2 = b.id AND a.id - 1 = c.id))
    AND a.people>=100
    AND b.people>=100
    AND c.people>=100
    GROUP BY a.id