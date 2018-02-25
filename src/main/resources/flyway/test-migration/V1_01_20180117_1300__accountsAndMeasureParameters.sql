CREATE TABLE ACCOUNTS(
  uuid CHARACTER VARYING(36) NOT NULL PRIMARY KEY,
  creation_time TIMESTAMP NOT NULL,
  modification_time TIMESTAMP NOT NULL,
  length_unit CHARACTER VARYING(255) NOT NULL,
  weight_unit CHARACTER VARYING(255) NOT NULL,
  facebook_id CHARACTER VARYING(255),
  vk_id CHARACTER VARYING(255),
  twitter_id CHARACTER VARYING(255)
);

CREATE TABLE MEASURE_PARAMETERS(
  uuid CHARACTER VARYING(36) NOT NULL PRIMARY KEY,
  creation_time TIMESTAMP NOT NULL,
  modification_time TIMESTAMP NOT NULL,
  account_uuid CHARACTER VARYING(36) NOT NULL REFERENCES ACCOUNTS(uuid) ON DELETE RESTRICT,
  weight_value REAL,
  record_date DATE NOT NULL,
  weight_unit CHARACTER VARYING(255) NOT NULL
);

INSERT INTO ACCOUNTS(uuid, creation_time, modification_time, length_unit, weight_unit) VALUES (
  '4a9b636e-f065-11e6-9dac-836adef2f111', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  'METER', 'KILOGRAM'
);

INSERT INTO MEASURE_PARAMETERS(uuid, creation_time, modification_time, account_uuid, weight_value, record_date, weight_unit) VALUES (
  '4a9b636e-f065-11e6-9dac-836adef2f3a6', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '4a9b636e-f065-11e6-9dac-836adef2f111', 105.0, '2018-01-15', 'KILOGRAM'
);

INSERT INTO MEASURE_PARAMETERS(uuid, creation_time, modification_time, account_uuid, weight_value, record_date, weight_unit) VALUES (
  '4a9b636e-f065-11e6-9dac-836adef21106', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '4a9b636e-f065-11e6-9dac-836adef2f111', 104.1, '2018-01-17', 'KILOGRAM'
);

INSERT INTO MEASURE_PARAMETERS(uuid, creation_time, modification_time, account_uuid, weight_value, record_date, weight_unit) VALUES (
  '4a9b636e-f065-11e6-9dac-836adef55314', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '4a9b636e-f065-11e6-9dac-836adef2f111', 103.0, '2018-01-19', 'KILOGRAM'
);