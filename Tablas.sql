---------------------------------------------------------------------------------------------------------------------------------------------

	-- Definición de Esquema de Base de Datos
	
	-- Los enumerados se guardan como VARCHAR
	-- Los datos booleanos se guardan como BOOLEAN (puede tomar los valores TRUE, FALSE)
	
---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE Sucursal
	(
		sID				SERIAL			NOT NULL	PRIMARY KEY,
		sCiudad			VARCHAR(20)		NOT NULL
	);
	
---------------------------------------------------------------------------------------------------------------------------------------------
	
	CREATE TABLE Producto
	(
		pID				SERIAL			NOT NULL	PRIMARY KEY,
		pNombre			VARCHAR(80)		NOT NULL,
		pCategoria		VARCHAR(20)		NOT NULL, 
		pDescripcion	VARCHAR(400)	NOT NULL
	);

---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE Compra
	(
		cID				SERIAL			NOT NULL	PRIMARY KEY,
		cMontoTotal		REAL			NOT NULL,
		cFecha			DATE			NOT NULL,
		sID				INT				NOT NULL,
		
		FOREIGN KEY (sID) REFERENCES Sucursal
	);

---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE Venta
	(
		vID				SERIAL			NOT NULL	PRIMARY KEY,
		vNombreCliente	VARCHAR(40)		NOT NULL,
		vEnvioGratis	BOOLEAN			NOT NULL,
		vImporte		REAL			NOT NULL,
		vFecha			DATE			NOT NULL,
		vMetodoPago		VARCHAR(20)		NOT NULL,
		vEstadoVenta	VARCHAR(20)		NOT NULL
	);
	
---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE Reserva
	(
		vID					SERIAL		NOT NULL	PRIMARY KEY,
		rTelefonoCliente	BIGINT 		NOT NULL,
		rSeña				REAL		NOT NULL,
		rFecha				DATE		NOT NULL,
		
		FOREIGN KEY (vID) REFERENCES Venta
	);

---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE ItemVenta 
	(
		ivID			SERIAL			NOT NULL	PRIMARY KEY,
		pID				INT				NOT NULL,
		ivCantidad		INT				NOT NULL,
		ivPrecioUnidad	REAL			NOT NULL,
		vID				INT				NOT NULL,
		
		FOREIGN KEY (pID) REFERENCES Producto,
		FOREIGN KEY (vID) REFERENCES Venta
	);
	
---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE ItemCompra 
	(
		icID			SERIAL			NOT NULL	PRIMARY KEY,
		pID				INT				NOT NULL,
		icCantidad		INT				NOT NULL,
		icCostoUnidad	REAL			NOT NULL,
		cID				INT				NOT NULL,
		
		FOREIGN KEY (pID) REFERENCES Producto,
		FOREIGN KEY (cID) REFERENCES Compra
	);
	
---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE Disponibilidad
	(
		dID					SERIAL			NOT NULL	PRIMARY KEY,
		pID					INT				NOT NULL,
		sID					INT				NOT NULL,
		dPrecioVenta		REAL			NOT NULL,
		dStockActual		INT				NOT NULL,
		dStockMinimo		INT				NOT NULL,
		dTieneStockMinimo	BOOLEAN			NOT NULL,

		FOREIGN KEY (pID) REFERENCES Producto,
		FOREIGN KEY (sID) REFERENCES Sucursal
	);

---------------------------------------------------------------------------------------------------------------------------------------------

	CREATE TABLE Gasto
	(
		gID				SERIAL			NOT NULL	PRIMARY KEY,
		gMontoTotal		REAL			NOT NULL,
		gFecha			DATE			NOT NULL,
		gNombre			VARCHAR(80)		NOT NULL,
		gDescripcion	VARCHAR(400)	NOT NULL,
		sID				INT				NOT NULL,
		
		FOREIGN KEY (sID) REFERENCES Sucursal
	);
	
---------------------------------------------------------------------------------------------------------------------------------------------

	-- Inserción de filas por defecto (de momento solo se consideran dos sucursales: San Luis y Neuquén): 
	
---------------------------------------------------------------------------------------------------------------------------------------------
	
	INSERT INTO Sucursal VALUES (DEFAULT, 'SAN_LUIS'), (DEFAULT, 'NEUQUEN');
	
---------------------------------------------------------------------------------------------------------------------------------------------
	
	-- Para limpiar la base de datos por completo:
	
	-- DROP TABLE Sucursal, Producto, Compra, Venta, Reserva, ItemVenta, ItemCompra, Disponibilidad, Gasto;
	
---------------------------------------------------------------------------------------------------------------------------------------------

