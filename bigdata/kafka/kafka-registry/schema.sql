DROP TABLE IF EXISTS schema_serdes_mapping;
DROP TABLE IF EXISTS schema_serdes_info;
DROP TABLE IF EXISTS schema_field_info;
DROP TABLE IF EXISTS schema_version_info;
DROP TABLE IF EXISTS schema_metadata_info;

CREATE TABLE IF NOT EXISTS schema_metadata_info (
  id              BIGINT AUTO_INCREMENT NOT NULL,
  type            VARCHAR(255)          NOT NULL,
  schemaGroup     VARCHAR(255)          NOT NULL,
  name            VARCHAR(255)          NOT NULL,
  compatibility   VARCHAR(255)          NOT NULL,
  validationLevel VARCHAR(255)          NOT NULL, -- added in 0.3.1, table should be altered to add this column from earlier versions.
  description     TEXT,
  evolve          BOOLEAN               NOT NULL,
  timestamp       BIGINT                NOT NULL,
  PRIMARY KEY (name),
  UNIQUE KEY (id)
);

CREATE TABLE IF NOT EXISTS schema_version_info (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  description      TEXT,
  schemaText       LONGTEXT              NOT NULL,
  fingerprint      TEXT                  NOT NULL,
  version          INT                   NOT NULL,
  schemaMetadataId BIGINT                NOT NULL,
  timestamp        BIGINT                NOT NULL,
  name             VARCHAR(255)          NOT NULL,
  UNIQUE KEY (id),
  UNIQUE KEY `UK_METADATA_ID_VERSION_FK` (schemaMetadataId, version),
  PRIMARY KEY (name, version)
);

CREATE TABLE IF NOT EXISTS schema_field_info (
  id               BIGINT AUTO_INCREMENT NOT NULL,
  schemaInstanceId BIGINT                NOT NULL,
  timestamp        BIGINT                NOT NULL,
  name             VARCHAR(255)          NOT NULL,
  fieldNamespace   VARCHAR(255),
  type             VARCHAR(255)          NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS schema_serdes_info (
  id                    BIGINT AUTO_INCREMENT NOT NULL,
  description           TEXT,
  name                  TEXT                  NOT NULL,
  fileId                TEXT                  NOT NULL,
  serializerClassName   TEXT                  NOT NULL,
  deserializerClassName TEXT                  NOT NULL,
  timestamp             BIGINT                NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS schema_serdes_mapping (
  schemaMetadataId BIGINT NOT NULL,
  serDesId         BIGINT NOT NULL,
  UNIQUE KEY `UK_IDS` (schemaMetadataId, serdesId)
);