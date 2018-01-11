# Employee  Id-Name-Salary-DepartmentId
# Department Id-Name
# find who have highest salary in each of department

select a.Name as Department, b.Name as Employee, b.Salary
from Department a, Employee b
  where a.Id = b.DepartmentId and NOT EXISTS
  (select 1 from Employee where DepartmentId=a.Id and Salary>b.Salary)
