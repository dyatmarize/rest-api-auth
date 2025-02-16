CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255)        NOT NULL,
    email         VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255)        NOT NULL,
    created_at    TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE blog_posts
(
    id         SERIAL PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    author_id  INTEGER      NOT NULL REFERENCES Users (id) ON DELETE CASCADE,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comments
(
    id          SERIAL PRIMARY KEY,
    post_id     INTEGER      NOT NULL REFERENCES BlogPosts (id) ON DELETE CASCADE,
    author_name VARCHAR(255) NOT NULL,
    content     TEXT         NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);