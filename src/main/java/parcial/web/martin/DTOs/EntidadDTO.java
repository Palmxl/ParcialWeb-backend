package parcial.web.martin.DTOs;

import java.util.List;

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
