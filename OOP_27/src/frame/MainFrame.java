package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import work.Run;


/**
 * ����� ��������� ���� ������������
 * � ���������
 *
 * @version 5
 * ����� � ������� ����������� ���������
 * @author ������ ������� ����������
 */
public class MainFrame extends JFrame {
	
	JLabel foto;
    JTextField a = new JTextField();
    JTextField H = new JTextField();
    JTextField So = new JTextField();
    JTextField S = new JTextField();
    JTextField V = new JTextField();
    
    
 // ������� ������       
    JButton jbtCalc = new JButton("�����");
    JButton jbtClear = new JButton("��������");
    JButton jbtAbout = new JButton("� ���������");
    JButton jbtAuthor = new JButton("�� ������");
    JButton jbtExit = new JButton("�����");
    
    JLabel label1 = new JLabel("��� ����������� ���������        ");
    JLabel label2 = new JLabel("������� �������� ����� -a (��)- ��������� ");
    JLabel label3 = new JLabel("������ - H (��) - ������������� �� �������");
    JLabel label4 = new JLabel("H = a * sqrt(2/3)");
    JLabel label5 = new JLabel("������� ��������� - So (��^2)- ������������� �� �������:");
    JLabel label6 = new JLabel("So = (a^2 * sqrt(3))/4");
    JLabel label7 = new JLabel("������� ������ ����������� - S (��^2) - ������������� �� �������:");
    JLabel label8 = new JLabel("S = a^2 * sqrt(3)");
    JLabel label9 = new JLabel("����� - V (��^3) - ������������� �� �������:");
    JLabel label10 = new JLabel("V = (So * H)/3");
    
	/**
	 * ����� ��������� ������� ����� ���������.
	 */
	public MainFrame() {
		// ������������� ���������, ����� �� ��������, ������ � �������� �������������� 
        setTitle("����� � ������� ����������� ���������");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(620,320);
        
        //�������� ����������� 
        try {
        	URL url = StartPage.class.getResource( "/res/tetr.jpg");        	
        foto = new JLabel(new ImageIcon(url)) ;
       
        } catch(Exception e) {
        	JOptionPane.showMessageDialog(this, "�� ������� ����� ���������� ���������, \n" 
        + "����������, ��������� ����� ���������");
        }
        
        H.setEditable(false);
        S.setEditable(false);
        So.setEditable(false);
        V.setEditable(false);
        
        // ������� ������ ������, ������ ����� �������� ����
        JPanel pBtn = new JPanel(new FlowLayout());

        // ��������� ������ �� ������ ������
        pBtn.add(jbtCalc);
        pBtn.add(jbtClear);
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        
        // ������� ����� ����� ����
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
        left.add(label1);
        left.add(foto);
        // ������� ����������� ����� ���� �����
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        center.add(label2);
        center.add(a);
        center.add(label3);
        center.add(label4);
        center.add(H);
        center.add(label5);
        center.add(label6);
        center.add(So);
        center.add(label7);
        center.add(label8);
        center.add(S);
        center.add(label9);
        center.add(label10);
        center.add(V);
        
        // ��������� ��� �� �����
        add(center,BorderLayout.CENTER);
        add(left,BorderLayout.LINE_START);
        add(pBtn,BorderLayout.PAGE_END);
        
        // ������ � ���������
        jbtAbout.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Ab ==null) {
            		Run.Ab =  new About();            		
            	}
				setEnabled(false);
            	Run.Ab.setVisible(true);	
            	
			}
		});
        
        //������ �� ������
        jbtAuthor.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Av ==null) {
            		Run.Av =  new Avtor();            		
            	}
				setEnabled(false);
            	Run.Av.setVisible(true);
            	
								
			}
		});
        
        // ������ �����
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "��", "���!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "������� ����?",
	                                "�������������", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // ������ �����
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(a,H,So,S,V);
			}
		});
        
        // ������ ��������
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a.setText("");
				H.setText("");
				S.setText("");
				So.setText("");
				V.setText("");
			}
		});
        
       
        
       
        // �������������� � ������
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"��, �����", "���, ��������"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "�� ������������� ������ �����?", "��������� �� ���� ��������",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
