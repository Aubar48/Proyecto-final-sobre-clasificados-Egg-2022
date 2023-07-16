
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Idiomas {
    
    INGLES("INGLES"),
    CHINO("CHINO"),
    HINDI("HINDI"),
    ESPAÑOL("ESPAÑOL"),
    ARABE("ARABE"),
    BENGALI("BENGALI"),
    FRANCES("FRANCES"),
    RUSO("RUSO"),
    PORTUGAL("PORTUGAL"),
    ALEMAN("ALEMAN"),
    JAPONES("JAPONES"),
    TURCO("TURCO"),
    ITALIANO("ITALIANO"),
    OTRO("OTRO");


    private String nombre;

    private Idiomas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
