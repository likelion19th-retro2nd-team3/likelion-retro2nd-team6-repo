package org.example.restexam.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.restexam.domain.Product;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductDto {

    private Long id;
    @NotBlank(message = "상품명을 입력 해 주세요.")
    private String name;
    @Min(value = 1, message = "가격은 1이상 입력 해 주세요.")
    private int price;

    // DTO -> Entity 변환 메서드
    public static Product fromDto(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }

    // Entity -> DTO 변환 메서드
    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
