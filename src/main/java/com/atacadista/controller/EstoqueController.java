package com.atacadista.controller;

import com.atacadista.bean.EstabelecimentoBean;
import com.atacadista.bean.EstoqueBean;
import com.atacadista.bean.ProdutoBean;
import com.atacadista.repository.EstoqueRepository;
import com.atacadista.request.EstoqueRequestDTO;
import com.atacadista.response.EstoqueResponseDTO;
import com.atacadista.serializable.EstoqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("estoque")
public class EstoqueController extends AbstractController<EstoqueRequestDTO, EstoqueResponseDTO, EstoqueId> {

    @Autowired
    private EstoqueRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Override
    public void insert(@RequestBody EstoqueRequestDTO data) {
        EstoqueBean estoqueData = new EstoqueBean(data);
        repository.save(estoqueData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Override
    public List<EstoqueResponseDTO> selectAll() {
        List<EstoqueResponseDTO> estoqueList = repository.findAll().stream()
                .map(EstoqueResponseDTO::new)
                .collect(Collectors.toList());
        return estoqueList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @Override
    public EstoqueResponseDTO selectById(@PathVariable EstoqueId id) {
        EstoqueBean estoqueBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Estoque não encontrado com ID: " + id
                ));
        return new EstoqueResponseDTO(estoqueBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable EstoqueId id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @Override
    public EstoqueResponseDTO update(@PathVariable EstoqueId id, @RequestBody EstoqueRequestDTO estoqueRequestDTO) {
        EstoqueBean estoqueBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Estoque não encontrado com ID: " + id
                ));

        estoqueBean.setEstabelecimento( new EstabelecimentoBean( estoqueRequestDTO.estabelecimento() ));
        estoqueBean.setProduto( new ProdutoBean( estoqueRequestDTO.produto() ));
        estoqueBean.setQuantidade(estoqueRequestDTO.quantidade());

        EstoqueBean updatedEstoque = repository.save(estoqueBean);

        return new EstoqueResponseDTO(updatedEstoque);
    }
}
