
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.TextArea;
//import java.awt.TextField;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.JPanel;
import java.awt.Desktop;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JLabel;

import javax.swing.JButton;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
	private JButton btnSearch;
	// private JScrollPane scrollPane;
	// private JPanel panel;
	// private JTextPane textPane;
	// private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterKeyword = new JLabel("Enter Keyword");
		lblEnterKeyword.setBounds(6, 6, 89, 16);
		frame.getContentPane().add(lblEnterKeyword);
		textField = new JTextField();
		textField.setBounds(107, 1, 130, 26);
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		btnSearch = new JButton("Search");
		btnSearch.setBounds(249, 1, 117, 29);
		frame.getContentPane().add(btnSearch);

		// scrollPane = new JScrollPane();
		// scrollPane.setViewportView(panel);
		// scrollPane.setBounds(6, 33,644,239);
		// frame.getContentPane().add(scrollPane);

		// panel = new JPanel();
		// panel.setBounds(6, 33, 644, 314);
		// panel.setLayout(null);
		// frame.getContentPane().add(panel);

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String inputSearch = textField.getText();
				SearchResult sr = new SearchResult(inputSearch);
				sr.setResultURL();
				sr.sortResult();

				for (int i = 0; i < sr.getArr().size(); i++) {
					JLabel label = new JLabel(sr.getArr().get(i).title);
					label.setBounds(5, 30 * (i + 1), 450, 30);
					frame.getContentPane().add(label);
					JButton button = new JButton("Go!");
					String url = sr.getArr().get(i).getURL();
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							try {
								Desktop.getDesktop().browse(new URL(url).toURI());
							} catch (Exception e) {
							}
						}
					});
					button.setBounds(400, 30 * (i + 1), 50, 30);
					frame.getContentPane().add(button);
					button.revalidate();
				}
				
			}
		});
	}
}
