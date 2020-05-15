package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.SituacaoPedido;

public class Pedido {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date dataPedido;
	private Cliente cliente;
	private SituacaoPedido situacao;

	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Date dataPedido, Cliente cliente, SituacaoPedido situacao) {
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.situacao = situacao;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public void adicionaItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public void removeItem(ItemPedido itemPedido) {
		itens.remove(itemPedido);
	}

	public Double total() {
		Double soma = 0.0;
		for (ItemPedido itm : itens) {
			soma += itm.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("SUMARIO DO PEDIDO: \n");
		sb.append("Data do Pedido: " + sdf.format(dataPedido) + "\n");
		sb.append("Situacao do Pedido: " + situacao + "\n");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido: \n");
		for (ItemPedido itm : itens) {
			sb.append(itm + "\n");
		}
		sb.append("Total do Pedido: $" + String.format("%.2f", total()));

		return sb.toString();
	}

}
