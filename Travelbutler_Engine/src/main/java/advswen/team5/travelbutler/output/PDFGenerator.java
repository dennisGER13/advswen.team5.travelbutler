package advswen.team5.travelbutler.output;

/*
 * Andreas Tauscher
 */

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination;
import twitter4j.Status;

public class PDFGenerator {

	private Response response;

	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font subcatFont = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
	private static Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
	private static Font normalFont_invert = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.WHITE);
	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.WHITE);
	private static Font highlightFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
	private static Font highlightFont_invert = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
	private static Font largeHighlightFont_invert = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.WHITE);

	private static DateFormat df = DateFormat.getDateTimeInstance( /* dateStyle */ DateFormat.MEDIUM,
			/* timeStyle */ DateFormat.SHORT);
	private static DecimalFormat round3 = new DecimalFormat("##0.000");
	
	private static String[] exchangeRates = {"US Dollar", "Euro", "Pound Sterling", "Yen", "Canadian Dollar"};

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
		addGoodToKnow(document);
		addHealth(document);
		addTweets(document, 10);

		document.close();
		System.out.println("Finished");
	}

	private void addWikipediaInfo(Document document) throws Exception {
		if (response.getWikipediaResponse() == null || response.getWikipediaResponse().isMissing())
			return;

		Paragraph wikipedia = new Paragraph();
		wikipedia.add(generateSubCategory("About your destination", "src/main/resources/icons/map.png"));
		wikipedia.add(new Paragraph(response.getWikipediaResponse().getShortExtract(1500), normalFont));
		document.add(wikipedia);
	}

	private void addTweets(Document document, int numOfTweets) throws Exception {
		if (response.getTwitterResponse() == null || response.getTwitterResponse().isMissing()) {
			return;
		}

		Paragraph twitter = new Paragraph();
		addEmptyLine(twitter, 1);
		twitter.add(generateSubCategory("What our partners recommend for your stay in " + response.getDestination(),
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

	private void addGoodToKnow(Document document) throws Exception {
		if (response.getTravelbriefingResponse() == null || response.getTravelbriefingResponse().isMissing()) {
			return;
		}

		float[] columnWidths = { 1, 1, 1, 1, 1, 1 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);
		PdfPCell cell;

		// ##############
		// ## Language ##
		// ##############

		cell = new PdfPCell(new Phrase("Language", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		TravelbriefingLanguage[] languages = response.getTravelbriefingResponse().getLanguage();
		String languagePhrase = "";
		for (TravelbriefingLanguage language : languages) {
			languagePhrase += language.getLanguage();
			if (language.getOfficial().equals("Yes"))
				languagePhrase += " (official)";
			languagePhrase += ", ";
		}

		cell = new PdfPCell(new Phrase(languagePhrase.substring(0, languagePhrase.length() - 2), normalFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setColspan(5);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		// ##############
		// ## Timezone ##
		// ##############

		cell = new PdfPCell(new Phrase("Timezone", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(response.getTravelbriefingResponse().getTimezone().getName(), normalFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setColspan(5);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		// ##############
		// ## Currency ##
		// ##############

		cell = new PdfPCell(new Phrase("Currency", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(response.getTravelbriefingResponse().getCurrency().getName(), normalFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setColspan(5);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		// ####################
		// ## Exchange Rates ##
		// ####################

		cell = new PdfPCell(new Phrase("Rates", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);
		
		TravelbriefingCurrency currency = response.getTravelbriefingResponse().getCurrency();
		
		for(String exchangeRate : exchangeRates){
			cell = new PdfPCell();
			cell.addElement(new Phrase(exchangeRate, normalFont));
			cell.addElement(new Phrase(String.valueOf(round3.format(currency.getExchangeRate(exchangeRate))), normalFont));
			cell.setPadding(5);
			cell.setBorderWidth(3);
			cell.setBorderColor(BaseColor.WHITE);
			table.addCell(cell);
		}


		// #################
		// ## Electricity ##
		// #################

		cell = new PdfPCell(new Phrase("Electricity", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		cell = new PdfPCell();
		TravelbriefingElectricity electricity = response.getTravelbriefingResponse().getElectricity();
		Paragraph paragraph = new Paragraph(electricity.getVoltage() + " Volt", largeHighlightFont_invert);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(paragraph);
		paragraph = new Paragraph(electricity.getFrequency() + " Herz", normalFont_invert);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(paragraph);
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(8);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		for (int i = 0; i < 4; i++) {
			if (i < electricity.getPlugs().length) {
				cell = new PdfPCell();
				Image image = Image.getInstance(
						"src/main/resources/plugs/type_" + electricity.getPlugs()[i].toLowerCase() + ".jpg");
				cell = new PdfPCell(image, true);
				cell.setBorderWidth(3);
				cell.setPadding(5);
				cell.setBorderColor(BaseColor.WHITE);
				table.addCell(cell);
			} else {
				cell = new PdfPCell();
				cell.setBorderWidth(3);
				cell.setBorderColor(BaseColor.WHITE);
				table.addCell(cell);
			}
		}

		Paragraph goodToKnow = new Paragraph();
		addEmptyLine(goodToKnow, 1);
		goodToKnow.add(generateSubCategory("Good to know", "src/main/resources/icons/lightbulb.png"));
		goodToKnow.add(table);
		document.add(goodToKnow);

	}

	private void addHealth(Document document) throws Exception {
		if (response.getTravelbriefingResponse() == null || response.getTravelbriefingResponse().isMissing()) {
			return;
		}

		float[] columnWidths = { 1, 5 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Water", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Drinking tap water in " + response.getDestination() + " is "
				+ response.getTravelbriefingResponse().getWater().getShortDescription(), normalFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Vaccinations", highlightFont));
		cell.setPadding(5);
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);
		table.addCell(cell);

		TravelbriefingVaccination[] vacs = response.getTravelbriefingResponse().getVaccinations();
		cell = new PdfPCell();
		cell.setBorderWidth(3);
		cell.setBorderColor(BaseColor.WHITE);

		if (vacs.length == 0) {
			cell.addElement(new Phrase("There are no recommondations for " + response.getDestination(), normalFont));
		} else {
			for (TravelbriefingVaccination vac : vacs) {
				cell.addElement(new Phrase(vac.getName(), highlightFont));
				cell.addElement(new Phrase(vac.getMessage(), normalFont));
			}
		}
		table.addCell(cell);

		Paragraph health = new Paragraph();
		addEmptyLine(health, 1);
		health.add(generateSubCategory("Health and risks", "src/main/resources/icons/health.png"));
		health.add(table);
		document.add(health);
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
