package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class SaludarControlador {
    String nombre;

	@GetMapping("/saludos")
	public String saludar() {
		return "¡Hola mundo!" + nombre;
	}

    @GetMapping("/despedidas")
    public String despedirse() {
        return "¡Adiós mundo!";
    }

    @PostMapping("/nombramientos")
    public void nombre( ) {
        nombre = "Kevin";
    }

    @PutMapping("/nombramientos")
    public void met1(){
        nombre = "actualizar"
    }

    @DeleteMapping("/nombramientos")
    public void met2(){
        nombre = null;
    }

}
