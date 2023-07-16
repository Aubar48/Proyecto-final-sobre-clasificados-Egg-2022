
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Oficio {
    
    CARPINTERO("Carpintero"),
    ELECTRICISTA("Electricista"),
    ALBAÑIL("Albañil"),
    PLOMERO("Plomero"),
    PROFESOR("Profesor"),
    ARTESANO("Artesano"),
    PANADERO("Panadero"),
    COMERCIANTE("Comerciante"),
    COCINERO("Cocinero"),
    REPOSTERO("Repostero"),
    JARDINERO("Jardinero"),
    GASISTA("Gasista"),
    ESTALISTA("Estilista"),
    REMISERO("Remisero"),
    PROGRAMADOR("Programador"),
    Repositor("Repositor"),
    OTRO("Otro");
    


    private String nombre;

    private Oficio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
