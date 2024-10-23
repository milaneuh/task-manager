DROP TABLE IF EXISTS task;

CREATE TABLE task (
    id  UUID PRIMARY KEY DEFAULT gen_random_uuid() ,
    description text NOT NULL,
    done boolean NOT NULL
);

ALTER TABLE public.task OWNER to myuser;
