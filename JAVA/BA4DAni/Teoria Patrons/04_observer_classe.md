# Observer — Codi de classe

> 💻 Codi desenvolupat a classe. Paquet: `observer`

---

## Classes del projecte

```
observer/
├── EventObserver.java    (interfície Observer)
├── Clau.java             (Subject)
├── Porta.java            (Observer concret)
├── Enemic.java           (Observer concret)
└── TestObserver.java     (Main)
```

---

## EventObserver.java — Interfície Observer

```java
package observer;

public interface EventObserver {
    public void activarEvent();
}
```

---

## Clau.java — El Subject

```java
package observer;

import java.util.ArrayList;

public class Clau {

    // Llista d'observers subscrits
    ArrayList<EventObserver> observers = new ArrayList<>();

    public void subscribe(EventObserver o) {
        observers.add(o);
    }

    public void unsubscribe(EventObserver o) {
        observers.remove(o);
    }

    // Notifica a tots els observers
    public void activate() {
        for (EventObserver o : observers) {
            o.activarEvent();
        }
    }

    // Quan s'agafa la clau, s'activen tots els events
    public void agafarClau() {
        activate();
    }
}
```

---

## Porta.java / Enemic.java — Observers concrets

```java
package observer;

public class Porta implements EventObserver {
    @Override
    public void activarEvent() {
        System.out.println("Porta byebye");
    }
}
```

```java
package observer;

public class Enemic implements EventObserver {
    @Override
    public void activarEvent() {
        System.out.println("Enemic va a per tu");
    }
}
```

---

## TestObserver.java — Main

```java
package observer;

public class TestObserver {

    public static void main(String[] args) {

        Clau c    = new Clau();
        Porta p   = new Porta();
        Enemic e  = new Enemic();

        c.subscribe(p);
        c.subscribe(e);
        c.agafarClau();
    }
}
```

**Sortida esperada:**
```
Porta byebye
Enemic va a per tu
```

---

## Com funciona

Quan el jugador agafa la clau (`agafarClau()`), la `Clau` notifica automàticament a tots els observers subscrits. Cada observer reacciona de forma independent:

| Rol al patró | Classe | Descripció |
|---|---|---|
| Subject | `Clau` | Manté la llista d'observers i els notifica |
| Observer | `EventObserver` | Interfície amb `activarEvent()` |
| Observer concret | `Porta` | Reacciona obrint/tancant la porta |
| Observer concret | `Enemic` | Reacciona activant l'enemic |

---

## Afegir un nou observer

Per afegir una `Trampa` que s'activi quan s'agafa la clau, només cal:

```java
public class Trampa implements EventObserver {
    @Override
    public void activarEvent() {
        System.out.println("Trampa activada!");
    }
}
```

```java
Trampa t = new Trampa();
c.subscribe(t);   // cap altra classe es modifica
```

**Cap classe existent es toca.** ✅

---

> 📘 **Mòdul 0485 · BA4 Patrons** · 1r CFGS DAM
