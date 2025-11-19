package pedido;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private String CEP;
	private double total_fatura;
	private Long id_cli;
	
	@ManyToMany
	@JoinTable(
			name= "item_produto",
			joinColumns = @JoinColumn(name = "numero_ped"),	
			inverseJoinColumns = @JoinColumn(name = "id_pro")
			)
	
	private List<Produto> produtos = new ArrayList<>();
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public double getTotal_fatura() {
		return total_fatura;
	}
	public void setTotal_fatura(double total_fatura) {
		this.total_fatura = total_fatura;
	}
	public Long getId_cli() {
		return id_cli;
	}
	public void setId_cli(Long id_cli) {
		this.id_cli = id_cli;
	}
	
	
	
	

}
