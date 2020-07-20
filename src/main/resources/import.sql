INSERT INTO venta(fecha,lugar, monto, nombre_cliente,observacion,tipo_de_venta) VALUES (NOW(),'Chillan',120000,'Doctor Mendez','4 metros','leña');
INSERT INTO venta(fecha,lugar, monto, nombre_cliente,observacion,tipo_de_venta) VALUES (NOW(),'Concepcion',250000,'Persona X','Mudanza 140km','Fleta');
INSERT INTO trabajador( nombre,apellido,fecha_de_nacimiento ,sueldo,abono) VALUES ( 'Matias','Parra',NOW(),0,0);
INSERT INTO actividad( fecha,lugar,total,estado, tipo_de_actividad,trabajador_id) VALUES ( '2018-01-01','Chile',120000,true,'asdasd',1);
