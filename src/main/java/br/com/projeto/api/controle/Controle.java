package br.com.projeto.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controle {

    private String style = "margin: 20px auto; width: max-content; box-shadow: 0px 0px 0px 2px rgba(0,0,0,.6); border-radius: 6px; padding: 10px;";

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }

        @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public void deletar(@PathVariable int codigo) {
        Pessoa obj = this.selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    // Testes
    @GetMapping("/")
    public String mensagem() {
        return String.format("<h1 style='%s'>Olá Mundo!</h1>", this.style);
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return String.format("<h1 style='%s'>Seja bem vindo(a)</h1>", this.style);
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return String.format("<h1 style='%s'>Seja bem vindo(a) %s</h1>", this.style, nome);
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }

}
