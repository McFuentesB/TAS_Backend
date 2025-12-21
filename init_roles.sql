
USE tas_db;

-- Insertar roles si no existen
INSERT INTO rol (id_rol, descripcion) VALUES ('ROL_CLIENTE', 'Cliente - Usuario que reserva citas')
ON DUPLICATE KEY UPDATE descripcion = 'Cliente - Usuario que reserva citas';

INSERT INTO rol (id_rol, descripcion) VALUES ('ROL_PROFESIONAL', 'Profesional - Usuario que ofrece servicios')
ON DUPLICATE KEY UPDATE descripcion = 'Profesional - Usuario que ofrece servicios';

SELECT * FROM rol;

-- =========================================
-- 1) ROLES
-- =========================================
INSERT INTO rol (id_rol, descripcion) VALUES
 ('ROL_CLIENTE', 'Cliente - Usuario que reserva citas'),
 ('ROL_PROFESIONAL', 'Profesional - Usuario que ofrece servicios')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion);

-- =========================================
-- 2) PROFESIONES
-- =========================================
INSERT INTO profesion (id_profesion, descripcion) VALUES
 ('KINE',  'Kinesiólogo'),
 ('PSICO', 'Psicólogo')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion);

-- =========================================
-- 3) RUBROS
-- =========================================
INSERT INTO rubro (id_rubro, descripcion) VALUES
 ('SALUD', 'Salud'),
 ('EDUC',  'Educación')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion);

-- =========================================
-- 4) SERVICIOS PROFESIONALES
-- =========================================
INSERT INTO servicio_profesional (id_servicio_profesional, descripcion_servicio_profesional) VALUES
 ('KINE_DOM',  'Kinesiología a domicilio'),
 ('PSICO_ONL', 'Psicoterapia online')
ON DUPLICATE KEY UPDATE descripcion_servicio_profesional = VALUES(descripcion_servicio_profesional);

-- =========================================
-- 5) TIPOS DE CITA
-- =========================================
INSERT INTO tipo_cita (id_tipo_cita, descripcion) VALUES
 ('ONLINE',     'Consulta online'),
 ('PRESENCIAL', 'Consulta presencial')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion);

-- =========================================
-- 6) PAGOS
-- =========================================
INSERT INTO pagos (id_pago, estado_pago) VALUES
 ('PAGO_1', 'PENDIENTE')
ON DUPLICATE KEY UPDATE estado_pago = VALUES(estado_pago);

-- =========================================
-- 7) USUARIOS BASE (1 CLIENTE, 1 PROFESIONAL)
--  IMPORTANTE:
--  - Usa estos correos/clave para las pruebas de login:
--    * cliente@test.com / 1234
--    * profesional@test.com / 1234
--  Si en tu API la clave va encriptada (BCrypt), reemplaza '1234' por el hash.
-- =========================================
INSERT INTO usuario (
    id_usuario, nombre, apellido, correo, clave,
    id_rol, foto_url, telefono, onboarded, user_type
) VALUES
('USR_CLIENTE_1', 'Juan', 'Pérez', 'cliente@test.com', '1234',
 'ROL_CLIENTE', NULL, '56911111111', 1, 'CLIENTE'),
('USR_PROF_1', 'Ana', 'González', 'profesional@test.com', '1234',
 'ROL_PROFESIONAL', NULL, '56922222222', 1, 'PROFESIONAL')
ON DUPLICATE KEY UPDATE
  nombre     = VALUES(nombre),
  apellido   = VALUES(apellido),
  correo     = VALUES(correo),
  id_rol     = VALUES(id_rol),
  telefono   = VALUES(telefono),
  onboarded  = VALUES(onboarded),
  user_type  = VALUES(user_type);

-- =========================================
-- 8) USUARIO CLIENTE
-- =========================================
INSERT INTO usuario_cliente (id_usuario_cliente, id_usuario) VALUES
 ('UCLI_1', 'USR_CLIENTE_1')
ON DUPLICATE KEY UPDATE id_usuario = VALUES(id_usuario);

-- =========================================
-- 9) USUARIO PROFESIONAL
-- =========================================
INSERT INTO usuario_profesional (
    id_usuario_profesional,
    id_usuario,
    id_profesion,
    id_servicio_profesional,
    id_rubro,
    descripcion,
    experiencia,
    pais,
    ciudad,
    servicios,
    precio_hora
) VALUES
('UPROF_1',
 'USR_PROF_1',
 'KINE',          -- Profesión
 'KINE_DOM',      -- Servicio profesional
 'SALUD',         -- Rubro
 'Kinesiólogo especializado en rehabilitación deportiva',
 '5 años',
 'Chile',
 'Santiago',
 'Rehabilitación;Terapia deportiva',
 30000)
ON DUPLICATE KEY UPDATE
 id_usuario              = VALUES(id_usuario),
 id_profesion            = VALUES(id_profesion),
 id_servicio_profesional = VALUES(id_servicio_profesional),
 id_rubro                = VALUES(id_rubro),
 descripcion             = VALUES(descripcion),
 experiencia             = VALUES(experiencia),
 pais                    = VALUES(pais),
 ciudad                  = VALUES(ciudad),
 servicios               = VALUES(servicios),
 precio_hora             = VALUES(precio_hora);

-- =========================================
-- 10) CITA DE PRUEBA ENTRE EL CLIENTE Y EL PROFESIONAL
-- =========================================
INSERT INTO cita (
    id_cita,
    id_usuario_cliente,
    id_usuario_profesional,
    fecha,
    hora,
    comentario,
    calificacion,
    id_tipo_cita,
    id_pago
) VALUES
('CITA_1',
 'UCLI_1',
 'UPROF_1',
 '2025-01-10',
 '10:00',
 'Dolor de rodilla al correr',
 NULL,
 'ONLINE',
 'PAGO_1')
ON DUPLICATE KEY UPDATE
  comentario   = VALUES(comentario),
  id_tipo_cita = VALUES(id_tipo_cita),
  id_pago      = VALUES(id_pago);

-- =========================================
-- 11) COMENTARIO SOBRE LA CITA
-- =========================================
INSERT INTO comentarios (
    id_comentario,
    id_usuario_profesional,
    id_usuario_cliente,
    calificacion,
    comentario
) VALUES
('COM_1',
 'UPROF_1',
 'UCLI_1',
 '5',
 'Excelente atención, muy recomendable')
ON DUPLICATE KEY UPDATE
  calificacion = VALUES(calificacion),
  comentario   = VALUES(comentario);

-- =========================================
-- 12) HISTORIAL DE LA CITA
-- =========================================
INSERT INTO historial (
    id_historial,
    comentario,
    id_cita
) VALUES
('HIST_1',
 'Paciente refiere mejoría después de dos sesiones',
 'CITA_1')
ON DUPLICATE KEY UPDATE
  comentario = VALUES(comentario),
  id_cita    = VALUES(id_cita);
