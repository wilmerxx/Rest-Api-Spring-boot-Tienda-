package wmsctienda.wmsctienda.wmscControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wmsctienda.wmsctienda.wmscModelos.wmscAlmacen;
import wmsctienda.wmsctienda.wmscModelos.wmscCliente;
import wmsctienda.wmsctienda.wmscModelos.wmscOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;
import wmsctienda.wmsctienda.wmscServicios.wmscAlmacenServicio;
import wmsctienda.wmsctienda.wmscServicios.wmscClienteServicio;
import wmsctienda.wmsctienda.wmscServicios.wmscOrdenServicio;
import wmsctienda.wmsctienda.wmscServicios.wmscProductoServicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
public class wmscOrdenControlador {
    @Autowired
    wmscOrdenServicio wmscOrdenService;
    @Autowired
    wmscProductoServicio wmscProductoService;
    @Autowired
    wmscAlmacenServicio wmscAlmacenService;
    @Autowired
    wmscClienteServicio wmscClienteService;

    @PostMapping("/wmscAgregarOrden")
    public ResponseEntity<?> wmscAgregarOrden(
            @RequestParam(value = "wmscOrderID") int wmscOrderID,
            @RequestParam(value = "wmscProductoID") int wmscProductoID,
            @RequestParam(value = "wmscClienteID") int wmscClienteID,
            @RequestParam(value = "wmscAlmacenID") int wmscAlmacenID,
            @RequestParam(value = "wsmcCantidadVentas") int wsmcCantidadVentas,
            @RequestParam(value = "wmscFechaIngreso") String wmscFechaIngreso,
            @RequestParam(value = "wmscTiempo") String wmscTiempo
    ){
        wmscProducto wmscProduct = wmscProductoService.wmscBuscarPorID(wmscProductoID);
        wmscAlmacen wmscAlmaceBuscado = wmscAlmacenService.wmscBuscarAlmacen(wmscAlmacenID);
        wmscCliente wmscClienteBuscado = wmscClienteService.wmscBuscarPorID(wmscClienteID);
        List<wmscProducto> wmscProductoList = new ArrayList<>();

        if(!Objects.isNull(wmscProduct)){
            wmscOrden wmscOrdenParaActualizar = wmscOrdenService.wmscBuscarPorID(wmscOrderID);
            if(wmscOrdenService.wmscBuscarPorID(wmscOrderID)==null){
                if(!Objects.isNull(wmscAlmaceBuscado)){
                    if (!Objects.isNull(wmscClienteBuscado)){
                        wmscProductoList.add(wmscProduct);
                        wmscOrden wmscOrde = new wmscOrden(
                                wmscOrderID,
                                wmscClienteID,
                                wmscAlmacenID,
                                wsmcCantidadVentas,
                                wmscFechaIngreso,
                                wmscTiempo,
                                wmscProductoList,
                                wmscClienteBuscado,
                                wmscAlmaceBuscado
                        );
                        wmscOrdenService.wmscAgregar(wmscOrde);
                        return ResponseEntity.ok("Agregado con exito la orden");
                    }else {
                        return ResponseEntity.ok("Cliente no existe");
                    }

                }else{
                    return ResponseEntity.ok("Almacen no existe");
                }


            }else {
                wmscOrdenParaActualizar.getWmscProductosList().add(wmscProduct);
                return ResponseEntity.ok("Producto nuevo agregado");
            }

        }else{
            return ResponseEntity.ok("No existe producto");
        }


    }

    @PostMapping("/wmscAgregarProductoOrden")
    public ResponseEntity<?> wmscAgregarProductoOreden(
            @RequestParam(value = "wmscOrdenID") int wmscOrdenID,
            @RequestParam(value = "wmscProductoID") int wmscProductoID
    ){
        wmscOrden wmscOrde =  wmscOrdenService.wmscBuscarPorID(wmscOrdenID);
        wmscProducto wmscProduct = wmscProductoService.wmscBuscarPorID(wmscProductoID);
        if(!Objects.isNull(wmscOrde)){
            if(!Objects.isNull(wmscProduct)){
               // wmscOrdenService.wmscAgregarProductosOrden(wmscOrde,wmscProduct);

                return ResponseEntity.ok("Productos agregado");
            }else {
                return ResponseEntity.ok("Producto no existe");
            }

        }else {
            return ResponseEntity.ok("Orden no existe");
        }
    }


    @GetMapping("/wmscListaOrdenes")
    public ResponseEntity<?> wmscListaOrdenes(){

        List<wmscOrden> wmscOrdenList = wmscOrdenService.wmscOrdenLista();
        if (!wmscOrdenList.isEmpty()) {
            return ResponseEntity.ok(wmscOrdenList);
        } else {
            return ResponseEntity.ok(Collections.emptyList()); // Devuelve una lista vacía si no hay datos
        }
    }
}
