package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * PanneauOptions
 * @author 21614263
 *
 */
public class PanneauOptions extends Panneau {
    private static final long serialVersionUID = 1L;
    // Buttons
    JRadioButton doubleOui = new JRadioButton("Oui");
    JRadioButton doubleNon = new JRadioButton("Non");
    JRadioButton surrenderOui = new JRadioButton("Oui");
    JRadioButton surrenderNon = new JRadioButton("Non");
    JRadioButton insuranceOui = new JRadioButton("Oui");
    JRadioButton insuranceNon = new JRadioButton("Non");
    // Nombre de split
    JComboBox <Integer> nbSplit = new JComboBox<Integer>();
    // Mises
    JComboBox<Integer> miseMin = new JComboBox<Integer>();
    JComboBox<Integer> miseMax = new JComboBox<Integer>();
    // Credit
    JComboBox<Integer> credit = new JComboBox<Integer>();
    // Nb paquets
    JComboBox<Integer> nbPaquets = new JComboBox<Integer>();
    // Joueurs
    JComboBox<String> j1 = new JComboBox<String>();
    JTextField j1Nom = new JTextField("Joueur 1");
    JComboBox<String> j2 = new JComboBox<String>();
    JTextField j2Nom = new JTextField("Joueur 2");
    JComboBox<String> j3 = new JComboBox<String>();
    JTextField j3Nom = new JTextField("Joueur 3");
    JComboBox<String> j4 = new JComboBox<String>();
    JTextField j4Nom = new JTextField("Joueur 4");
    JComboBox<String> j5 = new JComboBox<String>();
    JTextField j5Nom = new JTextField("Joueur 5");

    /**
     * Constructeur par defaut
     */
    public PanneauOptions() {
    	super();
        setLayout(null);
        preparePanel();
    }
	
    /**
     * Constructeur logique
     * @param fond : l'image de fond
     */
    public PanneauOptions(String fond){
    	super(fond);
    	IMG_FOND = new ImageIcon(fond).getImage();
    	setLayout(null);
    	setSize(new Dimension(1300,800));
    }
    
