package com.Ultra_Nerd.CodeLyokoLegacy.util.enums;

public enum TranslatedLocale {
    EN_US("en_us"),
    FR_FR("fr_fr");
    private final String name;
    TranslatedLocale(final String name)
    {
        this.name = name;
    }
    private void validate()
    {

    }
    public String getName()
    {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
