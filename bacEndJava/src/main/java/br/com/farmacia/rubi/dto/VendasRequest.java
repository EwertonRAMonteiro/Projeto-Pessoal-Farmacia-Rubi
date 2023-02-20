package br.com.farmacia.rubi.dto;

import br.com.farmacia.rubi.unums.VendasEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendasRequest {
    private VendasEnum formaPag;

    private Float valorTotal;

    private Date dataComp;

    private Byte vendedor;
}
