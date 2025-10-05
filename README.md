# 🚗 Concurrencia en la Intersección: Exclusión Mutua e Interbloqueo

Este proyecto se centra en el estudio y la resolución de problemas de **concurrencia** en programación, específicamente la **Exclusión Mutua** y el **Interbloqueo (Deadlock)**.

Hemos elegido el problema clásico del **Cruce de Tráfico** para simular estos desafíos en Java y demostrar cómo las estrategias de sincronización son esenciales para el buen funcionamiento de un sistema.

---

## 1. 💡 Conceptos Clave

Para comprender los desafíos de este proyecto, es crucial entender los fundamentos de la programación concurrente.

### Concurrencia

La **concurrencia** es la ejecución de múltiples tareas en un mismo período de tiempo. A diferencia de la ejecución secuencial, permite iniciar y avanzar en distintas tareas de forma simultánea. Esto introduce desafíos críticos relacionados con la coordinación del acceso a recursos compartidos.

### 1.1. Exclusión Mutua

La **Exclusión Mutua** es el principio que garantiza que solo un hilo o proceso a la vez puede acceder a un **recurso compartido**.

Su objetivo es evitar **conflictos** o **inconsistencias** (como la **Pérdida de Integridad de los Datos** y la **Aparición de Fallos**) cuando varios hilos intentan modificar el mismo recurso. Es un mecanismo esencial para la coherencia, pero debe combinarse con buenas estrategias de sincronización para evitar bloqueos.

### 1.2. Interbloqueo (Deadlock) 💀

El **interbloqueo** es una **situación** donde dos o más hilos se bloquean mutuamente de forma **permanente**, ya que cada uno posee un recurso que el otro necesita y ninguno puede avanzar.

Este problema ocurre si se cumplen simultáneamente las **cuatro condiciones de Coffman** (1971):

| Condición | Descripción |
| :--- | :--- |
| **Exclusión Mutua** | Los recursos están asignados de forma exclusiva a un único hilo. |
| **Retención y Espera** | Un hilo retiene recursos previamente asignados mientras espera nuevos recursos. |
| **Imposibilidad de Apropiación** | Los recursos solo pueden ser liberados voluntariamente por el hilo que los posee. |
| **Presencia de una Espera Circular** | Existe una cadena de hilos donde cada uno espera un recurso poseído por el siguiente, creando un ciclo vicioso. |

#### Estrategias para Evitar el Interbloqueo

El interbloqueo puede evitarse **rompiendo** una de las condiciones:
* **Romper la Espera Circular:** Imponiendo un orden fijo de adquisición de recursos.
* **Evitar Retención y Espera:** Exigir que un hilo adquiera todos los recursos a la vez, o libere los que tiene si no puede adquirir otro.
* **Permitir Expropiación:** Forzar a un hilo a liberar recursos si otro los necesita.
* **Detectar y Abortar:** Abortar uno de los hilos si se detecta un ciclo de espera.

---

## 2. 🚦 Caso Clásico: Cruce de Tráfico

Hemos elegido el **Cruce de Tráfico** para simular estos conceptos. En este modelo:
* Los **Vehículos** son los **Hilos/Procesos**.
* Los **Cuadrantes** de la intersección son los **Recursos** (que requieren exclusión mutua).

### 2.1. Simulación del Interbloqueo

Imaginemos una intersección con cuatro cuadrantes ($Q_1$ a $Q_4$). Cuando cuatro coches llegan simultáneamente con intención de seguir recto, se puede formar el ciclo:

* **Coche A** ocupa $Q_1$, esperando $Q_2$.
* **Coche B** ocupa $Q_2$, esperando $Q_3$.
* **Coche C** ocupa $Q_3$, esperando $Q_4$.
* **Coche D** ocupa $Q_4$, esperando $Q_1$.

**Resultado:** Se cumple la **Espera Circular** y el programa se detiene. ¡El interbloqueo es real!

### 2.2. Soluciones Implementadas en Java

Para resolver este problema, hemos implementado y simulado dos estrategias distintas de prevención de interbloqueo:

#### 1. Prioridad por Vía (Prevención)
Se asigna una **prioridad fija** a cada dirección (vía). Un coche solo puede entrar al cruce si no hay ningún vehículo de **mayor prioridad** esperando.

* **Lógica de Prevención:** Aunque los cuatro coches lleguen a la vez, la prioridad garantiza que uno avance primero. Esto rompe la **Espera Circular** porque siempre hay un camino de avance.

#### 2. Semáforos Reales (Control de Flujo)
Los coches esperan su turno para entrar al cruce siguiendo un **orden predefinido y secuencial**.

* **Lógica de Prevención:** Los vehículos esperan **fuera del cruce**, asegurando que solo un coche entra a la vez (o se permite un flujo controlado). Esto previene la condición de **Retención y Espera** dentro del cruce y evita cualquier conflicto al gestionarse el acceso de forma secuencial.

---

## 💻 Estructura del Proyecto

Este repositorio contiene la implementación en **Java** para simular tanto el interbloqueo como las soluciones mencionadas.
