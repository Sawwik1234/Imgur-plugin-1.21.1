package com.sawwik.imgurbook;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ImageSettingsGUI {

    private final StorageManager storageManager;

    public ImageSettingsGUI(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public void openImageSettings(Player player, String url, int width, int height) {
        Inventory gui = Bukkit.createInventory(null, 27, "Image Settings");

        ItemStack urlItem = createMenuItem(Material.PAPER, "Set URL", "Current: " + (url == null ? "None" : url));
        ItemStack widthItem = createMenuItem(Material.ARROW, "Set Width", "Current: " + width);
        ItemStack heightItem = createMenuItem(Material.ARROW, "Set Height", "Current: " + height);
        ItemStack saveItem = createMenuItem(Material.GREEN_WOOL, "Save Settings", "Click to save");

        gui.setItem(10, urlItem);
        gui.setItem(12, widthItem);
        gui.setItem(14, heightItem);
        gui.setItem(16, saveItem);

        player.openInventory(gui);
    }

    private ItemStack createMenuItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}