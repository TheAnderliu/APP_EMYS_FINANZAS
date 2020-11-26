

INSERT INTO tipo_moneda (ctipo_moneda, ntipo_moneda) values (1, 'SOLES');
INSERT INTO tipo_moneda (ctipo_moneda, ntipo_moneda) values (2, 'DOLARES');

INSERT INTO tipo_mantenimiento (ctipo_mantenimiento, ntipo_mantenimiento, num_tipo_mantenimiento) values (1, 'Mensual', 30);
INSERT INTO tipo_mantenimiento (ctipo_mantenimiento, ntipo_mantenimiento, num_tipo_mantenimiento) values (2, 'Trimestral', 90);
INSERT INTO tipo_mantenimiento (ctipo_mantenimiento, ntipo_mantenimiento, num_tipo_mantenimiento) values (3, 'Semestral', 180);

INSERT INTO tipo_tasa (ctipo_tasa, ntipo_tasa) values (1, 'Simple');
INSERT INTO tipo_tasa (ctipo_tasa, ntipo_tasa) values (2, 'Nominal');
INSERT INTO tipo_tasa (ctipo_tasa, ntipo_tasa) values (3, 'Efectiva');


INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (1, 'Quincenal', 15);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (2, 'Mensual', 30);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (3, 'Bimestral', 60);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (4, 'Trimestral', 90);
INSERT INTO periodo_tasa (cperiodo_tasa, nperiodo_tasa, num_periodo_tasa) values (5, 'Semestral', 180);

INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (1, 0);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (2, 1.50);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (3, 2.00);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (4, 2.50);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (5, 3.50);
INSERT INTO tipo_delivery (ctipo_delivery, monto_tipo_delivery) values (6, 5.00);



INSERT INTO administrador (cadministrador, nadministrador, ncorreo, ncontrasenia) values (1, 'Admin Emys', 'candydh@gmail.com', 'admin456');

INSERT INTO cliente (ccliente, bestado, napellido, nnombre, numdni,num_telefono) values (1,1,'Mendoza Marin', 'Aldo Anderson', 72260850, 941473807);

INSERT INTO linea (clinea, dfecha_emision, ncapitalizacion, ntasa, num_anio, num_credito, num_mantenimiento, cliente_id, periodotasa_id, tipomantenimiento_id, tipomoneda_id, tipotasa_id, deuda_total) values (1,'2020-11-19',3,10,360,100,2.5,1,1,1,1,3, 0.0);

insert into transaccion (ctransaccion, btipo, dfecha, monto, tdescripcion, tipodelivery_id, linea_id) values (1, 1, '2020-11-20', 21, 'Compra de shampoo más acondicionador', 1, 1);
insert into transaccion (ctransaccion, btipo, dfecha, monto, tdescripcion, tipodelivery_id, linea_id) values (2, 1, '2020-11-24', 30, 'Compra de perfume frutal', 1, 1);
insert into transaccion (ctransaccion, btipo, dfecha, monto, tdescripcion, tipodelivery_id, linea_id) values (3, 0, '2020-11-28', 30, 'Pago adelantado', 1, 1);