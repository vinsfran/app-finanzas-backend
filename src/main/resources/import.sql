/* Populate tabla clientes */
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

/* Creamos algunos usuarios con sus rols */
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$GqO2WMUqM.BsZWFJCkOKieOOHWoBJ75cDY//R3UI7h3ZqBDEMisTG',true, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$kqTEtBZVWHpfOoW6g7wQCOACAnhY4kjPPlrz7OKEEMxmkR1PvoJ/i',true, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuarios_id, roles_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuarios_id, roles_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuarios_id, roles_id) VALUES (2, 1);


INSERT INTO monedas (codigo, nombre) VALUES ('Gs.', 'Guarani');
INSERT INTO monedas (codigo, nombre) VALUES ('Us.', 'Dolar');
INSERT INTO monedas (codigo, nombre) VALUES ('Ps.', 'Peso Argentino');

INSERT INTO entidades_financieras (nombre, usuario_id) VALUES ('BANCO ITAU', 2);
INSERT INTO entidades_financieras (nombre, usuario_id) VALUES ('BANCO BBVA', 2);
INSERT INTO entidades_financieras (nombre, usuario_id) VALUES ('BANCO CONTINENTAL', 2);
INSERT INTO entidades_financieras (nombre, usuario_id) VALUES ('FINANCIERA EL COMERCIO', 2);

INSERT INTO tipos_pagos (nombre) VALUES ('Efectivo');
INSERT INTO tipos_pagos (nombre) VALUES ('Tarjeta');
INSERT INTO tipos_pagos (nombre) VALUES ('Cheque');


INSERT INTO prestamos (cantidad_cuotas, cantidad_cuotas_pagadas, destino_prestamo, estado, fecha_desembolso, fecha_vencimiento, interes, monto_cuota, monto_pagado, monto_prestamo, tasa, entidad_financiera_id, moneda_id, usuario_id) VALUES (12,0,'Construccion',true,'2019-06-10','2019-06-28',1,50000,0,500000,2,1,1,2);
INSERT INTO prestamos (cantidad_cuotas, cantidad_cuotas_pagadas, destino_prestamo, estado, fecha_desembolso, fecha_vencimiento, interes, monto_cuota, monto_pagado, monto_prestamo, tasa, entidad_financiera_id, moneda_id, usuario_id) VALUES (12,0,'Construccion',true,'2019-06-10','2019-06-28',1,50000,0,500000,2,2,2,1);


INSERT INTO tipos_ahorros (nombre) VALUES ('CDA');
INSERT INTO tipos_ahorros (nombre) VALUES ('BONOS');
INSERT INTO tipos_ahorros (nombre) VALUES ('Acciones');
INSERT INTO tipos_ahorros (nombre) VALUES ('Programado');

INSERT INTO tipos_cobros (nombre) VALUES ('Mensual');
INSERT INTO tipos_cobros (nombre) VALUES ('Trimestral');
INSERT INTO tipos_cobros (nombre) VALUES ('Anual');

INSERT INTO ahorros (cantidad_cobro, estado, cantidad_cuotas, fecha_inicio, fecha_vencimiento, interes, monto_capital, monto_cuota, monto_interes_cuota, plazo_total, tasa, entidades_financieras_id, monedas_id, tipos_ahorros_id, tipos_cobros_id, usuario_id) VALUES (0,'true',12,'2019-06-12','2019-06-13',2,500000,50000,0,12,1,1,1,1,1,2);
INSERT INTO ahorros (cantidad_cobro, estado, cantidad_cuotas, fecha_inicio, fecha_vencimiento, interes, monto_capital, monto_cuota, monto_interes_cuota, plazo_total, tasa, entidades_financieras_id, monedas_id, tipos_ahorros_id, tipos_cobros_id, usuario_id) VALUES (0,'true',12,'2019-06-12','2019-06-13',2,100000000,100000,0,12,1,3,1,1,1,1);

INSERT INTO conceptos (nombre, signo, usuario_id) VALUES ('Luz', '-', 2);
INSERT INTO conceptos (nombre, signo, usuario_id) VALUES ('Agua', '-', 2);
INSERT INTO conceptos (nombre, signo, usuario_id) VALUES ('Escuela', '-', 2);
INSERT INTO conceptos (nombre, signo, usuario_id) VALUES ('Sueldo', '+', 2);

INSERT INTO meses (nombre, numero) VALUES ('Enero', 1);
INSERT INTO meses (nombre, numero) VALUES ('Febrero', 2);
INSERT INTO meses (nombre, numero) VALUES ('Marzo', 3);
INSERT INTO meses (nombre, numero) VALUES ('Abril', 4);
INSERT INTO meses (nombre, numero) VALUES ('Mayo', 5);
INSERT INTO meses (nombre, numero) VALUES ('Junio', 6);
INSERT INTO meses (nombre, numero) VALUES ('Julio', 7);
INSERT INTO meses (nombre, numero) VALUES ('Agosto', 8);
INSERT INTO meses (nombre, numero) VALUES ('Septiembre', 9);
INSERT INTO meses (nombre, numero) VALUES ('Octubre', 10);
INSERT INTO meses (nombre, numero) VALUES ('Niviembre', 11);
INSERT INTO meses (nombre, numero) VALUES ('Diciembre', 12);
