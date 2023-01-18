CREATE DATABASE IF NOT EXISTS rtech;
USE rtech;

CREATE TABLE activity_type(
	id INT PRIMARY KEY AUTO_INCREMENT,
	text_activity_type TEXT NOT NULL
);

CREATE TABLE instructor (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name_instructor VARCHAR(100) NOT NULL
);

CREATE TABLE category_information (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name_category VARCHAR(100) NOT NULL,
    code_category VARCHAR(100) NOT NULL, 
    description_category TEXT,
    study_guide TEXT,
    is_active VARCHAR(50) DEFAULT 'INATIVA',
    order_category INT
);

CREATE TABLE category(
	id INT PRIMARY KEY AUTO_INCREMENT,
	icon_path VARCHAR(100),
    html_color_code VARCHAR(100),
    id_category_information INT NOT NULL,
    
    FOREIGN KEY (id_category_information)
    REFERENCES category_information(id)
);

CREATE TABLE subcategory(
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_category_information INT NOT NULL,
    id_category INT,
    
    FOREIGN KEY (id_category_information)
    REFERENCES category_information(id),
    
    FOREIGN KEY (id_category)
    REFERENCES category(id)
);

CREATE TABLE course (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name_course VARCHAR(100) NOT NULL,
    code_course VARCHAR(100) NOT NULL,
    estimated_time_course_completion TINYINT NOT NULL,
    public_visibility VARCHAR(50) DEFAULT 'PRIVADA',
    target_public TEXT,
    id_instructor INT NOT NULL,
    syllabus TEXT,
    developed_skill TEXT,    
    id_subcategory INT,
    
    FOREIGN KEY (id_instructor) 
    REFERENCES instructor(id),
    
    FOREIGN KEY (id_subcategory)
    REFERENCES subcategory(id)
);

CREATE TABLE section(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name_section VARCHAR(100) NOT NULL,
    code_section VARCHAR(100) NOT NULL, 
    order_section INT,
    is_active TINYINT DEFAULT 0,
    is_test TINYINT DEFAULT 0,
    id_course INT NOT NULL, 
    
    FOREIGN KEY (id_course)
    REFERENCES course(id)
);

CREATE TABLE activity(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    code_activity VARCHAR(100) NOT NULL,
    is_inactive TINYINT DEFAULT 1,
    id_activity_type INT,
    id_section INT NOT NULL,
    
    FOREIGN KEY (id_activity_type)
    REFERENCES activity_type(id),
    
    FOREIGN KEY (id_section)
    REFERENCES section(id)
);

CREATE TABLE video(
	id INT PRIMARY KEY AUTO_INCREMENT,
    minutes INT, 
    description_video TEXT,
    id_activity_type INT NOT NULL,
    
    FOREIGN KEY (id_activity_type)
    REFERENCES activity_type(id)
);

CREATE TABLE question(
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_question VARCHAR(100) DEFAULT 'unique answer',
    id_activity_type INT NOT NULL,
    
    FOREIGN KEY (id_activity_type)
    REFERENCES activity_type(id)
);

CREATE TABLE explanation(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_activity_type INT NOT NULL,
    
    FOREIGN KEY (id_activity_type) 
    REFERENCES activity_type(id)
);

CREATE TABLE alternative(
	id INT PRIMARY KEY AUTO_INCREMENT,
    text_alternative TEXT NOT NULL,
    order_alternative INT,
    is_correct TINYINT NOT NULL,
    justification TEXT,
    id_question INT NOT NULL,
    
    FOREIGN KEY (id_question)
    REFERENCES question(id)
);

DROP SCHEMA rtech;