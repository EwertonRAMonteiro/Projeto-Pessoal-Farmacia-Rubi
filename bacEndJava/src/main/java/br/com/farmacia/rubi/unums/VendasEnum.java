package br.com.farmacia.rubi.unums;

public enum VendasEnum {
    CREDITO("credito"),
    DEBITO("debito"),
    AVISTA("avista");

    private String formaPag;

    private VendasEnum (String formaPag) {
        this.formaPag = formaPag;
    }
}
