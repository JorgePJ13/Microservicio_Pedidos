package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pedido;

public interface PedidosDao extends JpaRepository<Pedido, Integer> {

}
