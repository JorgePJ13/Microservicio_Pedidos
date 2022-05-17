package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {

	/**
	 * Metodo que devuelve la lista de pedidos registrados
	 * 
	 * @return la lista de pedidos
	 */
	List<Pedido> pedidos();
	
	/**
	 * Metodo que da de alta un nuevo pedido con los datos del nuevo pedido
	 * 
	 * @param pedido: los datos del nuevo pedido
	 */
	void altaPedido(Pedido pedido);
}
