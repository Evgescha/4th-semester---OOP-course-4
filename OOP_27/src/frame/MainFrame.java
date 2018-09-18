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
 * Класс основного окна пользователя
 * О программе
 *
 * @version 5
 * Объем и площадь правильного тетраэдра
 * @author Шишлов Евгений Дмитриевич
 */
public class MainFrame extends JFrame {
	
	JLabel foto;
    JTextField a = new JTextField();
    JTextField H = new JTextField();
    JTextField So = new JTextField();
    JTextField S = new JTextField();
    JTextField V = new JTextField();
    
    
 // Создаем кнопки       
    JButton jbtCalc = new JButton("Найти");
    JButton jbtClear = new JButton("Очистить");
    JButton jbtAbout = new JButton("О программе");
    JButton jbtAuthor = new JButton("Об авторе");
    JButton jbtExit = new JButton("Выход");
    
    JLabel label1 = new JLabel("Вид правильного тетраэдра        ");
    JLabel label2 = new JLabel("Введите значения ребра -a (см)- тетраэдра ");
    JLabel label3 = new JLabel("Высота - H (см) - расчитывается по формуле");
    JLabel label4 = new JLabel("H = a * sqrt(2/3)");
    JLabel label5 = new JLabel("Площадь основания - So (см^2)- расчитывается по формуле:");
    JLabel label6 = new JLabel("So = (a^2 * sqrt(3))/4");
    JLabel label7 = new JLabel("Площадь полной поверхности - S (см^2) - расчитывается по формуле:");
    JLabel label8 = new JLabel("S = a^2 * sqrt(3)");
    JLabel label9 = new JLabel("Объем - V (см^3) - расчитывается по формуле:");
    JLabel label10 = new JLabel("V = (So * H)/3");
    
	/**
	 * Метод отрисовки главной формы программы.
	 */
	public MainFrame() {
		// устанавливаем заголовок, выход по крестику, размер и запрещем масщтабировать 
        setTitle("Объем и площадь правильного тетраэдра");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(620,320);
        
        //Загрузка изображения 
        try {
        	URL url = StartPage.class.getResource( "/res/tetr.jpg");        	
        foto = new JLabel(new ImageIcon(url)) ;
       
        } catch(Exception e) {
        	JOptionPane.showMessageDialog(this, "Не удается найти зображение тетраэдра, \n" 
        + "Пожалуйста, проверьте файлы программы");
        }
        
        H.setEditable(false);
        S.setEditable(false);
        So.setEditable(false);
        V.setEditable(false);
        
        // Создаем панель кнопок, нижняя часть главного окна
        JPanel pBtn = new JPanel(new FlowLayout());

        // Добавляем кнопки на панель кнопок
        pBtn.add(jbtCalc);
        pBtn.add(jbtClear);
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        
        // создаем левую часть окна
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
        left.add(label1);
        left.add(foto);
        // создаем центральную часть окна верха
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
        
        // Добавляем все на фрейм
        add(center,BorderLayout.CENTER);
        add(left,BorderLayout.LINE_START);
        add(pBtn,BorderLayout.PAGE_END);
        
        // кнопка о программе
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
        
        //кнопка об автаре
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
        
        // кнопка выйти
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "Да", "Нет!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "Закрыть окно?",
	                                "Подтверждение", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // кнопка найти
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(a,H,So,S,V);
			}
		});
        
        // кнопка очистить
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
        
       
        
       
        // предупреждение о выходе
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Да, выйти", "Нет, остаться"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Вы действительно хотите выйти?", "Отвечайте за свои поступки",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
