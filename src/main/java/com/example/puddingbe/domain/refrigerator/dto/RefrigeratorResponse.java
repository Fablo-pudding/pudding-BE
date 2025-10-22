import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RefrigeratorResponse {
    private List<IngredientInfo> ingredients;

    public static RefrigeratorResponse from(List<Ingredient> ingredients) {
        List<IngredientInfo> list = ingredients.stream()
                .map(ingredient -> new IngredientInfo(
                        ingredient.getType().toString(),
                        ingredient.getLevel().toString()
                ))
                .toList();

        return RefrigeratorResponse.builder()
                .ingredients(list)
                .build();
    }

    @Getter
    @AllArgsConstructor
    public static class IngredientInfo {
        private String type;
        private String level;
    }
}