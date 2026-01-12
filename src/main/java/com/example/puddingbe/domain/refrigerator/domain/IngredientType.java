package com.example.puddingbe.domain.refrigerator.domain;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;

public enum IngredientType {

    EGG {
        @Override
        public void apply(Ingredient ingredient) {
            ingredient.addEgg(1);
        }
    },
    MILK {
        @Override
        public void apply(Ingredient ingredient) {
            ingredient.addMilk(1);
        }
    },
    SUGAR {
        @Override
        public void apply(Ingredient ingredient) {
            ingredient.addSugar(1);
        }
    };

    public abstract void apply(Ingredient ingredient);
}
