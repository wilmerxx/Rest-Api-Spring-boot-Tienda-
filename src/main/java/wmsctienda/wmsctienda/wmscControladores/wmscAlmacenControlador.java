package wmsctienda.wmsctienda.wmscControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wmsctienda.wmsctienda.wmscModelos.wmscAlmacen;
import wmsctienda.wmsctienda.wmscServicios.wmscAlmacenServicio;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
public class wmscAlmacenControlador {
    @Autowired
    private wmscAlmacenServicio wmscAlmacenService;

    @GetMapping("/wmscAlmanes")
    public ResponseEntity<?> wmscAlmacenListas(){
        List<wmscAlmacen> wmscAlmacenList = wmscAlmacenService.wmscAlmacenListas();
        if(!wmscAlmacenList.isEmpty()){
            return ResponseEntity.ok(wmscAlmacenList);
        }else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
    @GetMapping("/wmscAlmanePorID/{wmscid}")
    public ResponseEntity<?> wmscBuscarPorID(@PathVariable(value = "wmscid") int wmscid){
        wmscAlmacen wmscAlmace = wmscAlmacenService.wmscBuscarAlmacen(wmscid);
        if(!Objects.isNull(wmscAlmace)){
            return ResponseEntity.ok(wmscAlmace);
        }else {
            return ResponseEntity.ok("No existe el almacen");
        }
    }
    @PostMapping("/wmscAgregarAlmacen")
    public ResponseEntity<?> wmscAgregar(
            @RequestParam(value = "wmscAlmacenID") int  wmscAlmacenID,
            @RequestParam(value = "wmscNombreAlmacen") String  wmscNombreAlmacen
    ){
        if( Objects.isNull(wmscAlmacenService.wmscBuscarAlmacen(wmscAlmacenID))){
            wmscAlmacen wmscAlmace = new wmscAlmacen(wmscAlmacenID,wmscNombreAlmacen);
            wmscAlmacenService.wmscAgregar(wmscAlmace);
            return ResponseEntity.ok(wmscAlmace);
        }else{
            return ResponseEntity.ok("Ya existe este cliente");
        }
    }
    @DeleteMapping("/wmscEliminarPorID/{wmscid}")
    public ResponseEntity<?> wmscEliminarPorID(@PathVariable(value = "wmscid") int wmscid){
        if(!Objects.isNull(wmscAlmacenService.wmscBuscarAlmacen(wmscid))){
            wmscAlmacenService.wmscEliminarPorID(wmscid);
            return ResponseEntity.ok("Almacen eliminado");
        }else{
            return ResponseEntity.ok("No existe almacen");
        }
    }
    @PutMapping("/wmscActualizarAlmacen/{wmscid}")
    public ResponseEntity<?> wmscActualizarPorId(
            @PathVariable(value = "wmscid") int wmscAlmacenID,
            @RequestParam(value = "wmscNombreAlmacen") String  wmscNombreAlmacen
    ){
        if(!Objects.isNull(wmscAlmacenService.wmscBuscarAlmacen(wmscAlmacenID))){
            wmscAlmacen wmscAlmace = new wmscAlmacen(wmscAlmacenID,wmscNombreAlmacen);
            wmscAlmacenService.wmscActualizarPorId(wmscAlmace);
            return ResponseEntity.ok(wmscAlmace);
        }else {
            return ResponseEntity.ok("No existe almacen");
        }
    }
}
