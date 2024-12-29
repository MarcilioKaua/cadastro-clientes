package com.example.cadasto_clientes.controller;

import com.example.cadasto_clientes.exception.EmailDuplicadoException;
import com.example.cadasto_clientes.model.Cliente;
import com.example.cadasto_clientes.model.Endereco;
import com.example.cadasto_clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public String listarClientes(@RequestParam(value = "nome", required = false) String nome, Model model) {
        List<Cliente> clientes = clienteService.listarClientes(nome);
        model.addAttribute("clientes", clientes);
        model.addAttribute("paramNome", nome);
        return "listarClientes";
    }

    @GetMapping("/novo")
    public String novoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "criarCliente"; // JSP
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "editarCliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return "redirect:/cliente/listar";
    }

    @PostMapping("/buscarEndereco")
    @ResponseBody
    public Endereco buscarEndereco(@RequestParam String cep) {
        return clienteService.consultarEndereco(cep);
    }

    @ExceptionHandler(EmailDuplicadoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleEmailDuplicadoException(EmailDuplicadoException ex) {
        return ex.getMessage();
    }
}