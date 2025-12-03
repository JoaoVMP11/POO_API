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
@RequestMapping(value = "/api/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public Cliente criar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizarCliente(@PathVariable Long id, 
			                      @RequestBody Cliente cliente) {
		Optional<Cliente> oClientel =  clienteRepository.findById(id);
		if(oClientel.isPresent()) {
			Cliente c = oClientel.get();
			c.setNome(cliente.getNome());
			c.setCEP(cliente.getCEP());
			return clienteRepository.save(c);
		}
		return null;
	}

}