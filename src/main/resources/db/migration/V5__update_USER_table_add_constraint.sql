ALTER TABLE users
    ADD CONSTRAINT fk_user_organisation
    FOREIGN KEY (organisation_id)
    REFERENCES organisation (id);