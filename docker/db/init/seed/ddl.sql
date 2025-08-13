-- DDL
CREATE TABLE trends
(
    id         bigserial PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content    text         NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);
