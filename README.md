# Rest-Api-Spring-boot-Tienda-
Trabajo autónomo de Distribuidas

wmscTienda
Se realiza un atienda que muestra el flujo de una orden de productos

﻿

wmsc Productos
Creación de la coleccion de los productos

﻿

GET
wmscLista de productos
http://localhost:8080/wmscListaProductos
﻿

POST
wmscAgregarProducto
http://localhost:8080/wmscAgregarProducto?wmscProductoID=3&wmscDepartamentoID=2&wmscNombre=pantalon&wmscPrecio=16
﻿

Query Params
wmscProductoID
3
wmscDepartamentoID
2
wmscNombre
pantalon
wmscPrecio
16
GET
wmscBuscar Producto
http://localhost:8080/wmscBuscarProducto/1
﻿

DELETE
wmscEliminar producto
http://localhost:8080/wmscEliminarProducto/2
﻿

PUT
wmscAactualizar producto
http://localhost:8080/wmscActualizarProducto/2?wmscProductoID=2&wmscOrdenID=2&wmscDepartamentoID=2&wmscNombre=camisa&wmscPrecio=16.4
﻿

Query Params
wmscProductoID
2
wmscOrdenID
2
wmscDepartamentoID
2
wmscNombre
camisa
wmscPrecio
16.4
wmsc Orden
﻿

POST
wmsc Registrar Orden
http://localhost:8080/wmscAgregarOrden?wmscOrderID=2&wmscProductoID=3&wmscClienteID=2&wmscAlmacenID=2&wsmcCantidadVentas=12&wmscFechaIngreso=12/2/2012&wmscTiempo=13:33
﻿

Query Params
wmscOrderID
2
wmscProductoID
3
wmscClienteID
2
wmscAlmacenID
2
wsmcCantidadVentas
12
wmscFechaIngreso
12/2/2012
wmscTiempo
13:33
GET
wmsc Lista de ordenes
http://localhost:8080/wmscListaOrdenes
﻿

wmscCliente
﻿

GET
wmscLista de cliente
http://localhost:8080/wmscClientes
﻿

POST
wmscAgregar Cliente
http://localhost:8080/wmscAgregarCliente?wmscClienteID=1&wmscNombresCompletos=Wilmer Mesias Shagñay Condo
﻿

Query Params
wmscClienteID
1
wmscNombresCompletos
Wilmer Mesias Shagñay Condo
GET
wmscBuscar Cliente
http://localhost:8080/wmscBuscarClientePorID/1
﻿

DELETE
wmscEliminar Cliente
http://localhost:8080/wmscEliminarCliente/1
﻿

PUT
wmscAactualizar cliente
http://localhost:8080/wmscActualizarCliente/1?wmscNombresCompletos=Wilmer Shagñay Condo
﻿

Query Params
wmscNombresCompletos
Wilmer Shagñay Condo
wmscAlmacen
﻿

GET
wmscLista de almacen
http://localhost:8080/wmscAlmanes
﻿

POST
wmscAgregar almacen
http://localhost:8080/wmscAgregarAlmacen?wmscAlmacenID=2&wmscNombreAlmacen=Shopping
﻿

Query Params
wmscAlmacenID
2
wmscNombreAlmacen
Shopping
GET
wmscBuscar almacen
http://localhost:8080/wmscAlmanePorID/2
﻿

DELETE
wmscEliminar almacen
http://localhost:8080/wmscEliminarPorID/1
﻿

PUT
wmscAactualizar almacen
http://localhost:8080/wmscActualizarAlmacen/2?wmscAlmacenID=2&wmscNombreAlmacen=Valeria story
﻿

Query Params
wmscAlmacenID
2
wmscNombreAlmacen
Valeria story