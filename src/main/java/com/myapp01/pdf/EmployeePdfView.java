package com.myapp01.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.myapp01.entity.EmployeeEntity;

public class EmployeePdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// get font path for local
//		String currentPath = this.getClass().getClassLoader().getResource(".").toString();
//		currentPath = currentPath.replaceAll("file:", "");
//		final String fontFile = currentPath + "com/myapp01/pdf/ipaexg.ttf";
		
		// get font path for heroku
		final String fontFile = "/app/src/main/java/com/myapp01/pdf/ipaexg.ttf";
		
		BaseFont baseFont = BaseFont.createFont(fontFile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont, 10, Font.NORMAL);
		Font fontHeader = new Font(baseFont, 14, Font.NORMAL);
		
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) model.get("employeeList");
		int rowCounter = 0;
		int rowPerPage = 50;
		for (EmployeeEntity employeeEntity : employeeList) {
			if (rowCounter == 0) {
				addHeader(doc, fontHeader);
				addEmptyLine(doc, font);
				addTableHeader(doc, font);					
			}
			addTableCell(doc, employeeEntity, font);
			if (++rowCounter == rowPerPage) {
				rowCounter = 0;
				doc.newPage();
			}
		}
		doc.close();
	}
	
	private void addHeader (Document doc, Font font) {
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(110);
		PdfPCell cell = new PdfPCell(new Phrase("社員一覧", font));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		cell.setBorder(0);
		table.addCell(cell);
		doc.add(table);
	}
	
	private void addEmptyLine (Document doc, Font font) {
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(110);
		PdfPCell cell = new PdfPCell(new Phrase("　", font));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		cell.setBorder(0);
		table.addCell(cell);
		doc.add(table);
	}
	
	private void addTableHeader (Document doc, Font font) {
		PdfPTable table = new PdfPTable(8);
		table.setWidths(new float[] {200, 200, 200, 200, 200, 200, 200, 200});
		table.setWidthPercentage(110);
		
		table.addCell(createTableHeaderCell("従業員ID", font));
		table.addCell(createTableHeaderCell("姓", font));
		table.addCell(createTableHeaderCell("名", font));
		table.addCell(createTableHeaderCell("姓（カナ）", font));
		table.addCell(createTableHeaderCell("名（カナ）", font));
		table.addCell(createTableHeaderCell("性別", font));
		table.addCell(createTableHeaderCell("誕生日", font));
		table.addCell(createTableHeaderCell("血液型", font));
		
		doc.add(table);
	}
	
	private void addTableCell (Document doc, EmployeeEntity employeeEntity, Font font) {
		PdfPTable table = new PdfPTable(8);
		table.setWidths(new float[] {200, 200, 200, 200, 200, 200, 200, 200});
		table.setWidthPercentage(110);
		
		table.addCell(createTableCell(employeeEntity.getEmpId(), font));
		table.addCell(createTableCell(employeeEntity.getLastName(), font));
		table.addCell(createTableCell(employeeEntity.getFastName(), font));
		table.addCell(createTableCell(employeeEntity.getLastNameKana(), font));
		table.addCell(createTableCell(employeeEntity.getFastNameKana(), font));
		table.addCell(createTableCell(employeeEntity.getGender(), font));
		table.addCell(createTableCell(employeeEntity.getBirthday(), font));
		table.addCell(createTableCell(employeeEntity.getBloodType(), font));
		doc.add(table);
	}
	
	private PdfPCell createTableHeaderCell (String text, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBackgroundColor(new Color(200, 200, 200));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		return cell;
	}
	
	private PdfPCell createTableCell (String text, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBackgroundColor(new Color(255, 255, 255));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		return cell;
	}
}
