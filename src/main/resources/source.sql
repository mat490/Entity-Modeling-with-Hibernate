/*#########################################################*/
/*------------------- 1. Comandos -------------------------*/
/*#########################################################*/

DROP DATABASE IF EXISTS `proyecto_final_m4`;
CREATE DATABASE IF NOT EXISTS `proyecto_final_m4` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proyecto_final_m4`;

/*Tabla para las direcciones de los pacientes*/
DROP TABLE IF EXISTS `Direcciones`;
CREATE TABLE Direcciones (
ID_Direccion INT PRIMARY KEY AUTO_INCREMENT,
pais VARCHAR (50) NOT NULL,
estado VARCHAR (50) NOT NULL,
municipio VARCHAR (50) NOT NULL,
colonia VARCHAR (50) NOT NULL,
calle VARCHAR (50) NOT NULL,
numero_casa INT NOT NULL,
codigo_postal VARCHAR(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

# Unique index para darle unicidad a la tabla direcciones
CREATE UNIQUE INDEX unicidad_direcciones
ON Direcciones (pais, estado, municipio, calle, colonia, numero_casa, codigo_postal);

INSERT INTO direcciones (ID_Direccion, pais, estado, municipio, colonia, calle, numero_casa, codigo_postal)
VALUES
(1, 'México', 'Morelos', 'Cuernavaca', 'Tlatelolco', 'Gálvez Local Ubicado', 102, '62000'),
(2, 'México', 'Nuevo León', 'Monterrey', 'Valle del Tenayo', 'Ahuehuetes', 12, '54147'),
(3, 'México', 'CDMX', 'Coyoacán', 'San Ángel', 'Av. Revolución', 25, '04510');

DROP TABLE IF EXISTS `sexos`;
/*Tabla para los sexos*/
CREATE TABLE sexos (
ID_Sexo INT PRIMARY KEY AUTO_INCREMENT,
sexo VARCHAR (20) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO sexos (ID_Sexo, sexo)
VALUES
(1, 'Masculino'),
(2, 'Femenino');


DROP TABLE IF EXISTS `Datos_Personales_Generales`;
/*Tabla de datos personales generales que tendrán medicos, pacientes y tutores*/
CREATE TABLE Datos_Personales_Generales (
ID_Datos_Personales_Generales INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
nombre2 VARCHAR(50) NOT NULL DEFAULT 'No tiene',
apellido1 VARCHAR(50) NOT NULL,
apellido1 VARCHAR(50) NOT NULL DEFAULT 'No tiene',
fecha_nacimiento DATE NOT NULL,
edad INT NOT NULL,
telefono VARCHAR (15) NOT NULL UNIQUE,
correo_electronico VARCHAR (50) NOT NULL UNIQUE,
ID_Direccion INT NOT NULL,
ID_Sexo INT NOT NULL,

CONSTRAINT fk_sexos_dpg FOREIGN KEY (ID_Sexo) REFERENCES sexos (ID_Sexo),
CONSTRAINT fk_id_direccion_dpg FOREIGN KEY (ID_Direccion) REFERENCES Direcciones (ID_Direccion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO datos_personales_generales
(ID_Datos_Personales_Generales, nombre, nombre2, apellido1, apellido2, fecha_nacimiento, edad, telefono, correo_electronico, ID_Direccion, ID_Sexo)
VALUES
(1, 'Juan', 'Manuel', 'Bolaños', 'Martínez', '2000-02-13', 24, '777-222-4444', 'manuel@correo.com', 1, 1),
(2, 'María', 'Eloisa', 'Morales', 'Hidalgo', '1990-05-03', 34, '81-3333-5555', 'maria@correo.com', 2, 2),
(3, 'Luis', 'Ángel', 'Alvarado', 'Quintana', '2004-07-27', 20, '55-4444-6666', 'luis@correo.com', 3, 1);



DROP TABLE IF EXISTS Estados_Civiles;
/*Tablas para contener la variedad de datos para los campos de los pacientes*/
CREATE TABLE Estados_Civiles (
ID_Estado_Civil INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombre_estado_civil VARCHAR (20) NOT NULL UNIQUE
);

INSERT INTO estados_civiles(ID_Estado_Civil, nombre_estado_civil)
VALUES
(1, 'Soltero'),
(2, 'Casado'),
(3, 'Viudo');

DROP TABLE IF EXISTS ocupaciones;
CREATE TABLE Ocupaciones (
ID_Ocupacion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ocupacion VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO ocupaciones(ID_Ocupacion, ocupacion)
VALUES
(1, 'Desorrallor de Software'),
(2, 'Arquitecto'),
(3, 'Estudiante');

DROP TABLE IF EXISTS combe;
CREATE TABLE COMBE (
ID_COMBE INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
combe VARCHAR(9) NOT NULL UNIQUE
);

INSERT INTO combe(ID_COMBE, combe)
VALUES
(1, 'Negativo'),
(2, 'Positivo');

DROP TABLE IF EXISTS Grupos_Sanguineos;
CREATE TABLE Grupos_Sanguineos (
ID_Grupo_Sanguineo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
grupo_sanguineo CHAR(2) NOT NULL UNIQUE
);

INSERT INTO grupos_sanguineos(ID_Grupo_Sanguineo, grupo_sanguineo)
VALUES
(1, 'A'),
(2, 'B'),
(3, 'AB'),
(4, 'O');

DROP TABLE IF EXISTS rh;
CREATE TABLE RH (
ID_RH INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
RH CHAR(9) NOT NULL UNIQUE
);
INSERT INTO rh(id_rh, rh)
VALUES
(1, 'Negativo'),
(2, 'Positivo');

DROP TABLE IF EXISTS Lugares_Nacimiento;
CREATE TABLE Lugares_Nacimiento (
ID_Lugar_Nacimiento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
pais VARCHAR (50) NOT NULL,
estado VARCHAR (50) NOT NULL,
municipio VARCHAR (50) NOT NULL
);

# Unique index para darle unicidad a la tabla de lugares de nacimiento
CREATE UNIQUE INDEX unicidad_lugares_nacimiento
ON lugares_nacimiento (pais, estado, municipio);

INSERT INTO Lugares_Nacimiento(ID_Lugar_Nacimiento, pais, estado, municipio)
VALUES
(1, 'México', 'Nuevo León', 'Monterrey'),
(2, 'México', 'CDMX', 'Miguel Hidalgo'),
(3, 'Estados Unidos', 'Columbia', 'Whashington D.C.');

DROP TABLE IF EXISTS pacientes;
/*Tabla de pacientes */
CREATE TABLE pacientes (
ID_Paciente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ID_Datos_Personales_Generales INT NOT NULL UNIQUE,
ID_Estado_Civil INT NOT NULL,
ID_Ocupacion INT NOT NULL,
ID_COMBE INT NOT NULL,
ID_Grupo_Sanguineo INT NOT NULL,
ID_RH INT NOT NULL,
ID_Lugar_Nacimiento INT NOT NULL,

CONSTRAINT fk_dpg FOREIGN KEY (ID_Datos_Personales_Generales) REFERENCES Datos_Personales_Generales (ID_Datos_Personales_Generales),
CONSTRAINT fk_estado_civil FOREIGN KEY (ID_Estado_Civil) REFERENCES estados_civiles (ID_Estado_Civil),
CONSTRAINT fk_ocupacion FOREIGN KEY (ID_Ocupacion) REFERENCES Ocupaciones (ID_Ocupacion),
CONSTRAINT fk_combe FOREIGN KEY (ID_COMBE) REFERENCES COMBE (ID_COMBE),
CONSTRAINT fk_grupos_sanguineos FOREIGN KEY (ID_Grupo_Sanguineo) REFERENCES grupos_sanguineos (ID_Grupo_Sanguineo),
CONSTRAINT fk_rh FOREIGN KEY (ID_RH) REFERENCES RH (ID_RH),
CONSTRAINT fk_lugar_nacimiento FOREIGN KEY (ID_Lugar_Nacimiento) REFERENCES lugares_nacimiento (ID_Lugar_Nacimiento)
);

INSERT INTO pacientes(ID_Paciente, ID_Datos_Personales_Generales, ID_Estado_Civil, ID_Ocupacion, ID_COMBE, ID_Grupo_Sanguineo, ID_RH, ID_Lugar_Nacimiento)
VALUES
(1, 1, 1, 1, 1,1,2,3),
(2, 2, 2, 2, 1,2,1,1),
(3, 3, 1, 3, 4,2,1,2);





-- Triggers ---
DROP TRIGGER IF EXISTS 'verificar_fecha_nacimiento_dpg'
 /*Trigger para verificar que la fecha de nacimiento de un paciente no sea posterior a la actual*/
DELIMITER //
CREATE TRIGGER verificar_fecha_nacimiento_dpg
BEFORE INSERT ON datos_personales_generales
FOR EACH ROW
BEGIN
	IF NEW.fecha_nacimiento > CURDATE()
	THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Fecha de nacimiento invalida';
	END IF;
END; //
DELIMITER ;

DROP TRIGGER IF EXISTS 'asignar_edad_dpg'
/*Trigger para asignar la edad de manera automática con la fecha de nacimiento*/
DELIMITER //
CREATE TRIGGER asignar_edad_dpg
BEFORE INSERT ON Datos_Personales_Generales
FOR EACH ROW
BEGIN
  DECLARE nacimiento DATE;
  # Obtener la fecha de nacimiento de la nueva fila
  SET nacimiento = NEW.fecha_nacimiento;

  # Calcular la edad en años y extraer la parte entera
  SET NEW.edad = FLOOR(YEAR(CURDATE()) - YEAR(nacimiento));
END; //
DELIMITER ;








