# Decorator — Codi de classe

> 💻 Codi desenvolupat a classe. Tres exemples progressius del patró.

---

## Exemples del projecte

```
decoratorClasseAbstracta/   → Exemple 1: estructura bàsica del patró
decoratorPersonatge/        → Exemple 2: decoració d'un personatge de joc
decoratorMonstreMarc/       → Exemple 3: monstres amb capacitats combinables
```

---

## Exemple 1: Estructura bàsica — `decoratorClasseAbstracta`

L'exemple més simple per entendre l'esquelet del patró.

### Component.java — Component abstracte

```java
package decoratorClasseAbstracta;

public abstract class Component {
    abstract public void operacio();
}
```

### ComponentConcret.java — L'objecte base que decorarem

```java
package decoratorClasseAbstracta;

public class ComponentConcret extends Component {

    @Override
    public void operacio() {
        System.out.println(" operació de Component Concret ");
    }
}
```

### Decorador.java — Decorator abstracte

```java
package decoratorClasseAbstracta;

public abstract class Decorador extends Component {

    private Component component;

    public Decorador(Component component) {
        this.component = component;
    }

    @Override
    public void operacio() {
        component.operacio();  // delega al component embolicat
    }
}
```

### DecoradorConcretA.java / DecoradorConcretB.java — Decoradors concrets

```java
package decoratorClasseAbstracta;

public class DecoradorConcretA extends Decorador {

    private String propietatAfegida;

    public DecoradorConcretA(Component component) {
        super(component);
    }

    @Override
    public void operacio() {
        super.operacio();  // executa primer el component embolicat
        this.propietatAfegida = "nova patata A afegida";
        System.out.println("Afegida patata A ");
    }
}
```

```java
package decoratorClasseAbstracta;

public class DecoradorConcretB extends Decorador {

    public DecoradorConcretB(Component component) {
        super(component);
    }

    @Override
    public void operacio() {
        super.operacio();
        comportamentAfegit();
        System.out.println("Afegint patata B ");
    }

    private void comportamentAfegit() {
        System.out.println("patata b afegida");
    }
}
```

### TestDecoratorAbstracta.java — Main

```java
package decoratorClasseAbstracta;

public class TestDecoratorAbstracta {

    public static void main(String[] args) {

        ComponentConcret cc = new ComponentConcret();
        DecoradorConcretA d1 = new DecoradorConcretA(cc);
        DecoradorConcretB d2 = new DecoradorConcretB(d1);

        d2.operacio();
    }
}
```

**Sortida esperada:**
```
 operació de Component Concret
Afegida patata A
patata b afegida
Afegint patata B
```

> L'ordre d'execució és de dins cap a fora: primer `cc`, després `d1`, després `d2`.

---

## Exemple 2: Personatge de joc — `decoratorPersonatge`

El patró aplicat a la creació d'un personatge al que s'afegeixen equipaments.

### PersonatgeJoc.java — Interfície component

```java
package decoratorPersonatge;

public interface PersonatgeJoc {
    public void crearPersonatge(Personatge p);
}
```

### Personatge.java — Objecte de dades

```java
package decoratorPersonatge;

public class Personatge {

    private String nom;
    private int vida;
    private int atac;

    public Personatge(String nom, int vida, int atac) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
    }

    public Personatge() {
        this.nom = "Dani";
        this.vida = 5;
        this.atac = 10;
    }

    public String getNom()        { return nom;  }
    public void setNom(String nom){ this.nom = nom; }
    public int getVida()          { return vida; }
    public void setVida(int vida) { this.vida += vida; }  // acumulatiu!
    public int getAtac()          { return atac; }
    public void setAtac(int atac) { this.atac += atac; }  // acumulatiu!

    @Override
    public String toString() {
        return "Personatge [nom=" + nom + ", vida=" + vida + ", atac=" + atac + "]";
    }
}
```

### PersonatgeGuerrer.java / PersonatgeComerciant.java — Components base

```java
package decoratorPersonatge;

public class PersonatgeGuerrer implements PersonatgeJoc {
    @Override
    public void crearPersonatge(Personatge p) {
        System.out.println("Guerrer " + p.getNom() + " creat");
    }
}

public class PersonatgeComerciant implements PersonatgeJoc {
    @Override
    public void crearPersonatge(Personatge p) {
        System.out.println("Comerciant " + p.getNom() + " creat");
    }
}
```

### PersonatgeDecorator.java — Decorator base

```java
package decoratorPersonatge;

public class PersonatgeDecorator implements PersonatgeJoc {

    public PersonatgeJoc personatgeDecorat;

    public PersonatgeDecorator(PersonatgeJoc personatgeDecorat) {
        this.personatgeDecorat = personatgeDecorat;
    }

    @Override
    public void crearPersonatge(Personatge p) {
        this.personatgeDecorat.crearPersonatge(p);
    }
}
```

### ArmaduraDecorator.java / ArmaDecorator.java — Decoradors concrets

```java
package decoratorPersonatge;

public class ArmaduraDecorator extends PersonatgeDecorator {

    public ArmaduraDecorator(PersonatgeJoc personatgeDecorat) {
        super(personatgeDecorat);
    }

    @Override
    public void crearPersonatge(Personatge p) {
        this.personatgeDecorat.crearPersonatge(p);
        afegirArmadura(p);
    }

    private void afegirArmadura(Personatge p) {
        System.out.println("Afegida armadura a " + p.getNom());
        p.setVida(10);
    }
}
```

