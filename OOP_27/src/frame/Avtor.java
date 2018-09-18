package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import work.Run;

/**
 * Класс об авторе
 * О программе
 *
 * @version 5
 * Объем и площадь правильного тетраэдра
 * @author Шишлов Евгений Дмитриевич
 */
public class Avtor extends JDialog{
	 /**
	 * Текстовое поле
	 */
	JTextArea jtxtArea = new JTextArea();
	 /**
	 * Кнока назад
	 */
	JButton jbtBack = new JButton("Назад");
	 /**
	 * Аватарка
	 */
	JLabel foto;
     
	 /**
	  * Конструктор окна об авторе
	  */
	public Avtor() {
		
		
        setTitle("Об авторе");
        setSize(460, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false); 
        setLocationRelativeTo(null); 
        /**
         * Загрузка изображения, ели его нет - вывод предупредительного окна
         */
        try {
        	URL url = StartPage.class.getResource( "/res/Avtor.jpg");        	
        foto = new JLabel(new ImageIcon(url)) ;
       
        } catch(Exception e) {
        	JOptionPane.showMessageDialog(this, "Не удается найти зображение автора, \n" 
        + "Пожалуйста, проверьте файлы программы");
        }
        
        // текст про автора
        jtxtArea.setEditable(false);
        jtxtArea.setText("2 Курс \n" + 
        		"Группа - Ит4\n" + 
        		"Автор: \n" + 
        		"Шишлов Евгений Дмитриевич\n"
        	  + "Вариант 27 \n");
		
        jtxtArea.setColumns(20);
        jtxtArea.setRows(5);
        jtxtArea.setWrapStyleWord(true);
        jtxtArea.setLineWrap(true);
        jtxtArea.setFont(new Font("Dialog", Font.BOLD, 18));

        // установка компанентов на фрейм
        setLayout(new BorderLayout());
        add(foto, BorderLayout.WEST);
        add(jtxtArea, BorderLayout.CENTER);
        add(jbtBack, BorderLayout.SOUTH);

        // Кнопка назад
        jbtBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Run.MF.setEnabled(true);
                dispose();				
			}
		});
        // фокусируемся на текущем фрейме
        setFocusable(true);
        setFocusableWindowState(true);
        
        // при закрытии окна, разрешать пользоваться другим
        // и ради этого переопределяем методы
        addWindowListener(new WindowListener() {      
            public void windowClosing(WindowEvent event) {
               Run.MF.setEnabled(true);
            }

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
 
        });
	}
}
