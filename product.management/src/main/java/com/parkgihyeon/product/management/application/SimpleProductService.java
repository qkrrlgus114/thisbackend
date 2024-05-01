package com.parkgihyeon.product.management.application;

import com.parkgihyeon.product.management.domain.Product;
import com.parkgihyeon.product.management.domain.ProductRepository;
import com.parkgihyeon.product.management.presentation.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;

    @Autowired
    public SimpleProductService(ProductRepository productRepository, ModelMapper modelMapper, ValidationService validationService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDTO add(ProductDTO productDTO){
        Product product = modelMapper.map(productDTO, Product.class);
        validationService.checkValid(product);

        Product savedProduct = productRepository.add(product);
        ProductDTO savedProductDTO = modelMapper.map(savedProduct, ProductDTO.class);
        return savedProductDTO;
    }

    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        return productDTOs;
    }

    public List<ProductDTO> containsName(String name){
        List<Product> productList = productRepository.findByNameContaining(name);

        return productList.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
    }

    public ProductDTO update(ProductDTO productDTO){
        Product product = modelMapper.map(productDTO, Product.class);
        Product updateProduct = productRepository.update(product);
        ProductDTO updateProductDTO = modelMapper.map(updateProduct, ProductDTO.class);

        return updateProductDTO;
    }

    public void deleteProduct(Long id){
        productRepository.delete(id);
    }
}
