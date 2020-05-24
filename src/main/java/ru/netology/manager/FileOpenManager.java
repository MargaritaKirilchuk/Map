package ru.netology.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FileOpenManager {
    private Map<String, String> extensionApp = new HashMap<String, String>();

    public FileOpenManager(Map<String, String> extensionApp) {
        this.extensionApp = extensionApp;
    }

    public void addApp(String extension, String app) {
        extensionApp.put(extension.toLowerCase(), app.toLowerCase());
    }

    public String getAppByExtension(String extension) {
        return extensionApp.get(extension.toLowerCase());
    }

    public void deleteApp(String extension) {
        extensionApp.remove(extension.toLowerCase());
    }

    public Set<String> getExtensionWithApp() {
        Set<String> result = new TreeSet<String>();
        for (String k : extensionApp.keySet()) {
            result.add(k);
        }
        return result;
    }

    public Set<String> getAppWithExtension() {
        Set<String> result = new TreeSet<String>();
        for (String k : extensionApp.values()) {
            result.add(k);
        }
        return result;
    }
}
