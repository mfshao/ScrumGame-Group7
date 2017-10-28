import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuButtonsPanel extends JPanel {

	private static final int BUTTON_IMAGE_WIDTH = 220;
	private static final int BUTTON_IMAGE_HEIGHT = 80;
	private static final int MUSIC_BUTTON_IMAGE_WIDTH = 85;
	private static final String BUTTONS_IMAGE_PATH = "images//buttons.png";
	private static final String MUSIC_BUTTON_IMAGE_PATH = "images//music_button.png";
	private MainMenu mainMenu;
    private JButton newGameButton;
	private JButton rulesButton;
    private JButton aboutUsButton;
    private JButton musicButton;
    private BufferedImage normalButtons;
    private BufferedImage musicButtons;
    private ImageIcon gNewGame;
    private ImageIcon yNewGame;
    private ImageIcon gRules;
    private ImageIcon yRules;
    private ImageIcon gAboutUs;
    private ImageIcon yAboutUs;
    private ImageIcon gMusic;
    private ImageIcon yMusic;
    private ImageIcon gnMusic;
    
	private static final long serialVersionUID = 1L;

	public MainMenuButtonsPanel(MainMenu mainMenu) {
		System.out.println("panel m created");
		this.mainMenu = mainMenu;
		initImages();
		initComponents();
	}
    
	private void initImages() {
    	try {
    		normalButtons = ImageIO.read(new File(BUTTONS_IMAGE_PATH));
    		musicButtons = ImageIO.read(new File(MUSIC_BUTTON_IMAGE_PATH));
    		gNewGame = new ImageIcon(normalButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yNewGame = new ImageIcon(normalButtons.getSubimage(2*BUTTON_IMAGE_WIDTH, 2*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gRules = new ImageIcon(normalButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 1*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yRules = new ImageIcon(normalButtons.getSubimage(2*BUTTON_IMAGE_WIDTH, 1*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gAboutUs = new ImageIcon(normalButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 5*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yAboutUs = new ImageIcon(normalButtons.getSubimage(2*BUTTON_IMAGE_WIDTH, 5*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gMusic = new ImageIcon(musicButtons.getSubimage(3*MUSIC_BUTTON_IMAGE_WIDTH, 0, MUSIC_BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yMusic = new ImageIcon(musicButtons.getSubimage(2*MUSIC_BUTTON_IMAGE_WIDTH, 0, MUSIC_BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gnMusic = new ImageIcon(musicButtons.getSubimage(1*MUSIC_BUTTON_IMAGE_WIDTH, 0, MUSIC_BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	private class OnMusicButtonClickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ConfigurationManager.getConfigurationManager().getConfiguration().toggleMusic();
			setMusicButton();
		}
    }
	
	private class OnNewGameButtonClickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainMenuSettingsPanel settingPanel = new MainMenuSettingsPanel(mainMenu);
			mainMenu.setPanel(settingPanel);
		}
    }
	
	private void setMusicButton() {
		if (ConfigurationManager.getConfigurationManager().getConfiguration().isMusicOn()) {
			musicButton.setIcon(gnMusic);
		} else {
			musicButton.setIcon(gMusic);
		}	
		System.out.println("Music on: " + ConfigurationManager.getConfigurationManager().getConfiguration().isMusicOn());
	}
	
	private void initComponents() {
		newGameButton = new javax.swing.JButton(gNewGame);
        newGameButton.setBorder(BorderFactory.createEmptyBorder());
        newGameButton.setContentAreaFilled(false);
        newGameButton.setRolloverIcon(yNewGame);
        newGameButton.setRolloverEnabled(true);
        newGameButton.addActionListener(new OnNewGameButtonClickedListener());

        rulesButton = new javax.swing.JButton(gRules);
        rulesButton.setBorder(BorderFactory.createEmptyBorder());
        rulesButton.setContentAreaFilled(false);
        rulesButton.setRolloverIcon(yRules);
        rulesButton.setRolloverEnabled(true);
        rulesButton.addActionListener(new MainMenuRulesAction());
        
        aboutUsButton = new javax.swing.JButton(gAboutUs);
        aboutUsButton.setBorder(BorderFactory.createEmptyBorder());
        aboutUsButton.setContentAreaFilled(false);
        aboutUsButton.setRolloverIcon(yAboutUs);
        aboutUsButton.setRolloverEnabled(true);
        aboutUsButton.addActionListener(new MainMenuAboutUsAction());
        
        musicButton = new javax.swing.JButton(gnMusic);
        musicButton.setBorder(BorderFactory.createEmptyBorder());
        musicButton.setContentAreaFilled(false);
        musicButton.setRolloverIcon(yMusic);
        musicButton.setRolloverEnabled(true);
        musicButton.addActionListener(new OnMusicButtonClickedListener());
        setMusicButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(musicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aboutUsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rulesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rulesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutUsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(musicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        this.setOpaque(false);
    }                                                     
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
