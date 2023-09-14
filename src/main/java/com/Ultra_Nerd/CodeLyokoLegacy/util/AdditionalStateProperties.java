package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.state.property.Property;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public record AdditionalStateProperties() {
    public static class FloatProperty extends Property<Float>
    {
        private final ImmutableSet<Float> values;
        private final int min,max;
        protected FloatProperty(final String name, final int min, final int max) {
            super(name, Float.class);
            if (min < 0) {
                throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
            } else if (max <= min) {
                throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
            } else {
                this.min = min;
                this.max = max;
                final Set<Float> set = Sets.newHashSet();

                for(float i = min; i <= max; ++i) {
                    set.add(i);
                }

                this.values = ImmutableSet.copyOf(set);
            }
        }

        @Override
        public Collection<Float> getValues() {
            return this.values;
        }


        @Override
        public boolean equals(final Object o) {
            if(this == o)
            {
                return true;
            } else if (o instanceof final FloatProperty floatProperty && super.equals(o)) {
                return this.values.equals(floatProperty.values);
            }
            return false;
        }

        @Override
        public int computeHashCode() {
            return 31*super.computeHashCode()+this.values.hashCode();
        }
        public static FloatProperty of(final String name,final int min, final int max)
        {
            return new FloatProperty(name, min, max);
        }

        @Override
        public Optional<Float> parse(final String name)
        {
            try {

                final float floatVar = Float.parseFloat(name);
                return floatVar >= this.min && floatVar <= this.max ? Optional.of(floatVar) : Optional.empty();
            } catch (final NumberFormatException err)
            {
                return Optional.empty();
            }
        }


        @Override
        public String name(final Float value) {
            return value.toString();
        }


    }
    public static class DoubleProperty extends Property<Double>
    {
        private final ImmutableSet<Double> values;
        private final double min,max;
        protected DoubleProperty(final String name, final double min, final double max) {
            super(name, Double.class);
            if (min < 0) {
                throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
            } else if (max <= min) {
                throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
            } else {
                this.min = min;
                this.max = max;
                final Set<Double> set = Sets.newHashSet();

                for(double i = min; i <= max; ++i) {
                    set.add(i);
                }

                this.values = ImmutableSet.copyOf(set);
            }
        }

        @Override
        public Collection<Double> getValues() {
            return this.values;
        }


        @Override
        public boolean equals(final Object o) {
            if(this == o)
            {
                return true;
            } else if (o instanceof final DoubleProperty doubleProperty && super.equals(o)) {
                return this.values.equals(doubleProperty.values);
            }
            return false;
        }

        @Override
        public int computeHashCode() {
            return 31*super.computeHashCode()+this.values.hashCode();
        }
        public static DoubleProperty of(final String name,final int min, final int max)
        {
            return new DoubleProperty(name, min, max);
        }

        @Override
        public Optional<Double> parse(final String name)
        {
            try {

                final double doubleVar = Double.parseDouble(name);
                return doubleVar >= this.min && doubleVar <= this.max ? Optional.of(doubleVar) : Optional.empty();
            } catch (final NumberFormatException err)
            {
                return Optional.empty();
            }
        }


        @Override
        public String name(final Double value) {
            return value.toString();
        }


    }
}
