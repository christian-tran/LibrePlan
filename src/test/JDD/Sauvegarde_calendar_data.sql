--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2020-01-07 09:54:46

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

DROP TABLE calendar_data CASCADE;

--
-- TOC entry 191 (class 1259 OID 26376)
-- Name: calendar_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE calendar_data (
    id bigint NOT NULL,
    version bigint NOT NULL,
    code character varying(255) NOT NULL,
    parent bigint,
    expiring_date date,
    base_calendar_id bigint,
    position_in_calendar integer
);


ALTER TABLE calendar_data OWNER TO postgres;

--
-- TOC entry 2497 (class 0 OID 26376)
-- Dependencies: 191
-- Data for Name: calendar_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO calendar_data (id, version, code, parent, expiring_date, base_calendar_id, position_in_calendar) VALUES (303, 1, '4b17f53a-d2a5-4a85-a448-ed341dc4c46f', NULL, NULL, 202, 0);


--
-- TOC entry 2378 (class 2606 OID 26926)
-- Name: calendar_data_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_data
    ADD CONSTRAINT calendar_data_code_key UNIQUE (code);


--
-- TOC entry 2380 (class 2606 OID 26380)
-- Name: calendar_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_data
    ADD CONSTRAINT calendar_data_pkey PRIMARY KEY (id);


--
-- TOC entry 2382 (class 2606 OID 27050)
-- Name: fk74fc040b7fa34e3f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_data
    ADD CONSTRAINT fk74fc040b7fa34e3f FOREIGN KEY (parent) REFERENCES base_calendar(id);


--
-- TOC entry 2381 (class 2606 OID 27045)
-- Name: fk74fc040ba44abee3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendar_data
    ADD CONSTRAINT fk74fc040ba44abee3 FOREIGN KEY (base_calendar_id) REFERENCES base_calendar(id);


-- Completed on 2020-01-07 09:54:46

--
-- PostgreSQL database dump complete
--

