ALTER TABLE users
ALTER COLUMN created_by TYPE varchar USING created_by::varchar,
    ALTER COLUMN created_by SET DEFAULT ''::character varying;

ALTER TABLE users
ALTER COLUMN modified_by TYPE varchar USING modified_by::varchar,
    ALTER COLUMN modified_by SET DEFAULT ''::character varying;

ALTER TABLE roles
ALTER COLUMN created_by TYPE varchar USING created_by::varchar,
    ALTER COLUMN created_by SET DEFAULT ''::character varying;

ALTER TABLE roles
ALTER COLUMN modified_by TYPE varchar USING modified_by::varchar,
    ALTER COLUMN modified_by SET DEFAULT ''::character varying;