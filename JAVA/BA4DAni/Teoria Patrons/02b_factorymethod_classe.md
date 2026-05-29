# Factory Method — Codi de classe

> 💻 Codi desenvolupat a classe. Paquet: `factoryMethod`

---

## Classes del projecte

```
factoryMethod/
├── Personatge.java
├── Guerrer.java
├── Arquer.java
├── Joc.java
├── JocGuerrers.java
├── JocArquers.java
└── MainJoc.java
```

> `Personatge`, `Guerrer` i `Arquer` són iguals que al paquet `factorySimple`.

---

## Joc.java — Creator abstracte

```java
package factoryMethod;

public abstract class Joc {

    // El Factory Method: abstracte, cada subclasse el sobreescriu
    public abstract Personatge factoryMethod();

    // Aquest mètode usa el producte sense saber quin és concretament
    public void jugar() {
        Personatge p = factoryMethod();
        p.atacar();
    }
}
```

---

## JocGuerrers.java / JocArquers.java — Creators concrets

```java
package factoryMethod;

public class JocGuerrers extends Joc {

    @Override
    public Personatge factoryMethod() {
        return new Guerrer();
    }
}
```

```java
package factoryMethod;

public class JocArquers extends Joc {

    @Override
    public Personatge factoryMethod() {
        return new Arquer();
    }
}
```

---

## MainJoc.java — El client

```java
package factoryMethod;

public class MainJoc {

    public static void main(String[] args) {

        Joc j1 = new JocGuerrers();
        j1.jugar();

        Joc j2 = new JocArquers();
        j2.jugar();
    }
}
```

**Sortida esperada:**
```
El Guerrer ataca amb l'espasa
L'Arquer ataca amb una fletxa
```

---

## Què canvia respecte al Simple Factory?

| | Simple Factory | Factory Method |
|---|---|---|
| El client fa | `PersonatgeFactory.crearPersonatge("guerrer")` | `new JocGuerrers()` + `jugar()` |
| Qui decideix el tipus | La Factory amb un `switch` | La subclasse sobreescrivint `factoryMethod()` |
| Afegir `JocMags` | Modificar el `switch` ❌ | Crear `JocMags extends Joc` ✅ |

## La línia clau

```java
public void jugar() {
    Personatge p = factoryMethod();  // Joc no sap quin Personatge és
    p.atacar();
}
```

`Joc` defineix el flux (`jugar`) però **delega la creació** a les subclasses. Cap classe existent s'ha de tocar per afegir nous tipus de joc.

---

> 📘 **Mòdul 0485 · BA4 Patrons** · 1r CFGS DAM
