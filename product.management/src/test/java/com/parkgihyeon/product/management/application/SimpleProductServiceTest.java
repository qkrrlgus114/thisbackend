package com.parkgihyeon.product.management.application;

import com.parkgihyeon.product.management.domain.EntityNotFoundException;
import com.parkgihyeon.product.management.presentation.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class SimpleProductServiceTest {

    @Autowired
    SimpleProductService simpleProductService;

    @Test
    @DisplayName("상품을 추가한 후 id로 조회하면 해당 상품이 조회되어야 한다.")
    void productAddAndFindByIdTest(){
        // given
        ProductDTO productDTO = new ProductDTO("연필", 300, 20);

        // when
        ProductDTO savedProductDTO = simpleProductService.add(productDTO);
        Long id = savedProductDTO.getId();
        ProductDTO foundProductDTO = simpleProductService.findById(id);

        // then
        assertEquals(savedProductDTO.getId(), foundProductDTO.getId());
        assertEquals(savedProductDTO.getPrice(), foundProductDTO.getPrice());
        assertEquals(savedProductDTO.getAmount(), foundProductDTO.getAmount());
        assertEquals(savedProductDTO.getName(), foundProductDTO.getName());
    }

    @Test
    @DisplayName("존재하지 않는 상품을 id로 조회하면 EntityNotFoundException이 발생한다.")
    void findProductNotExistIdTest(){
        Long notExistId = -1L;

        assertThrows(EntityNotFoundException.class, () ->{
            simpleProductService.findById(notExistId);
        });
    }

}