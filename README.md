# AESModValTaller - Banco ABC

## Integrantes
- Edwin Moreno 
- Felipe Castellanos 
- Frank Rodriguez


Para la solución de ese ejercicio, fue necesario el desarrollo de los siguientes servicios rest con las siguientes capacidades:

## Administrar compensación
**Descripción:** Permite notificar al área encargada sobre la realización de una compensación del pago de una factura que se debe realizar de forma manual en el caso que el servicio del proveedor no soporte esta capacidad.

**URL de acceso:** http://localhost:9020/banco/convenio/v1/compensacion/ 

**Capacidades:** generarCompensacion(idFactura)

## Administrar convenios
**Descripción:** Permite realizar la administración (Consulta, eliminación y recarga) de los convenios.

**URL de acceso:** http://localhost:9000/banco/convenio/v1/convenios/ 

**Capacidades:** consultarConvenios(), consultarConvenio(idConvenio), eliminarConvenio(idConvenio), recargar().

## Administrar cuentas
**Descripción:** Permite consultar las cuentas asociadas a un cliente y los saldos de estas.

**URL de acceso:** http://localhost:9040/banco/convenio/v1/cuentas/

**Capacidades:** consultarCuenta(idCuenta), consultarCuentaPorCliente(numeroDocumento)

## Administrar factura
**Descripción:** Permite realizar:
   Consultar: Permite consultar el valor a pagar de la factura consumiendo el servicio del proveedor.
   Pagar: Permite realizar el pago de una factura si el medio de pago seleccionado tiene saldo disponible.
   Compensar: Permite reversar el pago de una factura si el servicio del proveedor lo permite, en caso contrario crea una notificación al área correspondiente.
   
Además, este servicio es el encargado de direccionar las peticiones a la URL del servicio del proveedor según el identificador del convenio, la transformación de los mensajes de respuesta se realiza mediante XSLT.

**URL de acceso:** http://localhost:9010/banco/convenio/v1/factura/ 

**Capacidades:** consultarFactura(idFactura), pagarFactura(idFactura, valorFactura, idCuenta), compensarFactura(idFactura)

## SAPAuthorization
**Descripción:** Permite validar y autorizar a un cliente mediante un usuario y contraseña el acceso a la plataforma para el pago de convenios en línea.
**URL de acceso:** http://localhost:8080/ws
**URL WSDL:** http://localhost:8080/ws/authorization.wsdl
**Capacidades:** authorization(userName, password)

## Utilitarios
**Descripción:** Permite enviar notificaciones a los usuarios
**URL de acceso:** http://localhost:9050/banco/convenio/v1/utilitario
**Capacidades:** generarNotificacion(idFactura, mensaje)

#### Para mayor información acerca de los servicios ver documento de inventario de servicios (Inventario de servicios Taller.xlsx)

# ¿Como probar?
## Configurar el ambiente
1. Clonar el repositorio en la ruta deseada
2. Ingresar a la carpeta AESModValTaller
3. Dar permisos de ejecución al script chmod.sh con el comando ```chmod +x chmod.sh``` este comando asignará permisos de ejecución a los script internos del proyecto
4. Ingresar a cada una de las rutas para iniciar los servicios REST y SOAP
  - AdministarCompensacion
     ```./start.sh```
  - AdministarConvenios
     ```./start.sh```
  - AdministarCuenta
     ```./start.sh```
  - AdministarFactura
     ```./start.sh```
  - SAPAuthorization
     ```./start.sh```
  - Utilitarios
     ```./start.sh```     

## Pasos para realizar pagos y compensación
1. Consumir la capacidad **authorization** del servicio SAPAuthorization mediante SoapUI o Postman
  - El proyecto Soap se encuentra en la siguiente ruta: SAPAuthorization/SAPAuthorization-soapui-project.xml
  - #### Los usuarios configurados son: 101010, 101011, 101012 y 101013. Usuario y contraseña son iguales
2. Consultar la capacidad de **consultarConvenios** del servicio AdministarConvenios mediante Postman o línea de comandos para obtener el listado de convenios disponibles para realizar el pago en línea
  - curl -i -H "Accept: application/xml" -H "Content-type: application/xml" -X GET http://localhost:9000/banco/convenio/v1/convenios
  - curl -i -H "Accept: application/xml" -H "Content-type: application/xml" -X GET http://localhost:9000/banco/convenio/v1/convenios/10000
3. Consumir la capacidad de **consultarFactura** del servicio AdministarFactura mediante Postman o línea de comandos
  - curl -i -H "Accept: application/xml" -H "Content-type: application/xml" -X GET http://localhost:9010/banco/convenio/v1/factura/10000987
  - #### Se realiza una composición con la capacidad **consultarConvenio** del servicio AdministarConvenios para obtener los datos del convenio al cual pertenece la factura
4. Consumir la capacidad de **pagarFactura** del servicio AdministarFactura mediante Postman o línea de comandos para realizar el pago de una factura
  - curl -i -H "Accept: application/xml" -H "Content-type: application/xml" -X POST http://localhost:9010/banco/convenio/v1/factura/10000/987/023986
  - #### Se realiza una composición con la capacidad **consultarConvenio** del servicio AdministarConvenios para obtener la URL en la cual se encuentra expuesto el servicio de pagos del proveedor del convenio
  - #### Posteriormente de realizar el pago, este servicio realiza una composición con el servicio de **generarNotificacion** del servicio Utilitarios para enviar la confirmación del pago del convenio, _(ver log de la ejecución del servicio)_
5. Consumir la capacidad de **compensarFactura** del servicio AdministarFactura mediante Postman o línea de comandos para compensar el pago de una factura
  - curl -i -H "Accept: application/xml" -H "Content-type: application/xml" -X DELETE http://127.0.0.1:9010/banco/convenio/v1/factura/10000987
  - #### Se realiza una composición con la capacidad  **consultarConvenio** del servicio AdministarConvenios para obtener la URL en la cual se encuentra expuesto el servicio de compensación del proveedor del convenio
  - #### En el caso que el proveedor del convenio no soporte esta capacidad, se realiza otra composición con la capacidad **generarCompensacion** del servicio AdministarCompensacion con el fin de crear un ticket al área correspondiente para que se realice la compensación de forma manual   
  - #### Posteriormente de realizar la compensación o la creación del ticket, este servicio envía una notificación al cliente mediante la composición con la capacidad **generarNotificacion** del servicio Utilitarios para enviar la confirmación del estado de la compensación del convenio, _(ver log de la ejecución del servicio)_
  
## Desmontar el ambiente
1. Ingresar a cada una de las rutas para detener y eliminar los servicios REST y SOAP
  - AdministarCompensacion
     -```./stop.sh```
  - AdministarConvenios
     -```./stop.sh```
  - AdministarCuenta
     -```./stop.sh```
  - AdministarFactura
     -```./stop.sh```
  - SAPAuthorization
     -```./stop.sh```
  - Utilitarios
     ```./sttop.sh```     
     
###### Se anexa proyecto Postman como referencia: AESModVal.postman_collection.json
