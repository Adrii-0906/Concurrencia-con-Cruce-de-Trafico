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
