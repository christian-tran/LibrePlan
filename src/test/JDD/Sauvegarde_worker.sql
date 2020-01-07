--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2020-01-07 09:11:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

DROP TABLE worker CASCADE; 
--
-- TOC entry 282 (class 1259 OID 26875)
-- Name: worker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE worker (
    worker_id bigint NOT NULL,
    first_name character varying(255),
    surname character varying(255),
    nif character varying(255),
    user_id bigint
);


ALTER TABLE worker OWNER TO postgres;

--
-- TOC entry 2496 (class 0 OID 26875)
-- Dependencies: 282
-- Data for Name: worker; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2378 (class 2606 OID 26882)
-- Name: worker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY worker
    ADD CONSTRAINT worker_pkey PRIMARY KEY (worker_id);


--
-- TOC entry 2380 (class 2606 OID 27977)
-- Name: worker_user_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY worker
    ADD CONSTRAINT worker_user_id_key UNIQUE (user_id);


--
-- TOC entry 2381 (class 2606 OID 27765)
-- Name: fkd162537e40901220; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY worker
    ADD CONSTRAINT fkd162537e40901220 FOREIGN KEY (worker_id) REFERENCES resource(id);


-- Completed on 2020-01-07 09:11:46

--
-- PostgreSQL database dump complete
--

