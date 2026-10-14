package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class SaludarControlador {
    String nombre;

    @GetMapping("/saludos")
    public String saludar() {
        return "Hola mundo"+ nombre;
    }

    @GetMapping("/despedidas")
    public String despedirse(){
        return "Adiós mundo";
    }

    @PostMapping("/nombramientos")
    public void nombre(){
        nombre = "Kevin";   
    }

    @PutMapping("/nombramientos")
    public void met1(){
        nombre = "actualizar";   
    }

    @DeleteMapping("/nombramientos")
    public void met2(){
        nombre = null;   
    } 

    @GetMapping("/saludador/{nombre}")
    public Saludador met3(@PathVariable String nombre){
        return new Saludador(nombre);
    }

    @RequestMapping("/saludador2/{nombreX}") 
    public Saludador met4(@PathVariable("nombreX") String nombre){
        saludador = new Saludador(nombre);
        return saludador;
    }

    @RequestMapping("/")
    public String indice(){
        return """
        <h1>Menu principal</h1>
        <ul>
            <li><a href="/saludos">Saludos</a></li>
            <li><a href="/despedidas">Despedidas</a></li>
            <li>/nombramientos (Post, Put, Delete)</li>
            <li><a href="/saludador/default">Saludador/{nombre}</a></li>
            <li><a href="/saludador/default2">Saludador2/{nombreX}</a></li>
            <li><a href="/crearSaludador">Crear Saludador</a></li>
            <li><a href="/obtenerSaludador">Obtener Saludador</a></li>
        </ul>
        """;
    }

    Saludador saludador;

    @PostMapping ("/crearSaludador")
    public void crearSaludador(@RequestBody String nombre){
        saludador = new Saludador(nombre);
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(){
        return saludador;
    }
    
    @GetMapping("/getQuery")
    public String GetQueryString(@RequestParam String nombre, @RequestParam String paterno){
        return nombre + " " + paterno;
    }

    @GetMapping("/getQuery2")
    public String GetQueryString2(@RequestParam String nombre,
        @RequestParam (defaultValue = "") String paterno){
        return nombre + " " + paterno;
    }
}