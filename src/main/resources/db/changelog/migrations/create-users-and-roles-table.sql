CREATE TABLE roles (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL UNIQUE,
                       is_deleted  BOOLEAN DEFAULT false,
                       created_by  BIGINT NOT NULL DEFAULT 0,
                       modified_by BIGINT NOT NULL DEFAULT 0,
                       created_at  TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
                       modified_at TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL
);

CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       surname VARCHAR(255),
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       is_deleted  BOOLEAN DEFAULT false,
                       created_by  BIGINT NOT NULL DEFAULT 0,
                       modified_by BIGINT NOT NULL DEFAULT 0,
                       created_at  TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
                       modified_at TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL
);

CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            role_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id),
                            FOREIGN KEY (role_id) REFERENCES roles(id)
);