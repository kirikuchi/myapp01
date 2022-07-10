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

/**
 * PDFデータ生成クラス
 */
public class EmployeePdfView extends AbstractPdfView {

	/**
	 * PDFデータ生成
	 */
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// ローカルPC用のフォントファイルのパス
//		String currentPath = this.getClass().getClassLoader().getResource(".").toString();
//		currentPath = currentPath.replaceAll("file:", "");
//		final String fontFile = currentPath + "com/myapp01/pdf/ipaexg.ttf";
		
		// Heroku用のフォントファイルのパス
		final String fontFile = "/app/src/main/java/com/myapp01/pdf/ipaexg.ttf";
		
		BaseFont baseFont = BaseFont.createFont(fontFile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		// 明細用フォント
		Font font = new Font(baseFont, 10, Font.NORMAL);
		// ヘッダ用フォント
		Font fontHeader = new Font(baseFont, 14, Font.NORMAL);
		
		// 社員情報リスト
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) model.get("employeeList");
		// 行数カウンタ
		int rowCounter = 0;
		// 1ページに出力可能な行数
		int rowPerPage = 50;
		
		for (EmployeeEntity employeeEntity : employeeList) {
			if (rowCounter == 0) {
				// 新規ページの場合はヘッダを出力する
				addHeader(doc, fontHeader);
				addEmptyLine(doc, font);
				addTableHeader(doc, font);					
			}
			// 社員情報を出力する
			addTableCell(doc, employeeEntity, font);
			if (++rowCounter == rowPerPage) {
				// 1ページに出力可能な行数に到達した場合は新規ページを追加する
				rowCounter = 0;
				doc.newPage();
			}
		}
		doc.close();
	}
	
	/**
	 * ヘッダを出力する
	 * @param doc ドキュメント
	 * @param font フォント
	 */
	private void addHeader (Document doc, Font font) {
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(110);
		PdfPCell cell = new PdfPCell(new Phrase("社員一覧", font));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		cell.setBorder(0);
		table.addCell(cell);
		doc.add(table);
	}
	
	/**
	 * 空白行を出力する
	 * @param doc ドキュメント
	 * @param font フォント
	 */
	private void addEmptyLine (Document doc, Font font) {
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(110);
		PdfPCell cell = new PdfPCell(new Phrase("　", font));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		cell.setBorder(0);
		table.addCell(cell);
		doc.add(table);
	}
	
	/**
	 * 明細ヘッダを出力する
	 * @param doc ドキュメント
	 * @param font フォント
	 */
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
	
	/**
	 * 明細を出力する
	 * @param doc ドキュメント
	 * @param employeeEntity 社員情報
	 * @param font フォント
	 */
	private void addTableCell (Document doc, EmployeeEntity employeeEntity, Font font) {
		PdfPTable table = new PdfPTable(8);
		table.setWidths(new float[] {200, 200, 200, 200, 200, 200, 200, 200});
		table.setWidthPercentage(110);
		
		table.addCell(createTableCell(employeeEntity.getEmpId(), font));
		table.addCell(createTableCell(employeeEntity.getLastName(), font));
		table.addCell(createTableCell(employeeEntity.getFirstName(), font));
		table.addCell(createTableCell(employeeEntity.getLastNameKana(), font));
		table.addCell(createTableCell(employeeEntity.getFirstNameKana(), font));
		table.addCell(createTableCell(employeeEntity.getGender(), font));
		table.addCell(createTableCell(employeeEntity.getBirthday(), font));
		table.addCell(createTableCell(employeeEntity.getBloodType(), font));
		doc.add(table);
	}
	
	/**
	 * 明細ヘッダ用のセルを生成する
	 * @param text テキスト
	 * @param font フォント
	 * @return 明細ヘッダ用のセル
	 */
	private PdfPCell createTableHeaderCell (String text, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBackgroundColor(new Color(200, 200, 200));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		return cell;
	}
	
	/**
	 * 明細用のセルを生成する
	 * @param text テキスト
	 * @param font フォント
	 * @return 明細用のセル
	 */
	private PdfPCell createTableCell (String text, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBackgroundColor(new Color(255, 255, 255));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER.getId());
		return cell;
	}
}
