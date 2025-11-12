package pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private String CEP;
	private double total_fatura;
	private Long id_cli;
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
