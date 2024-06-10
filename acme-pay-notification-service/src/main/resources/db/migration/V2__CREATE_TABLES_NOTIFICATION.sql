create table  if not exists notification(
	id serial PRIMARY KEY,
	document VARCHAR(20) not null,
	statusDocument VARCHAR(20) not null

);
