
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Cliente;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Conta;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Endereco;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Tipo;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.dao.ClienteDAOImple;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.dao.ContaDAOImple;
import java.util.Date;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 13:06:32
 */
public class Main {

    public static void main(String[] args) {

        ClienteDAOImple clienteDAOImple = new ClienteDAOImple();
        ContaDAOImple contaDAOImple = new ContaDAOImple();

        //
        // CRUD Cliente / Conta
        //
        // Persistindo:
        Conta conta = fillConta();
        Cliente cliente = fillCliente();
        cliente.setConta(conta);
        clienteDAOImple.persist(cliente);

        // Procurar
        Cliente cl = clienteDAOImple.find(1l);
        Conta co = cl.getConta();
        System.out.println(cl.toString());
        System.out.println(co.toString());

        // Atualização:
        cl.setLogin("LOGIN ATUALIZADO");
        co.setSenha("SENHA ATUALIZADA");
        clienteDAOImple.update(cl);
        System.out.println(cl.toString());
        System.out.println(co.toString());

        // Alterar Senha
        contaDAOImple.alterarSenha(co, "SENHA ALTERADA");
        System.out.println(co.toString());

//        // Remoção:
//        clienteDAOImple.remove(cl);
//
//        //
//        // Realizar Login
//        //
//        Cliente clienteLogado = clienteDAOImple.realizarLogin("login", "senha");
//        System.out.println(clienteLogado.toString());
//        Conta contaCliente = clienteLogado.getConta();
//        //
//        // Simular um Deposito
//        //
//        System.out.println("Antes do Deposito: " + contaCliente.getSaldo());
//        contaDAOImple.depositar(contaCliente, new Double(200.00));
//        System.out.println("Depois: " + contaCliente.getSaldo());
//        //
//        // Simular um Saque
//        //
//        System.out.println("Antes do Saque: " + contaCliente.getSaldo());
//        contaDAOImple.sacar(contaCliente, new Double(100.00));
//        System.out.println("Depois: " + contaCliente.getSaldo());
    }

    private static Cliente fillCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf("111-222-333-44");
        cliente.setEmail("111@gmail.com");
        cliente.setLogin("login");
        cliente.setNascimento(new Date());
        cliente.setNome("cliente");
        cliente.setRg("11-22-33-44");
        cliente.setTelefone("(000) 1111-2222");

        Endereco endereco = fillEndereco();
        cliente.setEndereco(endereco);

        return cliente;
    }

    private static Endereco fillEndereco() {
        Endereco endereco = new Endereco();
        endereco.setBairro("centro");
        endereco.setCep("111111-111");
        endereco.setCidade("Cidade Grande");
        endereco.setEstado("Solido");
        endereco.setNumero("333");
        endereco.setPais("BR");
        endereco.setRua("Rua sem saida");
        return endereco;
    }

    private static Conta fillConta() {
        Conta conta = new Conta();
        conta.setAgencia("BDNC");
        conta.setDigitoAgencia("1234");
        conta.setDigitoConta("456");
        conta.setNumero("34355");
        conta.setSaldo(0.0);
        conta.setSenha("senha");
        conta.setTipo(Tipo.POUPANCA);
        return conta;
    }
}
