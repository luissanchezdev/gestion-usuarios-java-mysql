
![Grabación-de-pantalla-2023-12-30-a-la_s_-1 00 32-a](https://github.com/luissanchezdev/gestion-usuarios-java-mysql/assets/50006980/40f68dd1-03c3-4054-9901-1078f205440e)

# Gestión de Usuarios con JAVA y MySQL

Gestionar una base de datos de usuarios, incorporando funciones, como crear, actualizar y eliminar usuarios.

## Requisitos Previos

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) 8 o superior
- [Ant](https://ant.apache.org/)

## Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/luissanchezdev/gestion-usuarios-java-mysql.git
```
  
2. Descarga la mysql connector mysql-connector-j-8.2.0 y agregalo a tus librerías

3. Crear la base de datos ejecutado usando el script ubicado en la carpet "db"

4. Actualizar los parárametros de conexión con la base de datos propia. Para esto en la clase UsuarioDao.java cambiar los valores:

```bash
String db = "NOMBRE DE LA BASE DE DATOS PROPIA";
String user = "USUARIO DE BASE DE DATOS";
String password = "CONTRASEÑA DE BASE DE DATOS";
String host = "HOST - POR DEFECTO LOCALHOST";
String port = "PUERTO - POR DEFECTO 3306";
        
```

## Estructura del proyecto

```bash
/
|-- src/                  # Código fuente del proyecto
|-- build/classes/        # Archivos generados por Ant
|-- db/                   # Script de la base de datos
|-- nbproject/            # Archivos de Netbeans
|-- LICENSE               # Licencia GPL
|-- build.xml             # Archivo de construcción Ant
|-- manifiest.mf          # Metadatos
|-- README.md             # Este archivo
```

## Contribuir

Si deseas contribuir al proyecto, sigue estos pasos:

- Haz un fork del proyecto.
- Crea una nueva rama para tu función: git checkout -b nueva-caracteristica.
- Realiza tus cambios y haz commit: git commit -m 'Añadir nueva característica'.
- Haz push a la rama: git push origin nueva-caracteristica.
- Abre un pull request en GitHub.


## Licencia

Este proyecto está bajo la [Licencia Pública General de GNU (GPL)](https://www.gnu.org/licenses/gpl-3.0.html).

Ver el archivo LICENSE para más detalles.
