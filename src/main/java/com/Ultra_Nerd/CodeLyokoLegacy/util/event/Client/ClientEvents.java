package com.Ultra_Nerd.CodeLyokoLegacy.util.event.Client;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public record ClientEvents() {


    public static final Event<ClientEvents.onLanguageChanged> ON_LANGUAGE_CHANGED_EVENT = EventFactory.createArrayBacked(onLanguageChanged.class,
            (listener) -> () ->{

                for(final onLanguageChanged changed : listener)
                {
                    changed.languageChanged();
                }

            });

    @FunctionalInterface
    public interface onLanguageChanged {
        void languageChanged();
    }
}
