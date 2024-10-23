package org.example;

import java.util.List;

public class ProcessarBoletos {
    LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno)
    {
        this.leituraRetorno = leituraRetorno;
    }


    void processar(String nomeArquivo)
    {
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
