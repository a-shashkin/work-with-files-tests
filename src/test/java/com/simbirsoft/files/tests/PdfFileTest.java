package com.simbirsoft.files.tests;

import org.junit.jupiter.api.Test;
import com.codeborne.pdftest.PDF;

import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;

public class PdfFileTest {

    @Test
    void checkPdfFile() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("Test_PDF_document.pdf");
        PDF pdfFile = new PDF(stream);
        assertThat(pdfFile, PDF.containsText("Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium " +
                "doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae " +
                "vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, " +
                "sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, " +
                "qui dolorem ipsum, quia dolor sit, amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora " +
                "incidunt, ut labore et dolore magnam aliquam quaerat voluptatem."));
    }
}
