# 📚 Apunts de Patrons de Disseny — Java

**Mòdul:** 0485 · BA4 Patrons, piles, cues
**Curs:** 1r CFGS Desenvolupament d'Aplicacions Multiplataforma (DAM)

---

## Estructura dels materials

Cada patró té **dos fitxers**:

| Fitxer | Contingut |
|---|---|
| `XX_nompatró.md` | Teoria, UML i exemple neutre |
| `XX_nompatró_classe.md` | Codi fet a classe comentat |

---

## Índex

### Patrons Creacionals

| # | Patró | Teoria | Codi de classe |
|---|---|---|---|
| 1 | **Singleton** | [01_singleton.md](01_singleton.md) | [01_singleton_classe.md](01_singleton_classe.md) |
| 2a | **Simple Factory** | *(vegeu Factory Method)* | [02a_simplefactory_classe.md](02a_simplefactory_classe.md) |
| 2b | **Factory Method** | [02_factory.md](02_factory.md) | [02b_factorymethod_classe.md](02b_factorymethod_classe.md) |
| 2c | **Abstract Factory** | [02c_abstract_factory.md](02c_abstract_factory.md) | [02c_abstractfactory_classe.md](02c_abstractfactory_classe.md) |

### Patrons Estructurals

| # | Patró | Teoria | Codi de classe |
|---|---|---|---|
| 3 | **Decorator** | [03_decorator.md](03_decorator.md) | *(pendent)* |
| 5 | **Adapter** | [05_adapter.md](05_adapter.md) | *(pendent)* |

### Patrons de Comportament

| # | Patró | Teoria | Codi de classe |
|---|---|---|---|
| 4 | **Observer** | [04_observer.md](04_observer.md) | *(pendent)* |

---

## Resum ràpid

### Creacionals — gestionen la creació d'objectes
- **Singleton**: Una sola instància a tot el programa.
- **Simple Factory**: Mètode estàtic amb `switch` que centralitza la creació.
- **Factory Method**: Subclasses decideixen quin objecte crear sobreescrivint un mètode.
- **Abstract Factory**: Subclasses creen famílies senceres d'objectes coherents.

### Estructurals — defineixen com es composen les classes
- **Decorator**: Afegeix funcionalitat a un objecte dinàmicament, sense herència.
- **Adapter**: Fa compatibles dues interfícies incompatibles.

### Comportament — gestionen la comunicació entre objectes
- **Observer**: Un objecte notifica automàticament els seus subscriptors quan canvia.

---

## Principis SOLID relacionats

| Principi | Patrons que l'apliquen |
|---|---|
| **O**bert/Tancat (OCP) | Factory Method, Abstract Factory, Decorator, Observer, Adapter |
| **D**ependency Inversion (DIP) | Factory Method, Abstract Factory, Observer, Adapter |
| **S**ingle Responsibility (SRP) | Singleton, Decorator |
