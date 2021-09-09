CREATE TABLE IF NOT EXISTS postread(id bigint,title varchar(255), description varchar(255),
created_at datetime, updated_at datetime, user_id bigint,
primary key(id)) ^;

DROP TRIGGER IF EXISTS replicatePost ^;
CREATE TRIGGER replicatePost
after insert
on post for each row
begin
   insert into postread(id,created_at,description,title,updated_at,user_id)values(new.id,new.created_at,new.description,new.title,
   new.updated_at, new.user_id);
end ^;

DROP TRIGGER IF EXISTS updatePost ^;

CREATE TRIGGER updatePost
after update
on post for each row
begin
   if old.updated_at is not null then
   insert into postread(description, updated_at)
   values(new.description, new.updated_at);
   end if;
end ^;

commit ^;

