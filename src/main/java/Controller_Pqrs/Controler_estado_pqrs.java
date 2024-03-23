/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Pqrs;

import EJB_Pqrs.Estado_PqrsFacadeLocal;
import Entity_Pqrs.Estado_Pqrs;
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

public class Controler_estado_pqrs implements Serializable{

@EJB

private Estado_PqrsFacadeLocal estado_facade;
private List <Estado_Pqrs> lista_estado;
private Estado_Pqrs estado_pqrs; 
private String mensaje;

    public List<Estado_Pqrs> getLista_estado() {
        this.lista_estado = this.estado_facade.findAll();
        return lista_estado;
    }

    public void setLista_estado(List<Estado_Pqrs> lista_estado) {
        this.lista_estado = lista_estado;
    }

    public Estado_Pqrs getEstado_pqrs() {
        return estado_pqrs;
    }

    public void setEstado_pqrs(Estado_Pqrs estado_pqrs) {
        this.estado_pqrs = estado_pqrs;
    }

@PostConstruct 
public void init(){
    this.estado_pqrs = new Estado_Pqrs();
    
}





}


