
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Provincia {
    
    CATAMARCA("Catamarca"),
    CIUDAD_AUTONOMA_DE_BUENOS_AIRES("Cudad Autonomo de Buenos Aires"),
    CORDOBA("Cordoba"),
    CORRIENTES("Corrientes"),
    CHACO("Chacho"),
    CHUBUT("Chubut"),
    ENTRE_RIOS("Entre Rios"),
    FORMOSA("Formosa"),
    JUJUY("Jujuy"),
    LA_PAMPA("La Pampa"),
    LA_RIOJA("La Rioja"),
    MENDOZA("Mendoza"),
    MISIONES("Misiones"),
    NEUQUEN("Neuquen"),
    RIO_NEGRO("Rio Negro"),
    SALTA("Salta"),
    SAN_JUAN("San Juan"),
    SAN_LUIS("San Luis"),
    SANTA_CRUZ("Sanata Cruz"),
    SANTA_FE("Santa Fe"),
    SANTIAGO_DEL_ESTERO("Santiago del Estero"),
    TIERRA_DEL_FUEGO("Tierra del Fuego"),
    TUCUMAN("Tucuman");

    private String nombre;

    private Provincia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
