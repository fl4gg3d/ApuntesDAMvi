package mokepon;

/**
 * Enum Tipus
 *
 * Ens ajuda a limitar els valors possibles del tipus:
 * en lloc de Strings ("foc", "FOC", "Foc"...), només pot ser:
 * FOC, AIGUA o PLANTA.
 *
 * Avantatge:
 * - evita errors d'ortografia
 * - facilita comparacions (==) de forma segura
 */
public enum Tipus {
    FOC, AIGUA, PLANTA;
}