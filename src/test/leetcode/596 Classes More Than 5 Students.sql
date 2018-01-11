# list out all classes which have more than or equal to 5 students.
# courses: student - Class

SELECT class FROM (
    SELECT class, count(DISTINCT student) as num
    FROM courses
    GROUP BY class
) r WHERE num>4