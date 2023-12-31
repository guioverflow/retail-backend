package com.atacadista.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.atacadista.bean.ProdutoBean;
import com.atacadista.repository.ProdutoRepository;
import com.atacadista.request.ProdutoRequestDTO;
import com.atacadista.response.ProdutoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends AbstractController<ProdutoRequestDTO, ProdutoResponseDTO, Integer> {

    @Autowired
    private ProdutoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Override
    public void insert(@RequestBody ProdutoRequestDTO data) {
        ProdutoBean produtoData = new ProdutoBean(data);
        repository.save(produtoData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Override
    public List<ProdutoResponseDTO> selectAll() {
        List<ProdutoResponseDTO> produtosList = repository.findAll().stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
        return produtosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @Override
    public ProdutoResponseDTO selectById(@PathVariable Integer id) {
        ProdutoBean produtoBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + id
                ));
        return new ProdutoResponseDTO(produtoBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Override
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @Override
    public ProdutoResponseDTO update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO ProdutoRequestDTO) {
        ProdutoBean produtoBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + id
                ));

        produtoBean.setNome(ProdutoRequestDTO.nome());
        produtoBean.setDescricao(ProdutoRequestDTO.descricao());

        ProdutoBean updatedProduto = repository.save(produtoBean);

        return new ProdutoResponseDTO(updatedProduto);
    }
}
