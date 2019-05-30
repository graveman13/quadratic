CREATE TABLE public."values"
(
    id bigint NOT NULL,
    c integer NOT NULL,
    b integer NOT NULL,
    a integer NOT NULL,
    x1 double precision NOT NULL,
    x2 double precision,
    CONSTRAINT values_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."values"
    OWNER to postgres;