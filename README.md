[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/V5qV5exL)
### **Instrucciones para el Ejercicio "EvaluadorDeClases":**

1. **Crear la clase:**
    - Crea la clase **`LibretaDeNotas`** para que pueda evaluar y almacenar las calificaciones de una lista de estudiantes.
    - Utiliza un **`HashMap`** para almacenar las calificaciones de los estudiantes, donde la llave es el nombre del estudiante y el valor es un **`ArrayList`** de notas.
    - Solicita al usuario que ingrese la cantidad de alumnos y la cantidad de notas por alumno.
    - Solicita el nombre de cada alumno y las notas correspondientes, almacenándolas en el **`HashMap`**.
2. **Recorrer el HashMap y Evaluar Calificaciones:**
    - Utiliza un bucle (por ejemplo, **`for`** o **`foreach`**) para recorrer el **`HashMap`** de calificaciones.
3. **Calcular Promedio, Nota Máxima y Mínima por Estudiante:**
    - Después de evaluar las calificaciones, calcula y muestra para cada estudiante:
        - **Promedio de Notas:** Suma todas las calificaciones y divide por la cantidad total de notas.
        - **Nota Máxima:** Encuentra la calificación más alta en el **`ArrayList`**.
        - **Nota Mínima:** Encuentra la calificación más baja en el **`ArrayList`**.
4. **Menú de Opciones:**
    - Muestra un menú con las siguientes opciones:
        - **1. Mostrar el Promedio de Notas por Estudiante.**
        - **2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.**
        - **3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.**
        - **0. Salir del Menú.**
    - Utiliza un bucle para permitir al usuario seleccionar opciones hasta que ingrese 0 para salir.
5. **Operaciones del Menú:**
    - **Opción 1: Mostrar el Promedio de Notas por Estudiante.**
        - Muestra el promedio de notas por cada estudiante calculado previamente.
    - **Opción 2: Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.**
        - Solicita al usuario ingresar el nombre de un estudiante y una nota, luego verifica si es aprobatoria o reprobatoria según una nota de aprobación definida.
    - **Opción 3: Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.**
        - Solicita al usuario ingresar el nombre de un estudiante y una nota, luego verifica si está por sobre o por debajo del promedio general.
6. **Validaciones:**
    - Implementa validaciones para asegurar que las notas ingresadas estén en un rango válido y que la cantidad de alumnos sea un número positivo.

---
## 📚 LibretaDeNotas - Sistema de Evaluación y Gestión de Calificaciones

### 🛠️ Tecnologías Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

---
### 📋 Descripción

**LibretaDeNotas** es una aplicación Java que permite:
* 📚 **Registro y Evaluación de Calificaciones:** Ingresa hasta 50 alumnos y 10 notas por alumno, con notas válidas entre 0 y 7 (Ejemplo: 5,5 o 5).
* 📊 **Cálculo Automático:** Determina de manera eficiente el promedio, nota mínima y máxima de cada estudiante, utilizando métodos de la API Collections y Streams para optimizar el código.
* 🔄 **Menú Interactivo:** Ofrece opciones para mostrar promedios, evaluar si una nota es aprobatoria (mínimo 4.0) o reprobatoria, y comparar una nota individual con el promedio general del curso.
* 🚀 **Código Optimizado:** Aprovecha métodos y librerías de Java para reducir líneas de código, mejorando la legibilidad y eficiencia.

---
### ⚙️ Requisitos Previos

| Requisito      | Versión/Detalle           |
|----------------|---------------------------|
| Java JDK       | 21                        |
| IDE            | IntelliJ IDEA             |

---
### 🚀 Inicio Rápido

1. **Clonar el repositorio**

```
   git clone https://github.com/Generation-Chile-Java/libretadenotas-gperzal.git
```

2. **Abrir el proyecto en IntelliJ IDEA**

``
   File → Open → Selecciona la carpeta del proyecto
``
---
### 📁 Estructura del Proyecto
```
libretadenotas-gperzal/
│ └── LibretaDeNotas.java# Clase principal con la solución 
└── README.md # Documentación del proyecto
```
---
### 🔄 Funcionalidades

- **Registro de Alumnos y Calificaciones:**  
  Permite ingresar hasta **50 alumnos** y **10 notas** por alumno, validando que las notas estén en el rango de **0 a 7** (Ejemplo: 5,5 o 5).

- **Cálculo de Estadísticas:**  
  Utiliza métodos de **Collections** y **Streams** para calcular de forma concisa y eficiente:
   - **Promedio**
   - **Nota Mínima**
   - **Nota Máxima**

- **Menú Interactivo:**  
  Ofrece las siguientes opciones:
   - **Opción 1:** Mostrar el promedio de cada estudiante.
   - **Opción 2:** Evaluar si una nota es aprobatoria (mínimo 4.0) o reprobatoria.
   - **Opción 3:** Comparar una nota con el promedio general del curso.
   - **Opción 0:** Salir de la aplicación.

- **Optimización de Código:**  
  Se han utilizado métodos y librerías de Java para reducir líneas de código y mejorar la eficiencia y legibilidad del programa.

---
### 💻 Ejecución

Compila y ejecuta el proyecto con:
``
LibretaDeNotas.java 
``
