# Preguntas — Arquitectura en Capas

## 1. ¿Qué es un controlador?
Un controlador es la capa que recibe los requests HTTP, delega la ejecución al servicio y devuelve la respuesta al cliente.

## 2. ¿Qué responsabilidad tiene la capa de servicio?
La capa de servicio contiene la lógica de negocio, valida datos internamente y orquesta el flujo entre DTOs, entidad y repositorio.

## 3. ¿Qué hace el repositorio y de qué se encarga?
El repositorio persiste y recupera entidades desde la base de datos usando métodos como `save()` y `findAll()`.

## 4. ¿Qué es una entidad y a qué se mapea en la base de datos?
Una entidad es una clase JPA anotada con `@Entity` que se mapea a una tabla de la base de datos con sus columnas.

## 5. ¿Para qué sirve un DTO y por qué no devolvemos la entidad directamente?
Un DTO separa el modelo de persistencia de la API pública; evita exponer detalles de la base de datos y permite formatos diferentes.

## 6. ¿Cuál es la diferencia entre un `Request` y un `Response`?
Un `Request` representa los datos que el cliente envía al servidor; un `Response` representa los datos que el servidor devuelve.

## 7. ¿Por qué separamos la aplicación en capas? Menciona una ventaja.
Separamos en capas para mantener la responsabilidad clara, facilitar el mantenimiento y permitir pruebas más simples de cada parte.

## 8. ¿Qué anotación se usa para marcar un controlador REST? ¿Y un servicio?
Se usa `@RestController` para el controlador REST y `@Service` para la capa de servicio.

## 9. ¿Qué hace `@RequestBody` en un endpoint?
`@RequestBody` indica que el contenido JSON del body debe convertirse a un objeto Kotlin que recibe el método.

## 10. ¿Cuál es el flujo que sigue un request desde que llega hasta que se guarda en la base de datos?
El request llega al controlador, este llama al servicio, el servicio transforma y guarda la entidad con el repositorio, y finalmente devuelve el DTO.
