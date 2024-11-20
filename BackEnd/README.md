# Search

Api to send data to the client

# DataBase Script

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
    prd_id integer NOT NULL,
    prd_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    prd_img character varying(50) COLLATE pg_catalog."default",
    loj_cnpj character varying(14) COLLATE pg_catalog."default" NOT NULL,
    prd_price integer,
    CONSTRAINT prd_produto_pkey PRIMARY KEY (prd_id)
);

CREATE TABLE IF NOT EXISTS public.pro_promo
(
    pro_id integer NOT NULL,
    pro_preco integer NOT NULL,
    pro_inicio date,
    pro_fim date NOT NULL,
    prd_produto integer NOT NULL,
    CONSTRAINT pro_promo_pkey PRIMARY KEY (pro_id)
);

ALTER TABLE IF EXISTS public.prd_produto
    ADD FOREIGN KEY (loj_cnpj)
    REFERENCES public.loj_loja (loj_cnpj) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.pro_promo
    ADD CONSTRAINT pro_promo_prd_produto_fkey FOREIGN KEY (prd_produto)
    REFERENCES public.prd_produto (prd_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;