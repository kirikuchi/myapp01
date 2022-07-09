package com.myapp01.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class MyPdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

//		String currentPath = this.getClass().getClassLoader().getResource(".").toString();
//		currentPath = currentPath.replaceAll("file:", "");

//		final String fontFile = currentPath + "com/myapp01/pdf/ipaexg.ttf";
		final String fontFile = "/app/src/main/java/com/myapp01/pdf/ipaexg.ttf";
		
		BaseFont cnFont = BaseFont.createFont(fontFile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		List<String> words = (List<String>) model.get("wordList");
		for (String word : words) {
			doc.add(new Paragraph(word, new Font(cnFont, 12, Font.NORMAL)));
		}

		Table table = new Table(2, 2);
		table.addCell(new Paragraph("first cell"));
		table.addCell(new Paragraph("second cell"));
		table.addCell(new Paragraph("third cell"));
		table.addCell(new Paragraph("test"));

		doc.add(table);
	}
}
