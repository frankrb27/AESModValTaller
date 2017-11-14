# AESModValTaller - Banco ABC

# Integrantes
1. Edwin Moreno Cristancho
2. Felipe Castellanos Arias
3. Frank Rodriguez


Para la solución de ese ejercicio, fue necesario el desarrollo de los siguientes servicios rest con las siguientes capacidades:

# Administrar compensacion
Descripción: Permite notificar al área encargada sobre la realización de una compensación del pago de una factura que se debe realizar de forma manual en el caso que el servicio del proveedor no soporte esta capacidad.

URL de acceso: http://localhost:9020/banco/convenio/v1/compensacion/ 

Capacidades: generarCompensacion(idFactura)

# Administrar convenios
Descripción: Permite realizar la administración (Consulta, eliminación y recarga) de los convenios.

URL de acceso: http://localhost:9000/banco/convenio/v1/convenios/ 

Capacidades: consultarConvenios(), consultarConvenio(idConvenio), eliminarConvenio(idConvenio), recargar().

# Administrar cuentas
Descripción: Permite consultar las cuentas asociadas a un cliente y los saldos de estas.

URL de acceso: http://localhost:9040/banco/convenio/v1/cuentas/

Capacidades: consultarCuenta(idCuenta), consultarCuentaPorCliente(numeroDocumento)

# Administrar factura
Descripción: Permite realizar:
   Consultar: Permite consultar el valor a pagar de la factura consumiendo el servicio del proveedor.
   Pagar: Permite realizar el pago de una factura si el medio de pago seleccionado tiene saldo disponible.
   Compensar: Permite reversar el pago de una factura si el servicio del proveedor lo permite, en caso contrario crea una notificación al área correspondiente.
   
Además, este servicio es el encargado de direccionar las peticiones a la URL del servicio del proveedor según el identificador del convenio, la transformación de los mensajes de respuesta se realiza mediante XSLT.

URL de acceso: http://localhost:9010/banco/convenio/v1/factura/ 

Capacidades: consultarFactura(idFactura), pagarFactura(idFactura, valorFactura, idCuenta), compensarFactura(idFactura)

###### Para mayor información acerca de los servicios ver documento de inventario de servicios (Inventario de servicios Taller.xlsx)
