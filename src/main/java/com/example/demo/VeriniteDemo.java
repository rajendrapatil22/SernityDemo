package com.example.demo;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class VeriniteDemo {
public static void main(String[] args) {
    JFrame f=new JFrame("Verinite Demo");
    JButton b=new JButton("Report");
    b.setBounds(600,100,95,30);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);

    f.add(b);
    f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true);
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           // File htmlFile = new File(getTheNewestFile("/home/rajendrap/gitzeta/serenity-cucumber-starter/target/site/serenity","html));
            try {
                Desktop.getDesktop().browse(getTheNewestFile("/home/rajendrap/gitzeta/serenity-cucumber-starter/target/site/serenity","html").toURI());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println();
        }
    } );
}
    public static File getTheNewestFile(String filePath, String ext) {
        File theNewestFile = null;
        File dir = new File(filePath);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        File[] files = dir.listFiles(fileFilter);

        if (files.length > 0) {
            /** The newest file comes first **/
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            theNewestFile = files[0];
        }

        return theNewestFile;
    }
}  