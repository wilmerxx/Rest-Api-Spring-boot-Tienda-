package wmsctienda.wmsctienda.wmscControladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wmsctienda.wmsctienda.wmscModelos.wmscCliente;
import wmsctienda.wmsctienda.wmscServicios.wmscClienteServicio;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
@RestController
public class wmscClienteControlador {
    @Autowired
    private wmscClienteServicio wmscClienteService;
    @GetMapping("/wmscClientes")
    public ResponseEntity<?> wmscClienteListes(){
        List<wmscCliente> wmscClienteList = wmscClienteService.wmscClienteListes();
        if(!wmscClienteList.isEmpty()){
            return ResponseEntity.ok(wmscClienteList);
        }else {
            return  ResponseEntity.ok(Collections.emptyList()); //devuelve la lista de los clientes
        }
    }
    @GetMapping("/wmscBuscarClientePorID/{wmscid}")
    public ResponseEntity<?> wmscBuscarPorID(@PathVariable(value = "wmscid") int wmscID) {
        wmscCliente wmscClient = wmscClienteService.wmscBuscarPorID(wmscID);
        if(!Objects.isNull(wmscClient)){
            return ResponseEntity.ok(wmscClient);
        }
        return ResponseEntity.ok("No existe el cliente");
    }
    @PostMapping("/wmscAgregarCliente")
    public ResponseEntity<?> wmscAgregar(
            @RequestParam(value = "wmscClienteID") int wmscClienteID,
            @RequestParam(value = "wmscNombresCompletos") String wmscNombresCompletos
    ) {
        if (Objects.isNull(wmscClienteService.wmscBuscarPorID(wmscClienteID))){
            wmscCliente wmscClient = new wmscCliente(wmscClienteID,wmscNombresCompletos);
            wmscClienteService.wmscAgregar(wmscClient);
            return  ResponseEntity.ok(wmscClient);
        }else {
            return ResponseEntity.ok("Ya existe el cliente");
        }
    }
    @DeleteMapping("/wmscEliminarCliente/{wmscid}")
    public ResponseEntity<?> wmscEliminarPorID(@PathVariable(value = "wmscid") int wmscID) {
        if(!Objects.isNull(wmscClienteService.wmscBuscarPorID(wmscID))){
            wmscClienteService.wmscEliminarPorID(wmscID);
            return ResponseEntity.ok("Cliente eliminado");
        }else{
            return ResponseEntity.ok("No existe cliente");
        }
    }
    @PutMapping("/wmscActualizarCliente/{wmscid}")
    public ResponseEntity<?> wmscActualizarPorId(
            @PathVariable(value = "wmscid") int wmscClienteID,
            @RequestParam(value = "wmscNombresCompletos") String wmscNombresCompletos
    ) {
        if(!Objects.isNull(wmscClienteService.wmscBuscarPorID(wmscClienteID))){
            wmscCliente wmscClient = new wmscCliente(wmscClienteID,wmscNombresCompletos);
            wmscClienteService.wmscActualizarPorId(wmscClient);
            return ResponseEntity.ok(wmscClient);
        }else{
            return ResponseEntity.ok("No  existe producto");
        }
    }
}
