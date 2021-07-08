package Util;

import java.time.LocalDate;

public class Validacoes {

    private static final Integer NUMERO_MAXIMO_DE_HORAS_NO_DIA = 24;
    private static final Integer NUMERO_MINIMO_DE_HORAS_NO_DIA = 0;
    private static final Integer NUMERO_MAXIMO_DE_MINUTOS_NO_DIA = 60;
    private static final Integer NUMERO_MINIMO_DE_MINUTOS_NO_DIA = 0;
    private static final Integer NUMERO_DE_CARACTERES_DO_HORARIO_FORMATADO_PELA_MASCARA = 5;
    private static final String[] CARACTERES_INVALIDOS = {".", ",", "?", "!", "@", "#", "$", "%", "¨", "&", "*", "(", ")",
        "+", "=", "_", "~", "^", "]", "[", "{", "}", "º", "ª", "°", ";", ":", "<", ">", "/", "|", "´", "`"};
    private static final Integer JANEIRO = 1;
    private static final Integer FEVEREIRO = 2;
    private static final Integer MARCO = 3;
    private static final Integer ABRIL = 4;
    private static final Integer MAIO = 5;
    private static final Integer JUNHO = 6;
    private static final Integer JULHO = 7;
    private static final Integer AGOSTO = 8;
    private static final Integer SETEMBRO = 9;
    private static final Integer OUTUBRO = 10;
    private static final Integer NOVERMBRO = 11;
    private static final Integer DEZEMBRO = 12;

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
            int diaInformado = dataFormatada[2];
            int mesInformado = dataFormatada[1];
            int anoInformado = dataFormatada[0];

            LocalDate dataAtual = LocalDate.now();
            int anoAtual = dataAtual.getYear();
            int mesAtual = dataAtual.getMonthValue();
            int diaAtual = dataAtual.getDayOfMonth();

            return (anoInformado <= anoAtual) && (anoInformado != anoAtual || mesInformado <= mesAtual)
                    && (anoInformado != anoAtual || mesInformado != mesAtual || diaInformado <= diaAtual);
        }

        return false;

    }

    public static boolean validarHorario(String horario, String periodoDeAtendimentoDoMedico) {

        if (horario.length() != NUMERO_DE_CARACTERES_DO_HORARIO_FORMATADO_PELA_MASCARA) {
            return false;
        }

        String[] horarioInformado = horario.split(":");
        int horasInformadas = Integer.parseInt(horarioInformado[0]);
        int minutosInformados = Integer.parseInt(horarioInformado[1]);

        Integer horarioInicialDeAtendimento = 0;
        Integer horarioFinalDeAtendimento = 0;

        if (periodoDeAtendimentoDoMedico.equalsIgnoreCase("MATUTINO")) {
            horarioInicialDeAtendimento = 6;
            horarioFinalDeAtendimento = 12;
        } else if (periodoDeAtendimentoDoMedico.equalsIgnoreCase("VESPERTINO")) {
            horarioInicialDeAtendimento = 13;
            horarioFinalDeAtendimento = 19;
        }

        if ((horasInformadas > horarioFinalDeAtendimento) || ((horasInformadas == horarioFinalDeAtendimento)
                && (minutosInformados != NUMERO_MINIMO_DE_MINUTOS_NO_DIA))
                || (horasInformadas < horarioInicialDeAtendimento)) {
            return false;
        }

        return ((horasInformadas <= NUMERO_MAXIMO_DE_HORAS_NO_DIA
                && horasInformadas >= NUMERO_MINIMO_DE_HORAS_NO_DIA)
                && (minutosInformados <= NUMERO_MAXIMO_DE_MINUTOS_NO_DIA
                && minutosInformados >= NUMERO_MINIMO_DE_MINUTOS_NO_DIA));
    }

    public static boolean validarData(LocalDate data) {

        int[] dataFormatada = reformatarData(data);
        LocalDate localDate = LocalDate.of(dataFormatada[0], 1, 1);

        int diasDeFevereiro = 28;
        if (localDate.isLeapYear()) {
            diasDeFevereiro = 29;
        }

        int diaInformado = dataFormatada[2];
        int mesInformado = dataFormatada[1];

        return (((mesInformado == JANEIRO || mesInformado == MARCO || mesInformado == MAIO || mesInformado == JULHO
                || mesInformado == AGOSTO || mesInformado == OUTUBRO || mesInformado == DEZEMBRO) && (diaInformado <= 31))
                || ((mesInformado == ABRIL || mesInformado == JUNHO || mesInformado == SETEMBRO || mesInformado == NOVERMBRO) && (diaInformado <= 30))
                || ((mesInformado == FEVEREIRO) && (diaInformado <= diasDeFevereiro)));
    }

    public static boolean validarDataDeConsulta(LocalDate data) {

        if (validarData(data)) {

            int[] dataFormatada = reformatarData(data);
            int diaInformado = dataFormatada[2];
            int mesInformado = dataFormatada[1];
            int anoInformado = dataFormatada[0];

            LocalDate dataAtual = LocalDate.now();
            int anoAtual = dataAtual.getYear();
            int mesAtual = dataAtual.getMonthValue();
            int diaAtual = dataAtual.getDayOfMonth();

            return ((anoAtual > anoInformado) || (anoAtual == anoInformado && mesAtual > mesInformado)
                    || (anoAtual == anoInformado && mesAtual == mesInformado && diaAtual > diaInformado));
        }
        return false;
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
        boolean encontrouCaracterInvalido = false;
        int contadorDeEspacosSeguidos = 0;
        String caracterDoNome;

        if (nome.length() < 2) {
            return false;
        }

        for (int i = 0; i < nome.length(); i++) {
            caracterDoNome = nome.substring(i, i + 1);

            if (" ".equals(caracterDoNome)) {
                contadorDeEspacosSeguidos++;
                encontrouLetra = true;
            } else {

                for (int j = 0; j < 10; j++) {
                    if (caracterDoNome.equalsIgnoreCase(j + "")) {
                        contadorDeEspacosSeguidos = 0;
                        encontrouCaracterInvalido = true;
                    }
                }

                if (!encontrouCaracterInvalido) {
                    for (String caracter : CARACTERES_INVALIDOS) {
                        if (caracterDoNome.equalsIgnoreCase(caracter)) {
                            contadorDeEspacosSeguidos = 0;
                            encontrouCaracterInvalido = true;
                        } else {
                            contadorDeEspacosSeguidos = 0;
                            encontrouLetra = true;
                        }

                    }

                }

            }

            if (!encontrouLetra || contadorDeEspacosSeguidos > 1 || encontrouCaracterInvalido == true) {
                return false;
            }

            encontrouLetra = false;
        }

        return true;
    }

}
