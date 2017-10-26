import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private static final String MAIN_MENU_BG_PATH = "images//game_main_menu_bg.png";
	private static final String MAIN_MENU_TITLE_PATH = "images//game_logo.png";
	private JFrame jf;
	private JPanel jPanel1;
    private JPanel jPanel2;
    private BufferedImage mainMenuBG;
    private BufferedImage mainMenuTitle;
    private JLabel titleLogo;
    
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
    
    public JFrame getJf() {
		return jf;
	}

    private void initImages() {
    	try {			
			mainMenuBG = ImageIO.read(new File(MAIN_MENU_BG_PATH));
			mainMenuTitle = ImageIO.read(new File(MAIN_MENU_TITLE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void initComponents() {
    	jf = new JFrame();
        jPanel1 = new MainMenuPanel();
        jPanel2 = new MainMenuButtonsPanel(this);
        titleLogo = new JLabel(new ImageIcon(mainMenuTitle));

        jf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("Scrum Game");
        jf.setPreferredSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        jf.setSize(new java.awt.Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jf.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jf.pack();
        jf.setVisible(true);
        jf.setResizable(false);
    }
    
    public void setPanel(JPanel jp) {
    	jPanel1.remove(jPanel2);
    	jPanel2 = jp;
    	javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );   
        jPanel1.validate(); 
        jPanel1.repaint();  
    }
}
