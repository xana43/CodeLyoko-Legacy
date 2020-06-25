package io.github.elsopeen.lyokomod.world.template;

public class Processors {
    /**
     * Processor that causes stone to be replaced with a different type to prevent it being overwritten by other generation.
     */
    public static final StoneReplacementStructureProcessor STONE_REPLACEMENT_PROCESSOR = new StoneReplacementStructureProcessor();

}
