ALTER TABLE notification
ADD COLUMN created_at TIMESTAMP not null,
ADD COLUMN updated_at TIMESTAMP;