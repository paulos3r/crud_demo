PGDMP     2    '            	    y            postgres    12.8    12.8                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    13318    postgres    DATABASE     ?   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE postgres;
                postgres    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2823                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            	           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    1            ?            1259    24583    aluno    TABLE     ?   CREATE TABLE public.aluno (
    id integer NOT NULL,
    nome character(89) NOT NULL,
    idade integer NOT NULL,
    estado character(2) NOT NULL
);
    DROP TABLE public.aluno;
       public         heap    postgres    false            ?            1259    24581    aluno_id_seq    SEQUENCE     ?   ALTER TABLE public.aluno ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.aluno_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    204                      0    24583    aluno 
   TABLE DATA           8   COPY public.aluno (id, nome, idade, estado) FROM stdin;
    public          postgres    false    204   ?
       
           0    0    aluno_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.aluno_id_seq', 4, true);
          public          postgres    false    203            ?
           2606    24587    aluno aluno_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.aluno DROP CONSTRAINT aluno_pkey;
       public            postgres    false    204               ?   x?3?H,??W??42???2???/>??6(p???0?tK-?K?K???8MM8}?b???? <I+?     