```java
package decoratorPersonatge;

public class ArmaDecorator extends PersonatgeDecorator {

    String tipusArma;

    public ArmaDecorator(PersonatgeJoc personatgeDecorat, String tipusArma) {
        super(personatgeDecorat);
        this.tipusArma = tipusArma;
    }

    @Override
    public void crearPersonatge(Personatge p) {
        this.personatgeDecorat.crearPersonatge(p);
        afegirArma(p, this.tipusArma);
    }

    private void afegirArma(Personatge p, String tipusArma) {
        System.out.println("Afegida " + tipusArma + " a " + p.getNom());
        if (tipusArma.equals("espasa")) {
            p.setAtac(100);
        }
    }
}
```

### TestPersonatgeDecorator.java — Main

```java
package decoratorPersonatge;

public class TestPersonatgeDeocrator {

    public static void main(String[] args) {

        Personatge p = new Personatge("Dani2", 50, 10);

        PersonatgeGuerrer pjoc      = new PersonatgeGuerrer();
        ArmaduraDecorator pblindat  = new ArmaduraDecorator(pjoc);
        ArmaDecorator     pArmat    = new ArmaDecorator(pblindat, "espasa");

        pArmat.crearPersonatge(p);
        System.out.println(p.getAtac());
        System.out.println(p.getVida());
    }
}
```

**Sortida esperada:**
```
Guerrer Dani2 creat
Afegida armadura a Dani2
Afegida espasa a Dani2
110
60
```

---

## Exemple 3: Monstres — `decoratorMonstreMarc`

L'exemple més complet: monstres als que es combinen capacitats (element, àrea, boss).

### Element.java — Enum

```java
package decoratorMonstreMarc;

public enum Element {
    FOC, GEL, LLAMP
}
```

### Monstre.java — Component abstracte

```java
package decoratorMonstreMarc;

public abstract class Monstre {
    public abstract void atacar();
}
```

### MonstreBase.java — Component base

```java
package decoratorMonstreMarc;

public class MonstreBase extends Monstre {
    @Override
    public void atacar() {
        System.out.println("El Monstre ataca");
    }
}
```

### MonstreDecorador.java — Decorator base

```java
package decoratorMonstreMarc;

public class MonstreDecorador extends Monstre {

    protected Monstre mon;

    public MonstreDecorador(Monstre mon) {
        this.mon = mon;
    }

    @Override
    public void atacar() {
        mon.atacar();
    }
}
```

### Decoradors concrets

```java
package decoratorMonstreMarc;

public class MonstreAmbElement extends MonstreDecorador {

    Element el;

    public MonstreAmbElement(Monstre mon, Element el) {
        super(mon);
        this.el = el;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("El monstre ataca amb element " + el.name());
    }
}
```

```java
package decoratorMonstreMarc;

public class MonstreAmbArees extends MonstreDecorador {

    String area = "";

    public MonstreAmbArees(Monstre mon, String area) {
        super(mon);
        this.area = area;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("El monstre té un atac d'area " + area);
    }
}
```

```java
package decoratorMonstreMarc;

public class MonstreBoss extends MonstreDecorador {

    boolean raid = false;

    public MonstreBoss(Monstre mon, boolean raid) {
        super(mon);
        this.raid = raid;
    }

    @Override
    public void atacar() {
        super.atacar();
        if (raid) {
            System.out.println("Compte, el monstre és un boss de raid");
        } else {
            System.out.println("El monstre és un boss de masmorra!");
        }
    }
}
```

### TestMonstreDecorador.java — Main

```java
package decoratorMonstreMarc;

public class TestMonstreDecorador {

    public static void main(String[] args) {

        MonstreBase m = new MonstreBase();

        // Monstre amb element foc
        MonstreAmbElement me = new MonstreAmbElement(m, Element.FOC);
        me.atacar();
        System.out.println("...................................");

        // Monstre amb àrea
        MonstreAmbArees ma = new MonstreAmbArees(m, "Patata");
        ma.atacar();
        System.out.println("...................................");

        // Combinació: element + àrea
        MonstreAmbArees ma2 = new MonstreAmbArees(me, "PatatasArdiente");
        ma2.atacar();
        System.out.println();

        // Combinació: element + àrea + boss de raid
        MonstreBoss mb = new MonstreBoss(ma2, true);
        mb.atacar();
    }
}
```

**Sortida esperada:**
```
El Monstre ataca
El monstre ataca amb element FOC
...................................
El Monstre ataca
El monstre té un atac d'area Patata
...................................
El Monstre ataca
El monstre ataca amb element FOC
El monstre té un atac d'area PatatasArdiente

El Monstre ataca
El monstre ataca amb element FOC
El monstre té un atac d'area PatatasArdiente
Compte, el monstre és un boss de raid
```

> Fixa't com `mb.atacar()` executa tota la cadena sencera: MonstreBase → Element → Àrea → Boss.

---

> 📘 **Mòdul 0485 · BA4 Patrons** · 1r CFGS DAM
