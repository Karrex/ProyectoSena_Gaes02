/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;

import EJB_Inventario.CartaFacadeLocal;
import Entity_Inventario.Carta;
import Entity_Inventario.EstadoProducto;
import Entity_Inventario.Productos;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;


/**
 *
 * @author CFL
 */
@ManagedBean
@SessionScoped
public class ControllerCarta implements Serializable {

    @EJB
    private CartaFacadeLocal cartaFacade;
    private List<Carta> listaCarta;
    private Carta carta;
    private EstadoProducto estadoProducto;
    private Productos productos;
    private List<Carta> listaimagenes;
    private UploadedFile file;
    private String msj;

    public List<Carta> getListaCarta() {
        this.listaCarta = this.cartaFacade.findAll();
        return listaCarta;
    }

    public void setListaCarta(List<Carta> listaCarta) {
        this.listaCarta = listaCarta;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public List<Carta> getListaimagenes() {

        return listaimagenes;
    }

    public void setListaimagenes(List<Carta> listaimagenes) {
        this.listaimagenes = listaimagenes;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    @PostConstruct
    public void init() {
        this.carta = new Carta();
        this.estadoProducto = new EstadoProducto();
        this.productos = new Productos();
        listaimagenes = cartaFacade.findAll();

    }

    public void guardar() {
        try {
            this.carta.setIdproductosid(productos);
            this.carta.setIDEstadoProductos(estadoProducto);
            this.cartaFacade.edit(carta);

            this.msj = "Registro Guardado correctamente";
            this.carta = new Carta();
            this.productos = new Productos();
            this.estadoProducto = new EstadoProducto();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.carta.setIdproductosid(productos);
            this.carta.setIDEstadoProductos(estadoProducto);
            this.cartaFacade.edit(carta);
            this.carta.setNombrefoto(msj);

            this.msj = "Registro Actualizado correctamente";
            this.carta = new Carta();
            this.productos = new Productos();
            this.estadoProducto = new EstadoProducto();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Carta eli) {

        try {
            this.cartaFacade.remove(eli);
            this.msj = "Se elimino correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void subirImagen() {
        String rutacarpeta = "C:\\Users\\PC\\Documents\\NetBeansProjects\\UshuaiaAdvanced\\UshuaiaVerdadero\\src\\main\\webapp\\resources\\imagenes";
        try {
            if (file.getSize() > 0) {
                carta.setIdproductosid(productos);
                carta.setIDEstadoProductos(estadoProducto);
                carta.setNombrefoto(file.getFileName());
                carta.setImagen(file.getContent());
                cartaFacade.create(carta);
                escribirBytes(IOUtils.toByteArray(file.getInputStream()), rutacarpeta, file.getFileName());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se creo la imagen correctamente"));
            }
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    e.getMessage(), "error al crear la imagen"));

        }
    }

    private void escribirBytes(byte[] bytes, String carpeta, String NombreFoto) {
        try {
            Path path = Paths.get(carpeta, NombreFoto);
            Files.write(path, bytes);

        } catch (IOException ex) {
            System.out.println("error al escribir los bytes" + ex.getMessage());
        }
    }

    public void cargarDatos(Carta ca) {
        this.productos.setIDProducto(ca.getIdproductosid().getIDProducto());
        this.estadoProducto.setIDEstadoproducto(ca.getIDEstadoProductos().getIDEstadoproducto());
        this.carta = ca;
    }

    public void limpiar() {
        this.carta = new Carta();
        this.productos = new Productos();
        this.estadoProducto = new EstadoProducto();

    }

}
