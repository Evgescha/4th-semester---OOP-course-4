package work;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import frame.*;

/**
 * Главный запускающийся класс
 * О программе
 *
 * @version 5
 * Объем и площадь правильного тетраэдра
 * @author Шишлов Евгений Дмитриевич
 */
public class Run {

	
	/**
	 * Стартовое окно
	 */
	public static StartPage SP;
	/**
	 * Главное окно
	 */
	public static MainFrame MF;
	/**
	 * Программное окно (о программе)
	 */
	public static About Ab;
	/**
	 * Авторское окно
	 */
	public static Avtor Av;
	
	
	/**
	 * Главный метод, создает стартовое окно
	 * @param args строковый массив
	 */
	public static void main(String[] args) {
		 
		SP = new StartPage();
		SP.setVisible(true);
		
	}
	
	
	public static void Arbeit( JTextField A_, JTextField H_, JTextField So_, JTextField S_, JTextField V_) {
				
		if(isDigit(A_.getText())) {
		
		double A,H,So,S,V;
		A = Double.parseDouble(A_.getText());
		
		H = A * Math.sqrt((double)2/(double)3);
		
		So = (A*A  * Math.sqrt((double)3)) / 4;
		S = A*A * Math.sqrt((double)3);
		V = (So * H) / 3;
		
		H_.setText(H +"");
		So_.setText(So +"");
		S_.setText(S +"");
		V_.setText(V +"");
		
		} else {
			JOptionPane.showMessageDialog(null, "Ожидается ввод положительного целого числа. \n"+ "Проверьте, является ли введанная вами информация числом");
		}
    }
	
	/**
	 * Метод проверки строки на число
	 * @param s исходная строка в виде числа
	 * @return булевое значение, является ли строка числом
	 */
	public static boolean isDigit(String s)  {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	
}
