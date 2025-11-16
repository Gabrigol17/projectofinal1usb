# proyectofinaljava

Proyecto Maven de ejemplo creado por el asistente.

## Estructura

- `pom.xml` - configuración de Maven
- `src/main/java/com/example/proyectofinaljava/App.java` - clase principal

## Requisitos

- Java 11+ instalado
- Maven instalado

## Comandos (PowerShell)

Para compilar y empaquetar:

```powershell
mvn -f .\pom.xml clean package
```

Para ejecutar la clase principal directamente desde el JAR generado (usar classpath):

```powershell
java -cp .\target\proyectofinaljava-1.0-SNAPSHOT.jar com.example.proyectofinaljava.App
```

O ejecutar usando Maven:

```powershell
mvn -f .\pom.xml exec:java -Dexec.mainClass="com.example.proyectofinaljava.App"
```

(El último comando requiere agregar el plugin `exec` si se desea usarlo regularmente.)
