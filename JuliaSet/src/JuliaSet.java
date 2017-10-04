/**
 * Created by Phi on 6/16/17.
 */

import java.awt.image.*;
import java.util.stream.*;
import javax.imageio.*;
import java.io.*;
public class JuliaSet{
    static final int WIDTH = 4096;
    static final int HEIGHT = 2160;
    static final double REALFUNC = -0.221;
    static final double IMGFUNC = -0.713;

    public static void main(String[] args) throws IOException {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = (WritableRaster) image.getData();
        int[] pixels =
                DoubleStream.iterate(-1,r->r+2.0/(HEIGHT-1)).limit(HEIGHT).boxed().flatMap(r->
                        DoubleStream.iterate(-1,i->i+2.0/(WIDTH-1)).limit(WIDTH).mapToObj(i-> new Complex(r,i)))
                        .parallel()
                        .mapToInt(c->recursiveCount(0,c)).toArray();
        raster.setPixels(0, 0, WIDTH, HEIGHT, pixels);
        image.setData(raster);
        ImageIO.write(image, "png", new File("output.png"));
    }

    static int recursiveCount(int count, Complex complex){
        return complex.absoluteValue() < 2 ? count < 255 ? recursiveCount(count+1, complex.applyFunction()) : 255 : count;
    }

    static class Complex{
        double re;
        double im;
        public Complex(double re, double im){
            this.re = re;
            this.im = im;
        }
        public Complex applyFunction(){
            double newRe = re*re - im*im + REALFUNC;
            double newIm = 2*im*re + IMGFUNC;
            this.re = newRe;
            this.im = newIm;
            return this;
        }
        public double absoluteValue(){
            return Math.abs(im) + Math.abs(re);
        }
    }
}
