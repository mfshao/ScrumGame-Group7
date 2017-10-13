import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private static final int BUTTON_IMAGE_WIDTH = 169;
	private static final int BUTTON_IMAGE_HEIGHT = 82;
	private static final String BUTTON_RED_IMAGE_PATH = "images//r_buttons.png";
	private static final String BUTTON_YELLOW_IMAGE_PATH = "images//y_buttons.png";
    private javax.swing.JPanel jPanel1;
    private JButton startButton;
    private JButton aboutButton;
    private BufferedImage rButtons;
    private BufferedImage yButtons;
    private ImageIcon rStart;
    private ImageIcon yStart;
    private ImageIcon rAbout;
    private ImageIcon yAbout;

    public MainMenu() {
    }

    public void executeModule(){
    	initImages();
		initComponents();
	}

    private void initImages() {
    	try {
			rButtons = ImageIO.read(new File(BUTTON_RED_IMAGE_PATH));
			yButtons = ImageIO.read(new File(BUTTON_YELLOW_IMAGE_PATH));
			rStart = new ImageIcon(rButtons.getSubimage(0, 0, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			yStart = new ImageIcon(yButtons.getSubimage(0, 0, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			rAbout = new ImageIcon(rButtons.getSubimage(3*BUTTON_IMAGE_WIDTH+15, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			yAbout = new ImageIcon(yButtons.getSubimage(3*BUTTON_IMAGE_WIDTH+15, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void initComponents() {
    	JFrame jf = new JFrame();
        jPanel1 = new javax.swing.JPanel();

        startButton = new javax.swing.JButton(yStart);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setContentAreaFilled(false);
        startButton.setRolloverIcon(rStart);
        startButton.setRolloverEnabled(true);
        startButton.addActionListener(new MainMenuNewGameAction());

        aboutButton = new javax.swing.JButton(yAbout);
        aboutButton.setBorder(BorderFactory.createEmptyBorder());
        aboutButton.setContentAreaFilled(false);
        aboutButton.setRolloverIcon(rAbout);
        aboutButton.setRolloverEnabled(true);
        aboutButton.addActionListener(new MainMenuRulesAction());

        int startButtonHorizontalGap = (FRAME_WIDTH- BUTTON_IMAGE_WIDTH) / 2;
        int startButtonVeriticalGap = (FRAME_HEIGHT - BUTTON_IMAGE_HEIGHT) / 2;

        jf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("Scrum Game");
        jf.setPreferredSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        jf.setSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(startButtonHorizontalGap, startButtonHorizontalGap, startButtonHorizontalGap)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton)
                            .addComponent(aboutButton))
                    .addContainerGap(startButtonHorizontalGap, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(startButtonVeriticalGap, startButtonVeriticalGap, startButtonVeriticalGap)
                    .addComponent(startButton)
                    .addGap(20, 20, 20)
                    .addComponent(aboutButton)
                    .addContainerGap(startButtonVeriticalGap, Short.MAX_VALUE))
        );

        jf.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jf.pack();
        jf.setVisible(true);
    }

}
