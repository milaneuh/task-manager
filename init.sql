CREATE TABLE task (
    id text NOT NULL,
    description text NOT NULL,
    done boolean NOT NULL
);

ALTER TABLE public.task OWNER to myuser;

