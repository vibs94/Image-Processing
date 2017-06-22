package imageprocessing;

import java.awt.Color;

/**
 *
 * @author B.K.D.Vibodha
 */
public class EdgeDetection {
    public Image prewwitt(Image image, String state,int tr){
        if(state.equals("h")){ 
        int[][] ed = new int[][]{{-1,-1,-1},{0,0,0},{1,1,1}};
            for(int i=1;i<image.getBufferedImage().getWidth()-1;i=i+3){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j=j+3){
                Color color;
            
            int[][] colors = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = color.getRed()+color.getGreen()+color.getBlue();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        
                    }
                }
                colors=marixMul(colors, ed, 3,tr);
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(colors[m-i+1][n-j+1],colors[m-i+1][n-j+1],colors[m-i+1][n-j+1]);
                        image.getBufferedImage().setRGB(m, n, color.getRGB());
                    }
                }
        }
    }
        }
        else{
            int[][] ed = new int[][]{{1,0,1},{-1,0,1},{-1,0,1}};
            for(int i=1;i<image.getBufferedImage().getWidth()-1;i=i+3){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j=j+3){
                Color color;
            
            int[][] colors = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = color.getRed()+color.getGreen()+color.getBlue();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        
                    }
                }
                colors=marixMul(colors, ed, 3,tr);
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(colors[m-i+1][n-j+1],colors[m-i+1][n-j+1],colors[m-i+1][n-j+1]);
                        image.getBufferedImage().setRGB(m, n, color.getRGB());
                    }
                }
        }
    }
        }
        return image;
    }
    
    public Image sobel(Image image, String state,int tr){
        if(state.equals("h")){ 
        int[][] ed = new int[][]{{-1,-2,-1},{0,0,0},{1,2,1}};
            for(int i=1;i<image.getBufferedImage().getWidth()-1;i=i+3){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j=j+3){
                Color color;
            
            int[][] colors = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = color.getRed()+color.getGreen()+color.getBlue();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        
                    }
                }
                colors=marixMul(colors, ed, 3,tr);
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(colors[m-i+1][n-j+1],colors[m-i+1][n-j+1],colors[m-i+1][n-j+1]);
                        image.getBufferedImage().setRGB(m, n, color.getRGB());
                    }
                }
        }
    }
        }
        else{
            int[][] ed = new int[][]{{1,0,1},{-2,0,2},{-1,0,1}};
            for(int i=1;i<image.getBufferedImage().getWidth()-1;i=i+3){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j=j+3){
                Color color;
            
            int[][] colors = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = color.getRed()+color.getGreen()+color.getBlue();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        
                    }
                }
                colors=marixMul(colors, ed, 3,tr);
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(colors[m-i+1][n-j+1],colors[m-i+1][n-j+1],colors[m-i+1][n-j+1]);
                        image.getBufferedImage().setRGB(m, n, color.getRGB());
                    }
                }
        }
    }
        }
        return image;
    }
    
    public Image laplasian(Image image, String state,int tr){
        if(state.equals("+")){ 
        int[][] ed = new int[][]{{0,1,0},{1,-4,1},{0,1,0}};
            for(int i=1;i<image.getBufferedImage().getWidth()-1;i=i+3){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j=j+3){
                Color color;
            
            int[][] colors = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = color.getRed()+color.getGreen()+color.getBlue();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        
                    }
                }
                colors=marixMul(colors, ed, 3,tr);
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(colors[m-i+1][n-j+1],colors[m-i+1][n-j+1],colors[m-i+1][n-j+1]);
                        image.getBufferedImage().setRGB(m, n, color.getRGB());
                    }
                }
        }
    }
        }
        else{
            int[][] ed = new int[][]{{0,-1,0},{-1,4,-1},{0,-1,0}};
            for(int i=1;i<image.getBufferedImage().getWidth()-1;i=i+3){
            for(int j=1;j<image.getBufferedImage().getHeight()-1;j=j+3){
                Color color;
            
            int[][] colors = new int[3][3];
                int[][] greens = new int[3][3];
                int[][] blues = new int[3][3];
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(image.getBufferedImage().getRGB(m, n));
                        //System.out.println((m-i+1)+" "+(n-i+2));
                        colors[m-i+1][n-j+1] = color.getRed()+color.getGreen()+color.getBlue();
                        //System.out.println((m-i+(len-1)/2)+" "+(n-i+(len-1)/2));
                        
                    }
                }
                colors=marixMul(colors, ed, 3,tr);
                for(int m=i-1;m<i+2;m++){
                    for(int n=j-1;n<j+2;n++){
                        color = new Color(colors[m-i+1][n-j+1],colors[m-i+1][n-j+1],colors[m-i+1][n-j+1]);
                        image.getBufferedImage().setRGB(m, n, color.getRGB());
                    }
                }
        }
    }
        }
        return image;
    }
    
    public int[][] marixMul(int[][] a,int[][] b, int len,int tr){
        int[][] ans = new int[len][len];
        int val=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                for(int k=0;k<len;k++){
                    val=a[i][k]*b[k][j];
                }
                if(Math.abs(val-a[i][j])>tr){
                  ans[i][j]=255;  
                }
                else{
                    ans[i][j]=0;
                }
                
            }
        }
        return ans;
    }
}
