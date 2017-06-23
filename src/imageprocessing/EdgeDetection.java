package imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author B.K.D.Vibodha
 */
public class EdgeDetection {
    public Image prewwitt(Image image, String state,int tr){
        //BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        Image returnImage;
        if(state.equals("h")){ 
            int[][] ed = new int[][]{{-1,-1,-1},{0,0,0},{1,1,1}};
            returnImage=convolute(image, ed, tr);
        }
        else{
            int[][] ed = new int[][]{{1,0,1},{-1,0,1},{-1,0,1}};
            returnImage = convolute(image, ed, tr);
        }
        
        return returnImage;
    }
    
    public Image sobel(Image image, String state,int tr){
        Image returnImage;
        if(state.equals("h")){ 
            int[][] ed = new int[][]{{-1,-2,-1},{0,0,0},{1,2,1}};
            returnImage=convolute(image, ed, tr);
        }
        else{
            int[][] ed = new int[][]{{1,0,1},{-2,0,2},{-1,0,1}};
            returnImage = convolute(image, ed, tr);
        }
        
        return returnImage;
    }
    
    public Image laplasian(Image image, String state,int tr){
        Image returnImage;
        if(state.equals("h")){ 
            int[][] ed = new int[][]{{0,1,0},{1,-4,1},{0,1,0}};
            returnImage=convolute(image, ed, tr);
        }
        else{
            int[][] ed = new int[][]{{0,-1,0},{-1,4,-1},{0,-1,0}};
            returnImage = convolute(image, ed, tr);
        }
        
        return returnImage;
    }
    
    public int marixMul(int[][] a,int[][] b, int len,int tr){
        int ans =0;
        int val=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                val=val+a[i][j]*b[i][j];
                if(Math.abs(val-a[i][j])>tr){
                  ans=255;  
                }
            }
        }
        return ans;
    }
    
    public Image convolute(Image image,int[][] ed,int tr){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i=1;i<image.getBufferedImage().getWidth()-1;i++){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j++){
                Color color;
                int[][] colors = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = (color.getRed()+color.getGreen()+color.getBlue())/3;
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2)); 
                    }
                }
                if(marixMul(colors, ed, 3,tr)==255){
                    bufferedImage.setRGB(i, j, new Color(255,255,255).getRGB());
                }
                else{
                    bufferedImage.setRGB(i, j, new Color(0,0,0).getRGB());
                }
                    
            }
        }
        
        Image returnImage = new Image(bufferedImage);
        return returnImage;
    }
    
}
