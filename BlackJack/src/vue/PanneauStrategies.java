package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * PanneauStrategies
 * @author 21614263
 *
 */
public class PanneauStrategies extends Panneau {
    private static final long serialVersionUID = 2;
    private Image IMG_FOND;

    /**
     * Constructeur par defaut
     */
    public PanneauStrategies() {
        super();
        setLayout(null);
        preparePanel();
    }
	
    /**
     * Constructeur logique
     * @param fond : l'image de fond
     */
    public PanneauStrategies(String fond){
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
    	text.setText("\t\t\t\t   Strat\u00E9gies\n"+
    			"\n\n\n\t\tListe des strat\u00E9gies utilis\u00E9es dans le logiciel :\n\n"+
    			"\t - StrategieBasique (Strat\u00E9gie optimale selon Wikip\u00E9dia);\n"+
    			"\t - StrategieCroupier (Demander des cartes jusqu'\u00E0 atteindre\n\t une valeur de 17);\n"+
    			"\t - StrategieHasard (Une chance sur deux de demander une carte);\n"+
    			"\t - StrategieRisque (Toujours demander une carte).\n");
    	
    	add(text);
    }
}
