package br.com.marcos.conversor.converter;

import com.google.gson.annotations.SerializedName;

public class Convertor {
    private double valor;
    private double quantidade;
    private String moedaConvertora;
    private String moedaConvertida;

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Convertor(ConvertorApi conversorApi) {
        this.moedaConvertora = conversorApi.base_code();
        this.valor = Double.valueOf(conversorApi.conversion_rate());
        this.moedaConvertida = conversorApi.target_code();
    }

    @Override
    public String toString() {
        return "Convertor{" +
                "valor=" + valor +
                ", quantidade=" + quantidade* valor +
                ", moedaConvertora='" + moedaConvertora + '\'' +
                ", moedaConvertida='" + moedaConvertida + '\'' +
                '}';
    }
}
