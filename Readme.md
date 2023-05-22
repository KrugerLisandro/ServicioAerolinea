# TRABAJO PRACTICO DAOS

#ESTRUCTURA DEL PROYECTO

1) Controller: Es la capa encargada de recibir las peticiones HTTP, procesarlas y enviar la respuesta. Se encarga de la lógica de negocio relacionada con la presentación y la interacción con el usuario.


2) Entity: Es una carpeta que contiene clases que representa una tabla o vista de la base de datos. Cada instancia de la clase representa una fila de la tabla o vista.


3) Exception: En esta carpeta se definen las excepciones personalizadas que puede lanzar la aplicación. Es importante definir excepciones personalizadas para que la aplicación sea más robusta y se puedan manejar los errores de manera más adecuada.


4) Repository: Esta capa se encarga de interactuar con la base de datos. Se definen interfaces que extienden de JpaRepository, que proporciona los métodos necesarios para interactuar con la base de datos. Cada clase usa el sufijo "DAO".


5) Request: Se utiliza para manejar las peticiones HTTP realizadas por el cliente al servidor  


6) Response: Se utiliza para manejar las respuestas HTTP enviadas por el servidor al cliente. Cada clase usa el sufijo "DTO".


7) Service: Esta capa se encarga de la lógica de negocio de la aplicación. Aquí se definen las operaciones que se pueden realizar en la aplicación, y se implementan utilizando los repositorios y las entidades. 


8) ServiceImpl: En esta carpeta se implementan las interfaces definidas en la capa de servicio. Es importante separar la definición de la implementación para poder hacer pruebas unitarias de manera más sencilla. 


#SO 2 VUELO, RESPONSABLE KRUGER LISANDRO

Operaciones Requeridas: GET / POST / PUT /DELETE (Servicio Entidad)

Establece/Actualiza/Retorna los datos de un vuelo: 
 Nro, 
 Fecha / hora,
 Nro Filas, 
 Nro asientos por fila,  
 Tipo de vuelo,
 Destino,
 Origen (por el momento será siempre aeropuerto sauce viejo ya que solo consideraremos la venta de pasajes que partan desde    este lugar), 
 Estado (registrado  / reprogramado / cancelado) 
 
El estado es autocalculado por el sistema, no puede ser establecido por el usuario.  

No podrá haber dos vuelos con el mismo nro.

Una vez registrado, solo se permitirá cambiar la fecha y hora del mismo (lo cual pasa el vuelo al estado reprogramado) o eliminar el mismo (lo cual pasa el vuelo al estado cancelado)
 
Tanto la reprogramación como la cancelación de un vuelo dispararía la notificación automática del evento a todos los pasajeros aunque por simplicidad, no se pide implementar el servicio de alertas.  
