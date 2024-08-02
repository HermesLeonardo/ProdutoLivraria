package br.edu.unifio.drogaria.controladores.ProdutoControlador;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class CalculadoraControlador {
    private Double primeiroNumero;
    private Double segundoNumero;
    private Double resultado;

    public void somar(){
        resultado = primeiroNumero + segundoNumero;
    }

    public void subtrair(){
        resultado = primeiroNumero - segundoNumero;
    }
}
