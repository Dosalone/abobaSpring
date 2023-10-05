CREATE TABLE users (
    id bigserial PRIMARY KEY,
    name text NOT NULL,
    age INT NOT NULL,
    comment text
);

comment ON column users.comment IS 'Комментарий о пользователе';