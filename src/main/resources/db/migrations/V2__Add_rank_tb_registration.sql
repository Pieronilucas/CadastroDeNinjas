-- Migrations to add the column RANK in the registration table

ALTER TABLE tb_registration
ADD COLUMN rank VARCHAR(255);