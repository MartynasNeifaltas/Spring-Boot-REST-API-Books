CREATE TABLE IF NOT EXISTS books (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     author VARCHAR(255),
    description TEXT,
    rating FLOAT,
    title VARCHAR(255),
    "year" INT  -- Escaped the year keyword
    );
