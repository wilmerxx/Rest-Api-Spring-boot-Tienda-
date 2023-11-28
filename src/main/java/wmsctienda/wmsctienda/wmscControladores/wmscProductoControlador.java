package wmsctienda.wmsctienda.wmscControladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wmsctienda.wmsctienda.wmscModelos.wmscProducto;
import wmsctienda.wmsctienda.wmscServicios.wmscOrdenServicio;
import wmsctienda.wmsctienda.wmscServicios.wmscProductoServicio;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
public class wmscProductoControlador{
    @Autowired
    wmscProductoServicio wmscProductoServi;
    @GetMapping("/wmscListaProductos")
    public ResponseEntity<?> wmscListaProductos() {
        try {
            List<wmscProducto> wmscProductoList = wmscProductoServi.wmscProductoList();

            if (!wmscProductoList.isEmpty()) {
                return ResponseEntity.ok(wmscProductoList);
            } else {
                return ResponseEntity.ok(Collections.emptyList()); // Devuelve una lista vacía si no hay datos
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
    @PostMapping("/wmscAgregarProducto")
    public ResponseEntity<?> wmscAgregar(
            @RequestParam(value = "wmscProductoID") int wmscProductoID,
            @RequestParam(value = "wmscDepartamentoID") int wmscDepartamentoID,
            @RequestParam(value = "wmscNombre") String wmscNombre,
            @RequestParam(value = "wmscPrecio") double wmscPrecio) {
            if(Objects.isNull(wmscProductoServi.wmscBuscarPorID(wmscProductoID))){
                wmscProducto wmscProduct = new wmscProducto(
                        wmscProductoID,
                        wmscDepartamentoID,
                        wmscNombre,
                        wmscPrecio
                );
                wmscProductoServi.wmscAgregar(wmscProduct);
                return ResponseEntity.ok(wmscProduct);
            }else {
                return ResponseEntity.ok("Ya existe ese producto");
            }

    }
    @GetMapping("/wmscBuscarProducto/{wmscid}")
    public ResponseEntity<?> wmscBuscarPorID(@PathVariable(value = "wmscid") int wmscID) {
       wmscProducto wmscProduct = wmscProductoServi.wmscBuscarPorID(wmscID);
       if(!Objects.isNull(wmscProduct)){
           return ResponseEntity.ok(wmscProduct);
       }else {
           return ResponseEntity.ok("No existe ese producto");
       }

    }
    @DeleteMapping("/wmscEliminarProducto/{wmscid}")
    public ResponseEntity<?> wmscEliminarPorID(@PathVariable(value = "wmscid") int wmscID) {
        wmscProducto wmscProduct = wmscProductoServi.wmscBuscarPorID(wmscID);
        if(!Objects.isNull(wmscProduct)){
            wmscProductoServi.wmscEliminarPorID(wmscID);
            return ResponseEntity.ok("Producto eliminado");
        }else {
            return ResponseEntity.ok("No existe ese producto");
        }
    }
    @PutMapping("/wmscActualizarProducto/{wmscid}")
    public ResponseEntity<?> wmscActualizarPorId(
            @PathVariable(value = "wmscid") int wmscid,
            @RequestParam(value = "wmscDepartamentoID") int wmscDepartamentoID,
            @RequestParam(value = "wmscNombre") String wmscNombre,
            @RequestParam(value = "wmscPrecio") double wmscPrecio
            ) {
        if(!Objects.isNull(wmscProductoServi.wmscBuscarPorID(wmscid))){
            wmscProducto wmscProduct = new wmscProducto(wmscDepartamentoID,wmscDepartamentoID,wmscNombre,wmscPrecio);
            wmscProductoServi.wmscActualizarPorId(wmscProduct);
            return ResponseEntity.ok( wmscProduct);
        }else {
            return ResponseEntity.ok("No existe el producto");
        }
    }
}

