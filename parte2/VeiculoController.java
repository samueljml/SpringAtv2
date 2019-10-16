package br.com.gabriel.fatec_ipi_paoo_lista_veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.gabriel.fatec_ipi_paoo_lista_veiculos.model.beans.Veiculo;
import services.VeiculoServices;


@Controller
public class VeiculoController {
	
	//@Autowired
	//private VeiculosRepository veiculoRepositorio;
	@Autowired
	private VeiculoServices veiculosServices;
	
	@GetMapping("/veiculos")
	public ModelAndView listarVeiculos() {
		ModelAndView mav = new ModelAndView("listar_veiculos");
		mav.addObject(new Veiculo()); 
		List <Veiculo> veiculo = veiculosServices.listarTodos();
		mav.addObject("veiculos", veiculo);
		return mav;
	}
	 
	@PostMapping ("/veiculos")
	public String salvar (Veiculo veiculo) {
		veiculosServices.salvar(veiculo);
		return "redirect:/veiculos";
	}

}
