package apresentacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import negocio.Anotacao;
import persistencia.AnotacaoDAO;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        int menu, escolha;
        String titulo, texto, cor;
        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();

        do {
            System.out.println(
                    "Ola, bem vindo ao GoogleKeepTabajara!\nO que deseja fazer?\n(1)Nova anotacao\n(2)Listar\n(3)Atualizar\n(4)Deletar\n(0)Sair");
            menu = in.nextInt();

            if (menu == 1) {
                System.out.println("Nova anotacao");
                System.out.println("Titulo:");
                titulo = in.next();
                System.out.println("Texto");
                texto = in.next();
                System.out.println("Cor:");
                cor = in.next();

                Anotacao novaAnotacao = new Anotacao();
                novaAnotacao.setTitulo(titulo);
                novaAnotacao.setTexto(texto);
                novaAnotacao.setCor(cor);
                anotacaoDAO.inserir(novaAnotacao);

            } else if (menu == 2) {
                anotacaoDAO.listar().forEach(a -> System.out.println(a));
                ArrayList<Anotacao> vet = anotacaoDAO.listar();
                for (int i = 0; i < vet.size(); i++) {
                    vet.get(i);
                    // System.out.println(anotacao.getTitulo());
                }
            } else if (menu == 3) {
                System.out.println("ID da anotacao que deseja atualizar:");
                escolha = in.nextInt();
                Anotacao atualizar = anotacaoDAO.obterPorId(escolha);
                System.out.println("Novo titulo:");
                titulo = in.next();
                System.out.println("Novo texto");
                texto = in.next();
                System.out.println("Nova cor:");
                cor = in.next();
                atualizar.setTitulo(titulo);
                atualizar.setTexto(texto);
                atualizar.setCor(cor);
                anotacaoDAO.atualizar(atualizar);
            } else if (menu == 4) {
                System.out.println("ID da anotacao que deseja deletar:");
                escolha = in.nextInt();
                anotacaoDAO.deletar(escolha);
            }
        } while (menu != 0);
    }
}
