/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Pqrs;

import EJB_Pqrs.Tipo_PqrsFacadeLocal;
import Entity_Pqrs.Tipo_Pqrs;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author CFL
 */

@ManagedBean
@SessionScoped

public class Controller_tipo_pqrs implements Serializable {
    
    @EJB
    
    private Tipo_PqrsFacadeLocal tipos_pqrs_facade;
    private List <Tipo_Pqrs> lista_tipo_pqrs;
    private Tipo_Pqrs tipo_pqrs;
    private String mensaje;

    public List<Tipo_Pqrs> getLista_tipo_pqrs() {
        this.lista_tipo_pqrs = this.tipos_pqrs_facade.findAll();
        return lista_tipo_pqrs;
    }

    public void setLista_tipo_pqrs(List<Tipo_Pqrs> lista_tipo_pqrs) {
        this.lista_tipo_pqrs = lista_tipo_pqrs;
    }

    public Tipo_Pqrs getTipo_pqrs() {
        return tipo_pqrs;
    }

    public void setTipo_pqrs(Tipo_Pqrs tipo_pqrs) {
        this.tipo_pqrs = tipo_pqrs;
    }
    
    
    @PostConstruct
    
    public void init (){
        
        this.tipo_pqrs = new Tipo_Pqrs();
        
        
                
    }
    
    
    
}
