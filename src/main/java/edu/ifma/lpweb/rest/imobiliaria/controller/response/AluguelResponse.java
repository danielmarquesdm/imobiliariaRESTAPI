package edu.ifma.lpweb.rest.imobiliaria.controller.response;

import edu.ifma.lpweb.rest.imobiliaria.model.Aluguel;
import edu.ifma.lpweb.rest.imobiliaria.model.Locacao;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AluguelResponse {
    private Long id;
    private Locacao locacao;
    private LocalDate dataDeVencimento;
    private BigDecimal valorPago;
    private String observacoes;

    public static AluguelResponse toResponse(Aluguel aluguel) {
        return new AluguelResponse(
                aluguel.getId(),
                aluguel.getLocacao(),
                aluguel.getDataDeVencimento(),
                aluguel.getValorPago(),
                aluguel.getObservacoes()
        );
    }

}
