# Write your MySQL query statement below
Select max(salary) SecondHighestSalary from Employee where salary < (select max(salary) from Employee);