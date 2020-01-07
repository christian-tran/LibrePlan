--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2020-01-07 09:03:46

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

DROP TABLE user_table CASCADE; 

--
-- TOC entry 277 (class 1259 OID 26839)
-- Name: user_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_table (
    id bigint NOT NULL,
    version bigint NOT NULL,
    login_name character varying(255) NOT NULL,
    password character varying(255),
    email character varying(255),
    disabled boolean,
    lastconnectedscenario bigint,
    libreplan_user boolean DEFAULT true NOT NULL,
    application_language integer DEFAULT 0,
    expand_company_planning_view_charts boolean DEFAULT false NOT NULL,
    expand_order_planning_view_charts boolean DEFAULT true NOT NULL,
    expand_resource_load_view_charts boolean DEFAULT true NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    projects_filter_period_since integer,
    projects_filter_period_to integer,
    resources_load_filter_period_since integer,
    resources_load_filter_period_to integer,
    projects_filter_label_id bigint,
    resources_load_filter_criterion_id bigint
);


ALTER TABLE user_table OWNER TO postgres;

--
-- TOC entry 2503 (class 0 OID 26839)
-- Dependencies: 277
-- Data for Name: user_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1818, 1, 'admin', 'e02a1a8809e830cf7b7c875e43c16e684ed02a818c7ac25aeadd515432f908ea041447720c194d6b0ec19a1c3dd97f7b378efaab4dd8efd46de568adf3f44c9a', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1819, 1, 'wsreader', '9134100ea9446b87a04cda86febe02900e53ca5af2f5b9422c5120bc3291079a7de3ea91ec72e944167e3fbcb97d35a2a904ee66bacf3727a67f7e5bf9fdaadc', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1820, 1, 'wswriter', 'a3d23705b1bb5ededfc890707b8e3331760206a6ceb213469fdf320dbe889170c2da17106005c5d057c51462621d7d77f33e005e6b9f1cddec6fa8c9b7a66eb8', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1821, 1, 'wssubcontracting', 'ce46d7f9a6d17b8ed0eceb71944154b5e42884eef2a111f2a3609b827d9cc2c5c007b9f04343eeb9c8db28696d1426c3c29c2fee2e95332790a9c208b1602224', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1822, 1, 'manager', '4a9c5fecbaa3c8fe4facd803e0f85aded921757addc9072758fac7811dda1bc7d1ae0c2c91f48e604d0b61b21d3c3f7b19f8d176f28c4e3aa3eacb0cd263c016', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1823, 1, 'hresources', '9cef1471412b2d225ca48841f390402ac14127682efdaafc0463114df6e77c7f46aeac5f7e828369eae3d32d6b1e002c0f333bb13723d765be9477be841b82de', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1824, 1, 'outsourcing', '4e7e9a5e908c11370a48a90214134647f9429865172f76dd2c80df01d39b6c503b57268d1f02cb04ee590a0c357d8b2dcf91ceb21ffb622b5a77ff707fa4fc3a', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO user_table (id, version, login_name, password, email, disabled, lastconnectedscenario, libreplan_user, application_language, expand_company_planning_view_charts, expand_order_planning_view_charts, expand_resource_load_view_charts, first_name, last_name, projects_filter_period_since, projects_filter_period_to, resources_load_filter_period_since, resources_load_filter_period_to, projects_filter_label_id, resources_load_filter_criterion_id) VALUES (1825, 1, 'reports', 'f61ce5c70ced64bdc89bb9ded8dd2076baefb51a45997b5aca911e0d2df7997605c7fc3b6c793fa886591b531e3c2430e31e8cce3a495b59c8e5b11c889f3e85', NULL, false, NULL, true, 0, false, true, true, '', '', NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2383 (class 2606 OID 26996)
-- Name: user_table_login_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_table
    ADD CONSTRAINT user_table_login_name_key UNIQUE (login_name);


--
-- TOC entry 2385 (class 2606 OID 26846)
-- Name: user_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_table
    ADD CONSTRAINT user_table_pkey PRIMARY KEY (id);


--
-- TOC entry 2386 (class 2606 OID 27705)
-- Name: fk7358465a4cd98327; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_table
    ADD CONSTRAINT fk7358465a4cd98327 FOREIGN KEY (lastconnectedscenario) REFERENCES scenario(id);


--
-- TOC entry 2388 (class 2606 OID 28054)
-- Name: user_criterion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_table
    ADD CONSTRAINT user_criterion_fkey FOREIGN KEY (resources_load_filter_criterion_id) REFERENCES criterion(id) ON DELETE SET NULL;


--
-- TOC entry 2387 (class 2606 OID 28049)
-- Name: user_label_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_table
    ADD CONSTRAINT user_label_fkey FOREIGN KEY (projects_filter_label_id) REFERENCES label(id) ON DELETE SET NULL;


-- Completed on 2020-01-07 09:03:46

--
-- PostgreSQL database dump complete
--

