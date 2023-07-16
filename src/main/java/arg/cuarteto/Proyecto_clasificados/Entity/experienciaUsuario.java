/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Nnahu
 */
@Entity
public class experienciaUsuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String tituloExperiencia;
    private String fechaEmpresa;
    private String nombreEmpresa;
    private String puestoEmpresa;
    private String descripcionPuesto;
    
  

    public experienciaUsuario() {
    }

    public experienciaUsuario(String tituloExperiencia, String fechaEmpresa, String nombreEmpresa, String puestoEmpresa, String descripcionPuesto) {
        this.tituloExperiencia = tituloExperiencia;
        this.fechaEmpresa = fechaEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.puestoEmpresa = puestoEmpresa;
        this.descripcionPuesto = descripcionPuesto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTituloExperiencia() {
        return tituloExperiencia;
    }

    public void setTituloExperiencia(String tituloExperiencia) {
        this.tituloExperiencia = tituloExperiencia;
    }

    public String getFechaEmpresa() {
        return fechaEmpresa;
    }

    public void setFechaEmpresa(String fechaEmpresa) {
        this.fechaEmpresa = fechaEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPuestoEmpresa() {
        return puestoEmpresa;
    }

    public void setPuestoEmpresa(String puestoEmpresa) {
        this.puestoEmpresa = puestoEmpresa;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    
    
    
    
}
