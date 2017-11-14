# Write your MySQL query statement below
  select a.Name as Department, b.Name as Employee, b.Salary
from Department a, Employee b
  where a.Id = b.DepartmentId and
  (select count(distinct salary) from Employee where DepartmentId=a.Id and Salary>b.Salary)<3
# less than 3 higher salary in the same department