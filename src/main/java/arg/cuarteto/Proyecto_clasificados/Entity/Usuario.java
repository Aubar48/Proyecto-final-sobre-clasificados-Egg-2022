package arg.cuarteto.Proyecto_clasificados.Entity;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Roles;
import java.util.Date;
import javax.persistence.Column;
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
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    @Column(unique = true)
    private String email;
    private String clave;
    @OneToOne
    private Photo foto;

    public Photo getFoto() {
        return foto;
    }

    public void setFoto(Photo foto) {
        this.foto = foto;
    }
    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date baja;
    
    @Enumerated(EnumType.STRING)
    private Roles roles;
 
    @OneToOne
    private Publicacion publicacion;

    @OneToOne
    private FormUsuario formUsuario;
    
    public Usuario() {
    }

    public Usuario(String nombre, String email, String clave, Date alta, Date baja, Roles roles) {
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.alta = alta;
        this.baja = baja;
        this.roles = roles;
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Date getBaja() {
        return baja;
    }

    public void setBaja(Date baja) {
        this.baja = baja;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", clave=" + clave + ", alta=" + alta + ", baja=" + baja + ", roles=" + roles + ", publicacion=" + publicacion + '}';
    }

    public FormUsuario getFormUsuario() {
        return formUsuario;
    }

    public void setFormUsuario(FormUsuario formUsuario) {
        this.formUsuario = formUsuario;
    }

  
    
    
}
