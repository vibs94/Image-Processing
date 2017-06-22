package imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author B.K.D.Vibodha
 */
public class Sampling {
    
    Color color;
    int colorValue=0;

    //////////////////////// Dithering //////////////////////////////////////
    
    public Image dither(Image image){
        Color black = new Color(0,0,0);
        Color white = new Color(255,255,255);
        BufferedImage bufferdImage = new BufferedImage(image.getBufferedImage().getWidth()*2, image.getBufferedImage().getHeight()*2, BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<image.getBufferedImage().getWidth();i++){
            for(int j=0;j<image.getBufferedImage().getHeight();j++){
                //try{
                color = new Color(image.getBufferedImage().getRGB(i, j));
                //}
               /* catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(String.valueOf(i)+" "+String.valueOf(j));
                    System.out.println(String.valueOf(image.getBufferedImage().getHeight())+" "+String.valueOf(image.getBufferedImage().getWidth()));
                    break;
                }*/
                        
                colorValue = (color.getBlue()+color.getGreen()+color.getRed())/3;
                if(colorValue<50){
                    bufferdImage.setRGB(i*2, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2, j*2+1, black.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2+1, black.getRGB());
                }
                else if(colorValue<100){
                    bufferdImage.setRGB(i*2, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2, j*2+1, black.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2+1, white.getRGB());
                }
                else if(colorValue<150){
                    bufferdImage.setRGB(i*2, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2, j*2+1, white.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2+1, white.getRGB());
                }
                else if(colorValue<200){
                    bufferdImage.setRGB(i*2, j*2, black.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2, white.getRGB());
                    bufferdImage.setRGB(i*2, j*2+1, white.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2+1, white.getRGB());
                }
                else{
                    bufferdImage.setRGB(i*2, j*2, white.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2, white.getRGB());
                    bufferdImage.setRGB(i*2, j*2+1, white.getRGB());
                    bufferdImage.setRGB(i*2+1, j*2+1, white.getRGB());
                }
            }
        }
        Image returnImage = new Image(bufferdImage);
        return returnImage;
    }
    
    ////////////////////////////// Nearest Neibour ///////////////
    
    public Image nearestNeibour(Image image,int scale,String state){
        if(scale%2!=0){
            return null;
        }
        BufferedImage bufferdImage;
        if(state.equals("up")){
            //System.out.println("up");
            bufferdImage = new BufferedImage(image.getBufferedImage().getWidth()*scale, image.getBufferedImage().getHeight()*scale, BufferedImage.TYPE_INT_RGB);
            for(int i=0;i<image.getBufferedImage().getWidth();i++){
                for(int j=0;j<image.getBufferedImage().getHeight();j++){
                    //try{
                    color = new Color(image.getBufferedImage().getRGB(i, j));
                    bufferdImage.setRGB(i*scale, j*scale, color.getRGB());
                    bufferdImage.setRGB(i*scale, j*scale+1, color.getRGB());
                    bufferdImage.setRGB(i*scale+1, j*scale, color.getRGB());
                    bufferdImage.setRGB(i*scale+1, j*scale+1, color.getRGB());
                }
            }
        }
        else{
         bufferdImage = new BufferedImage(image.getBufferedImage().getWidth()/scale, image.getBufferedImage().getHeight()/scale, BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<image.getBufferedImage().getWidth();i=i+scale){
            for(int j=0;j<image.getBufferedImage().getHeight();j=j+scale){
                //try{
                color = new Color(image.getBufferedImage().getRGB(i, j));
                bufferdImage.setRGB(i/scale, j/scale, color.getRGB());
            }
        }   
        }
       Image returnImage = new Image(bufferdImage);
        return returnImage; 
    }
    
   /////////////////////////////////// Linear Interpolation /////////////////////////
    
   public Image linearIn(Image image,double scale,String state){
       BufferedImage bufferdImage;
       int a=-1;
       int b=-1;
       int i =-1;
       int j=-1;
        if(state.equals("up")){
            //System.out.println("up");
            bufferdImage = new BufferedImage((int)(image.getBufferedImage().getWidth()*scale), (int)(image.getBufferedImage().getHeight()*scale), BufferedImage.TYPE_INT_RGB);
            for(i=0;i<bufferdImage.getWidth();i++){
                for(j=0;j<bufferdImage.getHeight();j++){
                    //try{
                   a=(int)(i/scale);
                    b=(int)(j/scale);
                    try{
                    color = new Color(image.getBufferedImage().getRGB(a, b));
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println(String.valueOf(a)+" "+String.valueOf(b));
                        break;
                    }
                    bufferdImage.setRGB(i, j, color.getRGB());
                            
                }
            }
            //System.out.println(String.valueOf(i)+" "+String.valueOf(j));
        }
        else{
         bufferdImage = new BufferedImage((int)(image.getBufferedImage().getWidth()/scale), (int)(image.getBufferedImage().getHeight()/scale), BufferedImage.TYPE_INT_RGB);
        for(i=0;i<bufferdImage.getWidth();i++){
            for(j=0;j<bufferdImage.getHeight();j++){
                //try{
                
                a=(int)(i*scale);
                    b=(int)(j*scale);
                    try{
                    color = new Color(image.getBufferedImage().getRGB(a, b));
                   }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println(String.valueOf(i)+" "+String.valueOf(j));
                        break;
                    }
                    bufferdImage.setRGB(i, j, color.getRGB());
                
            }
        }
        //System.out.println("ij "+String.valueOf(bufferdImage.getWidth())+" "+String.valueOf(bufferdImage.getHeight()));
        }
       Image returnImage = new Image(bufferdImage);
        return returnImage;
   } 
    
}
    

    

