package com.simbirsoft.files.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TxtFileTest {

    @Test
    void checkTxtFile() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("X41822N.txt");
        InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        String line;
        List<String> txtLines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            txtLines.add(line);
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
