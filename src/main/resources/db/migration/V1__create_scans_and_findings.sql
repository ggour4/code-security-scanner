CREATE TABLE scans (
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    language    VARCHAR(20)  NOT NULL,
    code        TEXT         NOT NULL,
    status      VARCHAR(20)  NOT NULL,
    created_at  TIMESTAMPTZ  NOT NULL
);

CREATE TABLE findings (
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    scan_id     BIGINT       NOT NULL REFERENCES scans (id) ON DELETE CASCADE,
    rule_id     VARCHAR(200) NOT NULL,
    severity    VARCHAR(20)  NOT NULL,
    message     TEXT         NOT NULL,
    start_line  INT          NOT NULL,
    end_line    INT          NOT NULL
);

CREATE INDEX idx_findings_scan_id ON findings (scan_id);