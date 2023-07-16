package arg.cuarteto.Proyecto_clasificados.Entity;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Enumerated(EnumType.ORDINAL)
    private Oficio oficio;
    private String titulo;
    private int precio;
    private String descripcion;
    private Boolean activo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltabaja;
    @OneToOne
    private Photo photo;
    @OneToOne
    private Usuario usuario;
    @Enumerated(EnumType.ORDINAL)
    private Provincia provincia;

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Oficio getOficio() {
        return oficio;
    }

    public void setOficio(Oficio oficio) {
        this.oficio = oficio;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaAltabaja() {
        return fechaAltabaja;
    }

    public void setFechaAltabaja(Date fechaAltabaja) {
        this.fechaAltabaja = fechaAltabaja;
    }

}
