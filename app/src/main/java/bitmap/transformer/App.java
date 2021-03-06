/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

public class App {

    public static void main(String[] args) {

        Bitmap gray = new Bitmap("app/src/assets/baldy-8bit.bmp", "app/src/assets/", "gray.bmp");
        Bitmap border = new Bitmap("app/src/assets/baldy-8bit.bmp", "app/src/assets/", "border.bmp");
        Bitmap flip = new Bitmap("app/src/assets/baldy-8bit.bmp", "app/src/assets/", "flip.bmp");

        //runs in editor but not console. (Can't read input file)
        gray.blackAndWhite();
        border.addBorder();
        flip.flipVertical();
    }
}
