package parcial.web.martin.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import parcial.web.martin.entities.Contrato;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntidadDTO {

    private Long id;
    private String nit;
    private String nombre;
    private List<Contrato> contratos;
}
