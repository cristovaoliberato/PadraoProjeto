package org.example;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno{
    @Override
    public List<Boleto> lerArquivo(final String nomeArquivo) {
        try {
            List<String> linhas = Files.readAllLines(Path.of(nomeArquivo));
            var boletos = new ArrayList<Boleto>(linhas.size());
            for (String linha : linhas) {
                String[] vetor = linha.split(";");
                boletos.add(parseBoleto(vetor));
            }
            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    private Boleto parseBoleto(String[] info)
    {
        var boleto = new Boleto();
        boleto.setId(Integer.parseInt(info[0]));
        boleto.setCodBanco(info[1]);
        boleto.setDataVencimento(LocalDate.parse(info[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(info[3], FORMATO_DATA).atStartOfDay());
        boleto.setCpfCliente(info[4]);
        boleto.setValor(Double.parseDouble(info[5]));
        boleto.setJuros(Double.parseDouble(info[6]));
        boleto.setMulta(Double.parseDouble(info[7]));
        return boleto;
    }
}
