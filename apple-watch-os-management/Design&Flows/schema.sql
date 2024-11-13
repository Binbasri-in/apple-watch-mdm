
-- Devices Table
CREATE TABLE devices
(
    id SERIAL PRIMARY KEY NOT NULL,
    identity_cert TEXT NULL,
    serial_number VARCHAR(127) NULL,

    -- latest Authenticate
    authenticate TEXT NOT NULL,
    authenticate_at TIMESTAMP NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP -- trigger

);



-- -- function to update updated_at on each update
-- CREATE FUNCTION update_current_timestamp()
--     RETURNS TRIGGER AS
--     $$
-- BEGIN
--     NEW.updated_at = now();
-- RETURN NEW;
-- END;
-- $$ language 'plpgsql';


-- -- triggers for each update_at
-- CREATE TRIGGER update_at_to_current_timestamp BEFORE UPDATE ON devices
--     FOR EACH ROW EXECUTE PROCEDURE update_current_timestamp();

