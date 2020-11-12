

INSERT INTO tipo_moneda (id, tipo_moneda) values (1, 'SOLES');
INSERT INTO tipo_moneda (id, tipo_moneda) values (2, 'DOLARES');

INSERT INTO tipo_mantenimiento (id, nombre_tipo_mantenimiento, numero_tipo_mantenimiento) values (1, 'Mensual', 30);
INSERT INTO tipo_mantenimiento (id, nombre_tipo_mantenimiento, numero_tipo_mantenimiento) values (2, 'Trimestral', 90);
INSERT INTO tipo_mantenimiento (id, nombre_tipo_mantenimiento, numero_tipo_mantenimiento) values (3, 'Semestral', 180);

INSERT INTO Tipo_Tasa (id, nombre_tipo_tasa) values (1, 'Simple');
INSERT INTO Tipo_Tasa (id, nombre_tipo_tasa) values (2, 'Efectiva');
INSERT INTO Tipo_Tasa (id, nombre_tipo_tasa) values (3, 'Nominal');

INSERT INTO Periodo_Tasa (id, nombre_periodo_tasa, numero_periodo_tasa) values (1, 'Quincenal', 15);
INSERT INTO Periodo_Tasa (id, nombre_periodo_tasa, numero_periodo_tasa) values (2, 'Mensual', 30);
INSERT INTO Periodo_Tasa (id, nombre_periodo_tasa, numero_periodo_tasa) values (3, 'Bimestral', 60);
INSERT INTO Periodo_Tasa (id, nombre_periodo_tasa, numero_periodo_tasa) values (4, 'Trimestral', 90);
INSERT INTO Periodo_Tasa (id, nombre_periodo_tasa, numero_periodo_tasa) values (5, 'Semestral', 180);

INSERT INTO Tipo_Delivery (id, monto_tipo_delivery) values (1, 1.50);
INSERT INTO Tipo_Delivery (id, monto_tipo_delivery) values (2, 2.00);
INSERT INTO Tipo_Delivery (id, monto_tipo_delivery) values (3, 2.50);
INSERT INTO Tipo_Delivery (id, monto_tipo_delivery) values (4, 3.50);
INSERT INTO Tipo_Delivery (id, monto_tipo_delivery) values (5, 5.00);

INSERT INTO Administrador (id, nombres_apellidos, correo_electronico, contraseña) values (1, 'Aldo Mendoza Marín', 'aldoanderson10@gmail.com', '123');