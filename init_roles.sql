
USE tas_db;

-- Insertar roles si no existen
INSERT INTO rol (id_rol, descripcion) VALUES ('ROL_CLIENTE', 'Cliente - Usuario que reserva citas')
ON DUPLICATE KEY UPDATE descripcion = 'Cliente - Usuario que reserva citas';

INSERT INTO rol (id_rol, descripcion) VALUES ('ROL_PROFESIONAL', 'Profesional - Usuario que ofrece servicios')
ON DUPLICATE KEY UPDATE descripcion = 'Profesional - Usuario que ofrece servicios';

SELECT * FROM rol;
