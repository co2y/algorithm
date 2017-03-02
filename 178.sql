# Write your MySQL query statement below
select Score, (SELECT count(distinct Score) FROM Scores WHERE Score >= s1.Score) Rank from Scores s1 order by Score DESC;
