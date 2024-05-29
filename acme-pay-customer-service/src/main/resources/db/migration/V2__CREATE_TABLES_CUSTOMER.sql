create table  if not exists customer(
	id serial PRIMARY KEY,
	name VARCHAR not null,
	email VARCHAR not null,
	phone VARCHAR not null,
	document VARCHAR not null UNIQUE,
	created_at TIMESTAMP not null,
	updated_at TIMESTAMP
);
