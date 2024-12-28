package com.example.cadasto_clientes.controller;

import com.example.cadasto_clientes.model.Cliente;
import com.example.cadasto_clientes.model.Endereco;
import com.example.cadasto_clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarClientes(null);
        model.addAttribute("clientes", clientes);

        if (!clientes.isEmpty()) {
            model.addAttribute("clienteName", clientes.get(0).getNome());
        }

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
}