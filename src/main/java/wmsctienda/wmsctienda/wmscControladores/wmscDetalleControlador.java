package wmsctienda.wmsctienda.wmscControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wmsctienda.wmsctienda.wmscModelos.wmscDetalleOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscOrden;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;
import wmsctienda.wmsctienda.wmscServicios.wmscDetalleServicio;
import wmsctienda.wmsctienda.wmscServicios.wmscOrdenServicio;
import wmsctienda.wmsctienda.wmscServicios.wmscProductoServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class wmscDetalleControlador {
    @Autowired
    wmscDetalleServicio wmscDetalleService;
    @Autowired
    wmscOrdenServicio wmscOrdenService;
    @Autowired
    wmscProductoServicio wmscProductoService;
    @PostMapping("/wmscAgregarDetalleOrden")
    public ResponseEntity<?> wmscAgregarOrdenDetalle(
            @RequestParam(value = "wmscDetalleOrdenID") int wmscDetalleOrdenID,
            @RequestParam(value = "wmscOrdenID") int wmscOrdenID,
            @RequestParam(value = "wmscProductoID") int wmscProductoID,
            @RequestParam(value = "wmscTotal") double wmscTotal

    ){

        wmscOrden wmscOrde = wmscOrdenService.wmscBuscarPorID(wmscOrdenID);
        wmscProducto wmscProduct = wmscProductoService.wmscBuscarPorID(wmscProductoID);
        //wmscDetalleService.wmscAgregarProducto(wmscProduct);
        List<wmscProducto> wmscProductos = new ArrayList<>();

        if(!Objects.isNull(wmscProduct)){
            if(!Objects.isNull(wmscOrde)){

               if(wmscDetalleService.wmscBuscarDetallePorID(wmscDetalleOrdenID) == null){
                   wmscProductos.add(wmscProduct);
                   wmscDetalleOrden wmscNuevoDetalleOrden = new wmscDetalleOrden(wmscDetalleOrdenID,wmscOrdenID,wmscProductoID,wmscTotal,wmscProductos,wmscOrde);
                   wmscDetalleService.wmscAgregar(wmscNuevoDetalleOrden);
                   return ResponseEntity.ok("orden registrado");
               }else{

                  wmscDetalleOrden wmscDetalleEncontrado= wmscDetalleService.wmscBuscarDetallePorID(wmscDetalleOrdenID);
                   wmscDetalleEncontrado.getWmscProductoList().add(wmscProduct);
                  //wmscDetalleService.wmscAgregarProducto(wmscProduct);
                   return ResponseEntity.ok("actualizado con exito");
               }

            }else {
                return ResponseEntity.ok("No hay ordenes existentes");
            }
        }else {
            return ResponseEntity.ok("No hay  es producto stock");
        }

    }

    @GetMapping("/wmscListarDetallesOrden")
    public ResponseEntity<?> wmscListaDetalleOrdenes(){
        return ResponseEntity.ok(wmscDetalleService.wmscDetalleOrdenList());
    }


}
