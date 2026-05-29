# Singleton — Codi de classe

> 💻 Codi desenvolupat a classe. Paquet: `singleton`

---

## Classes del projecte

```
singleton/
├── GameManager.java
└── Main.java  (a crear per provar)
```

---

## GameManager.java

```java
package singleton;

public class GameManager {

    private boolean isPaused;
    private int score;
    private int level;

    // 1. Atribut estàtic privat: guarda l'única instància
    private static GameManager instance = null;

    // 2. Constructor privat: ningú de fora pot fer new GameManager()
    private GameManager() {
        this.isPaused = false;
        this.score    = 0;
        this.level    = 1;
    }

    // 3. Punt d'accés global: crea la instància si no existeix
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void pauseGame()           { this.isPaused = true;  }
    public void resumeGame()          { this.isPaused = false; }
    public void addScore(int points)  { this.score += points;  }
    public void nextLevel()           { this.level++;          }
    public int  getScore()            { return score;          }
    public boolean isPaused()         { return isPaused;       }
    public int  getLevel()            { return level;          }
}
```

---

## Exemple d'ús — Main.java

```java
package singleton;

public class Main {
    public static void main(String[] args) {

        // Obtenim la instància (es crea aquí per primera vegada)
        GameManager gm1 = GameManager.getInstance();
        gm1.addScore(100);
        gm1.nextLevel();

        // Obtenim la instància des d'un altre lloc del codi
        GameManager gm2 = GameManager.getInstance();

        System.out.println("Score: "  + gm2.getScore());   // 100
        System.out.println("Level: "  + gm2.getLevel());   // 2
        System.out.println("Iguals? " + (gm1 == gm2));     // true
    }
}
```

**Sortida esperada:**
```
Score: 100
Level: 2
Iguals? true
```

---

## Per què `gm2.getScore()` retorna 100?

`gm1` i `gm2` **no són dues variables independents** — les dues apunten al mateix objecte en memòria. `getInstance()` sempre retorna la mateixa instància, de manera que qualsevol canvi fet a través de `gm1` es reflecteix en `gm2`.

---

> 📘 **Mòdul 0485 · BA4 Patrons** · 1r CFGS DAM
