package imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author B.K.D.Vibodha
 */
public class PointOp {
    
    public Image rotateAnti(Image image){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getHeight(), image.getBufferedImage().getWidth(), BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<bufferedImage.getWidth();i++){
            for(int j=0;j<bufferedImage.getHeight();j++){
                bufferedImage.setRGB(i, j, image.getBufferedImage().getRGB(image.getBufferedImage().getWidth()-1-j, i));
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
        
    }
    
    public Image rotateClock(Image image){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getHeight(), image.getBufferedImage().getWidth(), BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<bufferedImage.getWidth();i++){
            for(int j=0;j<bufferedImage.getHeight();j++){
                bufferedImage.setRGB(i, j, image.getBufferedImage().getRGB(j, image.getBufferedImage().getHeight()-1-i));
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
        
    }
    
    public Image flip(Image image){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<bufferedImage.getWidth();i++){
            for(int j=0;j<bufferedImage.getHeight();j++){
                //System.out.println(String.valueOf(j)+" "+String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(image.getBufferedImage().getWidth()-1-i)+" ");
                bufferedImage.setRGB(i, j, image.getBufferedImage().getRGB(image.getBufferedImage().getWidth()-1-i,j ));
                
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
        
    }
    
     public Image negative(Image image){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<bufferedImage.getWidth();i++){
            for(int j=0;j<bufferedImage.getHeight();j++){
                //System.out.println(String.valueOf(j)+" "+String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(image.getBufferedImage().getWidth()-1-i)+" ");
                Color color = new Color(image.getBufferedImage().getRGB(i, j));
                Color newColour = new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue());
                        
                bufferedImage.setRGB(i, j, newColour.getRGB());
                
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
        
    }
     
     public Image grayLevetImage(Image image){
         BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        
         for(int i=0;i<bufferedImage.getWidth();i++){
            for(int j=0;j<bufferedImage.getHeight();j++){
                //System.out.println(String.valueOf(j)+" "+String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(image.getBufferedImage().getWidth()-1-i)+" ");
                Color color = new Color(image.getBufferedImage().getRGB(i, j));
                int grayVal= (color.getRed()+ color.getGreen()+color.getBlue())/3;
                Color newColour = new Color(grayVal,grayVal,grayVal);
                        
                bufferedImage.setRGB(i, j, newColour.getRGB());
                
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
     }
     
     public Image bright(Image image,int bri){
         //System.out.println(""+bri);
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        if(bri>0){
            for(int i=0;i<bufferedImage.getWidth();i++){
                for(int j=0;j<bufferedImage.getHeight();j++){
                    //System.out.println(String.valueOf(j)+" "+String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(image.getBufferedImage().getWidth()-1-i)+" ");
                    Color color = new Color(image.getBufferedImage().getRGB(i, j));
                    //System.out.println("r "+color.getRed());
                    int red=color.getRed()+bri;
                    if(red>255){
                        red=255;
                    }
                    int green=color.getGreen()+bri;;
                    if(green>255){
                        green=255;
                    }
                    int blue=color.getBlue()+bri;
                    if(blue>255){
                        blue=255;
                    }
//                    System.out.println(red+" "+green+" "+blue);
                    Color newColour = new Color(red,green,blue);

                    bufferedImage.setRGB(i, j, newColour.getRGB());

                }
            }
        }
        else{
            for(int i=0;i<bufferedImage.getWidth();i++){
                for(int j=0;j<bufferedImage.getHeight();j++){
                    //System.out.println(String.valueOf(j)+" "+String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(image.getBufferedImage().getWidth()-1-i)+" ");
                    Color color = new Color(image.getBufferedImage().getRGB(i, j));
                    Color newColour;
                    int red=color.getRed()+bri;
                    if(red<0){
                        red=0;
                    }
                    int green=color.getGreen()+bri;
                    if(green<0){
                        green=0;
                    }
                    int blue=color.getBlue()+bri;
                    if(blue<0){
                        blue=0;
                    }
                    //System.out.println(red+" "+green+" "+blue);
                    newColour = new Color(red,green,blue);
                    bufferedImage.setRGB(i, j, newColour.getRGB());

                }
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
        
    }
    
}
