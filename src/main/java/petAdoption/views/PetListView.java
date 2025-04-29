package petAdoption.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;

public class PetListView extends JFrame{
	
	
	public PetListView() {
		setTitle("Pet List Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(26, 39, 435, 237);
		panel.add(list);
		
		JButton addButton = new JButton("Add a Pet");
		addButton.setBounds(26, 300, 112, 21);
		panel.add(addButton);
		
		JButton adoptButton = new JButton("Adopt Selected");
		adoptButton.setBounds(136, 300, 112, 21);
		panel.add(adoptButton);
		
		JButton removeButton = new JButton("Remove Selected");
		removeButton.setBounds(246, 300, 112, 21);
		panel.add(removeButton);
		
		JButton deleteButton = new JButton("Delete Selected");
		deleteButton.setBounds(356, 300, 112, 21);
		panel.add(deleteButton);
		
		
	}
}
