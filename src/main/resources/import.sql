

INSERT INTO tipo_moneda (ctipo_moneda, ntipo_moneda) values (1, 'SOLES');
INSERT INTO tipo_moneda (ctipo_moneda, ntipo_moneda) values (2, 'DOLARES');

INSERT INTO tipo_mantenimiento (ctipo_mantenimiento, ntipo_mantenimiento, num_tipo_mantenimiento) values (1, 'Mensual', 30);
INSERT INTO tipo_mantenimiento (ctipo_mantenimiento, ntipo_mantenimiento, num_tipo_mantenimiento) values (2, 'Trimestral', 90);
INSERT INTO tipo_mantenimiento (ctipo_mantenimiento, ntipo_mantenimiento, num_tipo_mantenimiento) values (3, 'Semestral', 180);

INSERT INTO tipo_tasa (ctipo_tasa, ntipo_tasa) values (1, 'Simple');
INSERT INTO tipo_tasa (ctipo_tasa, ntipo_tasa) values (2, 'Efectiva');
INSERT INTO tipo_tasa (ctipo_tasa, ntipo_tasa) values (3, 'Nominal');

INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (1, 'Quincenal', 15);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (2, 'Mensual', 30);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (3, 'Bimestral', 60);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (4, 'Trimestral', 90);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (5, 'Semestral', 180);

INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (1, 1.50);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (2, 2.00);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (3, 2.50);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (4, 3.50);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (5, 5.00);



INSERT INTO administrador (cadministrador, nadministrador, ncorreo, ncontrasenia) values (1, 'Aldo Mendoza Marín', 'aldoanderson10@gmail.com', '123');

INSERT INTO cliente (ccliente, bestado, napellido, nnombre, numdni,num_telefono) values (1,1,'Mendoza Marin', 'Aldo Anderson', 12345678, 34);

INSERT INTO linea (clinea, dfecha_emision, ncapitalizacion, ntasa, num_anio, num_credito, num_mantenimiento, cliente_id, periodotasa_id, tipomantenimiento_id, tipomoneda_id, tipotasa_id) values (1,'2020-11-19',2323,2323,360,3232,2.5,1,1,1,1,1);