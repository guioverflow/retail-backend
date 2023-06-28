package com.atacadista.controller;

import com.atacadista.bean.EstabelecimentoBean;
import com.atacadista.bean.FuncionarioBean;
import com.atacadista.repository.FuncionarioRepository;
import com.atacadista.request.FuncionarioRequestDTO;
import com.atacadista.response.FuncionarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController extends AbstractController<FuncionarioRequestDTO, FuncionarioResponseDTO, Integer> {

    @Autowired
    private FuncionarioRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Override
    public void insert(@RequestBody FuncionarioRequestDTO data) {
        FuncionarioBean funcionarioData = new FuncionarioBean(data);
        repository.save(funcionarioData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Override
    public List<FuncionarioResponseDTO> selectAll() {
        List<FuncionarioResponseDTO> funcionariosList = repository.findAll().stream()
                .map(FuncionarioResponseDTO::new)
                .collect(Collectors.toList());
        return funcionariosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @Override
    public FuncionarioResponseDTO selectById(@PathVariable Integer id) {
        FuncionarioBean funcionarioBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Funcionario não encontrado com ID: " + id
                ));
        return new FuncionarioResponseDTO(funcionarioBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @Override
    public FuncionarioResponseDTO update(@PathVariable Integer id, @RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioBean funcionarioBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Funcionario não encontrado com ID: " + id
                ));

        funcionarioBean.setEstabelecimento(new EstabelecimentoBean( funcionarioRequestDTO.estabelecimento() ));
        funcionarioBean.setNome(funcionarioRequestDTO.nome());
        funcionarioBean.setCpf(funcionarioRequestDTO.cpf());
        FuncionarioBean updatedFuncionario = repository.save(funcionarioBean);

        return new FuncionarioResponseDTO(updatedFuncionario);
    }
}
