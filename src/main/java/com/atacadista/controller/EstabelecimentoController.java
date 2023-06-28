package com.atacadista.controller;

import com.atacadista.bean.EstabelecimentoBean;
import com.atacadista.repository.EstabelecimentoRepository;
import com.atacadista.request.EstabelecimentoRequestDTO;
import com.atacadista.response.EstabelecimentoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController extends AbstractController<EstabelecimentoRequestDTO, EstabelecimentoResponseDTO, Integer> {

    @Autowired
    private EstabelecimentoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Override
    public void insert(@RequestBody EstabelecimentoRequestDTO data) {
        EstabelecimentoBean estabelecimentoData = new EstabelecimentoBean(data);
        repository.save(estabelecimentoData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Override
    public List<EstabelecimentoResponseDTO> selectAll() {
        List<EstabelecimentoResponseDTO> estabelecimentosList = repository.findAll().stream()
                .map(EstabelecimentoResponseDTO::new)
                .collect(Collectors.toList());
        return estabelecimentosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @Override
    public EstabelecimentoResponseDTO selectById(@PathVariable Integer id) {
        EstabelecimentoBean estabelecimentoBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Estabelecimento não encontrado com ID: " + id
                ));
        return new EstabelecimentoResponseDTO(estabelecimentoBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @Override
    public EstabelecimentoResponseDTO update(@PathVariable Integer id, @RequestBody EstabelecimentoRequestDTO estabelecimentoRequestDTO) {
        EstabelecimentoBean estabelecimentoBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Estabelecimento não encontrado com ID: " + id
                ));

        estabelecimentoBean.setTelefone(estabelecimentoRequestDTO.telefone());
        estabelecimentoBean.setCnpj(estabelecimentoRequestDTO.cnpj());

        EstabelecimentoBean updatedEstabelecimento = repository.save(estabelecimentoBean);

        return new EstabelecimentoResponseDTO(updatedEstabelecimento);
    }
}
