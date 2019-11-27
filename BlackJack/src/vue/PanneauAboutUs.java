package vue;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
/**
 * PanneauAboutUs
 *
 */
public class PanneauAboutUs extends Panneau {
    private static final long serialVersionUID = 8;
    private Image IMG_FOND;
    
    /**
     * Constructeur par defaut
     */
    public PanneauAboutUs() {
        super();
        setLayout(null);
        preparePanel();
    }
	
    /**
     * Constructeur logique
     * @param fond : l'image de fond
     */
    public PanneauAboutUs(String fond){
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
    	text.setText("\t\t\t\t   \u00C0 Propos\n"+
    			"\n\n\n\t\tD\u00E9veloppeurs du projet (ordre alphab\u00E9tique) :\n\n\n"+
    			"\t\t - Abdoul-Hafarou ABDOU (21105799)\n"+
    			"\t\t - Bastien CHAPUSOT (21614263)\n"+
    			"\t\t - Mamadou Zaccharia DIALLO (21609180)\n"+
    			"\t\t - Ga\u00EBtan GUILBERT (21003711)\n"
    			);
    	
    	add(text);
    }
}
