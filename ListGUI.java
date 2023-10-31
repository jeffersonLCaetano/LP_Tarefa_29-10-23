import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListGUI extends JFrame {
    ArrayList<String> tasks = new ArrayList<String>();
    String printList = "";
    private JPanel painel = new JPanel();
    private JButton JButtonAddTasks = new JButton("Adicionar Tarefas");
    private JButton JButtonRemoveTasks = new JButton("Remover Tarefas");
    private JButton JButtonListTasks = new JButton("Listar Tarefas");


    JLabel iconList = new JLabel(new ImageIcon("./src/main/resources/iconList.gif"));    //LOGOS DO SISTEMA
    ImageIcon iconPlusList = new ImageIcon("./src/main/resources/plusList.gif");    //LOGOS DO SISTEMA
    ImageIcon iconRemoveList = new ImageIcon("./src/main/resources/removeList.gif");    //LOGOS DO SISTEMA
    ImageIcon iconListTasks = new ImageIcon("./src/main/resources/listTasks.gif");    //LOGOS DO SISTEMA
    ImageIcon iconSucess = new ImageIcon("./src/main/resources/sucess.gif");    //LOGOS DO SISTEMA

    public ListGUI() {

        this.setTitle("Lista de Tarefas");
        this.setSize(400, 300);

        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        painel.setBackground(new Color(255, 255, 255));

        painel.add(iconList);
        painel.add(JButtonAddTasks);

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(255, 255, 255));

        JButtonAddTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object addList = JOptionPane.showInputDialog(null, "Adicione uma tarefa:", "Adicionar Tarefa", JOptionPane.INFORMATION_MESSAGE, iconPlusList, null, "");
                String task = (String) addList;
                addTask(tasks, task);

            }
        });

        JButtonRemoveTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object removeList = JOptionPane.showInputDialog(null, updatePrintList(printList), "Remover Tarefa", JOptionPane.INFORMATION_MESSAGE, iconRemoveList, null, "");
                int index = Integer.valueOf((String) removeList);
                removeTask(tasks, index);

            }
        });

        JButtonListTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listTask(tasks);
            }
        });
    }

    public static void main(String[] args) {

        new ListGUI();
    }

    private void addTask(ArrayList<String> tasks, String task) {
        tasks.add(task);

        JOptionPane.showMessageDialog(null, "A task foi adicionada com sucesso!", "Tarefa Adicionada", JOptionPane.INFORMATION_MESSAGE, iconSucess);

        if (tasks.size() == 1) {
            painel.add(JButtonRemoveTasks);
            painel.add(JButtonListTasks);
            this.setSize(400, 400);
        }
    }

    private void removeTask(ArrayList<String> tasks, int index) {
        tasks.remove(index);

        JOptionPane.showMessageDialog(null, "A tarefa foi removida com sucesso!", "Tarefa Removida", JOptionPane.INFORMATION_MESSAGE, iconSucess);

        if (tasks.size() == 0) {
            painel.remove(JButtonRemoveTasks);
            painel.remove(JButtonListTasks);
            this.setSize(400, 300);
        }
    }

    private void listTask(ArrayList<String> tasks) {

        JOptionPane.showMessageDialog(null, updatePrintList(printList), "Listar Tarefas", JOptionPane.INFORMATION_MESSAGE, iconListTasks);
    }

    private String updatePrintList(String printList) {

        for (int i = 0; i < tasks.size(); i++) {
            printList += i + " - " + tasks.get(i) + "\n";
        }
        return printList;
    }
  }