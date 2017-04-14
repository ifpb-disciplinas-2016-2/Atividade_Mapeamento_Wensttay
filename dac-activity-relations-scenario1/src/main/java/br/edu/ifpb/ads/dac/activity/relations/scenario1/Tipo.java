package br.edu.ifpb.ads.dac.activity.relations.scenario1;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 09:22:13
 */
public enum Tipo {
    POUPANCA(0.56, 0.0),
    CORRENTE(0.0, 0.75);

    private Double taxaDeCredito;
    private Double taxaDeDebito;

    private Tipo(Double taxaDeCredito, Double taxaDeDebito) {
        this.taxaDeCredito = taxaDeCredito;
        this.taxaDeDebito = taxaDeDebito;
    }

    public Double getTaxaDeCredito() {
        return taxaDeCredito;
    }

    public Double getTaxaDeDebito() {
        return taxaDeDebito;
    }
}
