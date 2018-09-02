package panels;

import javax.swing.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class Test extends JFrame {
    private static SuperPanel superPanel;
    public Test(){
        super("dasda");
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setSize(800,300);
        this.setVisible(true);
    }
    private static void init(){
        JFrame jFrame=new Test();
        superPanel=new SuperPanel();
        jFrame.getContentPane().add(superPanel);

    }
    public static void main(String[] args) {
//        test.setSize(600,300);
//        test.setVisible(true);
        SwingUtilities.invokeLater(()->Test.init());
//        System.out.println(System.getProperty("user.home"));
    }
}
