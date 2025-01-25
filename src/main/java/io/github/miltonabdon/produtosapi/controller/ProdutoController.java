package io.github.miltonabdon.produtosapi.controller;

import io.github.miltonabdon.produtosapi.model.Produto;
import io.github.miltonabdon.produtosapi.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @PostMapping("/salvar")
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Salvando produto: " + produto);

        produto.setId(UUID.randomUUID().toString());

        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping("/buscaPorNome")
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

    @GetMapping("/buscaPorId/{id}")
    public Produto obterPorI(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

}
