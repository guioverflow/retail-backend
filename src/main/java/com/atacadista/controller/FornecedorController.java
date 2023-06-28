package com.atacadista.controller;

import com.atacadista.bean.FornecedorBean;
import com.atacadista.repository.FornecedorRepository;
import com.atacadista.request.FornecedorRequestDTO;
import com.atacadista.response.FornecedorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController extends AbstractController<FornecedorRequestDTO, FornecedorResponseDTO> {

    @Autowired
    private FornecedorRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Override
    public void insert(@RequestBody FornecedorRequestDTO data) {

        FornecedorBean fornecedorData = new FornecedorBean(data);
        repository.save(fornecedorData);

        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Override
    public List<FornecedorResponseDTO> selectAll() {
        List<FornecedorResponseDTO> fornecedoresList = repository.findAll().stream()
                .map(FornecedorResponseDTO::new)
                .collect(Collectors.toList());
        return fornecedoresList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @Override
    public FornecedorResponseDTO selectById(@PathVariable int id) {
        FornecedorBean fornecedorBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Fornecedor não encontrado com ID: " + id
                ));
        return new FornecedorResponseDTO(fornecedorBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable int id) {
        repository.deleteById(id);
        return;
    }

    @PutMapping("/{id}")
    @Override
    public FornecedorResponseDTO update(@PathVariable int id, @RequestBody FornecedorRequestDTO fornecedorRequestDTO) {
        FornecedorBean fornecedorBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Fornecedor não encontrado com ID: " + id
                ));

        fornecedorBean.setNome(fornecedorRequestDTO.nome());
        fornecedorBean.setCnpj(fornecedorRequestDTO.cnpj());
        fornecedorBean.setTelefone(fornecedorRequestDTO.telefone());
        fornecedorBean.setEmail(fornecedorRequestDTO.email());

        FornecedorBean updatedFornecedor = repository.save(fornecedorBean);

        return new FornecedorResponseDTO(updatedFornecedor);
    }
}
