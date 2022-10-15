package com.fx.demo;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
			runFrame(args[0], false);
		} else  {
			runFrame("x", true);
		}
	}

	public static void runFrame(String x, boolean exit) {
		JFrame frame = new JFrame("FrameDemo");
		if (exit) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
//5. Show it.
		frame.setVisible(true);

		JFXPanel jfxPanel = new JFXPanel();
		frame.getContentPane().add(jfxPanel, BorderLayout.CENTER);
//        frame.add(jfxPanel);

		Platform.runLater(() -> {
			WebView webView = new WebView();
			jfxPanel.setScene(new Scene(webView));
//			webView.getEngine().load("http://localhost:8080/test/" + x);
			webView.getEngine().load("http://localhost:8080/");
		});
	}
}
