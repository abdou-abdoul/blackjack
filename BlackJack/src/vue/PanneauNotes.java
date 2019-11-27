package vue;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

/**
 * PanneauNotes
 *
 */
public class PanneauNotes extends Panneau {
    private static final long serialVersionUID = 8;
    private Image IMG_FOND;
    
    /**
     * Constructeur par defaut
     */
    public PanneauNotes() {
        super();
        setLayout(null);
        preparePanel();
    }
	
    /**
     * Cosntructeur logique
     * @param fond : l'image de fond
     */
    public PanneauNotes(String fond){
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
    	text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
    	text.setText("\t\t\t\t\t   Remarques\n\n"+
                        " - Au lancement de la partie on fait patienter avant de demarer afin de laisser \n"+
                        "   le temps (en cas d'un retour vers le menu puis d'un relancement rapide du jeu)\n"+
                        "   à l'ancien moteur de jeu de se terminer ( pour ne pas \n"+
                        "   avoir plusieurs moteurs de jeu qui tournent en meme temps). \n\n"+ 
                        " - les messages du jeu ainsi que la legende des boutons sont en anglais car \n"+
                        "   on a voulu respecté certaines images du jeu  qui sont en anglais  \n\n"+
    			" - les joueurs robots ont leur Nom en blanc et les humains en vert  \n\n"+
    			" - le score affiché dans le jeu correspond à ce que gagne ou perd le joueur pour \n"+
                        "    chaque main à chaque tour\n\n"+
    			" - la partie est finie quand plus aucun joueur ne peut miser \n\n"+
    			" - On peut remarquer que la pioche dimiue que quand elle contiendra dans les \n"+
                        "   15 cartes à peu près"
    			);
    	
    	add(text);
    }
}