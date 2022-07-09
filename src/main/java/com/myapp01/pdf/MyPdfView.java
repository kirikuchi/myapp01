package com.myapp01.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.myapp01.entity.EmployeeEntity;

public class MyPdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// get font path for local
//		String currentPath = this.getClass().getClassLoader().getResource(".").toString();
//		currentPath = currentPath.replaceAll("file:", "");
//		final String fontFile = currentPath + "com/myapp01/pdf/ipaexg.ttf";
		
		// get font path for heroku
		final String fontFile = "/app/src/main/java/com/myapp01/pdf/ipaexg.ttf";
		
		BaseFont cnFont = BaseFont.createFont(fontFile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font font = new Font(cnFont, 10, Font.NORMAL);
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) model.get("employeeList");
		
		Table table = getNewTable(employeeList.size());
		setTableHeader(table, font);
		
		int rowCounter = 0;
		int rowPerPage = 24;
		for (EmployeeEntity employeeEntity : employeeList) {
			table.addCell(new Paragraph(employeeEntity.getEmpId(), font));
			table.addCell(new Paragraph(employeeEntity.getLastName(), font));
			table.addCell(new Paragraph(employeeEntity.getFastName(), font));
			table.addCell(new Paragraph(employeeEntity.getLastNameKana(), font));
			table.addCell(new Paragraph(employeeEntity.getFastNameKana(), font));
			table.addCell(new Paragraph(employeeEntity.getGender(), font));
			table.addCell(new Paragraph(employeeEntity.getBirthday(), font));
			table.addCell(new Paragraph(employeeEntity.getBloodType(), font));
			
			if (++rowCounter == rowPerPage) {
				rowCounter = 0;
				doc.add(table);
				table = getNewTable(employeeList.size());
				setTableHeader(table, font);
				doc.newPage();
			}
		}

		if (rowCounter < rowPerPage) {
			doc.add(table);
		}
	}
	
	private Table getNewTable (int colSize) {
		Table table = new Table(8, colSize);
		table.setPadding(5);
		table.setWidth(110);
		table.setWidths(new float[] {150, 150, 150, 150, 150, 100, 200, 100});
		return table;
	}
	
	private void setTableHeader (Table table, Font font) {
		table.addCell(new Paragraph("従業員ID", font));
		table.addCell(new Paragraph("姓", font));
		table.addCell(new Paragraph("名", font));
		table.addCell(new Paragraph("姓（カナ）", font));
		table.addCell(new Paragraph("名（カナ）", font));
		table.addCell(new Paragraph("性別", font));
		table.addCell(new Paragraph("誕生日", font));
		table.addCell(new Paragraph("血液型", font));
	}
}
