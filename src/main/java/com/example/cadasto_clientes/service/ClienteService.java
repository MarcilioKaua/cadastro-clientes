package com.example.cadasto_clientes.service;

import com.example.cadasto_clientes.model.Cliente;
import com.example.cadasto_clientes.model.Endereco;
import com.example.cadasto_clientes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ViaCepService viaCepService;

    public ClienteService(ClienteRepository clienteRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.viaCepService = viaCepService;
    }

    public Cliente salvarCliente(Cliente cliente) {
        // Validações ou outras lógicas
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(String nome) {
        return nome != null ? clienteRepository.findByNomeContaining(nome) : clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Endereco consultarEndereco(String cep) {
        return viaCepService.consultarCep(cep);
    }
}

