# Swap all f and m values (i.e., change all f values to m and vice versa) with a single update query and no intermediate temp table

UPDATE salary
SET sex = IF(sex='m', 'f', 'm')

