package com.parkgihyeon.product.management.application;

import com.parkgihyeon.product.management.domain.Product;
import com.parkgihyeon.product.management.domain.ProductRepository;
import com.parkgihyeon.product.management.presentation.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {

    private ProductRepository productRepository;
    private ValidationService validationService;

    @Autowired
    public SimpleProductService(ProductRepository productRepository, ValidationService validationService) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    public ProductDTO add(ProductDTO productDTO){
        Product product = ProductDTO.toEntity(productDTO);
        validationService.checkValid(product);

        Product savedProduct = productRepository.add(product);
        ProductDTO savedProductDTO = ProductDTO.toDTO(savedProduct);
        return savedProductDTO;
    }

    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id);
        ProductDTO productDTO = ProductDTO.toDTO(product);
        return productDTO;
    }

    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOs = products.stream()
                .map(product -> ProductDTO.toDTO(product))
                .toList();
        return productDTOs;
    }

    public List<ProductDTO> containsName(String name){
        List<Product> productList = productRepository.findByNameContaining(name);

        return productList.stream()
                .map(product -> ProductDTO.toDTO(product))
                .toList();
    }

    public ProductDTO update(ProductDTO productDTO){
        Product product = ProductDTO.toEntity(productDTO);
        Product updateProduct = productRepository.update(product);
        ProductDTO updateProductDTO = ProductDTO.toDTO(updateProduct);

        return updateProductDTO;
    }

    public void deleteProduct(Long id){
        productRepository.delete(id);
    }
}
