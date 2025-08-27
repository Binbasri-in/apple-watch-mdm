CREATE TABLE devices
(
    id                   VARCHAR(255) NOT NULL,
    identity_cert        TEXT         NULL,
    serial_number        VARCHAR(127) NULL,
    unlock_token         BYTEA        NULL,
    unlock_token_at      TIMESTAMP    NULL,
    authenticate         TEXT         NOT NULL,
    authenticate_at      TIMESTAMP    NOT NULL,
    token_update         TEXT         NULL,
    token_update_at      TIMESTAMP    NULL,
    bootstrap_token_b64  TEXT         NULL,
    bootstrap_token_at   TIMESTAMP    NULL,
    created_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
CREATE INDEX serial_number ON devices (serial_number);
CREATE TABLE users
(
    id                            VARCHAR(255) NOT NULL,
    device_id                     VARCHAR(255) NOT NULL,
    user_short_name               VARCHAR(255) NULL,
    user_long_name                VARCHAR(255) NULL,
    token_update                  TEXT         NULL,
    token_update_at               TIMESTAMP    NULL,
    user_authenticate             TEXT         NULL,
    user_authenticate_at          TIMESTAMP    NULL,
    user_authenticate_digest      TEXT         NULL,
    user_authenticate_digest_at   TIMESTAMP    NULL,
    created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, device_id),
    UNIQUE (id),
    FOREIGN KEY (device_id)
        REFERENCES devices (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE enrollments
(
    id                   VARCHAR(255) NOT NULL,
    device_id            VARCHAR(255) NOT NULL,
    user_id              VARCHAR(255) NULL,
    type                 VARCHAR(31)  NOT NULL,
    topic                VARCHAR(255) NOT NULL,
    push_magic           VARCHAR(127) NOT NULL,
    token_hex            VARCHAR(255) NOT NULL,
    enabled              BOOLEAN      NOT NULL DEFAULT TRUE,
    token_update_tally   INTEGER      NOT NULL DEFAULT 1,
    last_seen_at         TIMESTAMP    NOT NULL,
    created_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (device_id)
        REFERENCES devices (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE (user_id)
);
CREATE INDEX idx_type ON enrollments (type);
CREATE TABLE commands
(
    command_uuid   VARCHAR(127) NOT NULL,
    request_type   VARCHAR(63)  NOT NULL,
    command        TEXT         NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (command_uuid)
);
CREATE TABLE command_results
(
    id             VARCHAR(255) NOT NULL,
    command_uuid   VARCHAR(127) NOT NULL,
    status         VARCHAR(31)  NOT NULL,
    result         TEXT         NOT NULL,
    not_now_at     TIMESTAMP    NULL,
    not_now_tally  INTEGER      NOT NULL DEFAULT 0,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, command_uuid),
    FOREIGN KEY (id)
        REFERENCES enrollments (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (command_uuid)
        REFERENCES commands (command_uuid)
        ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX idx_status ON command_results (status);
CREATE TABLE enrollment_queue
(
    id             VARCHAR(255) NOT NULL,
    command_uuid   VARCHAR(127) NOT NULL,
    active         BOOLEAN      NOT NULL DEFAULT TRUE,
    priority       SMALLINT     NOT NULL DEFAULT 0,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, command_uuid),
    FOREIGN KEY (id)
        REFERENCES enrollments (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (command_uuid)
        REFERENCES commands (command_uuid)
        ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE OR REPLACE VIEW view_queue AS
SELECT q.id,
       q.created_at,
       q.active,
       q.priority,
       c.command_uuid,
       c.request_type,
       c.command,
       r.updated_at AS result_updated_at,
       r.status,
       r.result
FROM enrollment_queue AS q
    INNER JOIN commands AS c ON q.command_uuid = c.command_uuid
    LEFT JOIN command_results r ON r.command_uuid = q.command_uuid AND r.id = q.id
ORDER BY q.priority DESC, q.created_at;
CREATE TABLE push_certs
(
    topic         VARCHAR(255) NOT NULL,
    cert_pem      TEXT         NOT NULL,
    key_pem       TEXT         NOT NULL,
    stale_token   INTEGER      NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (topic)
);
CREATE TABLE cert_auth_associations
(
    id            VARCHAR(255) NOT NULL,
    sha256        CHAR(64)     NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, sha256)
);