    /**
     * preparePanel : instanciation du contenu du panel
     */
    private void preparePanel() {
    	JPanel options = new JPanel();
    	options.setBounds(50, 75, 1170, 600);
    	options.setBackground(new Color(70, 140, 67));
    	options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
    	options.setBorder(new EtchedBorder(EtchedBorder.RAISED));
    	
    	// Titre
    	JLabel titre = new JLabel("Options");
    	titre.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
    	titre.setForeground(Color.white);
    	
    	// RadioButtons pour les options binaires
    	doubleOui.setSelected(true);
    	doubleOui.setBackground(new Color(70, 140, 67));
    	doubleNon.setBackground(new Color(70, 140, 67));
    	surrenderOui.setSelected(true);
    	surrenderOui.setBackground(new Color(70, 140, 67));
    	surrenderNon.setBackground(new Color(70, 140, 67));
    	insuranceOui.setSelected(true);
    	insuranceOui.setBackground(new Color(70, 140, 67));
    	insuranceNon.setBackground(new Color(70, 140, 67));
    	// ButtonGroups pour les options binaires
    	ButtonGroup doubleAutorise = new ButtonGroup();
    	doubleAutorise.add(doubleOui);
    	doubleAutorise.add(doubleNon);
    	ButtonGroup surrenderAutorise = new ButtonGroup();
    	surrenderAutorise.add(surrenderOui);
    	surrenderAutorise.add(surrenderNon);
    	ButtonGroup insuranceAutorise = new ButtonGroup();
    	insuranceAutorise.add(insuranceOui);
    	insuranceAutorise.add(insuranceNon);
        JPanel panneauRadioButtons = new JPanel();
    	panneauRadioButtons.setBackground(new Color(70, 140, 67));
        JPanel panneauDouble = new JPanel();
    	panneauDouble.setBackground(new Color(70, 140, 67));
        panneauDouble.setBorder(new LineBorder(Color.BLACK));
        panneauDouble.add(new JLabel("Double ?"));
        panneauDouble.add(doubleOui);
        panneauDouble.add(doubleNon);
        panneauRadioButtons.add(panneauDouble);
        JPanel panneauSurrender = new JPanel();
    	panneauSurrender.setBackground(new Color(70, 140, 67));
        panneauSurrender.setBorder(new LineBorder(Color.BLACK));
        panneauSurrender.add(new JLabel("Surrender ?"));
        panneauSurrender.add(surrenderOui);
        panneauSurrender.add(surrenderNon);
        panneauRadioButtons.add(panneauSurrender);
        JPanel panneauInsurance = new JPanel();
    	panneauInsurance.setBackground(new Color(70, 140, 67));
        panneauInsurance.setBorder(new LineBorder(Color.BLACK));
        panneauInsurance.add(new JLabel("Insurance ?"));
        panneauInsurance.add(insuranceOui);
        panneauInsurance.add(insuranceNon);
        panneauRadioButtons.add(panneauInsurance);
        
    	
    	// Nombre de split
    	JPanel nbSplitPanel = new JPanel();
    	nbSplitPanel.setBackground(new Color(70, 140, 67));
    	for(int i=0; i<=4; i++) { nbSplit.addItem(i); }
        nbSplit.setSelectedItem(1);
    	nbSplitPanel.add(new JLabel("Nombre de split"));
    	nbSplitPanel.add(nbSplit);
    	
    	// Choix des mises et du credit
    	JPanel mises = new JPanel();
    	mises.setBackground(new Color(70, 140, 67));
    	for(int i=2; i<=20; i+=2) { miseMin.addItem(i); }
    	for(int i=500; i<=5000; i+=500) { miseMax.addItem(i); }
        for(int i=500; i<=10000; i+=500) { credit.addItem(i); }
        credit.setSelectedIndex(9);
    	mises.add(new JLabel("Mise : minimum"));
    	mises.add(miseMin);
    	mises.add(new JLabel("maximum"));
    	mises.add(miseMax);
        mises.add(new JLabel("Credit"));
        mises.add(credit);
        
    	
    	// Nombre de paquets
    	JPanel nbPaquetsPanel = new JPanel();
    	nbPaquetsPanel.setBackground(new Color(70, 140, 67));
    	for(int i=1; i<=8; i++) { nbPaquets.addItem(i);	}
    	nbPaquets.setSelectedIndex(3);
    	nbPaquetsPanel.add(new JLabel("Nombre de paquets"));
    	nbPaquetsPanel.add(nbPaquets);
    	
    	// ComboBoxes pour le choix des joueurs
    	j1.addItem("JoueurHumain");
    	j1.addItem("JoueurRobotBasique");
    	j1.addItem("JoueurRobotHasard");
    	j1.addItem("JoueurRobotRisque");
    	j2.addItem("null");
    	j2.addItem("JoueurHumain");
    	j2.addItem("JoueurRobotBasique");
    	j2.addItem("JoueurRobotHasard");
    	j2.addItem("JoueurRobotRisque");
    	j3.addItem("null");
    	j3.addItem("JoueurHumain");
    	j3.addItem("JoueurRobotBasique");
    	j3.addItem("JoueurRobotHasard");
    	j3.addItem("JoueurRobotRisque");
    	j4.addItem("null");
    	j4.addItem("JoueurHumain");
    	j4.addItem("JoueurRobotBasique");
    	j4.addItem("JoueurRobotHasard");
    	j4.addItem("JoueurRobotRisque");
    	j5.addItem("null");
    	j5.addItem("JoueurHumain");
    	j5.addItem("JoueurRobotBasique");
    	j5.addItem("JoueurRobotHasard");
    	j5.addItem("JoueurRobotRisque");
    	
    	// Choix des joueurs
    	JPanel joueursPanel = new JPanel();
    	joueursPanel.setBackground(new Color(70, 140, 67));
        // Joueur 1
        JPanel jp1 = new JPanel();
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
    	jp1.setBackground(new Color(70, 140, 67));
    	jp1.add(new JLabel("Joueur 1"));
        jp1.add(j1);
        jp1.add(j1Nom);
    	joueursPanel.add(jp1);
        // Joueur 2
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));
    	jp2.setBackground(new Color(70, 140, 67));
    	jp2.add(new JLabel("Joueur 2"));
    	jp2.add(j2);
        jp2.add(j2Nom);
        joueursPanel.add(jp2);
        // Joueur 3
        JPanel jp3 = new JPanel();
        jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
    	jp3.setBackground(new Color(70, 140, 67));
    	jp3.add(new JLabel("Joueur 3"));
        jp3.add(j3);
        jp3.add(j3Nom);
    	joueursPanel.add(jp3);
        // Joueur 4
        JPanel jp4 = new JPanel();
        jp4.setLayout(new BoxLayout(jp4, BoxLayout.Y_AXIS));
    	jp4.setBackground(new Color(70, 140, 67));
    	jp4.add(new JLabel("Joueur 4"));
        jp4.add(j4);
        jp4.add(j4Nom);
    	joueursPanel.add(jp4);
        // Joueur 5
        JPanel jp5 = new JPanel();
        jp5.setLayout(new BoxLayout(jp5, BoxLayout.Y_AXIS));
    	jp5.setBackground(new Color(70, 140, 67));
    	jp5.add(new JLabel("Joueur 5"));
        jp5.add(j5);
        jp5.add(j5Nom);
    	joueursPanel.add(jp5);

    	// Composition du panneau
    	options.add(titre);
    	options.add(panneauRadioButtons);
    	options.add(nbSplitPanel);
    	options.add(mises);
    	options.add(nbPaquetsPanel);
    	options.add(new JLabel(" "));
    	//options.add(new JLabel("Type des Joueurs (null = pas de joueur)"));
    	options.add(joueursPanel);
    	options.add(new JLabel(" "));
    	
    	add(options);
    }
    
    public boolean doubleAutorise() { return doubleOui.isSelected(); }
    public boolean surrenderAutorise() { return surrenderOui.isSelected(); }
    public boolean insuranceAutorise() { return insuranceOui.isSelected(); }
    public int nbSplitAutorise() { return nbSplit.getItemAt(nbSplit.getSelectedIndex()); }
    public int getMiseMin() { return miseMin.getItemAt(miseMin.getSelectedIndex()); }
    public int getMiseMax() { return miseMax.getItemAt(miseMax.getSelectedIndex()); }
    public int getCredit() { return credit.getItemAt(credit.getSelectedIndex()); }
    public int getNbPaquets() { return nbPaquets.getItemAt(nbPaquets.getSelectedIndex()); }
    
    /**
     * getJoueurs
     * @return la nature de chaque joueur
     */
    public String[] getJoueurs() { 
    	String[] joueurs = new String[5];
    	
    	joueurs[0] = (String)j1.getSelectedItem();
    	joueurs[1] = (String)j2.getSelectedItem();
    	joueurs[2] = (String)j3.getSelectedItem();
    	joueurs[3] = (String)j4.getSelectedItem();
    	joueurs[4] = (String)j5.getSelectedItem();
    	
    	return joueurs; 
    }
    
    /**
     * getNomJoueurs
     * @return le nom de chaque joueur
     */
    public String[] getNomJoueurs() {
        String[] nomJoueurs = new String[5];
        
        nomJoueurs[0] = j1Nom.getText();
        nomJoueurs[1] = j2Nom.getText();
        nomJoueurs[2] = j3Nom.getText();
        nomJoueurs[3] = j4Nom.getText();
        nomJoueurs[4] = j5Nom.getText();
        
        return nomJoueurs;
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
}
