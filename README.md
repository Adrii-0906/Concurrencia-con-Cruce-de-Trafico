# 🚦 Proyecto de Sistemas Operativos: Cruce de Tráfico y Bloqueos

Este repositorio aborda un problema fundamental en la informática concurrente: la gestión de **recursos compartidos** para evitar el **Interbloqueo (Deadlock)**. Utilizamos el clásico escenario del **Cruce de Tráfico** 🚗 como analogía principal, donde los vehículos son procesos y los cuadrantes de la intersección son los recursos.

---

## 💡 Conceptos Clave de Sincronización

El proyecto ilustra la relación entre dos conceptos vitales en la concurrencia:

### Exclusión Mutua (Mutual Exclusion)
Es un mecanismo **necesario** para la seguridad. Garantiza que **solo un coche** pueda ocupar un **cuadrante** (recurso) a la vez. El problema de interbloqueo surge *a pesar* de que esta condición se cumple.

### Interbloqueo (Deadlock) 💀
Un bloqueo **permanente** y **mutuo**. Ocurre cuando un conjunto de vehículos entra en un ciclo de espera. El interbloqueo solo se produce si se cumplen **simultáneamente** las cuatro condiciones de Coffman:

| Condición (Coffman) | Analgía en el Cruce de Tráfico |
| :--- | :--- |
| **Exclusión Mutua** | Un cuadrante solo puede ser usado por un coche. |
| **Retención y Espera** | El Coche A retiene $Q_1$ mientras espera $Q_2$ (retenido por B). |
| **No Expropiación** | Un coche no puede ser obligado a salir de su cuadrante. |
| **Espera Circular** | El Coche A espera a B, y el Coche B espera a A. |

---

## 🛠️ Soluciones Implementadas: Prevención

Nuestro objetivo es la **prevención**, eliminando una de las condiciones de Coffman para hacer el interbloqueo matemáticamente imposible.

### Solución A: Ordenación de Recursos (Negar la Espera Circular) ✅

Esta es la solución más sencilla y eficiente, eliminando la condición de **Espera Circular**.

1.  **Definición de Jerarquía:** Se asigna un orden numérico estricto a cada cuadrante (ej: $Q_1=1, Q_2=2, Q_3=3, Q_4=4$).
2.  **Regla de Oro:** Todo coche debe solicitar y adquirir sus cuadrantes en **orden ascendente de jerarquía**.
3.  **Funcionamiento:** Cuando dos coches entran en conflicto, ambos intentarán adquirir el recurso de **menor orden** primero. Solo uno lo obtendrá, y el otro esperará **sin retener nada**, rompiendo el ciclo de espera mutua.

### Solución B: Solicitud Atómica (Negar Retención y Espera) 🛑

Esta técnica garantiza que un coche nunca retenga una parte del cruce mientras espera otra.

1.  **Requerimiento Total:** Un coche debe declarar **todos los cuadrantes** que necesita para su ruta completa *antes* de entrar.
2.  **Adquisición Atómica:** El sistema verifica si *todos* los recursos están disponibles.
3.  **Funcionamiento:** Si la solicitud se puede satisfacer por completo, el coche entra. Si falta un solo recurso, el coche **no adquiere ninguno** y espera fuera del cruce, previniendo la condición de **Retención y Espera**.

---

## 💻 Guía de Uso Rápido

El repositorio utiliza Python para simular la concurrencia a través de hilos (`threading`) y objetos de sincronización (`Lock`).

### Estructura de Rutas de Prueba

Las siguientes rutas son las que pueden generar interbloqueo en un sistema sin control:

| Ruta | Cuadrantes Necesarios | Secuencia Natural |
| :--- | :--- | :--- |
| **Norte $\rightarrow$ Sur** | Q1, Q4 | $Q_1 \rightarrow Q_4$ |
| **Oeste $\rightarrow$ Este** | Q4, Q1 | $Q_4 \rightarrow Q_1$ |

### Ejecución

Para iniciar la simulación y observar cómo las técnicas de prevención garantizan un flujo de tráfico seguro:

```bash
python main.py
