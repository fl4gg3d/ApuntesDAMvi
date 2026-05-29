# Abstract Factory — Codi de classe

> 💻 Codi desenvolupat a classe. Paquet: `abstractFactory`

---

## Classes del projecte

```
abstractFactory/
├── Personatge.java        (interfície)
├── Guerrer.java
├── Arquer.java
├── Arma.java              (interfície)
├── Espasa.java
├── Arc.java
├── JocFactory.java        (Abstract Factory)
├── JocMedievalFactory.java
├── JocArquerFactory.java
└── MainJocAbstract.java
```

---

## Productes — Personatge i Arma

```java
package abstractFactory;

public interface Personatge {
    void atacar();
}
```

```java
package abstractFactory;

public interface Arma {
    void usar();
}
```

```java
package abstractFactory;

public class Guerrer implements Personatge {
    @Override
    public void atacar() {
        System.out.println("El Guerrer medieval ataca");
    }
}

public class Arquer implements Personatge {
    @Override
    public void atacar() {
        System.out.println("El Arquer ataca");
    }
}
```

```java
package abstractFactory;

public class Espasa implements Arma {
    @Override
    public void usar() {
        System.out.println("Espasa usada");
    }
}

public class Arc implements Arma {
    @Override
    public void usar() {
        System.out.println("Arc usat");
    }
}
```

---

## JocFactory.java — La Abstract Factory

```java
package abstractFactory;

public interface JocFactory {
    Personatge crearPersonatge();
    Arma crearArma();
}
```

---

## JocMedievalFactory.java / JocArquerFactory.java — Factories concretes

```java
package abstractFactory;

public class JocMedievalFactory implements JocFactory {

    @Override
    public Personatge crearPersonatge() {
        return new Guerrer();
    }

    @Override
    public Arma crearArma() {
        return new Espasa();
    }
}
```

```java
package abstractFactory;

public class JocArquerFactory implements JocFactory {

    @Override
    public Personatge crearPersonatge() {
        return new Arquer();
    }

    @Override
    public Arma crearArma() {
        return new Arc();
    }
}
```

---

## MainJocAbstract.java — El client

```java
package abstractFactory;

public class MainJocAbstract {

    public static void main(String[] args) {

        jugarAmbFactory(new JocMedievalFactory());
        jugarAmbFactory(new JocArquerFactory());
    }

    private static void jugarAmbFactory(JocFactory factory) {
        Personatge p = factory.crearPersonatge();
        Arma a       = factory.crearArma();

        p.atacar();
        a.usar();
    }
}
```

**Sortida esperada:**
```
El Guerrer medieval ataca
Espasa usada
El Arquer ataca
Arc usat
```

---

## La línia clau

```java
private static void jugarAmbFactory(JocFactory factory) {
```

`jugarAmbFactory` rep una `JocFactory` sense saber si és `JocMedievalFactory` o `JocArquerFactory`. Canviar una línia al `main` canvia **tota la família** d'objectes (personatge + arma) alhora.

---

## Garantia de coherència de família

| Factory | Personatge | Arma |
|---|---|---|
| `JocMedievalFactory` | `Guerrer` | `Espasa` |
| `JocArquerFactory` | `Arquer` | `Arc` |

Amb l'Abstract Factory és **impossible** combinar `Guerrer` amb `Arc` accidentalment — cada factory garanteix que els seus productes van sempre aparellats correctament.

---

## Afegir una nova família (ex: Elfs)

1. Crear `Elf implements Personatge`
2. Crear `ArcMagic implements Arma`
3. Crear `JocElfFactory implements JocFactory`

**Cap classe existent es modifica.** ✅

---

> 📘 **Mòdul 0485 · BA4 Patrons** · 1r CFGS DAM
