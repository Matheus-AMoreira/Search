# Search

Api to send data to the client

# DataBase Script

BEGIN;

CREATE TABLE IF NOT EXISTS public.loj_loja
(
loj_cnpj character varying(14) COLLATE pg_catalog."default" NOT NULL,
loj_name character varying(50) COLLATE pg_catalog."default",
loj_cep integer NOT NULL,
loj_numero integer,
CONSTRAINT loj_loja_pkey PRIMARY KEY (loj_cnpj)
);

CREATE TABLE IF NOT EXISTS public.prd_produto
(
prd_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
prd_nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
prd_preco numeric(6, 2) NOT NULL,
prd_atualizacao date NOT NULL,
prd_img character varying(100) COLLATE pg_catalog."default",
loj_cnpj character varying(14) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT prd_produto_pkey PRIMARY KEY (prd_id)
);

ALTER TABLE IF EXISTS public.prd_produto
ADD CONSTRAINT prd_produto_loj_cnpj_fkey FOREIGN KEY (loj_cnpj)
REFERENCES public.loj_loja (loj_cnpj) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION;

END;