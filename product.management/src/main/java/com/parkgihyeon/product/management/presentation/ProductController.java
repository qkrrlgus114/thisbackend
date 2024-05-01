package com.parkgihyeon.product.management.presentation;

import com.parkgihyeon.product.management.application.SimpleProductService;
import com.parkgihyeon.product.management.domain.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    public ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO){
        return simpleProductService.add(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable(name = "id") Long id){
        return simpleProductService.findById(id);
    }

    @GetMapping("/all")
    public List<ProductDTO> findAllProduct(){
        return simpleProductService.findAll();
    }

    @GetMapping
    public List<ProductDTO> findProducts(@RequestParam(required = false) String name){
        if(name == null) return simpleProductService.findAll();

        return simpleProductService.containsName(name);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable(name = "id") Long id,
                                    @RequestBody ProductDTO productDTO){
        productDTO.setId(id);
        ProductDTO update = simpleProductService.update(productDTO);

        return update;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        simpleProductService.deleteProduct(id);
    }
}
