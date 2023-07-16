
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Nacionalidad {
    
    ARGENTINA("Argentina"),
    CHILENA("Chile"),
    BOLIVIANA("Boliviana"),
    BRASILEÑA("Brasileña"),
    COLOMBIANA("Colombiana"),
    COSTARRICENSE("Costarricense"),
    MEXICANA("Mexicana"),
    PANAMEÑA("Panameña"),
    PARAGUAYA("Paraguaya"),
    URUGUAYA("Uruaguya"),
    PERUANA("Peruana"),
    PUERTORIQUEÑO("Puertoriqueño"),
    VENEZOLANA("Venezolana"),
    ECUATORIANA("Ecuatoriana"),
    CHINA("China"),
    JAPONES("Japones"),
    COREANA("Coreana"),
    ALEMANA("Alemana"),
    FRANCESA("Francesa"),
    AUSTRALIANA("Australiana"),
    CANADIENSE("Canadiense"),
    CUBANA("Cubana");
    private String nombre;

    private Nacionalidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
