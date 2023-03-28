CREATE DATABASE IF NOT EXISTS rtech;
USE rtech;

CREATE TABLE activity_type(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	text_activity_type TEXT NOT NULL
);

CREATE TABLE instructor (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_instructor VARCHAR(100) NOT NULL
);


CREATE TABLE category(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_category VARCHAR(100) NOT NULL,
    code_category VARCHAR(100) NOT NULL,
    description_category VARCHAR(255),
    study_guide VARCHAR(255),
    is_active VARCHAR(50) DEFAULT 'INATIVA',
    order_category INT,
	icon_path VARCHAR(100),
    html_color_code VARCHAR(100)
);

CREATE TABLE subcategory(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_subcategory VARCHAR(100) NOT NULL,
    code_subcategory VARCHAR(100) NOT NULL,
    description_subcategory VARCHAR(255),
    study_guide VARCHAR(255),
    is_active VARCHAR(50) DEFAULT 'INATIVA',
    order_subcategory INT,
    id_category BIGINT,

    FOREIGN KEY (id_category)
    REFERENCES category(id)
);

CREATE TABLE course (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_course VARCHAR(100) NOT NULL,
    code_course VARCHAR(100) NOT NULL,
    estimated_time_course_completion TINYINT NOT NULL,
    public_visibility VARCHAR(50) DEFAULT 'PRIVADA',
    target_public TEXT,
    id_instructor BIGINT NOT NULL,
    syllabus TEXT,
    developed_skills TEXT,
    id_subcategory BIGINT,
    
    FOREIGN KEY (id_instructor) 
    REFERENCES instructor(id),
    
    FOREIGN KEY (id_subcategory)
    REFERENCES subcategory(id)
);

CREATE TABLE section(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_section VARCHAR(100) NOT NULL,
    code_section VARCHAR(100) NOT NULL, 
    order_section INT,
    is_active bit DEFAULT 0,
    is_test bit DEFAULT 0,
    id_course BIGINT NOT NULL,
    
    FOREIGN KEY (id_course)
    REFERENCES course(id)
);

CREATE TABLE activity(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    code_activity VARCHAR(100) NOT NULL,
    is_inactive TINYINT DEFAULT 1,
    id_activity_type BIGINT,
    id_section BIGINT NOT NULL,
    
    FOREIGN KEY (id_activity_type)
    REFERENCES activity_type(id),
    
    FOREIGN KEY (id_section)
    REFERENCES section(id)
);

CREATE TABLE video(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    minutes INT, 
    description_video TEXT,
    id_activity_type BIGINT NOT NULL,
    
    FOREIGN KEY (id_activity_type)
    REFERENCES activity_type(id)
);

CREATE TABLE question(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type_question VARCHAR(100) DEFAULT 'unique answer',
    id_activity_type BIGINT NOT NULL,
    
    FOREIGN KEY (id_activity_type)
    REFERENCES activity_type(id)
);

CREATE TABLE explanation(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_activity_type BIGINT NOT NULL,
    
    FOREIGN KEY (id_activity_type) 
    REFERENCES activity_type(id)
);

CREATE TABLE alternative(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    text_alternative TEXT NOT NULL,
    order_alternative INT,
    is_correct TINYINT NOT NULL,
    justification TEXT,
    id_question BIGINT NOT NULL,
    
    FOREIGN KEY (id_question)
    REFERENCES question(id)
);