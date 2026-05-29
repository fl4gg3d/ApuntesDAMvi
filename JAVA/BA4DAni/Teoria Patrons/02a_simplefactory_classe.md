# Simple Factory — Codi de classe

> 💻 Codi desenvolupat a classe. Paquet: `factorySimple`

---

## Classes del projecte

```
factorySimple/
├── Personatge.java
├── Guerrer.java
├── Arquer.java
├── Mag.java
├── PersonatgeFactory.java
└── main.java
```

---

## Personatge.java — Interfície producte

```java
package factorySimple;

public interface Personatge {
    void atacar();
}
```

---

## Guerrer.java / Arquer.java / Mag.java — Productes concrets

```java
package factorySimple;

public class Guerrer implements Personatge {
    @Override
    public void atacar() {
        System.out.println("El Guerrer ataca amb l'espasa");
    }
}
```

```java
package factorySimple;

public class Arquer implements Personatge {
    @Override
    public void atacar() {
        System.out.println("L'Arquer ataca amb una fletxa");
    }
}
```

```java
package factorySimple;

public class Mag implements Personatge {
    @Override
    public void atacar() {
        System.out.println("El Mag ataca amb un encanteri");
    }
}
```

---

## PersonatgeFactory.java — La fàbrica

```java
package factorySimple;

public class PersonatgeFactory {

    public static Personatge crearPersonatge(String tipus) {

        switch (tipus) {
            case "guerrer": return new Guerrer();
            case "arquer":  return new Arquer();
            case "mag":     return new Mag();
            default: throw new IllegalArgumentException("Tipus no trobat " + tipus);
        }
    }
}
```

---

## main.java — El client

```java
package factorySimple;

public class main {

    public static void main(String[] args) {

        Personatge p1 = PersonatgeFactory.crearPersonatge("guerrer");
        Personatge p2 = PersonatgeFactory.crearPersonatge("arquer");
        Personatge p3 = PersonatgeFactory.crearPersonatge("mag");

        p1.atacar();
        p2.atacar();
        p3.atacar();
    }
}
```

**Sortida esperada:**
```
El Guerrer ataca amb l'espasa
L'Arquer ataca amb una fletxa
El Mag ataca amb un encanteri
```

---

## Què fa la Factory aquí?

El `main` no fa cap `new Guerrer()`, `new Arquer()` ni `new Mag()` — sempre passa per `PersonatgeFactory.crearPersonatge()`. Això vol dir que si canviem com es crea un `Guerrer` (per exemple, afegint paràmetres al constructor), **només ho toquem a la Factory**, no al client.

---

## Limitació: afegir un nou tipus

Si volem afegir un `Paladi`, hem de **modificar el `switch`** de `PersonatgeFactory`. Això viola el principi Obert/Tancat. Aquesta limitació és el punt de partida per entendre el **Factory Method**.

---

> 📘 **Mòdul 0485 · BA4 Patrons** · 1r CFGS DAM
