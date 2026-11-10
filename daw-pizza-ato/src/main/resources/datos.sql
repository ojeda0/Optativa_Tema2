-- =============================================
-- INSERTS: CLIENTE
-- =============================================
INSERT INTO cliente (nombre, direccion, email, telefono) VALUES
('Alejandro Morales', 'Avenida del Prado 14, 2B', 'a.morales@servidor-mail.com', '611223344'),
('Lucía Valverde', 'Calle Luna 45', 'lucia.valverde@correo-red.es', '622334455'),
('Mateo Fernández', 'Plaza Mayor 8, Bajo A', 'mateo.fernandez@inbox-web.org', '633445566'),
('Elena Benítez', 'Camino Real 102', 'elena.b@post-digital.net', '644556677'),
('Sergio Garrido', 'Ronda de Poniente 3, 4A', 's.garrido@dominio-correo.com', '655667788');

-- =============================================
-- INSERTS: PIZZA
-- =============================================
INSERT INTO pizza (nombre, descripcion, precio, vegetariana, vegana, disponible) VALUES
('Rústica de Campo', 'Base de tomate, mozzarella fior di latte, setas silvestres y aceite de trufa', 12.50, TRUE, FALSE, TRUE),
('Brasa Ibérica', 'Salsa barbacoa artesanal, carne mechada, bacon ahumado y cebolla crujiente', 13.90, FALSE, FALSE, TRUE),
('Huerta Mediterránea', 'Verduras asadas de temporada, aceitunas kalamata y queso vegetal', 11.80, TRUE, TRUE, TRUE),
('Cuatro Quesos Suaves', 'Combinación de gouda curado, emmental, gorgonzola dulce y parmesano', 12.00, TRUE, FALSE, TRUE),
('Diávola Picante', 'Tomate San Marzano, chorizo criollo picante, jalapeños y orégano', 13.20, FALSE, FALSE, FALSE);

-- =============================================
-- INSERTS: PEDIDO
-- =============================================
INSERT INTO pedido (id_cliente, fecha, total, metodo, notas) VALUES
(1, '2026-03-01 13:45:00', 25.00, 'DOMICILIO', 'Llamar al telefonillo del portal B'),
(2, '2026-03-01 14:15:30', 13.90, 'RECOGER', 'Recogida rápida en mostrador'),
(3, '2026-03-02 20:30:00', 35.80, 'LOCAL', 'Mesa asignada junto a la cristalera'),
(4, '2026-03-02 21:00:15', 11.80, 'DOMICILIO', 'Dejar pedido en conserjería'),
(5, '2026-03-03 21:40:00', 24.50, 'LOCAL', 'Celebración de cumpleaños');

-- =============================================
-- INSERTS: PIZZA_PEDIDO
-- =============================================
INSERT INTO pizza_pedido (id_pedido, id_pizza, cantidad, precio) VALUES
(1, 1, 2.0, 12.50),
(2, 2, 1.0, 13.90),
(3, 3, 1.0, 11.80),
(3, 4, 2.0, 12.00),
(4, 3, 1.0, 11.80);