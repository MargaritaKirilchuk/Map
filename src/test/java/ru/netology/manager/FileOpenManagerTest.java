package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private Map<String, String> extensionApp = new HashMap<String, String>();
    private FileOpenManager manager = new FileOpenManager(extensionApp);

    @Nested
    public class Empty {
        @Test
        void shouldAddApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put("psd", "adobephotoshop");
            manager.addApp("psd", "AdobePhotoshop");
            assertEquals(expected, extensionApp);
        }

        @Test
        void shouldGetAppByExtension() {
            assertNull(manager.getAppByExtension("png"));
        }

        @Test
        void shouldDeleteApp() {
            Map<String, String> expected = new HashMap<String, String>();
            assertEquals(expected, extensionApp);
        }

        @Test
        void shouldGetExtensionWithApp() {
            Set<String> expected = new TreeSet<String>();
            assertEquals(expected, manager.getExtensionWithApp());
        }

        @Test
        void shouldGetAppWithExtension() {
            Set<String> expected = new TreeSet<String>();
            assertEquals(expected, manager.getAppWithExtension());
        }
    }

    @Nested
    public class MultipleItem {

        @BeforeEach
        void setUp() {
            extensionApp.put("jpg", "paint");
            extensionApp.put("doc", "word");
            extensionApp.put("psd", "adobePhotoshop");
            extensionApp.put("html", "googleChrome");
        }

        @Test
        void shouldAddApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put("jpg", "paint");
            expected.put("doc", "word");
            expected.put("psd", "adobePhotoshop");
            expected.put("html", "googleChrome");
            manager.addApp("doc", "word");
            assertEquals(expected, extensionApp);
        }

        @Test
        void shouldGetAppByExtension() {
            String expected = "googleChrome";
            assertEquals(expected, manager.getAppByExtension("html"));
        }

        @Test
        void shouldDeleteApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put("jpg", "paint");
            expected.put("psd", "adobePhotoshop");
            expected.put("html", "googleChrome");
            manager.deleteApp("doc");
            assertEquals(expected, extensionApp);
        }

        @Test
        void shouldGetExtensionWithApp() {
            Set<String> expected = new TreeSet<String>();
            expected.add("jpg");
            expected.add("doc");
            expected.add("psd");
            expected.add("html");
            assertEquals(expected, manager.getExtensionWithApp());
        }

        @Test
        void shouldGetAppWithExtension() {
            Set<String> expected = new TreeSet<String>();
            expected.add("adobePhotoshop");
            expected.add("googleChrome");
            expected.add("paint");
            expected.add("word");
            assertEquals(expected, manager.getAppWithExtension());
        }
    }

}