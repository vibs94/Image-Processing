package imageprocessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author B.K.D.Vibodha
 */

public class ImageHandler {
    
    private static ImageHandler imageHandler = null;
    private ArrayList<Image> images;
    
    private ImageHandler(){
        //imageHandler = new ImageHandler();
    }
    
    public static ImageHandler getInstance(){
        if(imageHandler==null){
            imageHandler = new ImageHandler();
        }
        return imageHandler;
    }
    
    public void setImage(File file) throws IOException{
        images = new ArrayList<Image>();
        images.add(new Image(ImageIO.read(file)));
    }
    
    public void evolveImage(Image image){
        image.setId(images.size());
        //System.out.println(image.getId());
        images.add(image);
    }
    
    public Image getImage(){
         return images.get(images.size()-1);
    }
    
    public Image undo(int current){
        if(current==0){
            return null;
        }
        return images.get(current-1);
    }
    
    public Image redo(int current){
        if(current>=images.size()-1){
            return null;
        }
        return images.get(current+1);
    }
    
    public boolean saveImage(File file){
        try{
            ImageIO.write(getImage().getBufferedImage(), ".png", file);
            return true;
        }
        catch(IOException e){
            return false;
        }
            
    }
    
}
