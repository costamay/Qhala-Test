

select a.username, count(*) as [No of times], course_id, course_date

from [user] as a

inner join [courses] as b on a.user_id=b.user_id

group by username, course_id, course_date

having count(*) > 1

order by course_date desc
