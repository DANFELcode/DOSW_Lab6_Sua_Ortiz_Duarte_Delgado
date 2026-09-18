# DOSW_Lab6_Sua_Ortiz_Duarte

## Preguntas
### 1. ¿Para qué sirve el paquete Controller en la estructura Spring Boot?

El paquete `controller` contiene las clases anotadas con `@RestController` (o `@Controller`) que exponen los endpoints de la API REST. Su responsabilidad es recibir las peticiones HTTP (GET, POST, PUT, DELETE, etc.), delegar la lógica de negocio a la capa de `service` y devolver la respuesta correspondiente (normalmente serializada en JSON), sin implementar reglas de negocio directamente.

### 2. ¿Para qué sirve el paquete Service en la estructura Spring Boot?

El paquete `service` contiene las clases anotadas con `@Service` que concentran la lógica de negocio de la aplicación. Estas clases orquestan las operaciones necesarias para cumplir un caso de uso, coordinando llamadas a uno o varios `repository`, aplicando validaciones y reglas del dominio, y sirviendo de intermediario entre los `controller` y el acceso a datos.

### 3. ¿Para qué sirve el paquete Model en la estructura Spring Boot?

El paquete `model` contiene las clases que representan los conceptos centrales del negocio (por ejemplo, `Trabajador`, `Solicitud`, `Reseña`), independientemente de cómo se persistan en la base de datos. A diferencia de `entity`, el `model` puede incluir objetos de dominio puro con comportamiento propio, usados por la lógica de negocio en `service`, sin acoplarse directamente a anotaciones de persistencia como JPA.

### 4. ¿Para qué sirve el paquete Repository en la estructura Spring Boot?
Contiene las interfaces encargadas de la comunicación con la base de datos. Normalmente extienden de JpaRepository o CrudRepository,  permitiendo operaciones CRUD sin necesidad de escribir SQL manualmente.

### 5. ¿Para qué sirve el paquete Entity en la estructura Spring Boot?
Contiene las clases que representan las tablas de la base de datos. Cada clase, anotada con @Entity, se mapea a una tabla mediante JPA/Hibernate, y sus atributos corresponden a las columnas de dicha tabla.

### 6. ¿Para qué sirve el paquete DTO en la estructura Spring Boot?
Contiene clases (Data Transfer Object) usadas para transportar datos entre capas, especialmente entre el Controller y el cliente externo, evitando exponer directamente las entidades y controlando qué información se envía o recibe.

### 7. ¿Para qué sirve el paquete Exception en la estructura Spring Boot?
Contiene las clases personalizadas para el manejo de errores y excepciones, capturando situaciones anómalas de forma controlada, generalmente junto a un manejador global (@ControllerAdvice o @ExceptionHandler).


# Bibliografía

Spring. (2024). Spring Boot Reference Documentation. VMware. https://docs.spring.io/spring-boot/docs/current/reference/html/

Spring. (2024). Spring Data JPA - Reference Documentation. VMware. https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

Oracle. (2024). Java Persistence API (JPA) Specification. Oracle Corporation. https://www.oracle.com/java/technologies/persistence-jsp.html

Walls, C. (2022). Spring Boot in Action (2.ª ed.). Manning Publications.

Baeldung. (2024). Spring Boot Project Structure. Baeldung. https://www.baeldung.com/spring-boot-start