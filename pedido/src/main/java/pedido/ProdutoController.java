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
@RequestMapping(value = "/api/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
	
	@PostMapping
	public Produto salvarPessoa(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Produto atualizarProduto(@PathVariable Long id, 
			                      @RequestBody Produto produto) {
		Optional<Produto> oProdutol =  produtoRepository.findById(id);
		if(oProdutol.isPresent()) {
			Produto p = oProdutol.get();
			p.setDescricao(produto.getDescricao());
			p.setTipo(produto.getTipo());
			return produtoRepository.save(p);
		}
		return null;
	}

}


