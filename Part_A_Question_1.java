//Devdoot Ghosh
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;

import javax.swing.*;
public class Part_A_Question_1 {

	public static void main(String[] args) {
		
EventQueue.invokeLater(new Runnable(){
	public void run(){
		JFrame frame=new cframe();
		frame.setTitle("Part A Question 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		JLabel l= new JLabel("Change Properties",SwingConstants.CENTER);
		JPopupMenu pop=new JPopupMenu();
		
		JMenuItem prop=new JMenuItem("Properties");
		pop.add(prop);
		pop.addSeparator();
		pop.add(new JMenuItem("Option 2"));
		pop.addSeparator();
		pop.add(new JMenuItem("Option 3"));
		
		
		JPanel p=new JPanel();
		p.add(l);
		//.setLayout(new BorderLayout());
		//p.setBackground(Color.CYAN);
		l.addMouseListener(new mylist(pop,l,prop,frame,p));
		p.setLayout(new GridBagLayout());
				frame.add(p);
		

		
	}
});
	}

}class cframe extends JFrame{
	public cframe(){
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension ss=kit.getScreenSize();
	int sh=ss.height;
	int sw=ss.width;
	setSize(sw/2,sh/2);
	setLocationByPlatform(true);
	}
}
class comp extends JComponent{
	public void comp(){
		JLabel l= new JLabel("Change Properies",SwingConstants.CENTER);
	//l.setVisible(true);
	}
}
class mylist implements MouseListener{

private JFrame f;
	private JPopupMenu pop;
	private JLabel lab;
	private JMenuItem mt;
	private JPanel pane;
public mylist(JPopupMenu p,JLabel l,JMenuItem m,JFrame fr,JPanel pa){
	mt=m;
	lab=l;
	pop=p;
	f=fr;
	pane=pa;
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(SwingUtilities.isRightMouseButton(e)){
			pop.show(lab,0,0);
			mt.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					//setVisible(false);
					// TODO Auto-generated method stub
					JDialog d=new propd(f,lab,pane);
					d.setLocationRelativeTo(lab);
					d.setVisible(true);
					
				}});
				
		
		}
		}
		
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}}
class propd extends JDialog{
	public static String text=null;
	public static String bg=null;
	public static String fc=null;
	public propd(JFrame f,JLabel l,JPanel p){
	super(f,"Properties",Dialog.ModalityType.DOCUMENT_MODAL);
	JPanel jp=new JPanel();
	jp.add(new JLabel("Change Text : "));
	JTextArea tta=new JTextArea(1,10);
	jp.add(tta);
	jp.add(new JLabel("Change Background Color : "));
	JTextArea bta=new JTextArea(1,10);
	jp.add(bta);
	jp.add(new JLabel("Change Font Color : "));
	JTextArea fta=new JTextArea(1,10);
	jp.add(fta);
	JButton sub=new JButton("Submit");
	sub.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			text=tta.getText().trim();
			bg=bta.getText().trim().toLowerCase();
			fc=fta.getText().trim().toLowerCase();
			setVisible(false);
			if(text!=null&&!text.equals("")){
				l.setText(text);
			}

			Color color;
			try {
			    Field field = Class.forName("java.awt.Color").getField(bg);
			    color = (Color)field.get(null);
			   p.setBackground(color);
			} catch (Exception ee) {
			    color = null; // Not defined
			}
			//Color color;
			try {
			    Field field = Class.forName("java.awt.Color").getField(fc);
			    color = (Color)field.get(null);
			    l.setForeground(color);
			} catch (Exception ee) {
			    color = null; // Not defined
			}
p.repaint();
			l.repaint();
			
		}
		
	});
	
	jp.add(sub);
	add(jp,BorderLayout.SOUTH);
	pack();
	}
}
