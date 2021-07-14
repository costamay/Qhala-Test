
select p.id, name, category, uploadable_id, count(*), max(file_name)

from products as p

right join uploads as u on p.id=u.id

group by uploadable_id, p.id, name, category, file_name

order by file_name desc