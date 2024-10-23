package org.example;

public class Main {
    public static void main(String[] args)
    {
        var leituraRetorno = new LeituraRetornoBancoBrasil();
        var processador = new ProcessarBoletos(leituraRetorno);
        processador.processar("banco-brasil-1.csv");

        var leituraRetornoBradesco = new LeituraRetornoBradesco();
        var processadorBradesco = new ProcessarBoletos(leituraRetornoBradesco);

        processadorBradesco.processar("bradesco-1.csv");
    }
}