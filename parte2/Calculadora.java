package utils;

public class Calculadora {
	
	public double calculaAutonomia (double... valores) {
		double media = 0;
		for (Double elemento: valores) {
			media += elemento;
		}
		return valores.length > 0 ? media / valores.length : 0;
	}

}

