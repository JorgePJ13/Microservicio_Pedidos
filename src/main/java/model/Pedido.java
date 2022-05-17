package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido	 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private int codigoProducto;
	private int unidades;
	private double total;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPedido;
}
