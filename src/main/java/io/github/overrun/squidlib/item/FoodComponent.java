package io.github.overrun.squidlib.item;

import net.minecraft.potion.PotionEffect;

/**
 * @author squid233
 * @since 2020/10/10
 */
public interface FoodComponent {
    int getHunger();

    default float getSaturation() {
        return 0.6F;
    }

    boolean isMeat();

    boolean isAlwaysEdible();

    PotionEffect getPotionEffect();

    float getProbability();

    class Builder {
        private int hunger;
        private float saturation;
        private boolean isMeat;
        private boolean isAlwaysEdible;
        private PotionEffect potionEffect;
        private float probability;

        public Builder hunger(int hunger) {
            this.hunger = hunger;
            return this;
        }

        public Builder saturation(float saturation) {
            this.saturation = saturation;
            return this;
        }

        public Builder meat() {
            isMeat = true;
            return this;
        }

        public Builder setAlwaysEdible() {
            isAlwaysEdible = true;
            return this;
        }

        public Builder setPotionEffect(PotionEffect potionEffect, float probability) {
            this.potionEffect = potionEffect;
            this.probability = probability;
            return this;
        }

        public FoodComponent build() {
            return new FoodComponent() {
                @Override
                public int getHunger() {
                    return hunger;
                }

                @Override
                public float getSaturation() {
                    return saturation;
                }

                @Override
                public boolean isMeat() {
                    return isMeat;
                }

                @Override
                public boolean isAlwaysEdible() {
                    return isAlwaysEdible;
                }

                @Override
                public PotionEffect getPotionEffect() {
                    return potionEffect;
                }

                @Override
                public float getProbability() {
                    return probability;
                }
            };
        }
    }
}
