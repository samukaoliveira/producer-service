package br.com.sti.producer.controllers;

import br.com.sti.commons.dtos.ProductDTO;
import br.com.sti.producer.services.ProductService;
import br.com.sti.producer.services.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> produces(@RequestBody ProductDTO dto){
        service.createProduct(dto);
        return ResponseEntity.status(CREATED).build();
    }
}
