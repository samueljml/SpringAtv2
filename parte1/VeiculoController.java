package br.com.gabriel.fatec_ipi_paoo_lista_veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.gabriel.fatec_ipi_paoo_lista_veiculos.model.beans.Veiculo;
import br.com.gabriel.fatec_ipi_paoo_lista_veiculos.repository.VeiculosRepository;


@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculosRepository veiculoRepositorio;
	
	@GetMapping("/veiculos")
	public ModelAndView listarVeiculos() {
		ModelAndView mav = new ModelAndView("listar_veiculos");
		mav.addObject(new Veiculo()); 
		List <Veiculo> veiculo = veiculoRepositorio.findAll();
		mav.addObject("veiculo", veiculo);
		return mav;
	}
	 
	@PostMapping ("/veiculos")
	public String salvar (Veiculo veiculo) {
		veiculoRepositorio.save(veiculo);
		return "redirect:/veiculos";
	}

}
