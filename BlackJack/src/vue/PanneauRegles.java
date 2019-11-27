package vue;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
/**
 * PanneauRegles
 * @author 21614263
 *
 */
public class PanneauRegles extends Panneau {
    private static final long serialVersionUID = 1;
    private Image IMG_FOND;
    /**
     * Constructeur par defaut
     */
	public PanneauRegles() {
            super();
            setLayout(null);
            preparePanel();
	}
	/**
	 * Constructeur logique
	 * @param fond : l'image de fond
	 */
    public PanneauRegles(String fond){
    	super(fond);
    	IMG_FOND = new ImageIcon(fond).getImage();
    	setLayout(null);
    	setSize(new Dimension(1300,800));
    }
   
    @Override
    public void paintComponent(Graphics g){
    	if(IMG_FOND!=null) {
            g.drawImage(IMG_FOND, 0, 0,1300 ,800 , this);
    	} else {
            g.setColor(new Color(50, 120, 47));
            g.fillRect(0, 0, 1300, 800);
    	}
    }
    /**
     * preparePanel : instanciation du contenu du panel
     */
    protected void preparePanel() {
    	JTextArea text = new JTextArea();
    	text.setBounds(50, 75, 1170, 600);
    	//text.setFocusable(false);
    	text.setEditable(false);
    	text.setBorder(new EtchedBorder(EtchedBorder.RAISED));
    	text.setBackground(new Color(60, 130, 57));
    	text.setForeground(Color.WHITE);
    	text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
    	text.setText("\t\t\t\t   R\u00E8gles\n"+
    			"\n\n\n\n\n\t   Nous pourrions essayer d'expliquer les r\u00E8gles du BlackJack\n"+
    			"\t   ici mais il est plus s\u00FBr de vous rediriger vers Wikip\u00E9dia :\n\n"+
    			"\t\t   https://fr.wikipedia.org/wiki/Blackjack_(jeu)"
    			);
    	
    	add(text);
    }
}