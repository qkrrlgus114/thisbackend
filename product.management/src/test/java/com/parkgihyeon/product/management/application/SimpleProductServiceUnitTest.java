package com.parkgihyeon.product.management.application;

import com.parkgihyeon.product.management.domain.Product;
import com.parkgihyeon.product.management.domain.ProductRepository;
import com.parkgihyeon.product.management.presentation.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SimpleProductServiceUnitTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ValidationService validationService;
    @InjectMocks
    private SimpleProductService simpleProductService;

    @Test
    @DisplayName("상품이 추가 된 후에는 추가된 상품이 반환되어야 한다.")
    void productAddTest(){
        // given
        ProductDTO productDTO = new ProductDTO("연필", 300, 20);
        Long PRODUCT_ID = 1L;

        Product product = ProductDTO.toEntity(productDTO);
        product.setId(PRODUCT_ID);
        when(productRepository.add(any())).thenReturn(product);

        // when
        ProductDTO savedProductDTO = simpleProductService.add(productDTO);

        // then
        verify(validationService).checkValid(any(Product.class));
        assertEquals(savedProductDTO.getId(), PRODUCT_ID);
        assertEquals(savedProductDTO.getAmount(), product.getAmount());
        assertEquals(savedProductDTO.getName(), product.getName());
        assertEquals(savedProductDTO.getPrice(), product.getPrice());
    }
}
