package com.sawwik.imgurbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuideBookListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || item.getType() != Material.WRITTEN_BOOK) {
            return;
        }

        if (item.hasItemMeta() && item.getItemMeta().hasCustomModelData() &&
            item.getItemMeta().getCustomModelData() == 123456) { // ID для ideabook

            Player player = event.getPlayer();
            event.setCancelled(true);
            player.sendMessage("Открывается IdeaBook...");

            // Здесь можно добавить логику для открытия GUI или справочника
        }
    }

    public static ItemStack createIdeaBook() {
        ItemStack ideaBook = new ItemStack(Material.WRITTEN_BOOK);
        ItemMeta meta = ideaBook.getItemMeta();
        meta.setDisplayName("IdeaBook");
        meta.setCustomModelData(123456); // Уникальный ID для ideabook
        ideaBook.setItemMeta(meta);
        return ideaBook;
    }
}