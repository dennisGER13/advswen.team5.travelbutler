package advswen.team5.travelbutler.output;

import java.awt.Color;
import java.io.File;
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

import advswen.team5.travelbutler.api.response.Response;

public class PDFGeneratorV1 {

	private Response response;

	private PDRectangle mediabox;
	private float marginX = 50;
	private float marginY = 70;
	private float width;
	private float startX;
	private float startY;

	public PDFGeneratorV1(Response response) {
		this.response = response;
	}

	public void generate() throws Exception {
		String outputFileName = response.getDestination() + ".pdf";

		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page1 = new PDPage(PDRectangle.A4);
	    mediabox = page1.getMediaBox();
	    width = mediabox.getWidth() - 2*marginX;
	    startX = mediabox.getLowerLeftX() + marginX;
	    startY = mediabox.getUpperRightY() - marginX;
		document.addPage(page1);

		// Create a new font object selecting one of the PDF base fonts
		PDType0Font fontPlain = PDType0Font.load(document, new File("src/main/resources/arial.ttf"));
		
		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream cos = new PDPageContentStream(document, page1);

		int line = 0;

		cos.beginText();
		cos.setFont(fontPlain, 18);
		cos.newLineAtOffset(marginX, mediabox.getHeight() - marginY);
		cos.showText("Ihre Reise nach " + response.getDestination());
		cos.endText();
		line++;

		if (!response.getWikipediaResponse().isMissing()) {
			List<String> lines = getLines(prepareText(response.getWikipediaResponse().getExtract(), true), 12, fontPlain);
			cos.beginText();
			cos.setFont(fontPlain, 12);
			cos.newLineAtOffset(marginX, mediabox.getHeight() - 50 * (++line));
			for (String textLine: lines)
		    {
				cos.showText(textLine);
				cos.moveTextPositionByAmount(0, -1.3f*12);
		    }
			cos.endText();
		}

		// Make sure that the content stream is closed:
		cos.close();

		// Save the results and ensure that the document is properly closed:
		document.save(outputFileName);
		document.close();
	}
	
	private String prepareText(String text, boolean removeBrackets){
		text = text.replaceAll("[_[^\\w\\däüöÄÜÖß\\[\\]\\(\\)\\+\\-\\.\\,\\;\\:\\?\\! ]]", "");
		if(removeBrackets)
			text = text.replaceAll("\\(.*?\\)","");
		
		return text;
	}
	
	private List<String> getLines (String text, int fontSize, PDType0Font font) throws Exception{
		List<String> lines = new ArrayList<String>();
	    int lastSpace = -1;
	    while (text.length() > 0)
	    {
	        int spaceIndex = text.indexOf(' ', lastSpace + 1);
	        if (spaceIndex < 0)
	            spaceIndex = text.length();
	        String subString = text.substring(0, spaceIndex);
	        float size = fontSize * font.getStringWidth(subString) / 1000;
	        System.out.printf("'%s' - %f of %f\n", subString, size, width);
	        if (size > width)
	        {
	            if (lastSpace < 0)
	                lastSpace = spaceIndex;
	            subString = text.substring(0, lastSpace);
	            lines.add(subString);
	            text = text.substring(lastSpace).trim();
	            System.out.printf("'%s' is line\n", subString);
	            lastSpace = -1;
	        }
	        else if (spaceIndex == text.length())
	        {
	            lines.add(text);
	            System.out.printf("'%s' is line\n", text);
	            text = "";
	        }
	        else
	        {
	            lastSpace = spaceIndex;
	        }
	    }
	    return lines;
	}

}
