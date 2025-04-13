package com.sawwik.imgurbook;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageManager {

    private final UUID playerUUID;
    private final Map<String, Object> settings;

    public StorageManager(UUID playerUUID) {
        this.playerUUID = playerUUID;
        this.settings = new HashMap<>();
    }

    public void saveSetting(String key, Object value) {
        settings.put(key, value);
    }

    public Object getSetting(String key) {
        return settings.get(key);
    }

    public String getUrl() {
        return (String) settings.getOrDefault("url", null);
    }

    public int getWidth() {
        return (int) settings.getOrDefault("width", 100);
    }

    public int getHeight() {
        return (int) settings.getOrDefault("height", 100);
    }
}