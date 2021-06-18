package Util;

import java.time.LocalDate;


public class Validacoes {

    private static final int NUMERO_MAXIMO_DE_HORAS_NO_DIA = 24;
    private static final int NUMERO_MINIMO_DE_HORAS_NO_DIA = 0;
    private static final int NUMERO_MAXIMO_DE_MINUTOS_NO_DIA = 60;
    private static final int NUMERO_MINIMO_DE_MINUTOS_NO_DIA = 0;

    private Validacoes() {
    }

    public static boolean validarCpf(String cpf) {
        var validadorDeCpf = new int[11];
        var primeiroDigitoVerificador = 0;
        var segundoDigitoVerificador = 0;
        var variavelDeControle = 0;

        if (cpf.length() != 11) {
            return false;
        }

        for (var i = 0; i < 10; i++) {
            if (cpf.equals(i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i)) {
                return false;
            }
        }

        for (var i = 0; i < cpf.length(); i++) {
            validadorDeCpf[i] = (cpf.charAt(i) - '0');
        }

        for (var i = 10; i >= 2; i--) {
            primeiroDigitoVerificador += validadorDeCpf[variavelDeControle] * i;
            variavelDeControle++;
        }

        primeiroDigitoVerificador = (primeiroDigitoVerificador * 10) % 11;

        if (primeiroDigitoVerificador == 10) {
            primeiroDigitoVerificador = 0;
        }

        if (primeiroDigitoVerificador != validadorDeCpf[9]) {
            return false;
        } else {
            variavelDeControle = 0;

            for (var i = 11; i >= 2; i--) {
                segundoDigitoVerificador += validadorDeCpf[variavelDeControle] * i;
                variavelDeControle++;
            }

            segundoDigitoVerificador = (segundoDigitoVerificador * 10) % 11;

            if (segundoDigitoVerificador == 10) {
                segundoDigitoVerificador = 0;
            }

            return segundoDigitoVerificador == validadorDeCpf[10];
        }
    }

    public static boolean validarDtNascimento(LocalDate dtNascimento) {

        if (validarData(dtNascimento)) {

            int[] dataFormatada = reformatarData(dtNascimento);

            var hoje = LocalDate.now();
            int[] dataAtualFormatada = reformatarData(hoje);

            return (dataFormatada[0] <= dataAtualFormatada[0]) && (dataFormatada[0] != dataAtualFormatada[0] || dataFormatada[1] <= dataAtualFormatada[1])
                    && (dataFormatada[0] != dataAtualFormatada[0] || dataFormatada[1] != dataAtualFormatada[1] || dataFormatada[2] <= dataAtualFormatada[2]);
        }

        return false;

    }

    

    public static boolean validarHorario(String horario) {

        if (horario.length() != 5) {
            return false;
        }

        var horarioInformado = horario.split(":");
        var horasInformadas = Integer.parseInt(horarioInformado[0]);
        var minutosInformados = Integer.parseInt(horarioInformado[1]);

        return ((horasInformadas <= NUMERO_MAXIMO_DE_HORAS_NO_DIA && horasInformadas >= NUMERO_MINIMO_DE_HORAS_NO_DIA)
                && (minutosInformados <= NUMERO_MAXIMO_DE_MINUTOS_NO_DIA && minutosInformados >= NUMERO_MINIMO_DE_MINUTOS_NO_DIA));

    }

    public static boolean validarData(LocalDate data) {

        int[] dataFormatada = reformatarData(data);
        var localDate = LocalDate.of(dataFormatada[2], 1, 1);

        var diasDeFevereiro = 28;
        if (localDate.isLeapYear()) {
            diasDeFevereiro = 29;
        }

        return (((dataFormatada[1] == 1 || dataFormatada[1] == 3 || dataFormatada[1] == 5 || dataFormatada[1] == 7
                || dataFormatada[1] == 8 || dataFormatada[1] == 10 || dataFormatada[1] == 12) && (dataFormatada[2] <= 31))
                || ((dataFormatada[1] == 4 || dataFormatada[1] == 6 || dataFormatada[1] == 9 || dataFormatada[1] == 11) && (dataFormatada[2] <= 30))
                || ((dataFormatada[1] == 2) && (dataFormatada[2] <= diasDeFevereiro)));

    }

    public static int[] reformatarData(LocalDate data) {

        var dataASerValidada = data.toString();

        var dataInformada = dataASerValidada.split("-");
        var diaInformado = Integer.parseInt(dataInformada[2]);
        var mesInformado = Integer.parseInt(dataInformada[1]);
        var anoInformado = Integer.parseInt(dataInformada[0]);

        int[] dataFormatada = {anoInformado, mesInformado, diaInformado};
        return dataFormatada;
    }

}
