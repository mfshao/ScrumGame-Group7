import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenuSettingsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int BUTTON_IMAGE_WIDTH = 220;
	private static final int BUTTON_IMAGE_HEIGHT = 80;
	private static final int SMALL_BUTTON_IMAGE_WIDTH = 110;
	private static final int SMALL_BUTTON_IMAGE_HEIGHT = 40;
	private static final int MUSIC_BUTTON_IMAGE_WIDTH = 85;
	private static final String BUTTONS_IMAGE_PATH = "images//buttons.png";
	private static final String MUSIC_BUTTON_IMAGE_PATH = "images//music_button.png";
	private static final String SMALL_BUTTONS_IMAGE_PATH = "images//sm_buttons.png";
	private MainMenu mainMenu;
    private JButton startButton;
	private JButton cancelButton;
	private JButton teamsButton1;
	private JButton teamsButton2;
	private JButton teamsButton3;
	private JButton[] teamsButtons;
	private JButton boardLengthButton1;
	private JButton boardLengthButton2;
	private JButton boardLengthButton3;
	private JButton[] boardLengthButtons;
    private JButton musicButton;
    private BufferedImage normalButtons;
    private BufferedImage musicButtons;
    private BufferedImage smallButtons;
    private ImageIcon gStart;
    private ImageIcon yStart;
    private ImageIcon gCancel;
    private ImageIcon yCancel;
    private ImageIcon gTeam1;
    private ImageIcon yTeam1;
    private ImageIcon gnTeam1;
    private ImageIcon gTeam2;
    private ImageIcon yTeam2;
    private ImageIcon gnTeam2;
    private ImageIcon gTeam3;
    private ImageIcon yTeam3;
    private ImageIcon gnTeam3;
    private ImageIcon gBoardLength1;
    private ImageIcon yBoardLength1;
    private ImageIcon gnBoardLength1;
    private ImageIcon gBoardLength2;
    private ImageIcon yBoardLength2;
    private ImageIcon gnBoardLength2;
    private ImageIcon gBoardLength3;
    private ImageIcon yBoardLength3;
    private ImageIcon gnBoardLength3;
    private ImageIcon[] gTeams;
    private ImageIcon[] gnTeams;
    private ImageIcon[] gBoardLengths;
    private ImageIcon[] gnBoardLengths;
    private ImageIcon gMusic;
    private ImageIcon yMusic;
    private ImageIcon gnMusic;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;

	public MainMenuSettingsPanel(MainMenu mainMenu) {
		System.out.println("panel s created");
		this.mainMenu = mainMenu;
		initImages();
		initComponents();
	}
	
	private void initImages() {
    	try {
    		normalButtons = ImageIO.read(new File(BUTTONS_IMAGE_PATH));
    		musicButtons = ImageIO.read(new File(MUSIC_BUTTON_IMAGE_PATH));
    		smallButtons = ImageIO.read(new File(SMALL_BUTTONS_IMAGE_PATH));
    		gStart = new ImageIcon(normalButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 0*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yStart = new ImageIcon(normalButtons.getSubimage(2*BUTTON_IMAGE_WIDTH, 0*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gCancel = new ImageIcon(normalButtons.getSubimage(3*BUTTON_IMAGE_WIDTH, 4*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yCancel = new ImageIcon(normalButtons.getSubimage(2*BUTTON_IMAGE_WIDTH, 4*BUTTON_IMAGE_HEIGHT, BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gMusic = new ImageIcon(musicButtons.getSubimage(3*MUSIC_BUTTON_IMAGE_WIDTH, 0, MUSIC_BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		yMusic = new ImageIcon(musicButtons.getSubimage(2*MUSIC_BUTTON_IMAGE_WIDTH, 0, MUSIC_BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gnMusic = new ImageIcon(musicButtons.getSubimage(1*MUSIC_BUTTON_IMAGE_WIDTH, 0, MUSIC_BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT));
    		gTeam1 = new ImageIcon(smallButtons.getSubimage(3*SMALL_BUTTON_IMAGE_WIDTH, 0*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		yTeam1 = new ImageIcon(smallButtons.getSubimage(2*SMALL_BUTTON_IMAGE_WIDTH, 0*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gnTeam1 = new ImageIcon(smallButtons.getSubimage(1*SMALL_BUTTON_IMAGE_WIDTH, 0*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gTeam2 = new ImageIcon(smallButtons.getSubimage(3*SMALL_BUTTON_IMAGE_WIDTH, 1*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		yTeam2 = new ImageIcon(smallButtons.getSubimage(2*SMALL_BUTTON_IMAGE_WIDTH, 1*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gnTeam2 = new ImageIcon(smallButtons.getSubimage(1*SMALL_BUTTON_IMAGE_WIDTH, 1*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gTeam3 = new ImageIcon(smallButtons.getSubimage(3*SMALL_BUTTON_IMAGE_WIDTH, 2*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		yTeam3 = new ImageIcon(smallButtons.getSubimage(2*SMALL_BUTTON_IMAGE_WIDTH, 2*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gnTeam3 = new ImageIcon(smallButtons.getSubimage(1*SMALL_BUTTON_IMAGE_WIDTH, 2*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gBoardLength1 = new ImageIcon(smallButtons.getSubimage(3*SMALL_BUTTON_IMAGE_WIDTH, 3*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		yBoardLength1 = new ImageIcon(smallButtons.getSubimage(2*SMALL_BUTTON_IMAGE_WIDTH, 3*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gnBoardLength1 = new ImageIcon(smallButtons.getSubimage(1*SMALL_BUTTON_IMAGE_WIDTH, 3*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gBoardLength2 = new ImageIcon(smallButtons.getSubimage(3*SMALL_BUTTON_IMAGE_WIDTH, 4*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		yBoardLength2 = new ImageIcon(smallButtons.getSubimage(2*SMALL_BUTTON_IMAGE_WIDTH, 4*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gnBoardLength2 = new ImageIcon(smallButtons.getSubimage(1*SMALL_BUTTON_IMAGE_WIDTH, 4*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gBoardLength3 = new ImageIcon(smallButtons.getSubimage(3*SMALL_BUTTON_IMAGE_WIDTH, 5*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		yBoardLength3 = new ImageIcon(smallButtons.getSubimage(2*SMALL_BUTTON_IMAGE_WIDTH, 5*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		gnBoardLength3 = new ImageIcon(smallButtons.getSubimage(1*SMALL_BUTTON_IMAGE_WIDTH, 5*SMALL_BUTTON_IMAGE_HEIGHT, SMALL_BUTTON_IMAGE_WIDTH, SMALL_BUTTON_IMAGE_HEIGHT));
    		
    		gTeams = new ImageIcon[]{gTeam1, gTeam2, gTeam3};
    		gnTeams = new ImageIcon[]{gnTeam1, gnTeam2, gnTeam3};
    		
    		gBoardLengths = new ImageIcon[]{gBoardLength1, gBoardLength2, gBoardLength3};
    		gnBoardLengths = new ImageIcon[]{gnBoardLength1, gnBoardLength2, gnBoardLength3};
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
	
	private class OnCancelButtonClickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cancelled");
			ConfigurationManager.getConfigurationManager().getConfiguration().setBoardLenght("");
			ConfigurationManager.getConfigurationManager().getConfiguration().setNumberOfTeams(0);
			
			MainMenuButtonsPanel buttonsPanel = new MainMenuButtonsPanel(mainMenu);
			mainMenu.setPanel(buttonsPanel);
		}
    }
	
	private class OnTeamsButtonClickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < teamsButtons.length; i++) {
				teamsButtons[i].setIcon(gTeams[i]);
				if (((JButton) e.getSource()).equals(teamsButtons[i])) {
					((JButton) e.getSource()).setIcon(gnTeams[i]);
				}
			}
			String numberOfTeams = ((JButton) e.getSource()).getName();
			ConfigurationManager.getConfigurationManager().getConfiguration().setNumberOfTeams(Integer.parseInt(numberOfTeams));
			System.out.println("# of Teams: " + ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams());
		}
    }
	
	private class OnBoardLengthButtonClickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < boardLengthButtons.length; i++) {
				boardLengthButtons[i].setIcon(gBoardLengths[i]);
				if (((JButton) e.getSource()).equals(boardLengthButtons[i])) {
					((JButton) e.getSource()).setIcon(gnBoardLengths[i]);
				}
			}
			String boardLength = ((JButton) e.getSource()).getName();
			ConfigurationManager.getConfigurationManager().getConfiguration().setBoardLenght(boardLength);
			System.out.println("Board Length: " + ConfigurationManager.getConfigurationManager().getConfiguration().getBoardLenght());
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
		startButton = new javax.swing.JButton(gStart);
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setContentAreaFilled(false);
		startButton.setRolloverIcon(yStart);
		startButton.setRolloverEnabled(true);
		startButton.addActionListener(new MainMenuStartGameAction(mainMenu.getJf()));

		cancelButton = new javax.swing.JButton(gCancel);
		cancelButton.setBorder(BorderFactory.createEmptyBorder());
		cancelButton.setContentAreaFilled(false);
		cancelButton.setRolloverIcon(yCancel);
		cancelButton.setRolloverEnabled(true);
		cancelButton.addActionListener(new OnCancelButtonClickedListener());
		
		teamsButton1 = new javax.swing.JButton(gTeam1);
		teamsButton1.setBorder(BorderFactory.createEmptyBorder());
		teamsButton1.setContentAreaFilled(false);
		teamsButton1.setSize(new java.awt.Dimension(110, 40));
		teamsButton1.setName("2");
		
		teamsButton2 = new javax.swing.JButton(gTeam2);
		teamsButton2.setBorder(BorderFactory.createEmptyBorder());
		teamsButton2.setContentAreaFilled(false);
		teamsButton2.setSize(new java.awt.Dimension(110, 40));
		teamsButton2.setName("3");
		
		teamsButton3 = new javax.swing.JButton(gTeam3);
		teamsButton3.setBorder(BorderFactory.createEmptyBorder());
		teamsButton3.setContentAreaFilled(false);
		teamsButton3.setSize(new java.awt.Dimension(110, 40));
		teamsButton3.setName("4");
        
		teamsButtons = new JButton[]{teamsButton1, teamsButton2, teamsButton3};
		for (JButton jb : teamsButtons) {
			jb.addActionListener(new OnTeamsButtonClickedListener());
		}
		
		boardLengthButton1 = new javax.swing.JButton(gBoardLength1);
		boardLengthButton1.setBorder(BorderFactory.createEmptyBorder());
		boardLengthButton1.setContentAreaFilled(false);
		boardLengthButton1.setSize(new java.awt.Dimension(110, 40));
		boardLengthButton1.setName("Short");
		
		boardLengthButton2 = new javax.swing.JButton(gBoardLength2);
		boardLengthButton2.setBorder(BorderFactory.createEmptyBorder());
		boardLengthButton2.setContentAreaFilled(false);
		boardLengthButton2.setSize(new java.awt.Dimension(110, 40));
		boardLengthButton2.setName("Medium");
		
		boardLengthButton3 = new javax.swing.JButton(gBoardLength3);
		boardLengthButton3.setBorder(BorderFactory.createEmptyBorder());
		boardLengthButton3.setContentAreaFilled(false);
		boardLengthButton3.setSize(new java.awt.Dimension(110, 40));
		boardLengthButton3.setName("Long");
        
		boardLengthButtons = new JButton[]{boardLengthButton1, boardLengthButton2, boardLengthButton3};
		for (JButton jb : boardLengthButtons) {
			jb.addActionListener(new OnBoardLengthButtonClickedListener());
		}
		
        musicButton = new javax.swing.JButton(gnMusic);
        musicButton.setBorder(BorderFactory.createEmptyBorder());
        musicButton.setContentAreaFilled(false);
        musicButton.setRolloverIcon(yMusic);
        musicButton.setRolloverEnabled(true);
        musicButton.addActionListener(new OnMusicButtonClickedListener());
        setMusicButton();

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Game Setup");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Board Length:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setText("Number of Teams:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(musicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(teamsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(teamsButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(teamsButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(boardLengthButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boardLengthButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boardLengthButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(teamsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamsButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamsButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(boardLengthButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardLengthButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardLengthButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        this.setOpaque(false);
    }                                                     
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
