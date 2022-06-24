package com.simbirsoft.files.tests;

import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ZipWithPasswordFileTest {

    @Test
    void checkZipWithPasswordFile() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<String> txtLines = new ArrayList<>();
        String line;
        InputStream stream = classLoader.getResourceAsStream("zip/zip_with_password_sample.zip");
        try (ZipInputStream zipInputStream = new ZipInputStream(stream, "IHaveAPassword".toCharArray())){
            LocalFileHeader localFileHeader;
            InputStreamReader streamReader = new InputStreamReader(zipInputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
                while ((line = reader.readLine()) != null) {
                    txtLines.add(line);
                }
            }
        }

        Assertions.assertTrue(txtLines.contains("Serial number: X41822N"));
        Assertions.assertTrue(txtLines.contains("Name: November Annabelle Terra"));
        Assertions.assertTrue(txtLines.contains("Gender: Female"));
        Assertions.assertTrue(txtLines.contains("Date of birth: January 15, 2485"));
        Assertions.assertTrue(txtLines.contains("Place of birth: Tarsonis"));
        Assertions.assertTrue(txtLines.contains("Recruiter: Malcolm Kelerchian"));
        Assertions.assertTrue(txtLines.contains("Psi Index: 10"));
        Assertions.assertTrue(txtLines.contains("Armament: C-20A rifle"));
        Assertions.assertTrue(txtLines.contains("Status: AWOL"));
    }
}
