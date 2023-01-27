package com.Ultra_Nerd.CodeLyokoLegacy.util.Models;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import me.x150.renderer.objfile.ObjFile;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public record GlobalOBJModels() {
    public static ObjFile LYOKO_CORE;

    static
    {
        try {
            LYOKO_CORE =
                    new ObjFile(new FileInputStream(CodeLyokoMain.codeLyokoPrefix("models/block/core_of_lyoko.obj").toString()));
            LYOKO_CORE.linkMaterialFile(new File("A:\\CodeLyoko 1.18.2\\CodeLyoko-Fabric\\CodeLyoko-Legacy-FABRIC\\src\\main\\resources\\assets\\cm\\models\\block\\core_of_lyoko.mtl"));
            LYOKO_CORE.read();

        } catch (final IOException e) {
            CodeLyokoMain.LOG.info("failed to load obj ",e);

        }
    }

    public GlobalOBJModels {
        throw new UnsupportedOperationException();
    }
    public static void loadModels()
    {

    }
}
