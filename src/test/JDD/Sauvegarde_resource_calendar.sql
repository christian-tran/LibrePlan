--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2020-01-07 09:27:24

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

DROP TABLE resource_calendar CASCADE; 

--
-- TOC entry 251 (class 1259 OID 26713)
-- Name: resource_calendar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE resource_calendar (
    base_calendar_id bigint NOT NULL,
    capacity integer NOT NULL
);


ALTER TABLE resource_calendar OWNER TO postgres;

--
-- TOC entry 2494 (class 0 OID 26713)
-- Dependencies: 251
-- Data for Name: resource_calendar; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2378 (class 2606 OID 26717)
-- Name: resource_calendar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY resource_calendar
    ADD CONSTRAINT resource_calendar_pkey PRIMARY KEY (base_calendar_id);


--
-- TOC entry 2379 (class 2606 OID 27530)
-- Name: fk9619184fa44abee3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY resource_calendar
    ADD CONSTRAINT fk9619184fa44abee3 FOREIGN KEY (base_calendar_id) REFERENCES base_calendar(id);


-- Completed on 2020-01-07 09:27:24

--
-- PostgreSQL database dump complete
--

