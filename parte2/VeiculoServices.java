package services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.fatec_ipi_paoo_lista_veiculos.model.beans.Veiculo;
import br.com.gabriel.fatec_ipi_paoo_lista_veiculos.repository.VeiculosRepository;
import utils.Calculadora;

@Service
public class VeiculoServices {
	
	@Autowired
	private VeiculosRepository veiculoRepo;
	
	@Autowired
	private Calculadora calculadora;
	
	public void salvar (Veiculo veiculo) {
		veiculoRepo.save(veiculo);
	}
	
	public List <Veiculo> listarTodos (){
		List<Veiculo> veiculos = veiculoRepo.findAll();
		for (Veiculo veiculo : veiculos) {
			veiculo.setAutonomia(calculadora.calculaAutonomia(
					veiculo.getKm(),
					veiculo.getTank()
			));

		}
		return veiculos;
	}

}
