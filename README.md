# Ejercicios: Backend y Consumo de API en Android

## Ejercicio 1: Creación de un Backend Básico y Conexión con Android

### Descripción de la Actividad
En esta primera parte, se implementará un servicio REST básico utilizando Spring Boot y se conectará una aplicación Android para consumir dicho servicio.

### 1. Desarrollo del Backend
- Implementar un servicio REST básico utilizando **Spring Boot** o cualquier otro framework de preferencia.
- Exponer al menos un endpoint que retorne un mensaje en formato JSON (por ejemplo, "Hola Mundo").
- Configurar el servidor para escuchar en un puerto accesible (por defecto **8080**).
- Documentar la **URL del servicio** y la estructura de la respuesta JSON.

### 2. Configuración de la Aplicación Android
- Crear un nuevo proyecto en **Android Studio**.
- Configurar los permisos necesarios en `AndroidManifest.xml` para permitir la conexión a Internet:
  
  ```xml
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
  ```

- Para Android 9 (API 28) o superior, crear un archivo de configuración de seguridad `network_security_config.xml` en `res/xml/` para permitir conexiones a `localhost` (10.0.2.2):

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <network-security-config>
      <domain-config cleartextTrafficPermitted="true">
          <domain includeSubdomains="true">10.0.2.2</domain>
      </domain-config>
  </network-security-config>
  ```

- Referenciar la configuración en `AndroidManifest.xml`:

  ```xml
  <application
      android:networkSecurityConfig="@xml/network_security_config"
      ...>
  ```

### 3. Consumo del Servicio REST
- Implementar el código necesario para realizar una petición HTTP al backend.
- Utilizar Retrofit, Volley o HttpURLConnection para realizar la petición.
- Procesar la respuesta JSON y mostrar el contenido en la interfaz de usuario.
- Implementar manejo adecuado de errores y estados de carga.

### 4. Evidencias
- Capturas de pantalla del **backend** ejecutándose y mostrando la respuesta JSON.
- Capturas de pantalla de la **aplicación Android** mostrando la información recibida del backend.
- Código fuente comentado de las clases de conexión y manejadores de respuesta.

---

## Ejercicio 2: Consumo de una API Pública

### Descripción de la Actividad
En esta segunda parte, se extenderá el conocimiento para consumir una API pública y mostrar información más compleja en la aplicación Android.

### 1. Selección de una API Pública
- Elegir una API pública para consumir. Algunas opciones recomendadas son:
  - **Open Library API**: Búsqueda de libros y bibliografía.
  - **TV Maze API**: Información sobre series y programas de TV.
  - **The Movie Database (TMDB)**: Información sobre películas y series.
  - **OpenWeatherMap**: Datos meteorológicos.
- Documentar la API seleccionada, incluyendo la **base URL** y los **endpoints** utilizados.

### 2. Diseño de la Interfaz de Usuario
- Diseñar una interfaz de usuario que permita:
  - Realizar búsquedas o seleccionar categorías según la API elegida.
  - Mostrar los resultados en una lista o grid usando **RecyclerView**.
  - Ver detalles al seleccionar un elemento de la lista.
- Incluir elementos visuales como **imágenes** (si la API proporciona URLs de imágenes).
- Implementar un diseño responsivo para diferentes tamaños de pantalla.

### 3. Implementación del Consumo de API
- Crear **clases de modelo** necesarias para mapear las respuestas JSON de la API.
- Implementar el servicio de conexión usando **Retrofit** o la biblioteca de preferencia.
- Configurar adecuadamente **interceptores** o **headers** si la API requiere autenticación.
- Implementar **paginación** si la API lo soporta y es necesario.

### 4. Mejoras de Experiencia de Usuario
- Agregar **elementos de carga** (progress bars o skeletons) durante las peticiones.
- Implementar **cacheo de respuestas** para mejorar rendimiento.
- Configurar **manejo de errores** con mensajes descriptivos y opciones para reintentar.
- Agregar la funcionalidad de **"pull to refresh"** para actualizar el contenido.

### 5. Evidencias
- Capturas de pantalla mostrando la **navegación** y funcionalidad de la aplicación.
- Capturas de pantalla de diferentes estados (carga, error, sin resultados, etc.).
- Video corto demostrando la interacción con la aplicación.
- Código fuente comentado con explicaciones relevantes.

---


## Conclusión
Este proyecto cubre la implementación de un **backend REST básico** y el consumo de una **API pública** en Android, aplicando las mejores prácticas de conexión y visualización de datos en una interfaz responsiva.

