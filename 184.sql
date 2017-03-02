# Write your MySQL query statement below
select new.Name Department, ee.Name Employee, ee.Salary Salary from Employee ee inner join (select d.Id Id, d.Name Name, max(Salary) Salary from Employee e inner join Department d on e.DepartmentId=d.Id group by d.Name) new on ee.DepartmentId=new.Id and ee.Salary=new.Salary ;
