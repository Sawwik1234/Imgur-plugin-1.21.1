package com.sawwik.imgurbook;

import org.bukkit.plugin.java.JavaPlugin;

public class ImgurBookPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ImgurBook плагин активирован!");

        // Регистрация обработчиков событий
        getServer().getPluginManager().registerEvents(new GuideBookListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("ImgurBook плагин деактивирован!");
    }
}