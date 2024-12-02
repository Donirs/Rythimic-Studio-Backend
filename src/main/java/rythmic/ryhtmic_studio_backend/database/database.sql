use rythmic_studio_backend;

CREATE TABLE users
(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    password VARCHAR(100) NOT NULL,
    avatar VARCHAR(100),
    role VARCHAR(10) DEFAULT "user",
    token VARCHAR(100) UNIQUE,
    token_expired_at TIMESTAMP,
    otp VARCHAR(4) UNIQUE,
    otp_expired_at TIMESTAMP,
    reset_token VARCHAR(100) UNIQUE,
    reset_token_expired_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE (email)
) ENGINE=InnoDB;

-- Drop the users table
-- DROP TABLE users;

CREATE TABLE studios (
                         id INT NOT NULL AUTO_INCREMENT,
                         owner_id INT NOT NULL,
                         name VARCHAR(100) NOT NULL,
                         phone_number VARCHAR(100) NOT NULL,
                         street VARCHAR(255) NOT NULL,
                         district VARCHAR(100) NOT NULL,
                         city_or_regency VARCHAR(100) NOT NULL,
                         province VARCHAR(100) NOT NULL,
                         country VARCHAR(100) NOT NULL,
                         postal_code VARCHAR(10) NOT NULL,
                         latitude DECIMAL(10, 6) NOT NULL,
                         longitude DECIMAL(10, 6) NOT NULL,
                         rating DECIMAL(2, 1) NOT NULL DEFAULT 0.0,
                         reviews_count INT NOT NULL DEFAULT 0,
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (id),
                         FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE gallery (
                         id INT NOT NULL AUTO_INCREMENT,
                         studio_id INT NOT NULL,
                         photo_url TEXT NOT NULL,
                         description TEXT COMMENT 'Deskripsi foto',
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (id),
                         FOREIGN KEY (studio_id) REFERENCES studios(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE fields (
                        id INT NOT NULL AUTO_INCREMENT,
                        studio_id INT NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        floor_type VARCHAR(100) NOT NULL,
                        court_length DECIMAL(5, 2) NOT NULL,
                        court_width DECIMAL(5, 2) NOT NULL,
                        net_height DECIMAL(5, 2) COMMENT 'Tinggi net jika ada',
                        goal_width DECIMAL(5, 2) COMMENT 'Lebar gawang jika ada',
                        goal_height DECIMAL(5, 2) COMMENT 'Tinggi gawang jika ada',
                        ring_height DECIMAL(5, 2) COMMENT 'Tinggi ring jika ada',
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (id),
                        FOREIGN KEY (studio_id) REFERENCES studios(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE schedules (
                           id INT NOT NULL AUTO_INCREMENT,
                           field_id INT NOT NULL,
                           date DATE NOT NULL,
                           time_slot VARCHAR(100) NOT NULL,
                           price BIGINT NOT NULL,
                           status VARCHAR(100) NOT NULL DEFAULT 'available',
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (id),
                           FOREIGN KEY (field_id) REFERENCES fields(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE reviews (
                         id INT NOT NULL AUTO_INCREMENT,
                         studio_id INT NOT NULL,
                         user_id INT NOT NULL,
                         type VARCHAR(100) NOT NULL,
                         rating INT NOT NULL,
                         comment TEXT,
                         photo VARCHAR(100),
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (id),
                         FOREIGN KEY (studio_id) REFERENCES studios(id) ON DELETE CASCADE,
                         FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

show tables;