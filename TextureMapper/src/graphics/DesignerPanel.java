package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.DesignerAction;
import listeners.DesignerOnClick;

public class DesignerPanel extends JPanel {
	// Default grid values
	private int designWidth = 32;
	private int designHeight = 18;

	// Default resolution values
	private int resWidth = 1280;
	private int resHeight = 720;

	// Default cell size
	int labelSizeX;
	int labelSizeY;

	// Grid labels
	static JLabel[][] backGround;

	// CSV Data if imported
	String[][] data;

	// Buttons
	private JButton save;
	private JButton one;
	private JButton two;

	// Button array
	private JButton[] buttons = new JButton[3];

	// Colour value, default to 2
	private String colour = "2";

	// Images
	private ImageIcon imageIcon;
	private ImageIcon imageIcon1;

	// Handlers
	private DesignerOnClick mouse;
	private DesignerAction buttonHandler;

	public DesignerPanel(int resWidth, int resHeight) {
		// Default creation for designer panel
		this.resWidth = resWidth;
		this.resHeight = resHeight;
		this.setPreferredSize(new Dimension(this.resWidth, this.resHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setLayout(null);
		;
	}

	public void layoutCreate() {
		// Makes grid
		backGround = new JLabel[designHeight][designWidth];

		// Cell size and location
		int desResWidth = (int) (resWidth / 1.1);
		int desResHeight = (int) (resHeight / 1.1);
		labelSizeX = (desResWidth / designWidth);
		labelSizeY = (desResHeight / designHeight);
		int labelLocationX = (resWidth - desResWidth) / 2;
		int labelLocationY = resHeight - desResHeight;

		// Image resizing
		imageIcon = new ImageIcon("1.png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(labelSizeX, labelSizeY, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		imageIcon1 = new ImageIcon("2.png");
		Image image1 = imageIcon1.getImage();
		Image newimg1 = image1.getScaledInstance(labelSizeX, labelSizeY, java.awt.Image.SCALE_SMOOTH);
		imageIcon1 = new ImageIcon(newimg1);

		// Creates grid
		for (int i = 0; i < backGround.length; i++) {
			for (int j = 0; j < backGround[i].length; j++) {
				if (j == 0 && i > 0) {
					labelLocationY += labelSizeY;
					labelLocationX = (resWidth - desResWidth) / 2;
				}
				JLabel lblNewLabel = new JLabel("");

				if (data == null || data[i][j].equals("1")) {
					lblNewLabel.setName("1");
					lblNewLabel.setIcon(imageIcon);
				} else {
					lblNewLabel.setName("2");
					lblNewLabel.setIcon(imageIcon1);
				}

				lblNewLabel.setBounds(labelLocationX, labelLocationY, labelSizeX, labelSizeY);
				this.add(lblNewLabel);
				labelLocationX += labelSizeX;
				backGround[i][j] = lblNewLabel;

			}
		}
		// Create mouse for mouse inputs
		mouse = new DesignerOnClick(backGround, colour, imageIcon, imageIcon1, this);
		this.addMouseListener(mouse);

		// Add button handler for button inputs
		buttonHandler = new DesignerAction(backGround, buttons, this);

		// Save button
		save = new JButton("Save");
		save.setBounds(0, 0, 100, 20);
		this.add(save);
		buttons[0] = save;
		buttons[0].addActionListener(buttonHandler);

		// Colour 1 Button
		one = new JButton("One");
		one.setBounds(100, 0, 100, 20);
		this.add(one);
		buttons[1] = one;
		buttons[1].addActionListener(buttonHandler);

		// Colour 2 button
		two = new JButton("Two");
		two.setBounds(200, 0, 100, 20);
		this.add(two);
		buttons[2] = two;
		buttons[2].addActionListener(buttonHandler);
	}

	// Getters and setters below

	public int getDesignWidth() {
		return designWidth;
	}

	public void setDesignWidth(int designWidth) {
		this.designWidth = designWidth;
	}

	public int getDesignHeight() {
		return designHeight;
	}

	public void setDesignHeight(int designHeight) {
		this.designHeight = designHeight;
	}

	public String[][] getData() {
		return data;
	}//f

	public void setData(String[][] data) {
		this.data = data;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
