package isaacSolucio;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        List<Enemic> enemics = new ArrayList<>();
        enemics.add(EnemicFactory.crearEnemic(Mosca.class, Dificultat.DIFICIL));
        enemics.add(EnemicFactory.crearEnemic(Mosca.class, Dificultat.DIFICIL));
        enemics.add(EnemicFactory.crearEnemic(Mosca.class, Dificultat.FACIL));
        enemics.add(EnemicFactory.crearEnemic(Cuca.class, Dificultat.DIFICIL));
        enemics.add(EnemicFactory.crearEnemic(Cuca.class, Dificultat.DIFICIL));
        enemics.add(EnemicFactory.crearEnemic(Cuca.class, Dificultat.DIFICIL));
        enemics.add(EnemicFactory.crearEnemic(Cuca.class, Dificultat.FACIL));
        enemics.add(EnemicFactory.crearEnemic(Mosca.class, Dificultat.FACIL));

        System.out.println(enemics);
        // [Mosca [hp=3, punts=60], Mosca [hp=3, punts=60], Mosca [hp=1, punts=20],
        //  Cuca [hp=5, punts=125], Cuca [hp=5, punts=125], Cuca [hp=5, punts=125],
        //  Cuca [hp=3, punts=75], Mosca [hp=1, punts=20]]

        noPosisMassaPunts(enemics);

        System.out.println(enemics);
        // [Mosca [hp=3, punts=60], Mosca [hp=3, punts=60], Mosca [hp=1, punts=20],
        //  Cuca [hp=5, punts=125], Cuca [hp=3, punts=75], Mosca [hp=1, punts=20]]

        Tarot tarot = new Tarot();
        tarot.add("Carta1?");
        tarot.add("Carta-2");
        tarot.add("Carta-3");
        tarot.add("Carta4?");
        // Pila plena, canviem Carta-3 per Carta4?

        tarot.use(); // Isaac Utilitza Carta4?
        tarot.use(); // Isaac Utilitza Carta-2
        tarot.use(); // Isaac Utilitza Carta-2

        RoomManager roomManager = new RoomManager();
        List<Enemic> enemicsRM = roomManager.initRoom(3);
        System.out.println(enemicsRM);
        enemicsRM.get(0).danyar(3); // Enemic mort. Punts guanyats: 75 (o 60)
        System.out.println(roomManager); // RoomManager [punts=75] (o 60)
        System.out.println(enemicsRM);   // El primer enemic ha de tenir hp=0

        Tear tear = new TearBase();
        tear = new PolyphemusTear(new SoyMilkTear(tear));
        System.out.println(tear.getAtk());  // 4.0
        System.out.println(tear.getSize()); // 0.4

        Bomb bomb = new Bomb(5);
        AtkSizeProvider bombAdapted = new AdapterBomb(bomb);
        System.out.println(bombAdapted.getAtk());  // 2.5
        System.out.println(bombAdapted.getSize()); // 1.0
    }

    public static void noPosisMassaPunts(List<Enemic> enemics) {
        // FIX Ex.2: La versió original feia iterator.previous() fora del if,
        // cosa que feia retrocedir l'iterador fins i tot quan NO s'eliminava res,
        // provocant un bucle infinit o comportament incorrecte.
        //
        // Solució: després de mirar el següent, sempre tornem enrere UNA posició
        // per avançar normalment al proper hasNext(). Si eliminem, ja no cal
        // tornar enrere perquè el remove() opera sobre l'últim next() retornat.

        ListIterator<Enemic> iterator = enemics.listIterator();
        while (iterator.hasNext()) {
            Enemic actual = iterator.next();
            if (iterator.hasNext()) {
                // "Espiem" el seguent sense consumir-lo definitivament
                Enemic seguent = iterator.next();
                iterator.previous(); // tornem al cursor just després d'actual

                if (actual.punts > 100 && seguent.punts > 100) {
                    // Eliminem 'actual': fem previous per situar-nos sobre ell
                    iterator.previous();
                    iterator.remove();
                    // L'iterador queda apuntant al lloc on estava actual.
                    // El proper next() retornarà 'seguent', que és correcte.
                }
                // Si NO eliminem, el cursor ja és just després d'actual
                // i el proper next() retornarà 'seguent'. Correcte.
            }
        }
    }
}
