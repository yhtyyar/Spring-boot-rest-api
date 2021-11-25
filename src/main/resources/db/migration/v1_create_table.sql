CREATE TABLE IF NOT EXISTS "overlords"
(
    id   BIGSERIAL,
    name CHARACTER VARYING(100) NOT NULL,
    age  INT NOT NULL,
    CONSTRAINT overlords_pkey PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS "planets"
(
    id      BIGSERIAL,
    name    CHARACTER VARYING(100) NOT NULL,
    lord_id BIGINT,
    CONSTRAINT planets_pkey PRIMARY KEY (id),
    CONSTRAINT fk_overlords_planets FOREIGN KEY (lord_id)
    REFERENCES overlords MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );