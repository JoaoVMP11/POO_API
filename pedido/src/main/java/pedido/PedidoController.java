package pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pedido")
public class PedidoController {
	
	@Autowired 
	PedidoRepository pedidoRepository;
	

	@GetMapping
	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}
	
	@PostMapping
	public Pedido salvarPedido(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		pedidoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Pedido atualizarPedido(@PathVariable Long numero, 
			                      @RequestBody Pedido pedido) {
		Optional<Pedido> oPedidol =  pedidoRepository.findById(numero);
		if(oPedidol.isPresent()) {
			Pedido p = oPedidol.get();
			p.setCEP(pedido.getCEP());
			p.setTotal_fatura(pedido.getTotal_fatura());
			p.setId_cli(pedido.getId_cli());
			return pedidoRepository.save(p);
		}
		return null;
	}

}


