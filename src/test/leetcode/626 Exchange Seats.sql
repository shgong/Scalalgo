# Mary wants to change seats for the adjacent students
# seat: id-student

SELECT
    IF(id%2=1, IF(id=(SELECT COUNT(*) FROM seat),id,id+1), id-1) as id,
    student
FROM seat
ORDER BY id