package com.example.cadasto_clientes.service;

import com.example.cadasto_clientes.exception.EmailDuplicadoException;
import com.example.cadasto_clientes.model.Cliente;
import com.example.cadasto_clientes.model.Endereco;
import com.example.cadasto_clientes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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

    public void salvarCliente(Cliente cliente) {
        try {
            clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new EmailDuplicadoException("O e-mail informado já está cadastrado.");
        }
    }

    public List<Cliente> listarClientes(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            return clienteRepository.findByNomeContainingIgnoreCase(nome);
        }
        return clienteRepository.findAll();
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

