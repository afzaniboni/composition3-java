package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.SituacaoPedido;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Nome:");
		String nome = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Nascimento (dd/mm/yyyy)");
		Date nascimento = sdf.parse(sc.next());

		System.out.println("Entre com os dados do Pedido:");
		System.out.print("Situacao: ");
		String situacao = sc.next();
		System.out.print("Quantos itens terá o pedido: ");
		Integer qtdItem = sc.nextInt();

		Pedido pedido = new Pedido(new Date(), new Cliente(nome, email, nascimento), SituacaoPedido.valueOf(situacao));

		for (int i = 1; i <= qtdItem; i++) {
			System.out.println("Entre com o item #" + i + " do pedido:");
			System.out.print("Nome do Produto:");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do Produto:");
			Double precoProduto = sc.nextDouble();

			Produto produto = new Produto(nomeProduto, precoProduto);

			System.out.print("Quantidade:");
			Integer qteProduto = sc.nextInt();

			ItemPedido itemPedido = new ItemPedido(qteProduto, precoProduto, produto);

			pedido.adicionaItem(itemPedido);

		}

		System.out.println("");
		System.out.println(pedido);

		sc.close();

	}

}
