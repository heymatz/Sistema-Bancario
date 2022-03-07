import java.util.Scanner;

public class SistemaBancario {

    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        int resp, i = 0;

        Campos c = new Campos();

        System.out.println("Escolha a opção desejada \n 1-Cadastrar uma conta \n"
                + "2-Visualizar todas as contas de um cliente específico \n"
                + "3-Visualizar clientes com saldo negativo \n"
                + "4-Realizar alterações de cadastro \n"
                + "5-Realizar saque \n"
                + "6-Depositar em conta \n"
                + "7-Sair do programa");
        resp = leia.nextInt();

        while (resp >= 1 && resp <= 6) {
            if (resp == 1) {
                salvar();
            }
            if (resp == 2) {
                pesquisapornome();
            }
            if (resp == 3) {
                buscar();
            }
            if (resp == 4) {
                alterar();
            }
            if (resp == 5) {
                saque();
            }
            if (resp == 6) {
                deposito();
            }
            System.out.println("Escolha a opção desejada \n 1-Cadastrar uma conta \n"
                    + "2-Visualizar todas as contas de um cliente específico \n"
                    + "3-Visualizar clientes com saldo negativo \n"
                    + "4-Realizar alterações de cadastro \n"
                    + "5-Realizar saque \n"
                    + "6-Depositar em conta \n"
                    + "7-Sair do programa");
            resp = leia.nextInt();
        }
        if (resp == 7) {
            System.out.println("Você saiu do programa.");
        }
    }

    public static void salvar() {

        int i = 0;
        Campos c = new Campos();

        System.out.println(" NOME ");
        c.setNome(leia.next());
        System.out.println(" CONTA ");
        c.setNum(leia.nextInt());
        System.out.println(" CPF ");
        c.setCpf(leia.nextDouble());
        System.out.println(" TELEFONE ");
        c.setTel(leia.nextInt());
        System.out.println(" CIDADE ");
        c.setCidade(leia.next());
        System.out.println(" ESTADO ");
        c.setEstado(leia.next());
        System.out.println(" SALDO ");
        c.setSaldo(leia.nextDouble());
        Campos.vet.add(c);
    }

    public static void pesquisapornome() {

        String nomep = null;
        int i = 0;
        Campos c = new Campos();

        System.out.println("PESQUISAR NOME");
        nomep = leia.next();
        if (nomep.equalsIgnoreCase(Campos.vet.get(i).getNome())) {
            System.out.println("CONTA=" + Campos.vet.get(i).getNome());
            System.out.println("CPF=" + Campos.vet.get(i).getCpf());
            System.out.println("TELEFONE=" + Campos.vet.get(i).getTel());
            System.out.println("CIDADE=" + Campos.vet.get(i).getCidade());
            System.out.println("ESTADO=" + Campos.vet.get(i).getEstado());
            System.out.println("SALDO EM CONTA=" + Campos.vet.get(i).getSaldo());
        }
    }

    public static void alterar() {

        int nump = 0, i = 0;
        Campos c = new Campos();

        System.out.println("NUMERO DA CONTA A SER RECADASTRADA");
        nump = leia.nextInt();
        if (nump == (Campos.vet.get(i).getNum())) {
            System.out.println("NOVO NOME");
            c.setNome(leia.next());
            System.out.println("NOVO CPF");
            c.setCpf(leia.nextDouble());
            System.out.println("NOVO TELEFONE");
            c.setTel(leia.nextInt());
            System.out.println("NOVA CIDADE");
            c.setCidade(leia.next());
            System.out.println("NOVO ESTADO");
            c.setEstado(leia.next());
            System.out.println("NOVO SALDO EM CONTA");
            c.setSaldo(leia.nextDouble());
        }
    }

    public static void buscar() {

        int i = 0;
        Campos c = new Campos();

        System.out.println("CLIENTES COM SALDO NEGATIVO");
        if ((Campos.vet.get(i).getSaldo()) < 0) {
            System.out.println("NOME=" + Campos.vet.get(i).getNome());
            System.out.println("CONTA=" + Campos.vet.get(i).getNum());
            System.out.println("CPF=" + Campos.vet.get(i).getCpf());
            System.out.println("TELEFONE=" + Campos.vet.get(i).getTel());
            System.out.println("CIDADE=" + Campos.vet.get(i).getCidade());
            System.out.println("ESTADO=" + Campos.vet.get(i).getEstado());
            System.out.println("SALDO=" + Campos.vet.get(i).getSaldo());
        }
    }

    public static void deposito() {

        double dep, soma;
        int nump = 0, i = 0;
        Campos c = new Campos();

        System.out.println("CONTA A DEPOSITAR");
        nump = leia.nextInt();

        if (nump == (Campos.vet.get(i).getNum())) {
            System.out.println("SALDO EM CONTA=" + Campos.vet.get(i).getSaldo());
            System.out.println("VALOR A DEPOSITAR");
            dep = leia.nextDouble();

            soma = Campos.vet.get(i).getSaldo() + dep;

            System.out.println("SALDO ATUAL=" + soma);
        }
    }

    public static void saque() {

        double ret, subtracao;
        int i = 0, nump = 0;
        Campos c = new Campos();

        System.out.println("CONTA A EFETUAR SAQUE");
        nump = leia.nextInt();

        if (nump == (Campos.vet.get(i).getNum())) {
            System.out.println("SALDO EM CONTA=" + Campos.vet.get(i).getSaldo());
            System.out.println("VALOR A SACAR");
            ret = leia.nextDouble();

            subtracao = Campos.vet.get(i).getSaldo() - ret;

            System.out.println("SALDO ATUAL=" + subtracao);
        }
    }
}