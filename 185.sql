# Write your MySQL query statement below
select D.Name as Department, E.Name as Employee, E.Salary as Salary
  from Employee E, Department D
   where
        (select count(distinct(EE.Salary)) from Employee EE
        where E.DepartmentId = EE.DepartmentId and EE.Salary > E.Salary) in (0, 1, 2)
    and
         E.DepartmentId = D.Id
    order by E.DepartmentId, E.Salary DESC;
