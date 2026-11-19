
# API REST - Gestión de Artículos

API REST desarrollada con **Java 21 y Spring Boot**, cuyo objetivo es gestionar artículos y sus respectivas categorías mediante operaciones CRUD (Create, Read, Update, Delete).

El proyecto forma parte de una actividad práctica de desarrollo backend, aplicando conceptos de programación orientada a objetos, persistencia de datos y diseño de servicios REST.

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Jakarta Validation**
- **Maven**
- **Postman**

## Funcionalidades

### Gestión de artículos

- Crear artículos.
- Consultar todos los artículos.
- Consultar un artículo por su ID.
- Modificar artículos existentes.
- Eliminar artículos.

### Gestión de categorías

- Crear categorías.
- Consultar todas las categorías.
- Consultar una categoría por su ID.
- Modificar categorías existentes.
- Eliminar categorías.

### Características adicionales

- Relación `ManyToOne` entre artículos y categorías.
- Validaciones mediante Jakarta Validation.
- Manejo global de excepciones mediante `@RestControllerAdvice`.
- Uso de `ResponseEntity` para controlar las respuestas HTTP.
- Respuestas `201 Created` y encabezado `Location` al crear recursos.

## Estructura del proyecto

El proyecto sigue una arquitectura por capas, separando las responsabilidades de cada componente.

```text
src/
└── main/
    ├── java/
    │   └── com/example/articulos/
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       ├── model/
    │       ├── exception/
    │       └── ArticuloApiApplication.java
    │
    └── resources/
        └── application.properties
```

### Responsabilidades de las capas

- `controller`: recibe las solicitudes HTTP y devuelve las respuestas correspondientes.
- `service`: contiene la lógica de negocio.
- `repository`: gestiona el acceso y la persistencia de datos.
- `model`: contiene las entidades del sistema.
- `exception`: contiene las excepciones personalizadas y el manejo global de errores.

## Instalación y configuración

### Requisitos previos

- Java 21 o superior.
- MySQL.
- Maven.
- Git.

### 1. Clonar el repositorio

```bash
git clone https://github.com/marconovas/proyectoTalentoTech-BackendJava-26223-Novas-Medina-Marco.git
```

### 2. Crear la base de datos

Desde MySQL, ejecutar:

```sql
CREATE DATABASE articulos_db;
```

### 3. Configurar la conexión

Modificar el archivo `application.properties` con los datos correspondientes a tu entorno:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/articulos_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Ejecutar la aplicación

Desde la terminal, ubicarse en la raíz del proyecto y ejecutar:

```bash
mvn spring-boot:run
```

Una vez iniciada, la API estará disponible en:

```text
http://localhost:8080
```

## Endpoints

La API permite realizar operaciones CRUD sobre los recursos Artículos y Categorías.

### Artículos

| Método HTTP | Endpoint | Descripción |
|---|---|---|
| GET | `/api/articulos` | Obtener todos los artículos |
| GET | `/api/articulos/{id}` | Obtener un artículo por ID |
| POST | `/api/articulos` | Crear un artículo |
| PUT | `/api/articulos/{id}` | Modificar un artículo |
| DELETE | `/api/articulos/{id}` | Eliminar un artículo |

### Categorías

| Método HTTP | Endpoint | Descripción |
|---|---|---|
| GET | `/api/categorias` | Obtener todas las categorías |
| GET | `/api/categorias/{id}` | Obtener una categoría por ID |
| POST | `/api/categorias` | Crear una categoría |
| PUT | `/api/categorias/{id}` | Modificar una categoría |
| DELETE | `/api/categorias/{id}` | Eliminar una categoría |

Para probar los endpoints se puede utilizar Postman.

## Demostración del funcionamiento

A continuación, se encuentra el video demostrativo del funcionamiento de la API REST, donde se muestran las principales operaciones implementadas y las respuestas obtenidas.

**Video de demostración:**

[Ver demostración de la API](PEGAR_ENLACE_DEL_VIDEO)

## Autor

Proyecto desarrollado como parte de una actividad práctica de formación en desarrollo backend Java.
