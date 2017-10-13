import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private static final int BUTTON_IMAGE_WIDTH = 169;
	private static final int BUTTON_IMAGE_HEIGHT = 82;
	private static final String BUTTON_RED_IMAGE_PATH = "images//r_buttons.png";
	private static final String BUTTON_YELLOW_IMAGE_PATH = "images//y_buttons.png";
	private static final String MAIN_MENU_BG_PATH = "images//game_main_menu_bg.png";
	private static final String MAIN_MENU_TITLE_PATH = "images//game_logo.png";
    private MainMenuPanel jPanel1;
    private JButton startButton;
    private JButton aboutButton;
    private JButton helpButton;
    private JButton settingButton;
    private BufferedImage rButtons;
    private BufferedImage yButtons;
    private BufferedImage mainMenuBG;
    private BufferedImage mainMenuTitle;
    private ImageIcon rStart;
    private ImageIcon yStart;
    private ImageIcon rAbout;
    private ImageIcon yAbout;
    private ImageIcon rHelp;
    private ImageIcon yHelp;
    private ImageIcon rSetting;
    private ImageIcon ySetting;
    
    private class MainMenuPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		g.drawImage(mainMenuBG, 0, 0, getWidth(), getHeight(), this);
    	}
    }
    
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
			rAbout = new ImageIcon(rButtons.getSubimage(4*BUTTON_IMAGE_WIDTH, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			yAbout = new ImageIcon(yButtons.getSubimage(4*BUTTON_IMAGE_WIDTH, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			rHelp = new ImageIcon(rButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			yHelp = new ImageIcon(yButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			rSetting = new ImageIcon(rButtons.getSubimage(0, BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			ySetting = new ImageIcon(yButtons.getSubimage(0, BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
			
			mainMenuBG = ImageIO.read(new File(MAIN_MENU_BG_PATH));
			mainMenuTitle = ImageIO.read(new File(MAIN_MENU_TITLE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void initComponents() {
    	JFrame jf = new JFrame();
        jPanel1 = new MainMenuPanel();
        
        JLabel titleLogo = new JLabel(new ImageIcon(mainMenuTitle));

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
        aboutButton.addActionListener(new MainMenuCreditsAction());
        
        helpButton = new javax.swing.JButton(yHelp);
        helpButton.setBorder(BorderFactory.createEmptyBorder());
        helpButton.setContentAreaFilled(false);
        helpButton.setRolloverIcon(rHelp);
        helpButton.setRolloverEnabled(true);
        helpButton.addActionListener(new MainMenuRulesAction());
        
        settingButton = new javax.swing.JButton(ySetting);
        settingButton.setBorder(BorderFactory.createEmptyBorder());
        settingButton.setContentAreaFilled(false);
        settingButton.setRolloverIcon(rSetting);
        settingButton.setRolloverEnabled(true);
        settingButton.addActionListener(new MainMenuSettingAction());

        jf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("Scrum Game");
        jf.setPreferredSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        jf.setSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(60, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(159, 159, 159)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(60, 60, 60))
            );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jf.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jf.pack();
        jf.setVisible(true);
        jf.setResizable(false);
    }

}
