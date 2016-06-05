package advswen.team5.travelbutler.output;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.DateFormat;
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

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList;
import twitter4j.Status;

public class PDFGenerator {

	private Response response;

	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font subcatFont = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
	private static Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.WHITE);
	private static Font highlightFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
	private static Font highlightFont_invert = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);

	private static DateFormat df = DateFormat.getDateTimeInstance( /* dateStyle */ DateFormat.MEDIUM,
			/* timeStyle */ DateFormat.SHORT);

	public PDFGenerator(Response response) {
		this.response = response;
	}

	public void generate() throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("output/" + response.getDestination() + ".pdf"));
		document.open();
		document.addTitle("Traveling to " + response.getDestination());

		Paragraph headline = new Paragraph();
		addEmptyLine(headline, 1);
		headline.add(new Paragraph("Traveling to " + response.getDestination(), catFont));
		addEmptyLine(headline, 1);
		document.add(headline);

		addTravelWarnings(document);
		addWikipediaInfo(document);
		addTweets(document, 10);

		document.close();
		System.out.println("Finished");
	}

	private void addWikipediaInfo(Document document) throws Exception {
		if (response.getWikipediaResponse() == null || response.getWikipediaResponse().isMissing())
			return;

		Paragraph wikipedia = new Paragraph();
		wikipedia.add(generateSubCategory("About your destination", "src/main/resources/icons/map.png"));
		wikipedia.add(new Paragraph(response.getWikipediaResponse().getExtract(), normalFont));
		document.add(wikipedia);
	}

	private void addTweets(Document document, int numOfTweets) throws Exception {
		if (response.getTwitterResponse() == null || response.getTwitterResponse().isMissing()) {
			return;
		}

		Paragraph twitter = new Paragraph();
		addEmptyLine(twitter, 1);
		twitter.add(generateSubCategory("Many customers already enjoy their stay in " + response.getDestination(),
				"src/main/resources/icons/twitter.png"));
		List<Status> tweets = response.getTwitterResponse().getTweets();

		float[] columnWidths = { 1, 2, 8 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);

		int counter;
		if (tweets.size() > numOfTweets) {
			counter = numOfTweets;
		} else {
			counter = tweets.size();
		}

		PdfPCell cell;
		for (int i = 0; i < counter; i++) {
			Status tweet = tweets.get(i);

			Image image = Image.getInstance(tweet.getUser().getBiggerProfileImageURL());
			cell = new PdfPCell(image, true);
			cell.setBorderWidth(3);
			cell.setPadding(2);
			cell.setBorderColor(BaseColor.WHITE);
			table.addCell(cell);

			cell = new PdfPCell();
			cell.addElement(new Phrase(tweet.getUser().getScreenName(), highlightFont_invert));
			cell.addElement(new Phrase(df.format(tweet.getCreatedAt()), smallFont));
			cell.setBackgroundColor(new BaseColor(64, 153, 255));
			cell.setPadding(5);
			cell.setBorderWidth(3);
			cell.setBorderColor(BaseColor.WHITE);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(tweet.getText(), normalFont));
			cell.setPadding(5);
			cell.setBorderWidth(3);
			cell.setBorderColor(BaseColor.WHITE);
			table.addCell(cell);
		}

		twitter.add(table);
		document.add(twitter);
	}

	private void addTravelWarnings(Document document) throws Exception {
		if (response.getTravelbriefingResponse() == null || response.getTravelbriefingResponse().isMissing()) {
			return;
		}

		TravelbriefingAdviseList warnings = response.getTravelbriefingResponse().getAdvise();

		// If there are no advises this part of the document is left out
		if (warnings.getAll().isEmpty())
			return;

		float[] columnWidths = { 1, 5 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);

		PdfPCell cell;
		Image image = Image.getInstance("src/main/resources/icons/warning.png");
		cell = new PdfPCell(image, true);
		cell.setBorderWidth(3);
		cell.setPadding(10);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		cell = new PdfPCell();
		cell.addElement(generateSubCategory("Safety advises"));
		for (TravelbriefingAdvise warning : warnings.getAll()) {
			cell.addElement(new Phrase(warning.getSource() + ": " + warning.getAdvise(), highlightFont));
			cell.addElement(new Phrase("More details: " + warning.getUrl(), normalFont));
			cell.addElement(new Phrase(" "));
		}
		cell.setBorderWidth(0);
		table.addCell(cell);

		Paragraph travelAdvise = new Paragraph();
		travelAdvise.add(table);
		document.add(travelAdvise);

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private static Paragraph generateSubCategory(String text) {
		return new Paragraph(text, subcatFont);
	}

	private static Paragraph generateSubCategory(String text, String icon) throws Exception {
		Paragraph paragraph = new Paragraph();
		Image image = Image.getInstance(icon);
		image.scaleToFit(15, 15);
		paragraph.add(new Chunk(image, 0, 0));
		paragraph.add(new Phrase(" " + text, subcatFont));
		return paragraph;
	}

}
