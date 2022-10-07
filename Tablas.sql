CREATE TABLE Sucursales
(
	IDSucursal SERIAL NOT NULL PRIMARY KEY,
	ubicacionSucursal VARCHAR(20) NOT NULL
);
	
CREATE TABLE Productos
(
	IDProducto SERIAL NOT NULL PRIMARY KEY,
	nombreProducto VARCHAR(20) NOT NULL,
	categoriaProducto VARCHAR(20) NOT NULL, 
	descripcionProducto VARCHAR(200) NOT NULL
);
	
CREATE TABLE Ventas
(
	IDVenta	SERIAL NOT NULL	PRIMARY KEY,
	nombreClienteVenta VARCHAR(20) NOT NULL,
	apellidoClienteVenta VARCHAR(20) NOT NULL,
	envioGratisVenta BOOLEAN NOT NULL,
	importeVenta REAL NOT NULL,
	fechaPagoVenta DATE NOT NULL,
	metodoPagoVenta VARCHAR(20) NOT NULL,
	estadoVenta VARCHAR(20) NOT NULL
	IDSucursal INT NOT NULL,
	FOREIGN KEY (IDSucursal) REFERENCES Sucursal 
);

CREATE TABLE ItemsVenta 
(
	IDItemVenta SERIAL NOT NULL PRIMARY KEY,
	cantidadItemVenta INT NOT NULL,
	precioUnidadItemVenta REAL NOT NULL,
	IDVenta INT NOT NULL,
	IDProducto INT NOT NULL,
	FOREIGN KEY (IDProducto) REFERENCES Producto,
	FOREIGN KEY (IDVenta) REFERENCES Venta
);
	
INSERT INTO Sucursales VALUES (1, 'SAN_LUIS'), (2, 'NEUQUEN');
