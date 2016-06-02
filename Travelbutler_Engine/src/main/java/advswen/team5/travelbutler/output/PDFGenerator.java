package advswen.team5.travelbutler.output;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import advswen.team5.travelbutler.api.response.Response;
import twitter4j.Status;

public class PDFGenerator {

	private Response response;

	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

	public PDFGenerator(Response response) {
		this.response = response;
	}

	public void generate() throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(response.getDestination() + ".pdf"));
		document.open();
		document.addTitle("Ihre Reise nach " + response.getDestination());

		Paragraph headline = new Paragraph();
		addEmptyLine(headline, 1);
		headline.add(new Paragraph("Ihre Reise nach " + response.getDestination(), catFont));
		addEmptyLine(headline, 1);
		document.add(headline);

		addWikipediaInfo(document);
		addTweets(document, 10);

		document.close();
	}

	private void addWikipediaInfo(Document document) throws DocumentException {
		if (response.getWikipediaResponse().isMissing())
			return;

		Paragraph wikipedia = new Paragraph(response.getWikipediaResponse().getExtract(), normalFont);
		document.add(wikipedia);
	}

	private void addTweets(Document document, int numOfTweets) throws DocumentException {
		if (response.getTwitterResponse().isMissing())
			return;
		
		PdfPTable table = new PdfPTable(2);
		
		for (Status tweet : response.getTwitterResponse().getTweets()){
			table.addCell(tweet.getUser().getScreenName());
			table.addCell(tweet.getText());
		}
		
		document.add(table);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
