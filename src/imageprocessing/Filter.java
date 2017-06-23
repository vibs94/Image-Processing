package imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author B.K.D.Vibodha
 */
public class Filter {
    
    public Image meanFilter(Image image){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i=1;i<image.getBufferedImage().getWidth()-1;i++){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j++){
                Color color; 
                int[][] reds = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        reds[m-i+1][n-j+1] = color.getRed();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        greens[m-i+1][n-j+1] = color.getGreen();
                        blues[m-i+1][n-j+1] = color.getBlue();
                    }
                }
                int red = convolu(reds);
                int green = convolu(greens);
                int blue = convolu(blues);
                Color newColor = new Color(red,green,blue);
                bufferedImage.setRGB(i, j, newColor.getRGB());
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
        
    }
    
    public Image midFilter(Image image){
        BufferedImage bufferedImage = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Integer> reds;
        ArrayList<Integer> greens;
        ArrayList<Integer> blues;
        for(int i=1;i<image.getBufferedImage().getWidth()-1;i++){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j++){
                Color color; 
                reds = new ArrayList<Integer>();
                greens = new ArrayList<Integer>();
                blues = new ArrayList<Integer>();
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        reds.add(color.getRed());
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        greens.add(color.getGreen());
                        blues.add(color.getBlue());
                    }
                }
                Collections.sort(reds);
                Collections.sort(greens);
                Collections.sort(blues);
                int red = reds.get(reds.size()/2);
                int green = greens.get(greens.size()/2);
                int blue = blues.get(blues.size()/2);
                Color newColor = new Color(red,green,blue);
                 bufferedImage.setRGB(i, j, newColor.getRGB());
            }
        }
        Image returnImage = new Image(bufferedImage);
        return returnImage;
    }
    
    private int convolu(int[][] a){
        int ans=0;
        int num;
        int[][] fil = new int[][]{{1,2,1},{2,4,2},{1,2,1}}; 
        for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
              ans = ans + a[i][j]*fil[i][j];
           } 
        }
        return ans/16;
    }
    
}
