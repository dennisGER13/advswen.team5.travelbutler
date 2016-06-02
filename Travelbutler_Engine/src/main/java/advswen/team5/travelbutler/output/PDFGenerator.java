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
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import advswen.team5.travelbutler.api.response.Response;
import twitter4j.Status;

public class PDFGenerator {

	private Response response;

	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
	private static Font highlightFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);

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

		Paragraph twitter = new Paragraph();
		addEmptyLine(twitter, 1);
		List<Status> tweets = response.getTwitterResponse().getTweets();

		float[] columnWidths = { 1, 4 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);

		int counter;
		if (tweets.size() > numOfTweets) {
			counter = numOfTweets;
		} else {
			counter = tweets.size();
		}

		for (int i = 0; i <= counter; i++) {
			Status tweet = tweets.get(i);
			PdfPCell cell = new PdfPCell(new Phrase(tweet.getUser().getScreenName(), highlightFont));
			cell.setBackgroundColor(new BaseColor(64,153,255));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPadding(5);
			cell.setBorderWidth(3);
			cell.setBorderColor(BaseColor.WHITE);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(tweet.getText()));
			cell.setPadding(5);
			cell.setBorderWidth(3);
			cell.setBorderColor(BaseColor.WHITE);
			table.addCell(cell);
		}
		

		twitter.add(table);
		document.add(twitter);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
