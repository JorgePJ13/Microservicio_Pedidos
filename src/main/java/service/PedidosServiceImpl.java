package service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	PedidosDao dao;

	@Autowired
	RestTemplate template;

	String urlProductos = "http://servicio-productos/";

	public PedidosServiceImpl(@Autowired PedidosDao dao, @Autowired RestTemplate template) {
		super();
		this.dao = dao;
		this.template = template;
	}

	@Override
	public List<Pedido> pedidos() {
		return dao.findAll();
	}

	@Override
	public void altaPedido(Pedido pedido) {
		ResponseEntity<String> responseActualizar = template.exchange(
				urlProductos + "/Producto/" + pedido.getCodigoProducto() + "/" + pedido.getUnidades(), HttpMethod.PUT,
				null, String.class);
		ResponseEntity<Double> responseProductos = template
				.exchange(urlProductos + "/Producto/" + pedido.getCodigoProducto(), HttpMethod.GET, null, Double.class);

		String cuerpo = responseActualizar.getBody();
		if (cuerpo.equals("true")) {
			pedido.setTotal(responseProductos.getBody() * pedido.getUnidades());
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			pedido.setFechaPedido(timestamp);
			dao.save(pedido);
		}
	}

}
