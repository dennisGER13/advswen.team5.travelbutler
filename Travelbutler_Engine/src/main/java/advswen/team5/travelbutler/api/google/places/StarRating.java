package advswen.team5.travelbutler.api.google.places;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StarRating {

	private static BufferedImage[] sprites = null;
	private static int width = 100;
	private static int height = 36;
	private static int rows = 10;
	private static int cols = 1;
	
	public static BufferedImage getRatingStars(double rating){
		if(sprites == null){
			try {
				loadImages();
			} catch (IOException e) {
				return null;
			}
		}
		
		if(rating <= 0.5){
			return sprites[0];
		}else if(rating <= 1){
			return sprites[1];
		}else if(rating <= 1.5){
			return sprites[2];
		}else if(rating <= 2){
			return sprites[3];
		}else if(rating <= 2.5){
			return sprites[4];
		}else if(rating <= 3){
			return sprites[5];
		}else if(rating <= 3.5){
			return sprites[6];
		}else if(rating <= 4){
			return sprites[7];
		}else if(rating <= 4.5){
			return sprites[8];
		}else{
			return sprites[9];
		}
	}
	
	private static void loadImages() throws IOException{
		BufferedImage bigImg = ImageIO.read(new File("src/main/resources/star_ratings.gif"));
		// The above line throws an checked IOException which must be caught.

		sprites = new BufferedImage[rows * cols];

		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        sprites[(i * cols) + j] = bigImg.getSubimage(
		            j * width,
		            i * height,
		            width,
		            height
		        );
		    }
		}
	}
}
