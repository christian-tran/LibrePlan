--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2020-01-07 09:54:17

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

DROP TABLE calendar_availability CASCADE;

--
-- TOC entry 190 (class 1259 OID 26371)
-- Name: calendar_availability; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE calendar_availability (
    id bigint NOT NULL,
    version bigint NOT NULL,
    code character varying(255) NOT NULL,
    start_date date,
    end_date date,
    base_calendar_id bigint,
    position_in_calendar integer
);


ALTER TABLE calendar_availability OWNER TO postgres;

--
-- TOC entry 2496 (class 0 OID 26371)
-- Dependencies: 190
-- Data for Name: calendar_availability; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2378 (class 2606 OID 26924)
-- Name: calendar_availability_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_availability
    ADD CONSTRAINT calendar_availability_code_key UNIQUE (code);


--
-- TOC entry 2380 (class 2606 OID 26375)
-- Name: calendar_availability_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_availability
    ADD CONSTRAINT calendar_availability_pkey PRIMARY KEY (id);


--
-- TOC entry 2381 (class 2606 OID 27040)
-- Name: fk557738bca44abee3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_availability
    ADD CONSTRAINT fk557738bca44abee3 FOREIGN KEY (base_calendar_id) REFERENCES base_calendar(id);


-- Completed on 2020-01-07 09:54:17

--
-- PostgreSQL database dump complete
--

