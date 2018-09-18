package frame;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import work.Run;

/**
 * Класс о программе
 * О программе
 *
 * @version 5
 * Объем и площадь правильного тетраэдра
 * @author Шишлов Евгений Дмитриевич
 */

public class About extends JDialog {
	/**
	 * текстовое поле
	 */
	JTextArea jtxtArea = new JTextArea();
   
    /**
	 * Кнока назад
	 */
    JButton jbtBack = new JButton("Назад");

    /**
     * Конструктор класса о программе
     */
	public About(){
		setSize(340, 150);
		setResizable(false);
		setTitle("О программе");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // информация о программе
        jtxtArea.setColumns(20);
        jtxtArea.setRows(5);
        jtxtArea.setWrapStyleWord(true);
        jtxtArea.setLineWrap(true);
        jtxtArea.setEditable(false);
        jtxtArea.setText(
        		  "Программа предназначена для нахождения \n"
                + "Обьема и площади правильного тетраэдра. \n"
                + "Программа выводит результат вычисления \n"
                + "в специальные поля на экране.");

        jtxtArea.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // панель кнопок
        JPanel pnlButton = new JPanel(new GridLayout(1, 2, 5, 5));
        pnlButton.add(jbtBack);

        setLayout(new BorderLayout());
        add(jtxtArea, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        setFocusable(true);
        setFocusableWindowState(true);
       
        //Кнопка "Назад"
        jbtBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Back();
				
			}
		});
       

     // При выходе из окна открывать доступ к окну-родителю
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
	
	/**
	 * Возвращение на предыдущее окно
	 */
	void Back() {
		 Run.MF.setEnabled(true);
		 dispose();	
		   
	}

	
}
