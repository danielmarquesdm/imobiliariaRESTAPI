package edu.ifma.lpweb.rest.imobiliaria.controller.response;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import edu.ifma.lpweb.rest.imobiliaria.model.Locacao;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LocacaoResponse {
    private Long id;
    private Imovel imovel;
    private Cliente cliente;
    private BigDecimal valorDoAluguel;
    private BigDecimal percentualDeMulta;
    private LocalDate dataDeInicio;
    private LocalDate dataFinal;
    private String diaDoVencimento;
    private boolean ativo;
    private String observacoes;

    public static LocacaoResponse toResponse(Locacao locacao) {
        return new LocacaoResponse(
                locacao.getId(),
                locacao.getImovel(),
                locacao.getCliente(),
                locacao.getValorDoAluguel(),
                locacao.getPercentualDeMulta(),
                locacao.getDataDeInicio(),
                locacao.getDataFinal(),
                locacao.getDiaDoVencimento(),
                locacao.isAtivo(),
                locacao.getObservacoes()
        );
    }
}
