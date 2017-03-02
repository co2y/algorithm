# Write your MySQL query statement below
select
T.Request_at Day,
round(sum(case when T.Status <> 'completed' then 1 else 0 end)/count(*),2) "Cancellation Rate"
from Trips T
inner join Users U
on T.Client_Id = U.Users_Id and U.Banned='No'
where T.Request_at between '2013-10-01' and '2013-10-03'
group by T.Request_at
