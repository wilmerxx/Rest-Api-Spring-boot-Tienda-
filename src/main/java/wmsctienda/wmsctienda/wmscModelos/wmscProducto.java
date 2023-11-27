package wmsctienda.wmsctienda.wmscModelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class wmscProducto {
    private int wmscProductoID;
    private int wmscDepartamentoID;
    private String wmscNombre;
    private double wmscPrecio;

}
