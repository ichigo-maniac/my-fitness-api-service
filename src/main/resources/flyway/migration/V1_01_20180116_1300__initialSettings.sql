CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE OR REPLACE FUNCTION compare_dates(first_date timestamp, second_date timestamp) RETURNS boolean AS $$
  BEGIN
    -- check null
    IF ((first_date IS NULL) AND (second_date IS NULL)) THEN
      RETURN true;
    END IF;
    IF ((first_date IS NULL) AND (second_date IS NOT NULL)) THEN
      RETURN false;
    END IF;
    IF ((first_date IS NOT NULL) AND (second_date IS NULL)) THEN
      RETURN false;
    END IF;
    -- year
    IF extract(year from first_date) <> extract(year from second_date) THEN
      RETURN false;
    END IF;
    -- month --
    IF extract(month from first_date) <> extract(month from second_date) THEN
      RETURN false;
    END IF;
    -- day --
    IF extract(day from first_date) <> extract(day from second_date) THEN
      RETURN false;
    END IF;

    RETURN true;
  END;
$$ LANGUAGE plpgsql;