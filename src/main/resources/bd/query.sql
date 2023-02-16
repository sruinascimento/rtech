USE rtech;

-- os dados de todas as categorias ativas, na ordem
SELECT ci.id, ci.name_category, ci.code_category, description_category,
ci.study_guide, ci.is_active, ci.order_category, c.id, c.icon_path, c.html_color_code,
c.id_category_information FROM category_information ci 
INNER JOIN category c 
ON ci.id = c.id_category_information
WHERE ci.is_active = 'ATIVA'
ORDER BY ci.order_category ASC;

-- os dados de todas as subcategorias ativas, na ordem
SELECT ci.name_category, ci.code_category, description_category,
ci.study_guide, ci.is_active, ci.order_category, s.id_category FROM category_information ci 
INNER JOIN subcategory s 
ON ci.id = s.id_category_information
WHERE ci.is_active = 'ATIVA'
ORDER BY ci.order_category ASC;

-- os dados de todos os cursos públicos
SELECT c.id, c.name_course, c.code_course, c.estimated_time_course_completion, c.public_visibility, c.target_public, i.name_instructor, c.syllabus, 
c.developed_skill, ci.code_category, s.id AS `Subcategory Id`, ci.name_category AS `Subcategory Name`  FROM course c
INNER JOIN instructor i 
ON c.id_instructor = i.id
INNER JOIN subcategory s 
ON s.id = c.id_subcategory
INNER JOIN category_information ci 
ON ci.id = s.id_category_information
WHERE c.public_visibility = 'PÚBLICA';

-- os nomes das subcategorias que não tem descrições
SELECT ci.name_category FROM category_information ci 
INNER JOIN subcategory s 
ON s.id_category_information = ci.id
INNER JOIN category c 
ON c.id = s.id_category 
WHERE ci.description_category  IS NULL;


