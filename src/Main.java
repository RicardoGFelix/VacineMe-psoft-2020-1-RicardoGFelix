import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Controller controller = new Controller();
        System.out.println("\n\nSeja bem-vindo(a) ao Vacine-Me!\n\n");
        String userInterface = "\nQual processo deseja realizar? \n\n" +
                "1 - Cadastrar pessoa\n" +
                "2 - Adicionar comorbidade habilitada para vacinação\n" +
                "3 - Adicionar profissão habilitada para vacinação\n" +
                "4 - Atualizar idade mínima para vacinação\n" +
                "5 - Detalhar vacinação\n" +
                "6 - Vacinar pessoa\n" +
                "7 - Avançar pessoa para a próxima etapa do processo de vacinação\n" +
                "8 - Alterar comorbidades de uma pessoa \n" +
                "9 - Alterar profissão de uma pessoa \n" +
                "10 - Situação de uma pessoa\n" +
                "11 - Listar pessoas não habilitadas\n" +
                "12 - Listar pessoas habilitadas a tomar a 1º dose\n" +
                "13 - Listar pessoas que tomaram a 1º dose\n" +
                "14 - Listar pessoas habilitadas a tomar a 2º dose\n" +
                "15 - Listar pessoas imunizadas\n" +
                "0 - Sair";


        Scanner scanner = new Scanner(System.in);
        int option;

        while(true){
            System.out.println(userInterface);
            System.out.println("O que você deseja fazer? ");
            option = scanner.nextInt();
            scanner.nextLine();

            String cpf;
            String comorbidades;
            String profissao;

            switch(option){
                case(1):
                    String nome;
                    String cpfPessoa;
                    int idade;
                    String endereco;
                    String cartaoSUS;
                    String telefone;
                    String profissaoPessoa;
                    String comorbidadesPessoa;

                    System.out.println("Informe seu nome: ");
                    nome = scanner.nextLine();

                    System.out.println("Informe seu CPF: ");
                    cpfPessoa = scanner.nextLine();

                    System.out.println("Informe sua idade:");
                    idade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe seu endereço: ");
                    endereco = scanner.nextLine();

                    System.out.println("Informe o número do seu cartão do SUS: ");
                    cartaoSUS = scanner.nextLine();

                    System.out.println("Informe um número de telefone para contato: ");
                    telefone = scanner.nextLine();

                    System.out.println("Informe sua profissão: ");
                    profissaoPessoa = scanner.nextLine();

                    System.out.println("Informe suas comorbidades (Separe-as por espaço): ");
                    comorbidadesPessoa = scanner.nextLine();

                    controller.addPessoa(nome, cpfPessoa, idade, endereco, cartaoSUS, telefone, profissaoPessoa, comorbidadesPessoa);
                    break;
                case(2):
                    System.out.println("Informe a comorbidade a ser habilitada: ");
                    comorbidades = scanner.nextLine();
                    controller.addComorbidadeHabilitada(comorbidades);
                    break;
                case(3):
                    System.out.println("Informe a a profissão a ser habilitada: ");
                    profissao = scanner.nextLine();
                    controller.addProfissaoHabilitada(profissao);
                    break;
                case(4):
                    System.out.println("Informe a nova idade mínima para vacinação");
                    int idadePessoa = scanner.nextInt();
                    scanner.nextLine();
                    controller.setIdadeMinimaHabilitada(idadePessoa);
                    break;
                case(5):
                    controller.getDetalhes();
                    break;
                case(6):
                    System.out.println("Informe o seu CPF: ");
                    cpf = scanner.nextLine();
                    controller.vacinar(cpf);
                    break;
                case(7):
                    System.out.println("Informe o seu CPF: ");
                    cpf = scanner.nextLine();
                    controller.avancarEtapa(cpf);
                    break;
                case(8):
                    System.out.println("Informe o seu CPF: ");
                    cpf = scanner.nextLine();
                    System.out.println("Informe suas comorbidades (Separe-as por espaço): ");
                    comorbidades = scanner.nextLine();
                    controller.setPessoaComorbidades(cpf, comorbidades);
                    break;
                case(9):
                    System.out.println("Informe o seu CPF: ");
                    cpf = scanner.nextLine();
                    System.out.println("Informe sua profissão: ");
                    profissao = scanner.nextLine();
                    controller.setProfissao(cpf, profissao);
                    break;
                case(10):
                    System.out.println("Informe o seu CPF: ");
                    cpf = scanner.nextLine();
                    controller.getSituacao(cpf);
                    break;
                case(11):
                    controller.listarPessoasNaoHabilitadas();
                    break;
                case(12):
                    controller.listarPessoasHabilitadasPrimeiraDose();
                    break;
                case(13):
                    controller.listarPessoasVacinadasPrimeiraDose();
                    break;
                case(14):
                    controller.listarPessoasHabilitadasSegundaDose();
                    break;
                case(15):
                    controller.listarPessoasImunes();
                    break;
                case(0):
                    System.out.println("Tenha um bom dia! Até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida!\n\n");
            }
        }
    }
}
