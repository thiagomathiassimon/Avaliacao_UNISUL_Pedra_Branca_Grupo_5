package Util;

import java.time.LocalDate;

public class Validacoes {

    private static final int NUMERO_MAXIMO_DE_HORAS_NO_DIA = 24;
    private static final int NUMERO_MINIMO_DE_HORAS_NO_DIA = 0;
    private static final int NUMERO_MAXIMO_DE_MINUTOS_NO_DIA = 60;
    private static final int NUMERO_MINIMO_DE_MINUTOS_NO_DIA = 0;
    private static final String[] LETRAS_DO_ALFABETO = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" , " "};

    private Validacoes() {
    }

    public static boolean validarCpf(String cpf) {
        int[] validadorDeCpf = new int[11];
        int primeiroDigitoVerificador = 0;
        int segundoDigitoVerificador = 0;
        int variavelDeControle = 0;

        if (cpf.length() != 11) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
            if (cpf.equals(i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i)) {
                return false;
            }
        }

        for (int i = 0; i < cpf.length(); i++) {
            validadorDeCpf[i] = (cpf.charAt(i) - '0');
        }

        for (int i = 10; i >= 2; i--) {
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

            for (int i = 11; i >= 2; i--) {
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

            LocalDate hoje = LocalDate.now();
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

        String[] horarioInformado = horario.split(":");
        int horasInformadas = Integer.parseInt(horarioInformado[0]);
        int minutosInformados = Integer.parseInt(horarioInformado[1]);

        return ((horasInformadas <= NUMERO_MAXIMO_DE_HORAS_NO_DIA && horasInformadas >= NUMERO_MINIMO_DE_HORAS_NO_DIA)
                && (minutosInformados <= NUMERO_MAXIMO_DE_MINUTOS_NO_DIA && minutosInformados >= NUMERO_MINIMO_DE_MINUTOS_NO_DIA));

    }

    public static boolean validarData(LocalDate data) {

        int[] dataFormatada = reformatarData(data);
        LocalDate localDate = LocalDate.of(dataFormatada[2], 1, 1);

        int diasDeFevereiro = 28;
        if (localDate.isLeapYear()) {
            diasDeFevereiro = 29;
        }

        return (((dataFormatada[1] == 1 || dataFormatada[1] == 3 || dataFormatada[1] == 5 || dataFormatada[1] == 7
                || dataFormatada[1] == 8 || dataFormatada[1] == 10 || dataFormatada[1] == 12) && (dataFormatada[2] <= 31))
                || ((dataFormatada[1] == 4 || dataFormatada[1] == 6 || dataFormatada[1] == 9 || dataFormatada[1] == 11) && (dataFormatada[2] <= 30))
                || ((dataFormatada[1] == 2) && (dataFormatada[2] <= diasDeFevereiro)));

    }

    public static int[] reformatarData(LocalDate data) {

        String dataASerValidada = data.toString();

        String[] dataInformada = dataASerValidada.split("-");
        int diaInformado = Integer.parseInt(dataInformada[2]);
        int mesInformado = Integer.parseInt(dataInformada[1]);
        int anoInformado = Integer.parseInt(dataInformada[0]);

        int[] dataFormatada = {anoInformado, mesInformado, diaInformado};
        return dataFormatada;
    }

    public static boolean validarNome(String nome) {

        boolean encontrouLetra = false;
        int contadorDeEspacosSeguidos = 0;

        if (nome.length() < 2) {
            return false;
        }

        for (int i = 0; i < nome.length(); i++) {
            for (int j = 0; j < LETRAS_DO_ALFABETO.length; j++) {

                if (contadorDeEspacosSeguidos > 1) {
                    System.out.print(contadorDeEspacosSeguidos);
                   return false;
                }
                if (nome.substring(i).isBlank()) {
                    contadorDeEspacosSeguidos += 1;
                }
                if (nome.substring(i, i + 1).equalsIgnoreCase(LETRAS_DO_ALFABETO[j])) {

                    encontrouLetra = true;
                
                    
                }
            }

            if (!encontrouLetra) {
                return false;
            }
            contadorDeEspacosSeguidos = 0;
            encontrouLetra = false;
        }

        return true;

    }

}
