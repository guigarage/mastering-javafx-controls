package com.guigarage.chapter8;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.awt.*;

public class JFXPanelDemo1 {

    private static JButton swingButton;
    private static Button jfxButton;

    public static void main(String[] args) {

        final JFXPanel jfxPanel = new JFXPanel();

        SwingUtilities.invokeLater(() -> {
            JFrame swingFrame = new JFrame("Integrate JavaFX in Swing");
            swingFrame.getContentPane().setLayout(new BorderLayout());
            swingButton = new JButton("I'm a Swing button");
            swingFrame.getContentPane().add(BorderLayout.NORTH, swingButton);
            swingButton.addActionListener((e) -> {
                jfxButton.setDisable(!jfxButton.isDisable());
            });

            swingFrame.getContentPane().add(BorderLayout.CENTER, jfxPanel);
            jfxButton = new Button("I'm a JavaFX button");
            StackPane jfxPane = new StackPane(jfxButton);
            Scene jfxScene = new Scene(jfxPane);
            jfxPanel.setScene(jfxScene);
            jfxButton.setOnAction((e) -> {
                swingButton.setEnabled(!swingButton.isEnabled());
            });
            swingFrame.setVisible(true);
        });
    }
}