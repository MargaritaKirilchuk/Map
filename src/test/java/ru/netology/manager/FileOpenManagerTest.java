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
    private FileOpenManager manager = new FileOpenManager();
    private String psd = "psd";
    private String jpg = "jpg";
    private String doc = "doc";
    private String html = "html";
    private String adobePhotoshop = "adobephotoshop";
    private String paint = "paint";
    private String word = "word";
    private String googleChrome = "googlechrome";
    private String png = "png";




    @Nested
    public class Empty {
        @Test
        void shouldAddApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put(psd, adobePhotoshop);
            manager.addApp(psd, adobePhotoshop);
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetAppByExtension() {
            assertNull(manager.getAppByExtension(png));
        }

        @Test
        void shouldDeleteApp() {
            Map<String, String> expected = new HashMap<String, String>();
            assertEquals(expected, manager.getAllMap());
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
            manager.addApp(jpg, paint);
            manager.addApp(doc, word);
            manager.addApp(psd, adobePhotoshop);
            manager.addApp(html, googleChrome);
        }

        @Test
        void shouldAddApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put(jpg, paint);
            expected.put(doc, word);
            expected.put(psd, adobePhotoshop);
            expected.put(html, googleChrome);
            manager.addApp(doc, word);
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetAppByExtension() {
            String expected = googleChrome;
            assertEquals(expected, manager.getAppByExtension(html));
        }

        @Test
        void shouldDeleteApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put(jpg, paint);
            expected.put(psd, adobePhotoshop);
            expected.put(html, googleChrome);
            manager.deleteApp(doc);
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetExtensionWithApp() {
            Set<String> expected = new TreeSet<String>();
            expected.add(jpg);
            expected.add(doc);
            expected.add(psd);
            expected.add(html);
            assertEquals(expected, manager.getExtensionWithApp());
        }

        @Test
        void shouldGetAppWithExtension() {
            Set<String> expected = new TreeSet<String>();
            expected.add(adobePhotoshop);
            expected.add(googleChrome);
            expected.add(paint);
            expected.add(word);
            assertEquals(expected, manager.getAppWithExtension());
        }
    }

}