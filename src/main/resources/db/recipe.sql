-- Table: public.recipe

-- DROP TABLE IF EXISTS public.recipe;

CREATE TABLE IF NOT EXISTS public.recipe
(
    name text COLLATE pg_catalog."default",
    category text COLLATE pg_catalog."default",
    servefor bigint,
    code text COLLATE pg_catalog."default" NOT NULL,
    instructions text COLLATE pg_catalog."default",
    CONSTRAINT recipe_code PRIMARY KEY (code)
)


-- Table: public.ingredient

-- DROP TABLE IF EXISTS public.ingredient;

CREATE TABLE IF NOT EXISTS public.ingredient
(
    name text COLLATE pg_catalog."default" NOT NULL,
    recipe_code text COLLATE pg_catalog."default",
    CONSTRAINT ing_name PRIMARY KEY (name),
    CONSTRAINT fkadnupoa9aeodmrqbvsvnc777i FOREIGN KEY (recipe_code)
        REFERENCES public.recipe (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)






TABLESPACE pg_default;
