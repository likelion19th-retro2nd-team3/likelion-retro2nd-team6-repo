package org.example.restexam.service;


import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Product;
import org.example.restexam.dto.ProductDto;
import org.example.restexam.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        /* ----------------------------------- DTO에 변환 메서드를 만들기 전

        // DTO를 엔티티에 담아서
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();

        // Repository에 전달
        Product savedProduct = productRepository.save(product);

        // 전달한 엔티티를 다시 DTO로 변환해 리턴
        return ProductDto.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .build();
        */

        /* ----------------------------------- DTO에 변환 메서드를 만든 후 */

        // DTO -> Entity 변환
        Product product = ProductDto.fromDto(productDto);
        // 변환된 Entity를 Repository에 전달
        Product saveProduct = productRepository.save(product);
        // 전달된 Entity를 DTO로 변환하여 return
        return ProductDto.fromEntity(saveProduct);
    }

    // 상품 리스트
    public List<ProductDto> getProducts() {
        // TODO: 코드 해석
        return productRepository.findAll().stream().map(ProductDto::fromEntity).toList();
    }

    // 상품 조회
    public ProductDto getProduct(Long id) {
        // TODO: 코드 해석
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductDto.fromEntity(product);
    }

    // 상품 수정
    @Transactional
    public ProductDto updateProduct(ProductDto productDto) {
        // TODO: 코드 해석
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (productDto.getName() != null) {
            // TODO 여기는 왜 set?
            product.setName(productDto.getName());
        }

        if (productDto.getPrice() != 0) {
            product.setPrice(productDto.getPrice());
        }

        return ProductDto.fromEntity(product);
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

}
